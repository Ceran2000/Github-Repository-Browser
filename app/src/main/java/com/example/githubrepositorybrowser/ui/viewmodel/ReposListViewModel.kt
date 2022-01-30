package com.example.githubrepositorybrowser.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.model.getApolloClient
import kotlinx.coroutines.launch

class ReposListViewModel : ViewModel() {

    private var _repos = MutableLiveData(listOf<ReposListQuery.Node?>())
    val repos: LiveData<List<ReposListQuery.Node?>> = _repos

    private var _user = MutableLiveData<String>(null)
    val user: LiveData<String> = _user

    var repoToDisplay: ReposListQuery.Node?

    init {
        getDataFromApi()
        repoToDisplay = null
    }

    private fun getDataFromApi(numberOfRepos: Int = 100) {
        viewModelScope.launch {
            val response = getApolloClient().query(ReposListQuery(numberOfRepos)).execute()
            _repos.value = response.data?.viewer?.repositories?.nodes
            _user.value = response.data?.viewer?.login
        }
    }

    fun chooseRepoToDisplay(repo: ReposListQuery.Node?) {
        repoToDisplay = repo
    }

}