package com.example.composetutorial.ui

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composetutorial.R
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class ChangeProfile : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {
            ChangeProfileScreen()
            }
        }
    }
}



@Composable
fun ChangeProfileScreen(

) {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text(
            text = "Ubah Profil",
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(modifier = Modifier.height(36.dp))


        // Foto profil
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.LightGray)
            ) {
            Image(
                painter = painterResource(id = R.drawable.ic_person),
            contentDescription = "Foto Profil",
            modifier = Modifier
                .size(60.dp)
                .align(Alignment.Center)
            )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Text(
                style = MaterialTheme.typography.labelMedium,
                fontWeight = FontWeight.Bold,
                text = "Ganti foto profil >",
                color = Color.Blue,
                modifier = Modifier.padding(start = 8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Nama
        OutlinedTextField(
            shape = RoundedCornerShape(32.dp),
            value = name,
            onValueChange = { name = it },
            label = { Text("Nama") },
            modifier = Modifier.fillMaxWidth()


        )

        // Email
        OutlinedTextField(
            shape = RoundedCornerShape(32.dp),
            value = email,
            onValueChange = { email = it },
            label = { Text("Email") },
            modifier = Modifier.fillMaxWidth()

        )

        // Tanggal Lahir
        OutlinedTextField(
            shape = RoundedCornerShape(32.dp),
            value = dob,
            onValueChange = { dob = it },
            label = { Text("Tanggal Lahir") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Button
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center

        ) {
            Button(onClick = {
            }) {
                Text("Batal")
            }
            Spacer(modifier = Modifier.width(16.dp))

            Button(onClick = {
            /* ... */
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green)) {
                Text("Simpan")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ChangeProfileScreenPreview() {
    ComposeTutorialTheme {
        ChangeProfileScreen(
//            modifier = Modifier,
//            goToSetting = TODO()
        )
    }
}

