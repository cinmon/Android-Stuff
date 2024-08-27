package com.gianella.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gianella.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard(logo = painterResource(R.drawable.unknown),
        name = stringResource(R.string.name),
        title = stringResource(R.string.job_title),
        phoneNumber = stringResource(R.string.phone_number),
        username = stringResource(R.string.username),
        email = stringResource(R.string.email)
    )
}

@Composable
fun BusinessCard(
    logo : Painter,
    name : String,
    title : String,
    phoneNumber : String,
    username : String,
    email : String,
    modifier : Modifier = Modifier) {

    Column(modifier = Modifier.fillMaxSize().background(color = Color.LightGray)) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(3f).fillMaxWidth()
        ) {

            Image(
                painter = logo,
                contentDescription = "Logo of the brand"
            )

            Text(
                text = name,
                fontSize = 40.sp,
                modifier = Modifier
            )

            Text(
                text = title,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3ddc84),
                modifier = Modifier
            )


        }

        // Bottom
        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {

            // Phone number
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {

                Icon(
                    imageVector = Icons.Filled.Phone,
                    contentDescription = "Phone number"
                )

                Text(
                    text = phoneNumber
                )

            }

            // Social media
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(16.dp)
            ) {

                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = "Username"
                )

                Text(
                    text = username
                )

            }

            // Email
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {

                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = "Email"
                )

                Text(
                    text = email
                )

            }

        }
    }


}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardTheme {
        BusinessCardApp()
    }
}