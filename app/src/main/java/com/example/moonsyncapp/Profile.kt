package com.example.moonsyncapp

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun ProfileScreen(navController: NavHostController) {
    var selectedTab by remember { mutableStateOf(4) }

    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                selectedTab = selectedTab,
                onTabSelected = {
                    selectedTab = it
                    when(it) {
                        0 -> navController.navigate(Routes.HOME)
                        1 -> navController.navigate(Routes.CALENDAR)
                        3 -> navController.navigate(Routes.NOTIFICATIONS)
                        4 -> navController.navigate(Routes.PROFILE)
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues)
                .padding(24.dp)
        ) {
            // Header
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Profile",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = MoonSyncColors.DarkText
                )

                IconButton(onClick = { /* Settings */ }) {
                    Icon(
                        Icons.Default.Settings,
                        contentDescription = "Settings",
                        tint = MoonSyncColors.DarkText
                    )
                }
            }

            Spacer(modifier = Modifier.height(32.dp))

            // Profile Picture and Name
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Box(
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape)
                        .background(MoonSyncColors.LightPurple)
                        .border(3.dp, MoonSyncColors.PrimaryPurple, CircleShape),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "👤",
                        fontSize = 48.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                Text(
                    text = "Ada Smith",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = MoonSyncColors.DarkText
                )

                Text(
                    text = "ada.smith@email.com",
                    fontSize = 14.sp,
                    color = MoonSyncColors.GrayText
                )
            }

            Spacer(modifier = Modifier.height(40.dp))

            // Profile Options
            ProfileOption(
                icon = Icons.Default.Person,
                title = "Personal Information",
                subtitle = "Update your details",
                onClick = { }
            )

            ProfileOption(
                icon = Icons.Default.CalendarToday,
                title = "Cycle Settings",
                subtitle = "Manage cycle preferences",
                onClick = { }
            )

            ProfileOption(
                icon = Icons.Default.Notifications,
                title = "Notifications",
                subtitle = "Configure alerts",
                onClick = { }
            )

            ProfileOption(
                icon = Icons.Default.Lock,
                title = "Privacy & Security",
                subtitle = "Manage your privacy",
                onClick = { }
            )

            ProfileOption(
                icon = Icons.Default.Info,
                title = "About",
                subtitle = "App version & info",
                onClick = { }
            )

            Spacer(modifier = Modifier.weight(1f))

            // Logout Button
            OutlinedButton(
                onClick = { navController.navigate(Routes.WELCOME) },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(56.dp),
                shape = RoundedCornerShape(28.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    contentColor = Color.Red
                )
            ) {
                Icon(
                    Icons.Default.ExitToApp,
                    contentDescription = "Logout",
                    modifier = Modifier.size(20.dp)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Logout",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ProfileOption(
    icon: ImageVector,
    title: String,
    subtitle: String,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        shape = RoundedCornerShape(16.dp),
        color = MoonSyncColors.LightPurple.copy(alpha = 0.3f),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(48.dp)
                    .clip(CircleShape)
                    .background(MoonSyncColors.PrimaryPurple),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    icon,
                    contentDescription = title,
                    tint = Color.White,
                    modifier = Modifier.size(24.dp)
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = title,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = MoonSyncColors.DarkText
                )
                Text(
                    text = subtitle,
                    fontSize = 13.sp,
                    color = MoonSyncColors.GrayText
                )
            }

            Icon(
                Icons.Default.KeyboardArrowRight,
                contentDescription = "Navigate",
                tint = MoonSyncColors.GrayText
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ProfileScreenPreview() {
    ProfileScreen(navController = rememberNavController())
}
