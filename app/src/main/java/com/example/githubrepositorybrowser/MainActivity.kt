package com.example.githubrepositorybrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.githubrepositorybrowser.ui.theme.GithubRepositoryBrowserTheme
import com.example.githubrepositorybrowser.ui.view.list.ReposListItem
import com.example.githubrepositorybrowser.ui.viewmodel.ReposListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel by viewModels<ReposListViewModel>()
        mainViewModel.repos.observe(this) { nodes ->
            setContent {
                GithubRepositoryBrowserTheme {
                    Greetings(nodes)
                }
            }
        }
    }
}


@Composable
fun Greetings(list: List<ReposListQuery.Node?>) {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        items(list){ title ->
            ReposListItem(title)

        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val sampleList = listOf(
        "SimpleWeatherApp",
        "Random Reminder",
        "Best Quotes App",
        "GitHub Repository Browser"
    )
    GithubRepositoryBrowserTheme {
        ShowListExample(sampleList)
    }
}

@Composable
fun ShowListExample(list: List<String>) {

    Column {
        for (item in list) {
            val paddingModifier = Modifier.padding(10.dp)
            Card(elevation = 10.dp, modifier = paddingModifier.fillMaxWidth()) {
                //TODO: poprawić not null check
                Text(
                    text = item,
                    modifier = paddingModifier,
                    textAlign = TextAlign.Center,
                    fontSize = 24.sp
                )
            }
        }
    }

}