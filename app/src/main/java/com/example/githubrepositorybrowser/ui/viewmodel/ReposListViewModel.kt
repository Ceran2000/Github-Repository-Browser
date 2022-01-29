package com.example.githubrepositorybrowser.ui.viewmodel

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.exception.ApolloException
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.model.getApolloClient
import kotlinx.coroutines.launch

class ReposListViewModel : ViewModel() {

    //val repos = MutableLiveData<List<ReposListQuery.Node?>>()
    //var repos by remember { mutableStateOf("")}
    init{
        getRepos()
    }

    private var _repos = MutableLiveData(listOf<ReposListQuery.Node?>())
    val repos: LiveData<List<ReposListQuery.Node?>> = _repos

    private fun getRepos(){
        viewModelScope.launch {
            val response = getApolloClient().query(ReposListQuery(20)).execute()
            _repos.value = response.data?.viewer?.repositories?.nodes
        }
    }

}