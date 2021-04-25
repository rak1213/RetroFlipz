package com.rak12.retroflipz.activity

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.annotation.RequiresApi
import com.rak12.retroflipz.R

class GameshowActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_gameshow2)
        var link:String=""
        val myWebView:WebView=findViewById(R.id.webview)
        myWebView.webViewClient=object :WebViewClient(){
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                url: String?
            ): Boolean {
                if (url != null) {
                    view?.loadUrl(url)
                }
                return true
            }
        }
        if(intent!==null){
            link = intent.getStringExtra("url").toString()

        }
        Log.d("gamelink", link)
        myWebView.loadUrl(link)
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.allowContentAccess=true
        myWebView.getSettings().setUseWideViewPort(true);
             myWebView.setInitialScale(1);
        //myWebView.settings.useWideViewPort=true
        myWebView.settings.domStorageEnabled=true



    }
}