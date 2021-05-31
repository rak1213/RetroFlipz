package com.rak12.retroflipz.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.rak12.retroflipz.R
import com.rak12.retroflipz.adapter.GamesAdapter
import com.rak12.retroflipz.model.Games


class HomeFragment : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var layoutManager: RecyclerView.LayoutManager
    lateinit var adapter: GamesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recycler_games)

        layoutManager = LinearLayoutManager(requireContext())
        var gamelist = arrayListOf<Games>()
        gamelist.add(Games(1,"simon", "https://rak1213.github.io/Simon-Game/", R.drawable.scroller,"w"))
        gamelist.add(Games(2,"Light it up!", "https://rak1213.github.io/light-it-up/", R.drawable.light_it_up,"s"))
        gamelist.add(Games(3,"2048", "https://rak1213.github.io/2048/", R.drawable.a_2048,"s"))
        gamelist.add(Games(4,"Decody", "https://tejasvibhutiyal.github.io/decodyV1/", R.drawable.decody,"d"))
        gamelist.add(Games(5,"Life Guard", "https://tejasvibhutiyal.github.io/saveV1/", R.drawable.life_guard,"d"))
        gamelist.add(Games(6,"Scroller", "https://ravish22.github.io/Game/Scroller/", R.drawable.scroller,"d"))
        gamelist.add(Games(7,"Pacman","https://tejasvibhutiyal.github.io/PacmanV2/",R.drawable.pacman,"d"))
        adapter = GamesAdapter(requireContext(), gamelist)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        return view
    }


}