package com.example.login.ui.login

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.*
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.login.R
import kotlinx.coroutines.launch

class LoginActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Login(getTabList())
        }
    }

    private fun getTabList(): List<String> {
        return listOf(
            getString(R.string.login_caps),
            getString(R.string.signup_caps)
        )
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Login(tabList :  List<String>){
    val pagerState = rememberPagerState()
    Column(modifier = Modifier
        .fillMaxSize()

       ) {
        Box(
            modifier = Modifier
                .fillMaxSize(),
        ){
            Image(painter = painterResource(id = R.drawable.doctor_background),
                contentDescription = "",
                modifier =  Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop)
            Box(modifier = Modifier
                .fillMaxSize()
                .background(colorResource(id = R.color.blue_dark_transparent))    )
            Column() {

            }
            ViewPage(tabList, pagerState)
            TabLayout(tabList, pagerState)
        }

    }

}



@OptIn(ExperimentalFoundationApi::class)
@Composable
fun TabLayout(tabList: List<String>, pagerState: PagerState){
    val scope = rememberCoroutineScope()

    TabRow(
        selectedTabIndex = pagerState.currentPage,
        divider = {
            Spacer(modifier = Modifier.width(8.dp))
        },
        indicator = {
            TabRowDefaults.Indicator(
                height = 5.dp,
                color = Color.White,
                modifier = Modifier.tabIndicatorOffset( it[pagerState.currentPage])
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .background(colorResource(id = R.color.transparent))
    ) {
        tabList.forEachIndexed { index, s ->
            Tab(pagerState.currentPage == index,
                onClick = {
                scope.launch {
                    pagerState.animateScrollToPage(index)
                }
            },
                text = {
                    Text(text = s, fontSize = 24.sp, color = Color.White)
                },
                modifier = Modifier.background(colorResource(id = R.color.blue_dark_transparent))
            )
        }
    }
}




@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ViewPage(tabList: List<String>, pagerState: PagerState){
    HorizontalPager(state = pagerState, pageCount = tabList.size  ) {
        when (it){
            0 -> {
                LoginScreen()
            }
            1 -> {
                SignUpScreen()
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun DefaultPreview() {
    Login(listOf("Batata", "Cenoura"))
}