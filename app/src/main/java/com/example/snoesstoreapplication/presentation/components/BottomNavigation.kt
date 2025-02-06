package com.example.snoesstoreapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snoesstoreapplication.R
import com.example.snoesstoreapplication.presentation.theme.AppAccent
import com.example.snoesstoreapplication.presentation.theme.AppBackground
import com.example.snoesstoreapplication.presentation.theme.AppSubTextDark

@Composable
fun BottomNavigation(fromScreen: Int) {
    Box(Modifier
        .fillMaxWidth(),
        contentAlignment = Alignment.TopCenter
    ) {
        IconButton(
            onClick = {

            },
            colors = IconButtonDefaults.iconButtonColors(containerColor = AppAccent, contentColor = AppBackground),
            modifier = Modifier.size(65.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(R.drawable.bag2),
                contentDescription = "",
                modifier = Modifier.size(30.dp),
            )
        }
        Image(
            painter = painterResource(R.drawable.bottom),
            contentDescription = "",
            modifier = Modifier.fillMaxWidth(),
            contentScale = ContentScale.FillWidth
        )
        Row(
            Modifier.fillMaxWidth().padding(top = 60.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.width(150.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier.size(35.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.home),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),
                        tint = if (fromScreen == 1) AppAccent else AppSubTextDark
                    )
                }
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier.size(35.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.favorite),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),
                        tint = if (fromScreen == 2) AppAccent else AppSubTextDark
                    )
                }
            }
            Row(
                modifier = Modifier.width(150.dp),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier.size(35.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.notification),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),
                        tint = if (fromScreen == 3) AppAccent else AppSubTextDark
                    )
                }
                IconButton(
                    onClick = {

                    },
                    modifier = Modifier.size(35.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.profile),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),
                        tint = if (fromScreen == 4) AppAccent else AppSubTextDark
                    )
                }
            }
        }
    }
}

@Composable
@Preview
fun BottomNavigationPreview() {
    BottomNavigation(2)
}