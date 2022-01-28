package com.example.githubrepositorybrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.githubrepositorybrowser.ui.theme.GithubRepositoryBrowserTheme
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

    Column {
        for (item in list) {
            item?.name?.let { Text(it) }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubRepositoryBrowserTheme {
        //Greeting("Android")
    }
}