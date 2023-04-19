package com.drcmind.calculatorwithjetpackcompose

enum class CalculationOperator(val symbol : String? = null) {
    MULTIPLICATION("X"),
    DIVISION("/"),
    SUBSTRACTION("-"),
    ADDITION("+"),
    NONE
}