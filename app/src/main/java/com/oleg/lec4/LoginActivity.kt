package com.oleg.lec4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText

class LoginActivity : ForceLightThemeMode() {

    lateinit var btnLogin:Button
    lateinit var editLogin:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        findViews()
        handleEvents()
    }

    var btnLoginLisener = object : OnClickListener{
        override fun onClick(v: View?) {
            val email = editLogin.text.toString()
            if (email.length<3 || !email.contains("@")){
                editLogin.error = getString(R.string.invalid_email)
                return
            }
            else{
                //Intent to MainActivity + app context
                val intent = Intent(this@LoginActivity, MainActivity::class.java)
                intent.putExtra(EXTRA_EMAIL,email)
                startActivity(intent)
                finish()
            }
        }

    }
    private fun handleEvents(){
        btnLogin.setOnClickListener(btnLoginLisener)
    }
    private fun findViews(){
        btnLogin = findViewById(R.id.btn_login)
        editLogin = findViewById(R.id.edit_email)
    }

}