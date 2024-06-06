package com.example.jetpackcomposepractice2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposepractice2.ui.theme.JetpackComposePractice2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            JetpackComposePractice2Theme {
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(modifier: Modifier = Modifier) {
    val items = listOf(
        NavigationItemState(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasBadge = false,
            badgeNumber = 0
        ),
        NavigationItemState(
            title = "Inbox",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasBadge = true,
            badgeNumber = 10
        ),
        NavigationItemState(
            title = "Account",
            selectedIcon = Icons.Filled.Face,
            unselectedIcon = Icons.Outlined.Face,
            hasBadge = true,
            badgeNumber = 0
        )
    )
    var bottomNavState by rememberSaveable {
        mutableIntStateOf(0)
    }
    Scaffold(
        bottomBar = {
            NavigationBar(
                modifier
//                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                containerColor = Color(0xFFE0A9A5)
            ) {
                items.forEachIndexed { index, item ->
                    NavigationBarItem(
                        selected = bottomNavState == index,
                        onClick = {
                            bottomNavState = index
                        },
                        icon = {
                            BadgedBox(
                                badge = {
                                    if(item.hasBadge) {
                                        Badge {}
                                    }
                                    if(item.badgeNumber != 0) {
                                        Badge {
                                            Text(
                                                text = item.badgeNumber.toString()
                                            )
                                        }
                                    }
                                }
                            ) {
                                    Icon(
                                        imageVector =
                                            if(bottomNavState == index)
                                                item.selectedIcon
                                            else
                                                item.unselectedIcon,
                                        contentDescription = item.title
                                    )
                            }
                        },
                        label = {
                            Text(
                                text = item.title
                            )
                        },
                        colors = NavigationBarItemDefaults.colors(
                            selectedIconColor = Color(0xFF552A27),
                            selectedTextColor = Color(0xFF63332F),
                            indicatorColor = Color(0xFFBB7E7A)
                        )
                    )
                }
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Box(
                        modifier
                            .fillMaxWidth(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Top App Bar")
                    }
                },
                modifier
//                    .padding(10.dp)
                    .clip(RoundedCornerShape(20.dp)),
                navigationIcon = {
                    IconButton(
                        onClick = {  }
                    ) {
                        Icon(imageVector = Icons.Default.Menu, contentDescription = "Menu Icon")
                    }
                },
                actions = {
                    BadgedBox(
                        badge = {
                            Badge {}
                        },
                        modifier
                            .padding(8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.FavoriteBorder,
                            contentDescription = "Fav Icon"
                        )
                    }
                    Icon(
                        imageVector = Icons.Outlined.ShoppingCart,
                        contentDescription = "Fav Icon",
                        modifier.padding(8.dp)
                    )
                },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFFE0A9A5)
                )
            )
        }
    ) { innerPadding ->
        Column(
            Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .border(border = BorderStroke(2.dp, color = Color.Red)),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = items[bottomNavState].title,
                fontWeight = FontWeight.ExtraBold,
                fontSize = 22.sp
            )
        }
    }
}

data class NavigationItemState(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasBadge: Boolean,
    val badgeNumber: Int
)

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    JetpackComposePractice2Theme {
        MyApp()
    }
}