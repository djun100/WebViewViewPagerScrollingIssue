package com.example.secoo.webviewandviewpagerscrollsample

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient

class WebViewFragment : Fragment() {


    companion object {
        fun getInstance(url: String) : WebViewFragment {
            val fragment = WebViewFragment()
            fragment.arguments = Bundle().apply {
                putString("url", url)
            }
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.webview_item, container, false) as ViewGroup
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val webview = view.findViewById<WebView>(R.id.webview)
        webview.webViewClient=object :WebViewClient(){
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                super.shouldOverrideUrlLoading(view, request)
                return true
            }
        }
        webview.settings.javaScriptEnabled = true
        webview.overScrollMode = WebView.OVER_SCROLL_IF_CONTENT_SCROLLS
        var url=arguments?.getString("url") ?: "https://droidyue.com"
        webview.loadUrl(url)
    }
}