package com.rak12.retroflipz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import com.rak12.retroflipz.R


class ParentalControlFragment : Fragment() {

lateinit var button:SwitchCompat
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var view=inflater.inflate(R.layout.fragment_parental_control, container, false)
     button=view.findViewById(R.id.parentcontrolswitch)
       button.setOnCheckedChangeListener { buttonView, isChecked ->
           if(isChecked){
               Toast.makeText(requireContext(),"Enabled",Toast.LENGTH_SHORT).show()

           }
           else{

               Toast.makeText(requireContext(),"Disabled",Toast.LENGTH_SHORT).show()
           }
       }



        return  view

    }


}