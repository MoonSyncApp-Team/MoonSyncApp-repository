package com.example.moonsyncapp

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BottomNavigationBar(
    selectedTab: Int,
    onTabSelected: (Int) -> Unit
) {
    NavigationBar(
        containerColor = Color.Black,
        modifier = Modifier
            .height(80.dp)
            .clip(RoundedCornerShape(15.dp))
    ) {
        // Home Tab
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.Home,
                    "Home",
                    tint = if (selectedTab == 0) MoonSyncColors.PrimaryPurple else Color.White
                )
            },
            selected = selectedTab == 0,
            onClick = { onTabSelected(0) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MoonSyncColors.PrimaryPurple,
                unselectedIconColor = Color.White,
                indicatorColor = Color.Transparent
            )
        )

        // Calendar Tab
        NavigationBarItem(
            icon = {
                Icon(
                    Icons.Default.CalendarToday,
                    "Calendar",
                    tint = if (selectedTab == 1) MoonSyncColors.PrimaryPurple else Color.White
                )
            },
            selected = selectedTab == 1,
            onClick = { onTabSelected(1) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = MoonSyncColors.PrimaryPurple,
                unselectedIconColor = Color.White,
                indicatorColor = Color.Transparent
            )
        )

        // Add Tab (Center - Always White Circle)
        NavigationBarItem(
            icon = {
                Box(
                    modifier = Modifier
                        .background(Color.White, CircleShape)
                        .size(48.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        Icons.Default.Add,
                        "Add",
                        tint = Color.Black
                    )
                }
            },
            selected = selectedTab == 2,
            onClick = { onTabSelected(2) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = Color.Transparent
            )
        )

        // Notifications Tab - Dynamic Circle
        NavigationBarItem(
            icon = {
                if (selectedTab == 3) {
                    // Show purple circle when selected
                    Box(
                        modifier = Modifier
                            .background(MoonSyncColors.PrimaryPurple, CircleShape)
                            .size(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Notifications,
                            "Notifications",
                            tint = Color.White
                        )
                    }
                } else {
                    // Show just icon when not selected
                    Icon(
                        Icons.Default.Notifications,
                        "Notifications",
                        tint = Color.White
                    )
                }
            },
            selected = selectedTab == 3,
            onClick = { onTabSelected(3) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = Color.Transparent
            )
        )

        // Profile Tab - Dynamic Circle
        NavigationBarItem(
            icon = {
                if (selectedTab == 4) {
                    // Show purple circle when selected
                    Box(
                        modifier = Modifier
                            .background(MoonSyncColors.PrimaryPurple, CircleShape)
                            .size(48.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            Icons.Default.Person,
                            "Profile",
                            tint = Color.White
                        )
                    }
                } else {
                    // Show just icon when not selected
                    Icon(
                        Icons.Default.Person,
                        "Profile",
                        tint = Color.White
                    )
                }
            },
            selected = selectedTab == 4,
            onClick = { onTabSelected(4) },
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = Color.White,
                unselectedIconColor = Color.White,
                indicatorColor = Color.Transparent
            )
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BottomNavigationBarPreview() {
    BottomNavigationBar(selectedTab = 0, onTabSelected = {})
}