package com.estimote.notification


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

class QRCode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.qrcode)

        val actbar =supportActionBar
        actbar!!.title = "Menu Inicial"
        actbar.setDisplayHomeAsUpEnabled(true)
        actbar.setDisplayHomeAsUpEnabled(true)
        actbar.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFFFFF")))

    }

}
