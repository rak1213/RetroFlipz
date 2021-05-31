package com.rak12.retroflipz.activity

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import com.rak12.retroflipz.R
import java.util.*

class TimerActivity : AppCompatActivity() {
    lateinit var context: Context

    lateinit var alarmManager: AlarmManager
    lateinit var buttonAlarm: Button

    lateinit var buttonCancelAlarm: Button
    lateinit var ethours:EditText
    lateinit var etminutes:EditText
    lateinit var firstscreen:RelativeLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)

        buttonAlarm=findViewById(R.id.buttonAlarm)
        buttonCancelAlarm=findViewById(R.id.buttonCancelAlarm)

        ethours=findViewById(R.id.ethours)
        etminutes=findViewById(R.id.etminutes)
        firstscreen=findViewById(R.id.firstscreen)

        context=this
        alarmManager=getSystemService(Context.ALARM_SERVICE) as AlarmManager
        buttonAlarm.setOnClickListener {
            var hours=0
            if(ethours.text.toString()==""){
                hours=0
            }
            else{
                hours=(ethours.text.toString().toInt())*60*60
            }
            var min=0
            if(etminutes.text.toString()==""){
                min=0
            }else{
                min= (etminutes.text.toString().toInt())*60
            }
            var sec=(hours+min)*1000


            val thread=Thread{

                val intent2=Intent(context,PasswordActivity::class.java)




                val pendingintent2=PendingIntent.getActivity(context,1,intent2,PendingIntent.FLAG_UPDATE_CURRENT)
                Log.d("TimerActivity","create:"+ Date().toString())
                alarmManager.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+sec,pendingintent2)

            }
            thread.start()
            val intent=Intent(context,MainActivity::class.java)
            startActivity(intent)



        }

        buttonCancelAlarm.setOnClickListener{

            val intent= Intent(context,Receiver::class.java)
            val pendingIntent= PendingIntent.getBroadcast(context,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("TimerActivity","cancel :"+ Date().toString())
            alarmManager.cancel(pendingIntent)

        }

    }
    class Receiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("TimerActivity","Receiver:"+ Date().toString())

            Toast.makeText(context,"Here it is",Toast.LENGTH_SHORT).show()

        }


    }



    override fun onBackPressed() {
        //super.onBackPressed()
        val intent=Intent(context,MainActivity::class.java)
        startActivity(intent)
    }
}