package com.example.githubrepositorybrowser.ui.view.list

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.ui.viewmodel.ReposListViewModel


@Composable
fun ReposListItem(repoItem: ReposListQuery.Node) {
    repoItem.let {
        Text(it.name)
    }
}