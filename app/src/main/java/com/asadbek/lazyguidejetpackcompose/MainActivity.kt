package com.asadbek.lazyguidejetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.asadbek.lazyguidejetpackcompose.ui.theme.LazyGuideJetpackComposeTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyGuideJetpackComposeTheme {
                val state = rememberLazyListState(
                    initialFirstVisibleItemIndex = 99 // boshlang'ich birinchi ko'rinadigan ItemIndex
                )
                LazyVerticalGrid( // lazyVerticalGrid
                    // cells = item ko`rinishi hisoblanadi va ular ikki ko`rinishda fixed va adaptive
                    cells = GridCells.Fixed(2), // GridCells.Adaptive(100.dp) // GridCells.Fixed(5)
                    state = state,
                    content = {
                        items(100) { i ->
                            Box(modifier = Modifier
                                .padding(8.dp) // paddin 4 taraflama
                                .aspectRatio(1f)
                                .clip(RoundedCornerShape(5.dp)) // corner radiusi
                                .background(Color.Green), // item fon rangi
                                contentAlignment = Alignment.Center) {
                                Text(text = "Item raqami: $i")


                            }
                        }

                    })
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LazyGuideJetpackComposeTheme {
        Greeting("Android")
    }
}