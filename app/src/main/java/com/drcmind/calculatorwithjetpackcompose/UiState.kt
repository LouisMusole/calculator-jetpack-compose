package com.drcmind.calculatorwithjetpackcompose

data class UiState(
    val calculationExpression : String = "",
    val firstNumber : String = "0",
    val secondNumber : String = "0",
    val currentOperator : CalculationOperator = CalculationOperator.NONE,
    val answer : String = ""
)
