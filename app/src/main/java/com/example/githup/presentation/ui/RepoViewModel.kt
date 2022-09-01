package com.example.githup.presentation.ui

import androidx.lifecycle.ViewModel
import com.example.githup.data.repository.SetRepositoryImp
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RepoViewModel @Inject constructor (homeRepositoryImp: SetRepositoryImp): ViewModel()
{
    val listData = homeRepositoryImp.getRepo()

}