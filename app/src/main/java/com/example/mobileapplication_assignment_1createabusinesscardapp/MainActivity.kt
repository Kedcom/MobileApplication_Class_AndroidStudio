package com.example.mobileapplication_assignment_1createabusinesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BusinessCardApp()
        }
    }
}

@Composable  //this ui displays the busines Card
fun BusinessCardApp() {  //Light green background
    Box(
        modifier = Modifier.fillMaxSize()
            .background(Color(0xFFD2E8D4)),//Lightgreen background color for application
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(bottom = 50.dp),//keeps the size of the card
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(//for logo
                modifier = Modifier
                    .size(130.dp)//background icon size
                    .background(Color(0xFF073142)),//background color for image
                contentAlignment = Alignment.Center

            ){
                Image(
                    painter = painterResource(R.drawable.android_logo), // Android logo
                    contentDescription = "Android Logo"
                )
            }

//            Spacer(modifier = Modifier.height(7.dp))//gives space between text and image
            Text(
                "Jennifer Doe",
                fontSize = 39.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Light,
                modifier = Modifier.padding(vertical = 10.dp)
            )
            Text(
                "Android Developer Extraordinaire",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2E7D32)
            )

            Spacer(modifier = Modifier.height (50.dp))//space between contactinfo and text above it
        }
        Box(
            modifier = Modifier.align(Alignment.BottomCenter)
        ){
            ContactInfo(
                "+11 (123) 444 555 666",
                "@AndroidDev",
                "jen.doe@android.com"
            )
        }
    }
}

@Composable
fun ContactInfo(phone: String, share: String, email: String) {
    Column(
        modifier = Modifier
            .offset(y = -50.dp)
            .fillMaxWidth(), // Takes full width
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ContactItem(Icons.Default.Phone, phone)
        ContactItem(Icons.Default.Share, share)
        ContactItem(Icons.Default.Email, email)
    }
}

@Composable
fun ContactItem(icon: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .padding(4.dp) // Adds spacing between contacts
    ) {
        Icon(
            imageVector = icon,
            contentDescription = null,
            tint = Color(0xFF2E7D32), // color for icons
            modifier = Modifier.size(24.dp)// icon size
        )
        Spacer(modifier = Modifier.width(8.dp)) // Space between icon and text
        Text(text, fontSize = 16.sp)
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
        BusinessCardApp()
}