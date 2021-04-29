package com.puspawahyuningtias.metv.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.puspawahyuningtias.metv.R
import com.puspawahyuningtias.metv.data.DataFilm
import org.junit.Rule
import org.junit.Test

class MainActivityTest{
    private val dataMovie = DataFilm.generateMovies()
    private val dataTvShow = DataFilm.generateTvShow()

    @get:Rule
    var activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataMovie.size))
    }
    @Test
    fun loadDetailFilm() {
        onView(withId(R.id.rv_movies)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_movies_deskripsi)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movies_deskripsi)).check(matches(withText(dataMovie[0].description)))
        onView(withId(R.id.tv_movies_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movies_judul)).check(matches(withText(dataMovie[0].judul)))
        onView(withId(R.id.tv_movies_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movies_genre)).check(matches(withText(dataMovie[0].genre)))
        onView(withId(R.id.tv_movies_tahun)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_movies_tahun)).check(matches(withText(dataMovie[0].tahun)))
    }
    @Test
    fun loadTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(dataMovie.size))
    }

    @Test
    fun loadDetailTvShow() {
        onView(withText("TV SHOW")).perform(click())
        onView(withId(R.id.rv_tv_show)).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0, click()))
        onView(withId(R.id.tv_tvshow_deskripsi)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_deskripsi)).check(matches(withText(dataTvShow[0].description)))
        onView(withId(R.id.tv_tvshow_judul)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_judul)).check(matches(withText(dataTvShow[0].judul)))
        onView(withId(R.id.tv_tvshow_genre)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_genre)).check(matches(withText(dataTvShow[0].genre)))
        onView(withId(R.id.tv_tvshow_tahun)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_tvshow_tahun)).check(matches(withText(dataTvShow[0].tahun)))
    }
}