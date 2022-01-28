package com.example.githubrepositorybrowser.ui.view.list

import androidx.compose.runtime.Composable
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.ui.viewmodel.ReposListViewModel

@Composable
fun MainList(viewModel: ReposListViewModel) {
    //TODO: pobrac liste z viewModelu i przekazac do ReposList
}

@Composable
fun ReposList(reposList: List<ReposListQuery.Node>) {
    //TODO: wyswietlic liste repozytoriow
}
