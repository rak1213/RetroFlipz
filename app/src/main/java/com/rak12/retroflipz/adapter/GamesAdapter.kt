package com.rak12.retroflipz.adapter

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.rak12.retroflipz.R
import com.rak12.retroflipz.activity.GameshowActivity
import com.rak12.retroflipz.model.Games
import com.squareup.picasso.Picasso

class GamesAdapter(val context: Context,var arrayList: ArrayList<Games>):RecyclerView.Adapter<GamesAdapter.Vh>(){
    class Vh(view: View):RecyclerView.ViewHolder(view){
        val onerow:RelativeLayout=view.findViewById(R.id.onerow)
        val img:ImageView=view.findViewById(R.id.gameimg)
        val gamename:TextView=view.findViewById(R.id.gamename)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_singlegame,parent,false)
        return Vh(view)
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
       var data=arrayList[position]
        Picasso.get().load(data.image).error(R.drawable.ic_baseline_videogame_asset_24).into(holder.img)
            holder.gamename.text=data.gamename
        var link=data.link
        holder.onerow.setOnClickListener {
           Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show()
            Log.d("clicked", link)
            val intent=Intent(context,GameshowActivity::class.java)
            intent.putExtra("url",link)
            context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}