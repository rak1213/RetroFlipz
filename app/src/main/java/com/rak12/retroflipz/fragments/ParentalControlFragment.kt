package com.rak12.retroflipz.fragments

import android.app.AlarmManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Context.ALARM_SERVICE
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.rak12.retroflipz.R
import com.rak12.retroflipz.activity.SetPasswordActivity
import com.rak12.retroflipz.activity.TimerActivity
import java.util.*


class ParentalControlFragment : Fragment() {
    lateinit var alarmManager:AlarmManager

lateinit var button:SwitchCompat



    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.fragment_parental_control, container, false)

        alarmManager = requireActivity().getSystemService(ALARM_SERVICE) as AlarmManager
     button=view.findViewById(R.id.parentcontrolswitch)
       button.setOnCheckedChangeListener { buttonView, isChecked ->
           if(isChecked){
               Toast.makeText(requireContext(), "Enabled", Toast.LENGTH_SHORT).show()
               val intent=Intent(view.context, SetPasswordActivity::class.java)
               startActivity(intent)
           }
           else{

               val intent= Intent(context, TimerActivity.Receiver::class.java)
               val pendingIntent= PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT)
               Log.d("TimerActivity", "cancel :" + Date().toString())
               alarmManager.cancel(pendingIntent)

               Toast.makeText(requireContext(), "Disabled", Toast.LENGTH_SHORT).show()
           }
       }



        return  view

    }

    class Receiver: BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            Log.d("TimerActivity", "Receiver:" + Date().toString())

            Toast.makeText(context, "Here it is", Toast.LENGTH_SHORT).show()

        }


    }

}