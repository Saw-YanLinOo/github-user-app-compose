package com.agb.github_user_app.presentation.detail

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.net.toUri
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import coil.compose.AsyncImage
import com.agb.github_user_app.R
import com.agb.github_user_app.data.model.UserModel
import com.agb.github_user_app.presentation.navigation.Screens


fun NavGraphBuilder.detailScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable<Screens.DetailScreen> {backStackEntry->
        val detail: Screens.DetailScreen = backStackEntry.toRoute()

        DetailScreen(
            id = detail.id,
            login = detail.login,
            onBackClick = {
                navController.popBackStack()
            },
            onProfileClick = { user->
                // open profile link with webview
                // or open in browser
                val profileUrl = user.htmlUrl ?: return@DetailScreen
                val intent = Intent(Intent.ACTION_VIEW, profileUrl.toUri())
                navController.context.startActivity(intent)

            }
        )
    }
}

@Composable
fun DetailScreen(
    id: Long = 1,
    login:String = "",
    onBackClick: () -> Unit = {},
    onProfileClick: (UserModel) -> Unit = {}
) {

    val detailViewModel = hiltViewModel<DetailViewModel>()
    val user = detailViewModel.user.collectAsState().value
//    val user = sampleUsers.firstOrNull { it.id == id }

    if (user == null) {
        Text("User not found", modifier = Modifier.padding(16.dp))
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(Modifier.height(16.dp))

        // Back arrow
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            IconButton(onClick = onBackClick) {
                Icon(Icons.Default.ArrowBack, contentDescription = "Back")
            }
        }

        AsyncImage(
            model = user.avatarUrl,
            contentDescription = user.login,
            modifier = Modifier
                .size(100.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Spacer(Modifier.height(12.dp))

        Text(user.login?:"", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        Spacer(Modifier.height(4.dp))

        Text(user.name?:"", fontSize = 24.sp, fontWeight = FontWeight.Normal)

        Spacer(Modifier.height(24.dp))

        // Follower and Following section
        Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
            StatBox(
                count = user.followers?:0,
                label = "followers",
                backgroundColor = Color(0xFFF272B5),
                icon = painterResource(id = R.drawable.ic_visibility)
            )
            StatBox(
                count = user.following?:0,
                label = "following",
                backgroundColor = Color(0xFFB2EBF2),
                icon = painterResource(id = R.drawable.ic_military_tech)
            )
        }

        Spacer(Modifier.weight(1f))

        // Go To Profile Button
        Button(
            onClick = { onProfileClick(user) },
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp)
                .height(56.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
        ) {
            Text("Go To Profile", color = Color.White)
            Spacer(modifier = Modifier.width(8.dp))
            Icon(Icons.Default.Send, contentDescription = null, tint = Color.White)
        }
    }
}

@Composable
fun StatBox(count: Long, label: String, backgroundColor: Color, icon: Painter) {
    Column(
        modifier = Modifier
            .size(width = 120.dp, height = 160.dp)
            .clip(RoundedCornerShape(16.dp))
            .background(backgroundColor)
            .padding(16.dp),
        horizontalAlignment = Alignment.Start,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        Icon(icon, contentDescription = label, tint = Color.Black)
        Text(" $count", fontSize = 28.sp, fontWeight = FontWeight.Bold)
        Text(label, fontSize = 16.sp, fontWeight = FontWeight.Bold)
    }
}

@Preview
@Composable
fun DetailScreenPreview(modifier: Modifier = Modifier) {

    DetailScreen(
        id = 1,
        onBackClick = {},
        onProfileClick = {}
    )
}