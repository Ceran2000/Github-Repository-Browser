package com.example.githubrepositorybrowser.ui.view.details

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.twotone.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.githubrepositorybrowser.ReposListQuery
import com.example.githubrepositorybrowser.ui.theme.GithubRepositoryBrowserTheme


@Composable
fun RepoDetails(navController: NavController, repo: ReposListQuery.Node?) {

    Scaffold(
        topBar = { TopBarDetails(onBackArrowClicked = navController::popBackStack) },
        content = { DetailsContent(repo) }
    )
}

@Composable
fun TopBarDetails(onBackArrowClicked: () -> Unit) {

    TopAppBar(
        title = {
            Text(text = "Details", color = Color.White)
        },
        navigationIcon = {
            Icon(
                imageVector = Icons.TwoTone.ArrowBack,
                contentDescription = "Back",
                modifier = Modifier
                    .clickable(onClick = onBackArrowClicked)
                    .padding(8.dp),
                tint = Color.White

            )
        },
        backgroundColor = Color.DarkGray
    )
}

@Composable
fun DetailsContent(repo: ReposListQuery.Node?) {

    repo?.let {
        Column(
            modifier = Modifier
                .fillMaxHeight(0.5f)
                .fillMaxWidth()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            val paddingModifier = Modifier.padding(4.dp)
            Text(
                repo.name,
                fontSize = 36.sp,
                textAlign = TextAlign.Center,
                modifier = paddingModifier
            )
            repo.description?.let { desc ->
                Text(
                    desc,
                    fontSize = 18.sp,
                    color = Color.Gray,
                    modifier = paddingModifier
                )
            }
            Text(
                "Issues: ${repo.issues.totalCount}",
                fontSize = 18.sp,
                color = Color.Gray,
                modifier = paddingModifier
            )
            Text(
                "Commit comments: ${repo.commitComments.totalCount}",
                fontSize = 18.sp,
                color = Color.Gray,
                modifier = paddingModifier
            )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    val title = "Github Repository Browser"
    val desc = "Application that displays repositories of single GitHub user"
    val issues = "0"
    val commits = "1"
    GithubRepositoryBrowserTheme {
        Column(
            modifier = Modifier
                .background(color = Color.Green)
                .padding(16.dp),
        ) {
            Text(title, fontSize = 36.sp, textAlign = TextAlign.Center)
            Text(desc, fontSize = 24.sp, textAlign = TextAlign.Center)
            Row {
                Text("Issues: $issues")
                Spacer(modifier = Modifier.weight(1f))
                Text("Commit comments: $commits", textAlign = TextAlign.Right)
            }
        }
    }
}