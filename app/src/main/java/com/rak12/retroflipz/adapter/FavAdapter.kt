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
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.rak12.retroflipz.R
import com.rak12.retroflipz.activity.GameshowActivity
import com.rak12.retroflipz.database.GamesEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.fragment_home.view.*

class FavAdapter(val context: Context, val list: List<GamesEntity>) :
    RecyclerView.Adapter<FavAdapter.FavViewholde>() {
    class FavViewholde(view: View) : RecyclerView.ViewHolder(view) {
        val onerow: RelativeLayout =view.findViewById(R.id.onerow)
        val img:ImageView=view.findViewById(R.id.gameimg)
        val gamename:TextView=view.findViewById(R.id.gamename)
        var imgfav: ImageView = view.findViewById(R.id.imgIsFav)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewholde {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_singlegame, parent, false)
        return FavViewholde(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: FavViewholde, position: Int) {
        var data=list[position]
        Picasso.get().load(data.img).error(R.drawable.ic_baseline_videogame_asset_24).into(holder.img)
        holder.gamename.text=data.name
        var link=data.link
        var id = data.id
        holder.onerow.setOnClickListener {
            Toast.makeText(context,"clicked", Toast.LENGTH_LONG).show()
            Log.d("clicked", link)
            val intent=Intent(context,GameshowActivity::class.java)
            intent.putExtra("url",link)
            context.startActivity(intent)
        }
        val gamesEntity =
            GamesEntity(data.id, data.name, data.img,data.link,data.gd)
        val checkfav = GamesAdapter.DBAsynctask(context, gamesEntity, 1).execute().get()
        if (checkfav) {
            holder.imgfav.setBackgroundResource(R.drawable.ic_favfilled)
        } else {
            holder.imgfav.setBackgroundResource(R.drawable.ic_favb)
        }


    }


}