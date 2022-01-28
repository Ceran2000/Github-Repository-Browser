package com.example.githubrepositorybrowser.ui.view.list

import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.ui.viewmodel.ReposListViewModel


@Composable
fun ReposListItem(repo: ReposListQuery.Node?) {

    val paddingModifier = Modifier.padding(10.dp)
    Card(elevation = 10.dp, modifier = paddingModifier.fillMaxWidth()) {
        //TODO: poprawić not null check
        Text(repo?.name.toString(),modifier = paddingModifier, textAlign = TextAlign.Center, fontSize = 24.sp)
    }
}