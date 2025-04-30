package com.agb.github_user_app.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import coil.compose.AsyncImage
import com.agb.github_user_app.data.model.User
import com.agb.github_user_app.data.model.sampleUsers
import com.agb.github_user_app.presentation.navigation.Screens
import com.agb.github_user_app.ui.theme.LocalCustomColorsPalette


fun NavGraphBuilder.homeScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable<Screens.HomeScreen> {
        HomeScreen(
            modifier = modifier,
            goToDetail = { userId ->
                navController.navigate(Screens.DetailScreen(userId))
            }
        )
    }
}

@Composable
fun HomeScreen(modifier: Modifier = Modifier, goToDetail: (Int) -> Unit = {}) {

    val categories = listOf("Flutter", "Programming", "React", "Vue", "Android")
    val userList = sampleUsers

    Scaffold { innerPadding ->
        Column(
            modifier=modifier
                .fillMaxSize()
                .background(LocalCustomColorsPalette.current.mobileBackground)
                .padding(top = innerPadding.calculateTopPadding())
        ) {
            TopBar()
            Text("Categories", modifier = modifier.padding(16.dp))
            LazyRow(
                modifier= Modifier
                    .height(52.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                contentPadding = PaddingValues(horizontal = 16.dp),
            ) {
                items(categories) { category ->
                    AssistChip(onClick = {}, label = {Text(category)})
                }
            }

            Text(
                text = "Total ${10} users available",
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Italic,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
                    .padding(top = 8.dp)
            )
            LazyVerticalGrid(
                columns = GridCells.Adaptive(minSize = 160.dp),
                contentPadding = PaddingValues(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                items(userList) { user ->
                    UserCard(user = user,
                        onClick = {
                            goToDetail(user.id)
                        }
                    )
                }
            }
        }
    }
}


@Composable
fun UserCard(user: User,onClick: () -> Unit = {}) {
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(16.dp))
            .background(Color.LightGray)
            .height(240.dp)
            .fillMaxWidth()
            .clickable{onClick()}
    ) {
        AsyncImage(
            model = user.avatarUrl,
            contentDescription = user.username,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 12.dp, vertical = 16.dp)
                .align(Alignment.BottomCenter)
                .background(Color.Black.copy(alpha = 0.5f))
                .padding(8.dp)
        ) {
            Text(
                text = user.name,
                color = Color.White,
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}
@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        OutlinedTextField(
            value = "",
            onValueChange = {},
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
            placeholder = { Text("Search") },
            modifier = Modifier
                .weight(1f)
                .height(56.dp),
            shape = RoundedCornerShape(12.dp),
            colors = OutlinedTextFieldDefaults.colors()
        )

        Spacer(modifier = Modifier.width(12.dp))

        IconButton(onClick = {}) {
            Icon(
                imageVector = Icons.Default.Notifications,
                contentDescription = "Notifications"
            )
        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}