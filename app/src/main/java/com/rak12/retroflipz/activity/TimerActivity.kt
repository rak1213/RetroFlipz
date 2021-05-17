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
    lateinit var timePicker: TimePicker
    lateinit var alarmManager: AlarmManager
    lateinit var buttonAlarm: Button
    lateinit var buttonUpdateAlarm: Button
    lateinit var buttonCancelAlarm: Button
    lateinit var ethours:EditText
    lateinit var etminutes:EditText
    lateinit var firstscreen:RelativeLayout
    lateinit var secondscreen:RelativeLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        timePicker = findViewById(R.id.timePicker)
        buttonAlarm=findViewById(R.id.buttonAlarm)
        buttonCancelAlarm=findViewById(R.id.buttonCancelAlarm)
        buttonUpdateAlarm=findViewById(R.id.buttonUpdateAlarm)
        ethours=findViewById(R.id.ethours)
        etminutes=findViewById(R.id.etminutes)
         firstscreen=findViewById(R.id.firstscreen)
       // secondscreen=findViewById(R.id.secondscreen)
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
                val intent= Intent(context,Receiver::class.java)
             val intent2=Intent(context,PasswordActivity::class.java)
                val arr= arrayListOf<Intent>(
                    Intent(intent),
                    Intent(intent2)
                )
               // val rec=Receiver().onReceive(this,intent2)
                val pendingIntent= PendingIntent.getBroadcast(context,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
                val pendingintent2=PendingIntent.getActivity(context,1,intent2,PendingIntent.FLAG_UPDATE_CURRENT)
                Log.d("TimerActivity","create:"+ Date().toString())
                alarmManager.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+sec,pendingintent2)

            }
            thread.start()




        }
        buttonUpdateAlarm.setOnClickListener {
           // var seconds= OnClickTime()*1000
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

            val intent= Intent(context,Receiver::class.java)
            val pendingIntent= PendingIntent.getBroadcast(context,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("TimerActivity","update :"+ Date().toString())
            alarmManager.setExact(AlarmManager.RTC_WAKEUP,System.currentTimeMillis()+sec,pendingIntent)

        }
        buttonCancelAlarm.setOnClickListener {

            val intent= Intent(context,Receiver::class.java)
            val pendingIntent= PendingIntent.getBroadcast(context,0,intent, PendingIntent.FLAG_UPDATE_CURRENT)
            Log.d("TimerActivity","cancel :"+ Date().toString())
            alarmManager.cancel(pendingIntent)

        }

    }
    class Receiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("TimerActivity","Receiver:"+ Date().toString())
           // Toast.makeText(this,"Seconds: $sec",Toast.LENGTH_SHORT).show()
           Toast.makeText(context,"Here it is",Toast.LENGTH_SHORT).show()

        }


    }

    private fun OnClickTime(): Int {

        val timePicker = findViewById<TimePicker>(R.id.timePicker)
        var timeset:Int=0
        timePicker.setOnTimeChangedListener { _, hour, minute -> var hour = hour
            var am_pm = ""
            // AM_PM decider logic
            when {hour == 0 -> { hour += 12
                am_pm = "AM"
            }
                hour == 12 -> am_pm = "PM"
                hour > 12 -> { hour -= 12
                    am_pm = "PM"
                }
                else -> am_pm = "AM"
            }
            //val hour = if (hour < 10) "0" + hour else hour
           val hours= if(hour<10) "0"+ hour else hour
            timeset=(hours.toString().toInt())*60*60
            val min = if (minute < 10) "0" + minute else minute
            timeset=timeset+((min.toString().toInt())*60)
            // display format of time

        }
        return timeset
    }

    override fun onBackPressed() {
        //super.onBackPressed()
        val intent=Intent(context,MainActivity::class.java)
        startActivity(intent)
    }
}