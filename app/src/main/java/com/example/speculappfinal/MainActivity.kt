package com.example.speculappfinal

import android.content.Intent
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.speculappfinal.databinding.ActivityMainBinding
import com.example.speculappfinal.formulario.FormularioFragment


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var webView: WebView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.main)
        /*val imageView= findViewById<ImageView>(R.id.imageView)
        Picasso.get()
            .load(R.drawable.ndvi)
            .resize(800, 800) // Redimensionar la imagen
            .centerInside()// URL de la imagen o archivo local
            .into(imageView)*/
        webView = binding.webView
        val button1 = binding.button1
        //val button2 = findViewById<Button>(R.id.button2)



        button1.setOnClickListener {
            cambiarAFormularioFragment()
        }

        // button2.setOnClickListener {

        // }

        // Configurar WebView
        val webSettings: WebSettings = webView.settings

        // webSettings.userAgentString = "Your custom user agent string" // Opcional

        webView.webViewClient = WebViewClient()
        webView.settings.javaScriptEnabled = true
        webSettings.cacheMode = WebSettings.LOAD_DEFAULT // Cargar desde caché si es posible
        webSettings.domStorageEnabled = true // Habilita el almacenamiento DOM
        webSettings.mediaPlaybackRequiresUserGesture = false // Permite la reproducción automática
        webSettings.setSupportMultipleWindows(true) // Soporta múltiples ventanas
        webSettings.allowUniversalAccessFromFileURLs
        webSettings.javaScriptCanOpenWindowsAutomatically = true
        webSettings.setGeolocationEnabled(true)
        webSettings.setSupportZoom(true)
        webSettings.databaseEnabled = true
        webSettings.domStorageEnabled = true
        webSettings.layoutAlgorithm
        val desktopUserAgent = "Mozilla/5.0 (Windows NT 11.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36"
        webSettings.userAgentString = desktopUserAgent
        // Cargar la URL de tu Google Earth Engine App modificado
        val googleEarthEngineAppUrl = "https://sentinel-indiced.projects.earthengine.app/view/ndvi"
        webView.loadUrl(googleEarthEngineAppUrl)

    }

    private fun cambiarAFormularioFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.main, FormularioFragment())
            .addToBackStack(null)
            .commit()
    }

}