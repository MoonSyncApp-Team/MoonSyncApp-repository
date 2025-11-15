package com.example.moonsyncapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun PillScheduleScreen(navController: NavHostController) {
    var selectedSchedule by remember { mutableStateOf("28 days without break") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "How would you take\nyour pill?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MoonSyncColors.DarkText,
            textAlign = TextAlign.Center,
            lineHeight = 36.sp
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "This assists us with understanding your\npersonal designs better",
            fontSize = 15.sp,
            color = MoonSyncColors.GrayText,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(120.dp))

        // Dropdown-style selector
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Up arrow
            IconButton(onClick = { /* Scroll up */ }) {
                Icon(
                    Icons.Default.KeyboardArrowUp,
                    contentDescription = "Previous",
                    tint = Color.LightGray
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Selected option
            Text(
                text = selectedSchedule,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = MoonSyncColors.DarkText
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Down arrow
            IconButton(onClick = { /* Scroll down */ }) {
                Icon(
                    Icons.Default.KeyboardArrowDown,
                    contentDescription = "Next",
                    tint = Color.LightGray
                )
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Next Button
        Button(
            onClick = { navController.navigate(Routes.HOME) },
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = MoonSyncColors.PrimaryPurple
            ),
            shape = RoundedCornerShape(28.dp)
        ) {
            Text(
                text = "NEXT",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(40.dp))
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun PillScheduleScreenPreview() {
    PillScheduleScreen(navController = rememberNavController())
}