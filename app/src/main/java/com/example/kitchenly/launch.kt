package com.kitchenly.app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class LaunchActivity : AppCompatActivity() {

    private lateinit var btnNext: Button
    private lateinit var progressBar: ProgressBar
    private var autoRedirectHandler: Handler? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launch)

        initViews()

        setupClickListeners()

        startAutoRedirect()
    }

    private fun initViews() {
        btnNext = findViewById(R.id.btnNext)
        progressBar = findViewById(R.id.progressBar)
    }

    private fun setupClickListeners() {
        btnNext.setOnClickListener {
            navigateToOnboarding()
        }
    }

    private fun startAutoRedirect() {
        autoRedirectHandler = Handler(Looper.getMainLooper())
        autoRedirectHandler?.postDelayed({
            btnNext.visibility = View.GONE
            progressBar.visibility = View.VISIBLE

            Handler(Looper.getMainLooper()).postDelayed({
                navigateToOnboarding()
            }, 1000)
        }, 3000)
    }

    private fun navigateToOnboarding() {
        val intent = Intent(this, OnboardingActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onDestroy() {
        super.onDestroy()
        autoRedirectHandler?.removeCallbacksAndMessages(null)
    }
}