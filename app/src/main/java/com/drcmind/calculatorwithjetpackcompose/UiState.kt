package com.drcmind.calculatorwithjetpackcompose

data class UiState(
    var calculationExpression : String = "",
    var firstNumber : String = "0",
    val currentOperator : CalculationOperator = CalculationOperator.NONE,
    var secondNumber : String = "0",
    var answer : String = ""
)
