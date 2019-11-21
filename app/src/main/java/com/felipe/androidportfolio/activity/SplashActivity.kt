package com.felipe.androidportfolio.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.felipe.androidportfolio.R

class SplashActivity : AppCompatActivity(), Runnable {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onResume() {
        super.onResume()
        Handler().postDelayed(this, 1000)
    }

    override fun run() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}
