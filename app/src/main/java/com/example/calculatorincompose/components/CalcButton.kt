package com.example.calculatorincompose.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.calculatorincompose.Calculator

@Composable
fun CalcButton(operation: String, calculator: Calculator) {
    Button(
        onClick = {
            when (operation) {
                "delete" -> calculator.deleteText()
                "clear" -> calculator.clearText()
                "=" -> calculator.parseText()
                else -> calculator.addText(operation)
            }
        },

        colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.primary),
        modifier = Modifier
            .width(100.dp)
            .height(90.dp)
    ) {
        Text(text = operation, color = MaterialTheme.colors.secondaryVariant)
    }
}