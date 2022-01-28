package com.example.githubrepositorybrowser.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.apollographql.apollo3.exception.ApolloException
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.model.getApolloClient
import kotlinx.coroutines.launch

class ReposListViewModel : ViewModel() {

    val repos = MutableLiveData<List<ReposListQuery.Node?>>()
    init{
        getRepos()
    }

    private fun getRepos(){
        viewModelScope.launch {
            val response = getApolloClient().query(ReposListQuery(4)).execute()
            repos.value = response.data?.viewer?.repositories?.nodes
        }
    }

}