package com.rak12.retroflipz.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rak12.retroflipz.R
import com.rak12.retroflipz.adapter.GamesAdapter
import com.rak12.retroflipz.model.Games

class MainActivity : AppCompatActivity() {
    lateinit var progressLayout: RelativeLayout
    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter:GamesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //progressLayout=findViewById(R.id.progress_layout)
        recyclerView=findViewById(R.id.recycler_games)
        layoutManager=LinearLayoutManager(this)
      var gamelist= arrayListOf<Games>()
        gamelist.add(Games("simon","https://rak1213.github.io/Simon-Game/","sdcd"))
        gamelist.add(Games("Light it up!","https://rak1213.github.io/light-it-up/","sdcd"))
        gamelist.add(Games("2048","https://rak1213.github.io/2048/","sdcd"))
        gamelist.add(Games("Decody","https://tejasvibhutiyal.github.io/decodyV1/","sdcd"))
        gamelist.add(Games("Life Guard","https://tejasvibhutiyal.github.io/saveV1/","sdcd"))
        gamelist.add(Games("Scroller","https://ravish22.github.io/Game/Scroller/","sdcd"))
 adapter=GamesAdapter(this,gamelist)
      recyclerView.layoutManager=layoutManager
        recyclerView.adapter=adapter


    }
}