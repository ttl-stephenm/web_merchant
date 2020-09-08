package com.ttl.monarisweb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebSettings
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var webSetting: WebSettings

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        API.init()
        webSetting = my_web_view.settings
        webSetting.javaScriptEnabled = true

        API.service.getStoreListing().enqueue(object: Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Log.e("NET", t.localizedMessage)
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                Log.e("STATUS", response.body()!!)

                my_web_view.loadDataWithBaseURL(null, response.body()!!, "text/html", "UTF-8", "")

            }

        })
    }
}