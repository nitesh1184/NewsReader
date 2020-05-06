package com.example.newsreader.ui.view.listartical

import android.os.Bundle

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.newsreader.models.Article
import com.example.newsreader.ui.adapter.ListArticlesAdapter
import com.example.newsreader.R
import com.example.newsreader.ui.view.details.DetailArticleActivity
import com.example.newsreader.utils.OnItemClickListener
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity


class ListArticlesFragment : Fragment(), ListArticlesView {

    private lateinit var rvArticles: RecyclerView
    private lateinit var pbArticles: ProgressBar
    private lateinit var adapter: ListArticlesAdapter
    private var articles = ArrayList<Article>()
    private lateinit var presenter: ListArticlesPresenter


    override fun insertListArticles(data: List<Article>?) {
        data?.let {
            articles.addAll(it)
            adapter.notifyDataSetChanged()
        }
    }

    override fun loadingData(isNotFinished: Boolean) {
        pbArticles.visibility = if(isNotFinished) View.VISIBLE else View.GONE
        rvArticles.visibility = if(isNotFinished) View.GONE else View.VISIBLE
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        val rootView = inflater.inflate(R.layout.fragment_listarticles, container, false)

        init(rootView)

        arguments?.takeIf { it.containsKey("category") }?.apply {
            getString("category")?.let {
                presenter.getArticlesByCategory((activity as ArticleBySourceActivity).getSourceName(),
                    it
                )
            }
        }
        return rootView
    }

    private fun init(view : View){
        pbArticles = view.find(R.id.pb_articles)

        rvArticles = view.find(R.id.rv_articles)
        rvArticles.layoutManager = LinearLayoutManager(activity)
        rvArticles.isNestedScrollingEnabled = true

        adapter = ListArticlesAdapter(articles)
        adapter.setOnItemClickListener(OnItemClickListener {
            activity?.startActivity<DetailArticleActivity>("article" to it)
        })

        rvArticles.adapter = adapter

        presenter = ListArticlesPresenter(this)
    }

}
