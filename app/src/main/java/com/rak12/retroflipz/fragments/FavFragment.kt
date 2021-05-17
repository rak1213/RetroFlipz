package com.rak12.retroflipz.fragments

import android.content.Context
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.rak12.retroflipz.R
import com.rak12.retroflipz.adapter.FavAdapter
import com.rak12.retroflipz.database.Database
import com.rak12.retroflipz.database.GamesEntity


class FavFragment : Fragment() {
    lateinit var pl1: RelativeLayout
    private lateinit var rlNoFav: RelativeLayout
    lateinit var rv1: RecyclerView
    lateinit var no: TextView
    lateinit var nofav: RelativeLayout
    lateinit var lay: RecyclerView.LayoutManager
    lateinit var adapter1: FavAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view=inflater.inflate(R.layout.fragment_fav, container, false)


        no=view.findViewById(R.id.no)
        rlNoFav = view.findViewById(R.id.rlNoFavorites)
        rv1 = view.findViewById(R.id.rv1)
        pl1 = view.findViewById(R.id.rlLoading)



        lay = LinearLayoutManager(activity as Context)
        pl1.visibility = View.VISIBLE
        // Inflate the layout for this fragment
        var restlist1: List<GamesEntity>? = Favresr(activity as Context).execute().get(
        )



            if ((restlist1?.isEmpty())!!) {
                pl1.visibility = View.GONE
                rlNoFav.visibility = View.VISIBLE

            } else {
                pl1.visibility = View.GONE
                rlNoFav.visibility = View.GONE

                adapter1 = FavAdapter(activity as Context, restlist1)
                rv1.layoutManager = lay
                rv1.adapter = adapter1

            }
        return view
    }
    class Favresr(val context: Context) : AsyncTask<Void, Void, List<GamesEntity>>() {
        override fun doInBackground(vararg params: Void?): List<GamesEntity> {
            val db = Room.databaseBuilder(context, Database::class.java, "db").build()
            return db.gamesdao().getall()

        }}


}