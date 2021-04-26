package com.puspawahyuningtias.metv.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.puspawahyuningtias.metv.R
import com.puspawahyuningtias.metv.databinding.FragmentMoviesBinding
import com.puspawahyuningtias.metv.databinding.FragmentTvShowBinding

class TvShowFragment : Fragment() {
    private lateinit var fragmentTvShowBinding: FragmentTvShowBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        fragmentTvShowBinding = FragmentTvShowBinding.inflate(layoutInflater, container, false)
        return fragmentTvShowBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[MoviesViewModel::class.java]
            val courses = viewModel.getCourses()
            val academyAdapter = ListItemAdapter()
            academyAdapter.setCourses(courses)

            with(fragmentTvShowBinding.rvTvShow) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = academyAdapter
            }
        }
    }
}