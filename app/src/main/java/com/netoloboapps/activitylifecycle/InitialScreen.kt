package com.netoloboapps.activitylifecycle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.netoloboapps.activitylifecycle.ui.theme.ActivityLifeCycleTheme

@Composable
fun InitialScreen(
    onButtonClick: () -> Unit
){
    // A surface container using the 'background' color from the theme
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Button(
                onClick = onButtonClick
            ) {
                Text(text = stringResource(id = R.string.new_screen))
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun DefaultInitialScreen() {
    ActivityLifeCycleTheme { InitialScreen {} }
}