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
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerView = view.findViewById(R.id.recycler_games)

        layoutManager = LinearLayoutManager(requireContext())
        var gamelist = arrayListOf<Games>()
        gamelist.add(Games("simon", "https://rak1213.github.io/Simon-Game/", "sdcd"))
        gamelist.add(Games("Light it up!", "https://rak1213.github.io/light-it-up/", "sdcd"))
        gamelist.add(Games("2048", "https://rak1213.github.io/2048/", "sdcd"))
        gamelist.add(Games("Decody", "https://tejasvibhutiyal.github.io/decodyV1/", "sdcd"))
        gamelist.add(Games("Life Guard", "https://tejasvibhutiyal.github.io/saveV1/", "sdcd"))
        gamelist.add(Games("Scroller", "https://ravish22.github.io/Game/Scroller/", "sdcd"))
        adapter = GamesAdapter(requireContext(), gamelist)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        return view
    }


}