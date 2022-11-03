package com.oleg.lec4

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatDelegate
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : ForceLightThemeMode() {
    lateinit var tvEmail:TextView
    lateinit var btnShowWebSite:FloatingActionButton
    lateinit var btnPhone:FloatingActionButton
    lateinit var btnShowMap:FloatingActionButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main)
        findView()
        handleEvents()


        val email = intent.getStringExtra(EXTRA_EMAIL)?:getString(R.string.Guest)
        tvEmail.text =getString(R.string.greet_user,email)
    }

    private fun findView(){
        tvEmail = findViewById(R.id.tv)
        btnPhone = findViewById(R.id.btn_dial_phone)
        btnShowMap = findViewById(R.id.btn_show_map)
        btnShowWebSite = findViewById(R.id.btn_android_website)
    }

    private fun handleEvents(){
        btnShowWebSite.setOnClickListener{
            vieWebSite()
        }
        btnPhone.setOnClickListener{
            dialPhone()
        }
        btnShowMap.setOnClickListener{
            showMap()
        }
    }
    private fun dialPhone(){
        val uri = Uri.parse("tel:0507123012")
        val intent = Intent(Intent.ACTION_DIAL,uri)
        startActivity(intent)
    }
    private fun vieWebSite(){
        val uri = Uri.parse("https://developer.android.com/")
        val intent = Intent(Intent.ACTION_VIEW,uri)
        startActivity(intent)
    }
    private fun showMap(){
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:47.6,-122.3?z=12"))
        startActivity(intent)
    }
}