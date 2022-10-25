package com.netoloboapps.activitylifecycle

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.netoloboapps.activitylifecycle.ui.theme.ActivityLifeCycleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.i(TAG, "Create")
        setContent {
            ActivityLifeCycleTheme {
                ActivityLifeCycleApp()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG, "OnStart")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "OnResume")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "OnPause")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "OnStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "OnDestroy")
    }


    companion object {
        const val TAG = "IGTILog"
    }
}

@Composable
fun ActivityLifeCycleApp() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "initial_screen"
    ) {
        composable(route = "initial_screen") {
            InitialScreen(
                onButtonClick = { navController.navigate("second_screen") }
            )
        }
        composable(route = "second_screen") {
            SecondScreen(
                onButtonClick = {
                    navController.navigate("initial_screen"){
                        popUpTo("initial_screen"){
                            inclusive = true
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ActivityLifeCycleTheme {
        InitialScreen(
            onButtonClick = {}
        )
    }
}