package com.drcmind.calculatorwithjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.DecimalFormat

@Composable
fun CalculatorScreen(viewModel: MainViewModel= androidx.lifecycle.viewmodel.compose.viewModel()) {
    val state = viewModel.uiState
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(2f)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
            ) {
                Text(
                    text = state.value.calculationExpression,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 30.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.End
                    )
                )
                Text(
                    text = if(state.value.answer.isNotEmpty())
                        DecimalFormat("###.#").format(state.value.answer.toDouble())
                        else if (state.value.currentOperator == CalculationOperator.NONE) DecimalFormat("###.#").format(state.value.firstNumber.toDouble()) else DecimalFormat("###.#").format(state.value.secondNumber.toDouble()),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 60.sp,
                        color = Color.Black,
                        textAlign = TextAlign.End
                    )
                )
            }

        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f)
                .padding(8.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    character ="C", isHighlignt = true,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.onUiEvent(UiEvent.OnClearAll)
                    }
                )
                ActionCalculator(
                    character ="/",
                    isHighlignt = true,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.onUiEvent(UiEvent.OnDivideClicked)
                    })
                ActionCalculator(character ="X", isHighlignt = true, modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.onUiEvent(UiEvent.OnTimesClicked)
                    })
                ActionCalculator(
                    icon = Icons.Default.ArrowBack,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.onUiEvent(UiEvent.OnClearClicked)
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    character = "7",
                    modifier = Modifier.weight(1f),
                    onClick = {viewModel.onUiEvent(UiEvent.On7Clicked)}
                )
                ActionCalculator(
                    character ="8",
                    modifier = Modifier.weight(1f),
                    onClick = {viewModel.onUiEvent(UiEvent.On8Clicked)}
                )
                ActionCalculator(
                    character ="9",
                    modifier = Modifier.weight(1f),
                    onClick = {viewModel.onUiEvent(UiEvent.On9Clicked)}
                )
                ActionCalculator(
                    character ="-",
                    isHighlignt = true,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.onUiEvent(UiEvent.OnMinusClicked)
                    }
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    character ="4",
                    modifier = Modifier.weight(1f),
                    onClick = {viewModel.onUiEvent(UiEvent.On4Clicked)}
                )
                ActionCalculator(
                    character ="5",
                    modifier = Modifier.weight(1f),
                    onClick = {viewModel.onUiEvent(UiEvent.On5Clicked)}
                )
                ActionCalculator(
                    character ="6",
                    modifier = Modifier.weight(1f),
                    onClick = {viewModel.onUiEvent(UiEvent.On6Clicked)}
                )
                ActionCalculator(
                    character ="+", isHighlignt = true,
                    modifier = Modifier.weight(1f),
                    onClick = {
                        viewModel.onUiEvent(UiEvent.OnPlusClicked)
                    })
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(2f)
            ) {
                Column(modifier = Modifier.weight(3f)) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ActionCalculator(
                            character ="1",
                            modifier = Modifier.weight(1f),
                            onClick = {viewModel.onUiEvent(UiEvent.On1Clicked)}
                        )
                        ActionCalculator(
                            character ="2",
                            modifier = Modifier.weight(1f),
                            onClick = {viewModel.onUiEvent(UiEvent.On2Clicked)}
                        )
                        ActionCalculator(
                            character ="3",
                            modifier = Modifier.weight(1f),
                            onClick = {viewModel.onUiEvent(UiEvent.On3Clicked)}
                        )
                    }
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .weight(1f),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ActionCalculator(
                            character ="0",
                            modifier = Modifier.weight(3f),
                            onClick = {
                                viewModel.onUiEvent(UiEvent.On0Clicked)
                            }
                        )
                    }
                }
                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .weight(1f)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight(0.8f)
                            .width(60.dp)
                            .background(MaterialTheme.colors.secondary)
                            .align(Alignment.Center)
                            .clickable {
                                viewModel.onUiEvent(UiEvent.OnEgalClicked)
                            }
                    ) {
                        Text(
                            text = "=",
                            style = TextStyle(
                                fontSize = 30.sp,
                                color = Color.White
                            ),
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ActionCalculator(
    modifier: Modifier = Modifier,
    character: String? = null,
    icon: ImageVector? = null,
    isHighlignt: Boolean = false,
    onClick: () -> Unit
) {
    Box(
        modifier = modifier
            .size(60.dp)
            .clip(RoundedCornerShape(50))
            .clickable { onClick() }
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = "Signe", modifier = Modifier.align(Alignment.Center),
                tint = MaterialTheme.colors.secondary
            )
        } else {
            Text(
                text = character!!, style = TextStyle(
                    fontSize = 30.sp,
                    color = if (isHighlignt) MaterialTheme.colors.secondary else Color.Black
                ), modifier = Modifier.align(Alignment.Center)
            )
        }

    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview() {
    CalculatorScreen()
}

