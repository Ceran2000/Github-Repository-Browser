package com.example.githubrepositorybrowser.ui.view.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.ui.viewmodel.ReposListViewModel


@Composable
fun ReposListView(navController: NavController, viewModel: ReposListViewModel) {

    val repos: List<ReposListQuery.Node?> by viewModel.repos.observeAsState(listOf())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        items(repos) { title ->
            ReposListItem(title, onClick = { navController.navigate("repoDetails") })
        }
    }

    //Greetings(repos)
}

@Composable
fun ReposListItem(repo: ReposListQuery.Node?, onClick: () -> Unit) {

    val paddingModifier = Modifier.padding(10.dp)
    Card(
        elevation = 10.dp,
        modifier = paddingModifier
            .fillMaxWidth()
            .clickable { onClick() }

    ) {
        //TODO: poprawić not null check
        Text(
            repo?.name.toString(),
            modifier = paddingModifier,
            textAlign = TextAlign.Center,
            fontSize = 24.sp
        )
    }
}


/*@Composable
fun Greetings(list: List<ReposListQuery.Node?>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        items(list) { title ->
            ReposListItem(title)

        }
    }

}*/
