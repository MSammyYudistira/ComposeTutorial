package com.example.composetutorial.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.RoundRect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composetutorial.R
import com.example.composetutorial.ui.theme.ComposeTutorialTheme

class DetailTransaction : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeTutorialTheme {
                    DetailTransactionScreen()
                }
            }
        }
    }

@Composable
fun DetailTransactionScreen() {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Row (
            modifier = Modifier
                .fillMaxWidth()



        ){

            // Top Bar

            Image(
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = "Back",
                modifier = Modifier
                    .size(35.dp)

            )

            Text(
                text = "Detail Transaksi",
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(start = 13.dp)
            )

        }


            Spacer(modifier = Modifier.height(36.dp))


        // Icon
        Column (
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .clip(CircleShape)
                    .background(Color.Red)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_food),
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
                text = "-Rp. 90.000",
                color = Color.Red,
                fontSize = 24.sp
            )
            
            // List Kategori
            Surface (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .size(width = 0.dp, height = 200.dp),
                shape = RoundedCornerShape(16.dp),
                border = BorderStroke(2.dp, Color.Black),

            ){
                Column (
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.SpaceEvenly

                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding( start = 12.dp, end = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            color = Color.Gray,
                            text = "Kategori"
                        )
                        Text("Makanan")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding( start = 12.dp, end = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            color = Color.Gray,
                            text = "Tanggal"
                        )
                        Text("Minggu, 10 November 2024")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding( start = 12.dp, end = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            color = Color.Gray,
                            text = "Waktu Transaksi"
                        )
                        Text("12:12 WIB")
                    }

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding( start = 12.dp, end = 12.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            color = Color.Gray,
                            text = "Deskripsi"
                        )
                        Text("Burger Bangor")
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))

            // Detail Gambar
            Text(
                text = "Detail Gambar"
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 16.dp)
                    .size(width = 0.dp, height = 200.dp)
                    .borderDashed(
                        width = 4.dp,
                        color = Color.Gray,
                        dashLength = 10f,
                        gapLength = 6f
                    ),
                shape = RoundedCornerShape(16.dp)
                
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_person),
                    contentDescription = "Foto Profil",
                    modifier = Modifier
                        .size(40.dp)
                )

            }
        }

    }
}

fun Modifier.borderDashed(
    width: Dp,
    color: Color,
    dashLength: Float = 10f,
    gapLength: Float = 6f
): Modifier = this.then(
    Modifier.drawBehind {
        val size = this.size
        val cornerRadius = 16.dp.toPx() // Mengonversi radius ke px

        val paint = Paint().apply {
            this.color = color
            this.style = Stroke
            this.strokeWidth = width.toPx() // Mengonversi Dp ke Px untuk lebar border
            this.pathEffect = PathEffect.dashPathEffect(floatArrayOf(dashLength, gapLength)) // Border putus-putus
        }

        // Membuat path dengan rounded corners
        val path = Path().apply {
            // Menambahkan rounded rect (segmen dengan radius sudut)
            addRoundRect(
                RoundRect(
                    left = 0f,
                    top = 0f,
                    right = size.width,
                    bottom = size.height,
                    radiusX = cornerRadius,
                    radiusY = cornerRadius
                )
            )
        }

        // Menggambar path (border putus-putus) ke canvas
        drawIntoCanvas { canvas ->
            canvas.drawPath(path, paint) // Menggambar path menggunakan canvas
        }
    }
)

@Preview(showBackground = true)
@Composable
fun DetailTransactionPreview() {
    ComposeTutorialTheme {
    DetailTransactionScreen()
    }
}