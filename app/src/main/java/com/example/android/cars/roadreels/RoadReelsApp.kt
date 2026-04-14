package com.example.android.cars.roadreels
//add navigation button (from detail screen to homescreen)
//add item button's lib
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberTopAppBarState
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.android.cars.roadreels.ui.screen.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RoadReelsApp(
    windowSizeClass: WindowSizeClass
) {
    val navController = rememberNavController()
    val scrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState())

    val currentBackStackEntryState = navController.currentBackStackEntryAsState()
    val currentBackStackEntry = currentBackStackEntryState.value
    val route = currentBackStackEntry?.destination?.route

    Scaffold(
        modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            if (route?.equals(Screen.Main.name) == true) {
                CenterAlignedTopAppBar(
                    title = { Text(stringResource(R.string.app_name)) },
                    scrollBehavior = scrollBehavior,
                )

            } else if (route?.startsWith(Screen.Detail.name) == true) {
                CenterAlignedTopAppBar(
                    title = { Text(stringResource(R.string.bbb_title)) },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Icon(
                                Icons.AutoMirrored.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    }
                )
            }

        },
        // Setting this to 0dp for the player allows the video to take up the full
        // screen space even before the system bars hiding animation completes.
        contentWindowInsets = if (route?.equals(Screen.Player.name) == true) WindowInsets(0.dp) else WindowInsets.systemBars
    ) { innerPadding ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .consumeWindowInsets(innerPadding),
            color = if (route?.equals(Screen.Player.name) == true) Color.Black else MaterialTheme.colorScheme.background
        ) {
            RoadReelsNavHost(windowSizeClass, navController)
        }
    }
}