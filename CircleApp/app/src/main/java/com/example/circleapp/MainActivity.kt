package com.example.circleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.circleapp.ui.theme.CircleAppTheme
import kotlin.math.PI
import kotlin.math.pow

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircleAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFFE3F2FD)
                ) {
                    CircleAreaCalculator()
                }
            }
        }
    }
}

@Composable
fun CircleAreaCalculator() {
    var radiusText by remember { mutableStateOf(TextFieldValue("")) }
    var resultText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Image(
            painter = painterResource(id = R.drawable.circle_icon),
            contentDescription = "Circle Icon",
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 20.dp)
        )

        OutlinedTextField(
            value = radiusText,
            onValueChange = { radiusText = it },
            label = { Text("Enter radius") },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(12.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                if (radiusText.text.isEmpty()) {
                    resultText = "Please enter a radius."
                } else {
                    val radius = radiusText.text.toDoubleOrNull()
                    if (radius != null) {
                        val area = PI * radius.pow(2)
                        resultText = "Area of circle: %.2f".format(area)
                    } else {
                        resultText = "Invalid input. Please enter a number."
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1976D2)),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(text = "Calculate Area", color = Color.White, fontSize = 18.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = resultText,
            color = Color(0xFF1B5E20),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCircleAreaCalculator() {
    CircleAppTheme {
        CircleAreaCalculator()
    }
}
