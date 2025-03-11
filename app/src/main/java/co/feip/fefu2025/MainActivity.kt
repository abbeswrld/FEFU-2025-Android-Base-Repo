package co.feip.fefu2025

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge
import androidx.core.content.ContextCompat

class MainActivity : ComponentActivity() {

    private var count: Int = 0
    private lateinit var counterTextView: TextView
    private val internetReceiver = InternetReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.main_activity)

        counterTextView = findViewById(R.id.counter).apply {
            text = count.toString()
            setOnClickListener { text = (++count).toString() }
        }

        savedInstanceState?.let {
            count = it.getInt("count")
            counterTextView.text = count.toString()
        }

        registerInternetReceiver()
    }

    override fun onDestroy() {
        super.onDestroy()
        unregisterReceiver(internetReceiver)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("count", count)
    }

    private fun registerInternetReceiver() {
        ContextCompat.registerReceiver(
            this,
            internetReceiver,
            IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION),
            ContextCompat.RECEIVER_EXPORTED
        )
    }
}

class InternetReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent?) {
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val network = connectivityManager.activeNetwork
        val capabilities = connectivityManager.getNetworkCapabilities(network)

        val status = when {
            network == null || capabilities == null -> "Internet is disabled"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> "WiFi is enabled"
            capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> "Cellular is enabled"
            else -> "Internet is disabled"
        }

        Log.d("InternetReceiver", status)
    }
}