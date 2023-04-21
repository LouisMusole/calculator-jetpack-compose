package com.drcmind.calculatorwithjetpackcompose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class CalculatorViewModel : ViewModel() {
    val uiState : MutableState<UiState> = mutableStateOf(UiState())

    fun onUiEvent(uiEvent: UiEvent){

        when (uiEvent){
            is UiEvent.On0Clicked, UiEvent.On1Clicked, UiEvent.On2Clicked, UiEvent.On3Clicked,
                UiEvent.On4Clicked, UiEvent.On5Clicked, UiEvent.On6Clicked, UiEvent.On7Clicked,
                UiEvent.On8Clicked, UiEvent.On9Clicked ->{
                    updateNumber(uiEvent.character!!)
                }
            is UiEvent.OnClearAll ->{
                uiState.value = UiState()
            }
            is UiEvent.OnClear ->{
                clear()
            }
            is UiEvent.OnPlusClicked, UiEvent.OnMinusClicked, UiEvent.OnTimesClicked,
                UiEvent.OnDivideClicked ->{
                    operate(uiEvent.operator)
                }
            is UiEvent.OnEgalCliked ->{
                egalize()
            }
        }

    }

    private fun updateNumber(numberCharacter : String){
        if(uiState.value.answer.isNotEmpty()){
            uiState.value = uiState.value.copy(
                firstNumber = "0", currentOperator = CalculationOperator.NONE,
                calculationExpression = ""
            )
        }
        if(uiState.value.currentOperator == CalculationOperator.NONE){
            uiState.value = uiState.value.copy(
                firstNumber = uiState.value.firstNumber + numberCharacter,
                answer = ""
            )
        }else{
            uiState.value = uiState.value.copy(
                calculationExpression = "${myDecimalFormatter(uiState.value.firstNumber.toDouble())} " +
                        "${uiState.value.currentOperator.symbol}",
                secondNumber = uiState.value.secondNumber + numberCharacter
            )
        }
    }

    private fun clear(){
        if(uiState.value.answer.isNotEmpty()){
            return
        }
        if(uiState.value.currentOperator == CalculationOperator.NONE){
            uiState.value = uiState.value.copy(
                firstNumber = uiState.value.firstNumber.dropLast(1)
            )
        }else{
            uiState.value = uiState.value.copy(
                secondNumber = uiState.value.secondNumber.dropLast(1)
            )
        }
    }

    private fun operate(operator: CalculationOperator){
        uiState.value = uiState.value.copy(
            answer = "",
            currentOperator = operator,
            calculationExpression = "${myDecimalFormatter(uiState.value.firstNumber.toDouble())} " +
                    "${operator.symbol}"
        )
    }

    private fun egalize(){
        when (uiState.value.currentOperator){
            CalculationOperator.ADDITION ->{
                uiState.value = uiState.value.copy(
                    answer = (uiState.value.firstNumber.toDouble() + uiState.value.secondNumber.toDouble()).toString(),
                    firstNumber = (uiState.value.firstNumber.toDouble() + uiState.value.secondNumber.toDouble()).toString(),
                    currentOperator = CalculationOperator.NONE,
                    calculationExpression = "${myDecimalFormatter(uiState.value.firstNumber.toDouble())} " +
                            "${uiState.value.currentOperator.symbol} " +
                            "${myDecimalFormatter(uiState.value.secondNumber.toDouble())} =",
                    secondNumber = "0"
                )
            }
            CalculationOperator.SUBSTRACTION->{
                uiState.value = uiState.value.copy(
                    answer = (uiState.value.firstNumber.toDouble() - uiState.value.secondNumber.toDouble()).toString(),
                    firstNumber = (uiState.value.firstNumber.toDouble() - uiState.value.secondNumber.toDouble()).toString(),
                    currentOperator = CalculationOperator.NONE,
                    calculationExpression = "${myDecimalFormatter(uiState.value.firstNumber.toDouble())} " +
                            "${uiState.value.currentOperator.symbol} " +
                            "${myDecimalFormatter(uiState.value.secondNumber.toDouble())} =",
                    secondNumber = "0"
                )
            }
            CalculationOperator.MULTIPLICATION->{
                uiState.value = uiState.value.copy(
                    answer = (uiState.value.firstNumber.toDouble() * uiState.value.secondNumber.toDouble()).toString(),
                    firstNumber = (uiState.value.firstNumber.toDouble() * uiState.value.secondNumber.toDouble()).toString(),
                    currentOperator = CalculationOperator.NONE,
                    calculationExpression = "${myDecimalFormatter(uiState.value.firstNumber.toDouble())} " +
                            "${uiState.value.currentOperator.symbol} " +
                            "${myDecimalFormatter(uiState.value.secondNumber.toDouble())} =",
                    secondNumber = "0"
                )
            }
            CalculationOperator.DIVISION->{
                uiState.value = uiState.value.copy(
                    answer = (uiState.value.firstNumber.toDouble() / uiState.value.secondNumber.toDouble()).toString(),
                    firstNumber = (uiState.value.firstNumber.toDouble() / uiState.value.secondNumber.toDouble()).toString(),
                    currentOperator = CalculationOperator.NONE,
                    calculationExpression = "${myDecimalFormatter(uiState.value.firstNumber.toDouble())} " +
                            "${uiState.value.currentOperator.symbol} " +
                            "${myDecimalFormatter(uiState.value.secondNumber.toDouble())} =",
                    secondNumber = "0"
                )
            }
            CalculationOperator.NONE->{}
        }
    }

    private fun myDecimalFormatter(input : Double) : String = DecimalFormat("###.#").format(input)

}