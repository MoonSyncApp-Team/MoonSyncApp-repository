package com.example.moonsyncapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
fun BirthdateScreen(navController: NavHostController) {
    var selectedMonth by remember { mutableStateOf("Jan") }
    var selectedDay by remember { mutableStateOf(4) }
    var selectedYear by remember { mutableStateOf(2000) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(60.dp))

        Text(
            text = "When were you born?",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MoonSyncColors.DarkText,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Since cycles can change over time, this assists\nus with modifying the application for you",
            fontSize = 15.sp,
            color = MoonSyncColors.GrayText,
            textAlign = TextAlign.Center,
            lineHeight = 22.sp
        )

        Spacer(modifier = Modifier.height(80.dp))

        // Date Picker Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            // Month Picker
            DatePickerColumn(
                value = selectedMonth,
                onValueChange = { selectedMonth = it },
                items = listOf("Jan", "Feb", "Mar", "Apr", "May", "Jun",
                    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"),
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Day Picker
            DatePickerColumn(
                value = selectedDay.toString(),
                onValueChange = { selectedDay = it.toIntOrNull() ?: 4 },
                items = (1..31).map { it.toString() },
                modifier = Modifier.weight(1f)
            )

            Spacer(modifier = Modifier.width(16.dp))

            // Year Picker
            DatePickerColumn(
                value = selectedYear.toString(),
                onValueChange = { selectedYear = it.toIntOrNull() ?: 2000 },
                items = (1950..2010).map { it.toString() },
                modifier = Modifier.weight(1f)
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        // Next Button
        Button(
            onClick = { navController.navigate(Routes.MEDICATION) },
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
fun BirthdateScreenPreview() {
    BirthdateScreen(navController = rememberNavController())
}