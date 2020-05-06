package com.example.newsreader.ui.view.listchannel

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreader.R
import com.example.newsreader.models.Source
import com.example.newsreader.ui.adapter.ListSourcesAdapter
import com.example.newsreader.ui.view.listartical.ArticleBySourceActivity
import com.example.newsreader.utils.OnItemClickListener
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity


class ListSourcesActivity : AppCompatActivity(), ListSourcesView {


    private lateinit var rvSources: RecyclerView
    private lateinit var pbSources: ProgressBar
    private lateinit var toolbar: Toolbar
    private lateinit var adapter: ListSourcesAdapter
    private var sources = ArrayList<Source>()
    private lateinit var presenter: ListSourcesPresenter


    override fun insertListSources(data: List<Source>?) {
        data?.let {
            sources.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

    override fun loadingData(isNotFinished: Boolean) {
        pbSources.visibility = if (isNotFinished) View.VISIBLE else View.GONE
        rvSources.visibility = if (isNotFinished) View.GONE else View.VISIBLE
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listsources)

        init()
        presenter.getSources()
    }

    private fun init() {
        pbSources = find(R.id.pb_sources)
        toolbar = find(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.title = resources.getString(R.string.do_choose_sources)


        rvSources = find(R.id.rv_sources)
        rvSources.layoutManager = GridLayoutManager(this, 2)

        adapter = ListSourcesAdapter(sources)
        adapter.setOnItemClickListener(OnItemClickListener {
            startActivity<ArticleBySourceActivity>("source" to it)
        })

        rvSources.adapter = adapter

        presenter = ListSourcesPresenter(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            android.R.id.home -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }

}
