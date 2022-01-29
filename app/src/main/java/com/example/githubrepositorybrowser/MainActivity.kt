package com.example.githubrepositorybrowser

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.*
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubrepositorybrowser.ui.theme.GithubRepositoryBrowserTheme
import com.example.githubrepositorybrowser.ui.view.details.RepoDetails
import com.example.githubrepositorybrowser.ui.view.list.ReposListView
import com.example.githubrepositorybrowser.ui.viewmodel.ReposListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            val reposListViewModel by viewModels<ReposListViewModel>()

            NavHost(navController, startDestination = "reposList") {
                composable(route = "reposList") {
                    ReposListView(navController, reposListViewModel)
                }
                composable(route = "repoDetails") {
                    RepoDetails(navController)
                }
            }
        }


    }
}


/*@Preview(showBackground = true)
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
}*/

public fun NavGraphBuilder.composable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    content: @Composable (NavBackStackEntry) -> Unit
) {
    addDestination(
        ComposeNavigator.Destination(provider[ComposeNavigator::class], content).apply {
            this.route = route
            arguments.forEach { (argumentName, argument) ->
                addArgument(argumentName, argument)
            }
            deepLinks.forEach { deepLink ->
                addDeepLink(deepLink)
            }
        }
    )
}