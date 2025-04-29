package com.agb.github_user_app.presentation.onboarding

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.agb.github_user_app.R
import com.agb.github_user_app.presentation.navigation.Screens
import com.agb.github_user_app.ui.theme.LocalCustomColorsPalette
import kotlinx.coroutines.launch


fun NavGraphBuilder.onBoardingScree (
    modifier: Modifier = Modifier,
    navController: NavController
) {
    composable<Screens.OnBoardingScreen> {
        OnBoardingScreen(
            onFinished = {
                navController.navigate(Screens.HomeScreen){
                    popUpTo(Screens.OnBoardingScreen) {
                        inclusive = true
                    }
                }
            }
        )
    }
}

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier,onFinished:()-> Unit = {}) {

    val pagerState = rememberPagerState(
        initialPage = 0,
        initialPageOffsetFraction = 0f,
        pageCount = { onboardingPages.size }
    )
    val coroutineScope = rememberCoroutineScope()


    Scaffold { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(LocalCustomColorsPalette.current.mobileBackground)
                .padding(innerPadding)

        ) {

            Box(modifier = Modifier.fillMaxWidth()) {
                Text(text = ">> Skip",
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.TopEnd)
                        .clickable{ onFinished() }
                )

            }

            HorizontalPager (
                state = pagerState,
                modifier = Modifier.weight(1f),
            ) { page ->
                OnboardingPage(pageData = onboardingPages[page])
            }

            Row(
                modifier = Modifier
                    .height(82.dp)
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp, vertical = 24.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                // Page indicators
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                ) {
                    repeat(onboardingPages.size) { iteration ->
                        val width = animateDpAsState(
                            targetValue = if (pagerState.currentPage == iteration) 24.dp else 8.dp,
                            label = "indicator width"
                        )
                        Box(
                            modifier = Modifier
                                .height(8.dp)
                                .width(width.value)
                                .clip(CircleShape)
                                .background(
                                    if (pagerState.currentPage == iteration)
                                        Color(0xFF555555)
                                    else
                                        Color.LightGray
                                )
                        )
                    }
                }

                // Next button (circle with arrow)
                Icon(
                    painter = painterResource(R.drawable.ic_arrow_right),
                    contentDescription = "Next",
                    tint = Color.White,
                    modifier = Modifier
                        .size(24.dp)
                        .clip(CircleShape)
                        .background(Color(0xFFFF7043))
                        .clickable {

                            if (pagerState.currentPage < onboardingPages.size - 1) {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(pagerState.currentPage + 1)
                                }
                            } else {
                                onFinished()
                            }
                        }
                )
            }
        }
    }
}

@Composable
fun OnboardingPage(pageData: OnboardingPageData) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = pageData.imageRes),
            contentDescription = "Onboarding Image",
            modifier = Modifier
                .height(250.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = pageData.title,
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            color = Color.Black
        )
    }
}

@Preview
@Composable
fun OnboardingPagePreview() {
    OnBoardingScreen()
}

data class OnboardingPageData(
    val title: String,
    val imageRes: Int
)

val onboardingPages = listOf(
    OnboardingPageData(
        title = "Rev Up Your Ride: Exclusive Benefits with Aung Gabar Motors's Membership!",
        imageRes = R.drawable.intro1 // Replace with your actual drawable resources
    ),
    OnboardingPageData(
        title = "Unlock Premium Perks – Join the Aung Gabar Motors Membership today!",
        imageRes = R.drawable.intro2
    ),
    OnboardingPageData(
        title = "Drive More, Save More – The Ultimate Motors Membership App!",
        imageRes = R.drawable.intro3
    )
)