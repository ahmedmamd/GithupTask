package com.example.githup.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githup.R
import com.example.githup.databinding.ActivityRopoBinding
import com.example.githup.presentation.adapter.RepoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import androidx.recyclerview.widget.RecyclerView


@AndroidEntryPoint
class RopoActivity : AppCompatActivity() {
    lateinit var binding: ActivityRopoBinding
    var repoViewModel: RepoViewModel? = null

    lateinit var mainListAdapter: RepoAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_ropo)
        repoViewModel=  ViewModelProviders.of(this).get(RepoViewModel::class.java)


        initView()
        getMyRepoList()
    }
    private fun initView() {
        with(binding){
            mainListAdapter = RepoAdapter()
            repoList.apply {
                layoutManager = LinearLayoutManager(this@RopoActivity)
                adapter = mainListAdapter


                var loading = true
                var pastVisiblesItems: Int
                var visibleItemCount: Int
                var totalItemCount: Int

                repoList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                        if (dy > 0) { //check for scroll down
                            visibleItemCount = layoutManager!!.getChildCount()
                            totalItemCount = layoutManager!!.getItemCount()
                            pastVisiblesItems = (layoutManager!! as LinearLayoutManager).findFirstVisibleItemPosition()
                            if (loading) {
                                if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                                    loading = false
                                    getMyRepoList()
//                                    Log.v("...", "Last Item Wow !")
                                    // Do pagination.. i.e. fetch new data
                                    loading = true
                                }
                            }
                        }
                    }
                })
            }
        }
    }

    private fun getMyRepoList(){
        lifecycleScope.launch {
            repoViewModel?.listData?.collect {
                mainListAdapter.submitData(it)
            }
    }}

}