package com.drcmind.calculatorwithjetpackcompose

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
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
fun CalculatorScreen(viewModel: CalculatorViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){

    val uiState = viewModel.uiState

    Column(modifier = Modifier.fillMaxSize()) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .weight(2f)){
            Column(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)) {
                Text(
                    text = uiState.value.calculationExpression,
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
                    text = if(uiState.value.answer.isNotEmpty())
                        DecimalFormat("###.#").format(uiState.value.answer.toDouble())
                    else if(uiState.value.currentOperator == CalculationOperator.NONE)
                        DecimalFormat("###.#").format(uiState.value.firstNumber.toDouble())
                    else DecimalFormat("###.#").format(uiState.value.secondNumber.toDouble())
                    ,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    style = TextStyle(
                        fontSize = 60.sp,
                        textAlign = TextAlign.End
                    )
                )
            }
        }
        Spacer(modifier = Modifier.height(16.dp))
        Column(modifier = Modifier
            .fillMaxWidth()
            .weight(3f)
            .padding(8.dp)) {
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "CA",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.OnClearAll)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "/",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.OnDivideClicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "X",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.OnTimesClicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    icon = Icons.Default.ArrowBack,
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.OnClear)
                    }
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "7",
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.On7Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "8",
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.On8Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "9",
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.On9Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "-",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.OnMinusClicked)
                    }
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(1f),
                verticalAlignment = Alignment.CenterVertically
            ) {
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "4",
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.On4Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "5",
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.On5Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "6",
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.On6Clicked)
                    }
                )
                ActionCalculator(
                    modifier = Modifier.weight(1f),
                    character = "+",
                    isHighLight = true,
                    onActionCalculatorClick = {
                        viewModel.onUiEvent(UiEvent.OnPlusClicked)
                    }
                )
            }
            Row(modifier = Modifier
                .fillMaxWidth()
                .weight(2f)) {
                Column(modifier = Modifier.weight(3f)) {
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ActionCalculator(
                            modifier = Modifier.weight(1f),
                            character = "1",
                            onActionCalculatorClick = {
                                viewModel.onUiEvent(UiEvent.On1Clicked)
                            }
                        )
                        ActionCalculator(
                            modifier = Modifier.weight(1f),
                            character = "2",
                            onActionCalculatorClick = {
                                viewModel.onUiEvent(UiEvent.On2Clicked)
                            }
                        )
                        ActionCalculator(
                            modifier = Modifier.weight(1f),
                            character = "3",
                            onActionCalculatorClick = {
                                viewModel.onUiEvent(UiEvent.On3Clicked)
                            }
                        )
                    }
                    Row(modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        ActionCalculator(
                            modifier = Modifier.weight(3f),
                            character = "0",
                            onActionCalculatorClick = {
                                viewModel.onUiEvent(UiEvent.On0Clicked)
                            }
                        )
                    }
                }
                Box(modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f)){
                    Box(modifier = Modifier
                        .fillMaxHeight(0.8f)
                        .width(60.dp)
                        .background(MaterialTheme.colors.secondary)
                        .align(Alignment.Center)
                        .clickable {
                            viewModel.onUiEvent(UiEvent.OnEgalCliked)
                        }
                    ){
                        Text(
                            text = "=",
                            style = TextStyle(fontSize = 30.sp, color = Color.White),
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
    character : String? = null,
    icon : ImageVector? = null,
    isHighLight : Boolean = false,
    onActionCalculatorClick : () -> Unit
){
    Box(modifier = modifier
        .size(60.dp)
        .clip(RoundedCornerShape(50))
        .clickable { onActionCalculatorClick() }
    ){
        if(icon != null){
            Icon(imageVector = icon, contentDescription = "Symbole à afficher",
                tint = MaterialTheme.colors.secondary,
                modifier = Modifier.align(Alignment.Center)
            )
        }else{
            Text(text = character!!,
                style = TextStyle(
                    fontSize = 30.sp,
                    color = if(isHighLight) MaterialTheme.colors.secondary else Color.Black
                ),
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorScreenPreview(){
    CalculatorScreen()
}