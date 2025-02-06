package com.example.snoesstoreapplication.presentation.screen.favourite

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.snoesstoreapplication.R
import com.example.snoesstoreapplication.data.models.Product
import com.example.snoesstoreapplication.data.models.UIProduct
import com.example.snoesstoreapplication.data.models.UIProducts
import com.example.snoesstoreapplication.presentation.components.BottomNavigation
import com.example.snoesstoreapplication.presentation.components.ProductCard
import com.example.snoesstoreapplication.presentation.theme.AppAccent
import com.example.snoesstoreapplication.presentation.theme.AppBackground
import com.example.snoesstoreapplication.presentation.theme.AppRed
import io.github.jan.supabase.createSupabaseClient
import io.github.jan.supabase.postgrest.Postgrest
import io.github.jan.supabase.postgrest.from
import io.github.jan.supabase.serializer.KotlinXSerializer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

@Composable
fun FavouriteScreen(navController: NavController) {
    val products = remember {
        mutableStateListOf<Product>()
    }
    var isLoading by remember { mutableStateOf(false) }

    val supabase = createSupabaseClient(
        supabaseUrl = "https://pzvpuvqokihpvcxliogq.supabase.co",
        supabaseKey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InB6dnB1dnFva2locHZjeGxpb2dxIiwicm9sZSI6ImFub24iLCJpYXQiOjE3Mzg3NzI0OTksImV4cCI6MjA1NDM0ODQ5OX0.QHXOP-sk7IfqLRy9IqAjKJ_9L0G6t6nj7dX-u8pEZ_4"
    ) {
        defaultSerializer = KotlinXSerializer()
        install(Postgrest)
    }

    LaunchedEffect(Unit) {
        withContext(Dispatchers.IO) {
            isLoading = true
            val results = supabase.from("products").select().decodeList<Product>()
            products.addAll(results)
            isLoading = false
        }
    }


    if (!isLoading) {
        Column(
            Modifier
                .fillMaxSize()
                .background(AppBackground)
                .padding(top = 15.dp)
        ) {
            Row(
                Modifier
                    .fillMaxWidth()
                    .padding(25.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(
                    onClick = {

                    },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
                    modifier = Modifier.size(55.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.back),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),
                    )
                }
                Text(
                    text = "Избранное",
                    fontSize = 22.sp
                )
                IconButton(
                    onClick = {

                    },
                    colors = IconButtonDefaults.iconButtonColors(containerColor = Color.White),
                    modifier = Modifier.size(55.dp)
                ) {
                    Icon(
                        imageVector = ImageVector.vectorResource(R.drawable.favorite_fill),
                        contentDescription = "",
                        modifier = Modifier.size(30.dp),
                        tint = AppRed
                    )
                }
            }
            Spacer(Modifier.padding(20.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                items(UIProducts) {item ->
                    ProductCard(item)
                }
            }
        }
        Column(
            Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            BottomNavigation(2)
        }
    } else {
        CircularProgressIndicator(
            modifier = Modifier.fillMaxSize(),
            color = AppAccent,
            trackColor = AppBackground
        )
    }
}


@Preview
@Composable
private fun FavouriteScreenPreview() {
    FavouriteScreen(rememberNavController())
}