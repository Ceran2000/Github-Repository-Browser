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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import androidx.navigation.*
import androidx.navigation.compose.ComposeNavigator
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.githubrepositorybrowser.ui.theme.GithubRepositoryBrowserTheme
import com.example.githubrepositorybrowser.ui.view.details.RepoDetails
import com.example.githubrepositorybrowser.ui.view.list.ReposListView
import com.example.githubrepositorybrowser.ui.viewmodel.ReposListViewModel
import com.google.accompanist.systemuicontroller.rememberSystemUiController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            val systemUiController = rememberSystemUiController()
            systemUiController.setSystemBarsColor(
                color = Color.DarkGray
            )

            val navController = rememberNavController()
            val reposListViewModel by viewModels<ReposListViewModel>()

            NavHost(navController, startDestination = "reposList") {
                composable(route = "reposList") {
                    ReposListView(navController, reposListViewModel)
                }
                composable(route = "repoDetails") {
                    RepoDetails(navController, reposListViewModel.repoToDisplay)
                }
            }
        }


    }
}