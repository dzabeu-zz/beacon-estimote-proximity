package com.estimote.notification

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.estimote.mustard.rx_goodness.rx_requirements_wizard.RequirementsWizardFactory

//
// Running into any issues? Drop us an email to: contact@estimote.com
//

 class  MainActivity : AppCompatActivity(),View.OnClickListener {


     override fun onClick (v: View?){
         val app = application as MyApplication
         app.enableNotificationForce()
     }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val app = application as MyApplication

        var btPromo = findViewById(R.id.bntPromo) as Button
        btPromo.setOnClickListener{
            val intent = Intent(this,   Promo::class.java )
            startActivity(intent)
        }

       // var btPromo2 = findViewById(R.id.bntPromo2) as Button
       // btPromo2.setOnClickListener(this)

        RequirementsWizardFactory
                .createEstimoteRequirementsWizard()
                .fulfillRequirements(this,
                        onRequirementsFulfilled = {
                            Log.d("app", "requirements fulfilled")
                            app.enableBeaconNotifications()
                        },
                        onRequirementsMissing = { requirements ->
                            Log.e("app", "requirements missing: " + requirements)
                        },

                        onError = { throwable ->
                            Log.e("app", "requirements error: " + throwable)
                        })
    }



}
