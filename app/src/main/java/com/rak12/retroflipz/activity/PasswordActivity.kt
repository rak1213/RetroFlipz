package com.rak12.retroflipz.activity

import android.content.Intent
import android.content.SharedPreferences
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.rak12.retroflipz.R

class PasswordActivity : AppCompatActivity() {
    //lateinit var imgLogo:ImageView
    lateinit var txtPassword:TextView
    lateinit var etPassword:EditText
    lateinit var btnPassword:Button
    lateinit var sp:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)
        //  imgLogo=findViewById(R.id.imgLogo1)
        txtPassword=findViewById(R.id.txtPassword)
        etPassword=findViewById(R.id.etPassword)
        btnPassword=findViewById(R.id.btnPassword)
        sp=getSharedPreferences(R.string.fileSharedPreference.toString(), MODE_PRIVATE)
        btnPassword.setOnClickListener {
            if(etPassword.text.toString()==sp.getString("password","0")){
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)
            }else{
                etPassword.setError("Please enter valid Password")
            }
        }
    }
}