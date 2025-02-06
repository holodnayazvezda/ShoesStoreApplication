package com.example.snoesstoreapplication.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.snoesstoreapplication.R
import com.example.snoesstoreapplication.data.models.UIProduct
import com.example.snoesstoreapplication.presentation.theme.AppAccent
import com.example.snoesstoreapplication.presentation.theme.AppBackground
import com.example.snoesstoreapplication.presentation.theme.AppHint
import com.example.snoesstoreapplication.presentation.theme.AppRed
import com.example.snoesstoreapplication.presentation.theme.AppText

@Composable
fun ProductCard(UIProduct: UIProduct) {
    Box(Modifier
        .width(250.dp)
        .clip(RoundedCornerShape(25.dp))
        .background(Color.White)
    ) {
        Column(Modifier.fillMaxWidth()) {
            Image(
                modifier = Modifier.fillMaxWidth().width(120.dp).padding(top = 30.dp, start = 25.dp),
                painter = painterResource(UIProduct.image),
                contentDescription = "",
                contentScale = ContentScale.FillWidth
            )
            Spacer(Modifier.padding(65.dp))
            Row(
                Modifier.fillMaxWidth().padding(start = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "₽${UIProduct.price}",
                    color = AppText,
                    fontSize = 18.sp
                )
                Box(
                    Modifier
                        .width(50.dp).height(50.dp)
                        .clip(RoundedCornerShape(topStart = 25.dp))
                        .background(AppAccent),
                    contentAlignment = Alignment.Center
                ) {
                    IconButton(
                        onClick = {

                        },
                        modifier = Modifier.size(30.dp)
                    ) {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.add),
                            contentDescription = "",
                            modifier = Modifier.size(40.dp),
                            tint = Color.White
                        )
                    }
                }
            }
        }

        Column(
            Modifier.padding(start = 20.dp, top = 20.dp)
        ) {
            IconButton(
                onClick = {

                },
                colors = IconButtonDefaults.iconButtonColors(containerColor = AppBackground),
                modifier = Modifier.size(50.dp)
            ) {
                Icon(
                    imageVector = ImageVector.vectorResource(R.drawable.favorite_fill),
                    contentDescription = "",
                    modifier = Modifier.size(25.dp),
                    tint = AppRed
                )
            }
            Spacer(Modifier.padding(30.dp))
            Text(
                text = UIProduct.title,
                fontSize = 20.sp,
                color = AppAccent
            )
            Spacer(Modifier.padding(10.dp))
            Text(
                text = UIProduct.name,
                fontSize = 30.sp,
                color = AppHint
            )
            Spacer(Modifier.padding(10.dp))
        }

    }
}


@Preview
@Composable
private fun ProductCardPrev() {
    ProductCard(UIProduct())
}
