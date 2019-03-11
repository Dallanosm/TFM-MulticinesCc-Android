package com.multicinescc.app.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.multicinescc.app.R
import com.multicinescc.app.extension.load
import com.multicinescc.app.models.MovieView
import kotlinx.android.synthetic.main.item_movie.view.*

class MoviesAdapter(private val context: Context, private val items: List<MovieView>,
                    private val onItemClicked: (MovieView) -> Unit) : PagerAdapter() {

    override fun isViewFromObject(view: View, `object`: Any): Boolean = view == `object`

    override fun getCount(): Int = items.size

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(context).inflate(R.layout.item_movie, container, false)
        val movie = items[position]
        view.image.load(movie.img)
        view.setOnClickListener { onItemClicked(movie) }
        container.addView(view)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

}