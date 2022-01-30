package com.example.githubrepositorybrowser.ui.view.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.ui.viewmodel.ReposListViewModel


@Composable
fun ReposListView(navController: NavController, viewModel: ReposListViewModel) {

    val user: String by viewModel.user.observeAsState("")

    Scaffold(
        topBar = {
            TopBar(title = user)
        },
        content = {
            ReposListContent(navController, viewModel)
        }
    )
}

@Composable
fun ReposListContent(navController: NavController, viewModel: ReposListViewModel) {

    val repos: List<ReposListQuery.Node?> by viewModel.repos.observeAsState(listOf())
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(repos) { repo ->
            ReposListItem(navController, repo, onClick = viewModel::chooseRepoToDisplay)
        }

    }

}

@Composable
fun ReposListItem(
    navController: NavController,
    repo: ReposListQuery.Node?,
    onClick: (ReposListQuery.Node?) -> Unit
) {

    val paddingModifier = Modifier.padding(8.dp)
    repo?.name?.let { name ->
        Card(
            elevation = 10.dp,
            modifier = paddingModifier
                .fillMaxWidth(0.75f)
                .clickable {
                    onClick(repo)
                    navController.navigate("repoDetails")
                }
        ) {
            Row {
                Text(
                    name,
                    modifier = paddingModifier.weight(0.8f),
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "See Details",
                    modifier = Modifier
                        .align(Alignment.CenterVertically)
                        .weight(0.2f),
                    tint = Color.DarkGray

                )
            }

        }
    }

}

@Composable
fun TopBar(title: String?) {
    TopAppBar(
        title = {
            title?.let { Text(text = it, color = Color.White) }
        }, backgroundColor = Color.DarkGray
    )
}