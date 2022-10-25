package com.netoloboapps.activitylifecycle

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.netoloboapps.activitylifecycle.ui.theme.ActivityLifeCycleTheme

@Composable
fun SecondScreen(onButtonClick: () -> Unit){
    //variable used to preserve the visibility of the back button even with screen rotation
    var buttonBackIsVisible by rememberSaveable { mutableStateOf(false)}

        Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(8.dp)
        ) {
            Button(
                onClick = { buttonBackIsVisible = !buttonBackIsVisible },
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .weight(1.0f)
                    .padding(bottom = 8.dp)
            ) {
                Text(text = stringResource(id = R.string.show_new_button))
            }
            AnimatedVisibility(visible = buttonBackIsVisible) {
                Button(
                    onClick = onButtonClick,
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.5f)
                ) {
                    Icon(
                        Icons.Filled.ArrowBack,
                        contentDescription = null,
                    )
                    Text(text = stringResource(id = R.string.back))

                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSecondScreen(){
    ActivityLifeCycleTheme { SecondScreen {} }
}