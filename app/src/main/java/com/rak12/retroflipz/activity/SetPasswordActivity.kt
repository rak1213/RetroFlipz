package com.rak12.retroflipz.activity

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.rak12.retroflipz.R

class SetPasswordActivity : AppCompatActivity() {
    lateinit var etEnterPassword:EditText
    lateinit var etConfirmPassword:EditText
    lateinit var sp:SharedPreferences
    lateinit var btnNext:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_password)
        etEnterPassword=findViewById(R.id.etEnterPassword)
        etConfirmPassword=findViewById(R.id.etConfirmPassword)
        sp=getSharedPreferences(
            R.string.fileSharedPreference.toString(),
            MODE_PRIVATE)
       btnNext=findViewById(R.id.btnNext)
        btnNext.setOnClickListener {
            if(etEnterPassword.text.toString()==etConfirmPassword.text.toString()){
                sp.edit().putString("password",etEnterPassword.text.toString()).commit()
                val intent= Intent(this,TimerActivity::class.java)
                startActivity(intent)
            }else{
                etConfirmPassword.setError("Enter same Password")
            }
        }
    }
}