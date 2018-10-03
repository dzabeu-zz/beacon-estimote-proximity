package com.estimote.notification


import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.View
import android.widget.Button

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

class Promo : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.promo)


        val actbar =supportActionBar
        actbar!!.title = "Promoções em destaque"
        actbar.setDisplayHomeAsUpEnabled(true)
        actbar.setDisplayHomeAsUpEnabled(true)
        actbar.setBackgroundDrawable(ColorDrawable(Color.parseColor("#FFFFFF")))

    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}
