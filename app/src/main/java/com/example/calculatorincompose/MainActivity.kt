package com.example.calculatorincompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.calculatorincompose.components.CalcButton
import com.example.calculatorincompose.ui.theme.CalculatorInComposeTheme
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorInComposeTheme {
                var calcStr by remember { mutableStateOf("") }
                val calcObj = object : Calculator {
                    override fun addText(text: String) {
                        calcStr += text
                    }

                    override fun deleteText() {
                        if (calcStr.isNotEmpty()) {
                            calcStr = calcStr.substring(0 until calcStr.length - 1)
                        }
                    }

                    override fun clearText() {
                        println("Clearing text")
                        calcStr = ""
                    }

                    override fun parseText() {
                        val expression = Expression(calcStr)
                        calcStr = "${expression.calculate()}"
                    }

                }
                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    Text(
                        text = calcStr,
                        fontSize = 55.sp,
                        modifier = Modifier
                            .fillMaxHeight(.25f)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Start
                    )
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Row {
                            CalcButton(operation = "√", calculator = calcObj)
                            CalcButton(operation = "(", calculator = calcObj)
                            CalcButton(operation = ")", calculator = calcObj)
                            CalcButton(operation = "/", calculator = calcObj)
                        }
                        Row {
                            CalcButton(operation = "7", calculator = calcObj)
                            CalcButton(operation = "8", calculator = calcObj)
                            CalcButton(operation = "9", calculator = calcObj)
                            CalcButton(operation = "*", calculator = calcObj)
                        }
                        Row {
                            CalcButton(operation = "4", calculator = calcObj)
                            CalcButton(operation = "5", calculator = calcObj)
                            CalcButton(operation = "6", calculator = calcObj)
                            CalcButton(operation = "-", calculator = calcObj)
                        }
                        Row {
                            CalcButton(operation = "1", calculator = calcObj)
                            CalcButton(operation = "2", calculator = calcObj)
                            CalcButton(operation = "3", calculator = calcObj)
                            CalcButton(operation = "+", calculator = calcObj)
                        }
                        Row {
                            CalcButton(operation = "0", calculator = calcObj)
                            CalcButton(operation = ".", calculator = calcObj)
                            CalcButton(operation = "=", calculator = calcObj)
                            CalcButton(operation = "delete", calculator = calcObj)
                        }
                        Row {
                            CalcButton(operation = "clear", calculator = calcObj)
                            CalcButton(operation = "sin", calculator = calcObj)
                            CalcButton(operation = "cos", calculator = calcObj)
                            CalcButton(operation = "tan", calculator = calcObj)
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    CalculatorInComposeTheme {
    }
}