package com.drcmind.calculatorwithjetpackcompose

sealed class UiEvent(
    val character : String?=null,
    val operator: CalculationOperator = CalculationOperator.NONE
){
    object On0Clicked : UiEvent(character = "0")
    object On1Clicked : UiEvent(character ="1")
    object On2Clicked : UiEvent(character ="2")
    object On3Clicked : UiEvent(character ="3")
    object On4Clicked : UiEvent(character ="4")
    object On5Clicked : UiEvent(character ="5")
    object On6Clicked : UiEvent(character ="6")
    object On7Clicked : UiEvent(character ="7")
    object On8Clicked : UiEvent(character ="8")
    object On9Clicked : UiEvent(character ="9")
    object OnPlusMinusClicked : UiEvent(character = "-")
    object OnDotClicked : UiEvent(character = ".")
    object OnClearClicked : UiEvent()
    object OnPlusClicked : UiEvent(operator = CalculationOperator.ADDITION)
    object OnMinusClicked : UiEvent(operator = CalculationOperator.SUBSTRACTION)
    object OnDivideClicked : UiEvent(operator = CalculationOperator.DIVISION)
    object OnTimesClicked : UiEvent(operator = CalculationOperator.MULTIPLICATION)
    object OnEgalClicked : UiEvent()
    object OnClearAll : UiEvent()
}
