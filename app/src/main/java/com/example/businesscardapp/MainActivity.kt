package com.example.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardAppTheme {
                BusinessCardApp()
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = Color(0xFFabf7b1)
    ) {
        Column(Modifier.fillMaxSize().padding(bottom = 32.dp)) {
            PersonSection(
                Modifier.weight(5F)
            )
            ContactsSection(
                Modifier
                    .weight(1F)
            )
        }
    }
}

@Composable
fun PersonSection(modifier: Modifier = Modifier) {
    val logo = painterResource(R.drawable.android_logo)
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(painter = logo, contentDescription = stringResource(R.string.android_logo_desc))
        Text(
            text = stringResource(R.string.full_name),
            fontSize = 48.sp
        )
        Text(
            text = stringResource(R.string.title),
            color = Color(0xFF0b6a3c),
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun ContactsSection(modifier: Modifier = Modifier) {
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column {
            Contact(
                icon = Icons.Default.Call,
                iconDescription = stringResource(R.string.phone_number_desc),
                text = stringResource(R.string.phone_number)
            )
            Contact(
                icon = Icons.Default.Share,
                iconDescription = stringResource(R.string.twitter_icon_desc),
                text = stringResource(R.string.twitter)
            )
            Contact(
                icon = Icons.Default.Email,
                iconDescription = stringResource(R.string.email_icon_desc),
                text = stringResource(R.string.email)
            )
        }
    }
}

@Composable
fun Contact(modifier: Modifier = Modifier, icon: ImageVector, iconDescription: String, text: String) {
    Row(modifier.padding(top = 8.dp, bottom = 8.dp)) {
        Icon(
            imageVector = icon,
            contentDescription = iconDescription,
            tint = Color(0xFF3ddc84)
        )
        Text(modifier = Modifier.padding(start = 16.dp), text = text)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCardApp()
    }
}