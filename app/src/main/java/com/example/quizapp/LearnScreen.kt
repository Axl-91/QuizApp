package com.example.quizapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizapp.ui.theme.PurpleGrey40
import com.example.quizapp.ui.theme.Typography

@Composable
fun LearnScreen(navController: NavController) {
    val modules = listOf(
        Module(1, "Module 1"),
        Module(2, "Module 2"),
        Module(3, "Module 3"),
        Module(4, "Module 4"),
        Module(5, "Module 5"),
        Module(6, "Module 6"),
        Module(7, "Module 7"),
        Module(8, "Module 8"),
        Module(9, "Module 9"),
        Module(10, "Module 10")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFD5D2D2))
            .padding(16.dp)
    ) {
        Column(
            modifier =
                Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp)
                    .background(Color.White, shape = RoundedCornerShape(8.dp))
        ) {
            Text(
                "Welcome, TestUser",
                style = Typography.titleLarge,
                modifier = Modifier.padding(10.dp)
            )

            Text(
                "Ear we go, dive into harmonic bliss",
                style = Typography.labelSmall,
                color = PurpleGrey40,
                modifier = Modifier.padding(horizontal = 10.dp).padding(bottom = 5.dp)
            )
        }

        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth()
                .background(Color.White, shape = RoundedCornerShape(8.dp))
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(32.dp)
            ) {
                itemsIndexed(modules) { index, module ->
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        val offsetX = if (index % 2 == 0) (-80).dp else 80.dp

                        ModuleCircle(
                            module = module,
                            modifier = Modifier.offset(x = offsetX)
                        ) {
                            navController.navigate("quiz/${module.id}")
                        }
                    }
                }
            }
        }
    }
}