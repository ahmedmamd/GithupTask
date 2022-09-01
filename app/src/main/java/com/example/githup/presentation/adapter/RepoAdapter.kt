package com.example.githup.presentation.adapter


import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.githup.R
import com.example.githup.data.models.RepoModel
import com.example.githup.data.source.local.RepoDao
import com.example.githup.data.source.local.RepoEntity
import com.example.githup.databinding.ItemRepoBinding

class RepoAdapter: PagingDataAdapter<RepoModel, RepoAdapter.ViewHolder>(DataDifferntiator),RepoDao {



    lateinit var repoEntity: RepoEntity

    class ViewHolder(var binding: ItemRepoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.binding.repo = getItem(position)
         repoEntity = RepoEntity(getItem(position)!!.id,getItem(position)!!.name,getItem(position)!!.owner.login,getItem(position)!!.description,getItem(position)!!.fork )
            save(repoEntity)

        if (getItem(position)!!.fork){
            holder.binding.itemCard.setBackgroundColor(Color.WHITE)
        }
        else
        {
            holder.binding.itemCard.setBackgroundColor(Color.GREEN)
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding : ItemRepoBinding
        binding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_repo,parent,false)
        return ViewHolder(binding)
    }

    object DataDifferntiator : DiffUtil.ItemCallback<RepoModel>() {

        override fun areItemsTheSame(oldItem: RepoModel, newItem: RepoModel): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: RepoModel, newItem: RepoModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun getAll(): RepoEntity? {
        TODO("Not yet implemented")
    }

    override fun save(user: RepoEntity) {

    }

    override fun deleteAll() {
        TODO("Not yet implemented")
    }

}