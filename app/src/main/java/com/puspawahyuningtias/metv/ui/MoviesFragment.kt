package com.puspawahyuningtias.metv.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.puspawahyuningtias.metv.R
import com.puspawahyuningtias.metv.databinding.ActivityMainBinding
import com.puspawahyuningtias.metv.databinding.FragmentMoviesBinding

class MoviesFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMoviesBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
    private val list = ArrayList<Movies>()
    private lateinit var binding: FragmentMoviesBinding
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvHeroes.setHasFixedSize(true)
        list.addAll(getListHeroes())
        showRecyclerList()
    }
    fun getListHeroes(): ArrayList<Movies> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)
        val listHero = ArrayList<Movies>()
        for (position in dataName.indices) {
            val hero = Movies(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        binding.rvHeroes.apply {
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            val listHeroAdapter = ListItemAdapter(list)
            binding.rvHeroes.adapter = listHeroAdapter
        }
    }
}