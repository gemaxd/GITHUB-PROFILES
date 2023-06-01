package com.manarimjesse.githubprofiles.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.annotation.ExperimentalCoilApi
import com.manarimjesse.githubprofiles.presentation.user_detail.UserDetailScreen
import com.manarimjesse.githubprofiles.presentation.user_detail.UserDetailScreenViewModel
import com.manarimjesse.githubprofiles.presentation.user_list.UserListScreen
import com.manarimjesse.githubprofiles.presentation.user_list.UserListScreenViewModel

@ExperimentalCoilApi
@ExperimentalMaterial3Api
@ExperimentalAnimationApi
@ExperimentalFoundationApi
@Composable
fun SetupNavigation(){
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.UserListScreen.route){

        composable(
            route = Screen.UserListScreen.route
        ){
            val viewModel = hiltViewModel<UserListScreenViewModel>()
            val state = viewModel.state

            UserListScreen(
                navController = navController,
                state = state.value,
                onEvent = viewModel::onEvent
            )
        }

        composable(
            route = Screen.UserDetailScreen.route+ "/{userLogin}",
            arguments = listOf(
                navArgument("userLogin") {
                    type = NavType.StringType
                    nullable = false
                }
            )
        ){ entry ->
            val viewModel = hiltViewModel<UserDetailScreenViewModel>()
            val detailState = viewModel.detailState
            val reposState = viewModel.reposState

            UserDetailScreen(
                navController = navController,
                detailState = detailState.value,
                reposState = reposState.value,
                onEvent = viewModel::onEvent,
                login = entry.arguments?.getString("userLogin") ?: "NONE"
            )
        }
    }
}