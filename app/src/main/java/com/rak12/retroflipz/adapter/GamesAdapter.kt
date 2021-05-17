package com.rak12.retroflipz.adapter

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.rak12.retroflipz.R
import com.rak12.retroflipz.activity.GameshowActivity
import com.rak12.retroflipz.database.Database
import com.rak12.retroflipz.database.GamesEntity
import com.rak12.retroflipz.model.Games
import com.squareup.picasso.Picasso

class GamesAdapter(val context: Context,var arrayList: ArrayList<Games>):RecyclerView.Adapter<GamesAdapter.Vh>(){
    class Vh(view: View):RecyclerView.ViewHolder(view){
        val onerow:RelativeLayout=view.findViewById(R.id.onerow)
        val img:ImageView=view.findViewById(R.id.gameimg)
        val gamename:TextView=view.findViewById(R.id.gamename)
        var imgfav: ImageView = view.findViewById(R.id.imgIsFav)

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
        var id = data.id
        holder.onerow.setOnClickListener {
           Toast.makeText(context,"clicked",Toast.LENGTH_LONG).show()
            Log.d("clicked", link)
            val intent=Intent(context,GameshowActivity::class.java)
            intent.putExtra("url",link)
            context.startActivity(intent)
        }


        val gamesEntity =
            GamesEntity(data.id, data.gamename, data.image,data.link,data.gd)

        val checkfav = DBAsynctask(context, gamesEntity, 1).execute().get()
        if (checkfav) {
            holder.imgfav.setBackgroundResource(R.drawable.ic_favfilled)
        } else {
            holder.imgfav.setBackgroundResource(R.drawable.ic_favb)
        }
        holder.imgfav.setOnClickListener {
            if (!DBAsynctask(context, gamesEntity, 1).execute().get()) {
                val addtofav = DBAsynctask(context, gamesEntity, 2).execute().get()
                if (addtofav) {
                    Toast.makeText(context, "ADDED TO FAVS", Toast.LENGTH_SHORT).show()

                    holder.imgfav.setBackgroundResource(R.drawable.ic_favfilled)
                } else {
                    Toast.makeText(context, "Some error occured", Toast.LENGTH_SHORT).show()

                }
            } else {
                val removefav = DBAsynctask(context, gamesEntity, 3).execute().get()
                if (removefav) {
                    Toast.makeText(context, "REMOVED FROM FAVS", Toast.LENGTH_SHORT).show()

                    holder.imgfav.setBackgroundResource(R.drawable.ic_favb)
                } else {
                    Toast.makeText(context, "Some error occured", Toast.LENGTH_SHORT).show()

                }


            }
        }



    }


    class DBAsynctask(val context: Context, val gamesEntity: GamesEntity, val mode: Int) :
        AsyncTask<Void, Void, Boolean>() {
        val db =
            Room.databaseBuilder(context, Database::class.java, "db")
                .build()

        override fun doInBackground(vararg params: Void?): Boolean {
            when (mode) {
                1 -> {
                    val gamesEntity1: GamesEntity =
                        db.gamesdao().getbyid(gamesEntity.id)
                    db.close()
                    return gamesEntity1 != null
                }
                2 -> {
                    db.gamesdao().insert(gamesEntity)
                    db.close()
                    return true
                }
                3 -> {
                    db.gamesdao().delete(gamesEntity)
                    db.close()
                    return true
                }
            }
            return false
        }


    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}