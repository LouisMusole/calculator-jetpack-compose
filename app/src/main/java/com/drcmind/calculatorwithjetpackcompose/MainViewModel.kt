package com.drcmind.calculatorwithjetpackcompose

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import java.text.DecimalFormat

class MainViewModel : ViewModel() {
    val uiState: MutableState<UiState> = mutableStateOf(UiState())

    fun onUiEvent(event: UiEvent) {
        when (event) {
            is UiEvent.On0Clicked, UiEvent.On1Clicked, UiEvent.On2Clicked, UiEvent.On3Clicked,
            UiEvent.On4Clicked, UiEvent.On5Clicked, UiEvent.On6Clicked, UiEvent.On7Clicked,
            UiEvent.On8Clicked, UiEvent.On9Clicked, UiEvent.OnPlusMinusClicked, UiEvent.OnDotClicked -> {
                updateNumber(event.character!!)
            }

            is UiEvent.OnClearClicked -> {
                clear()
            }

            is UiEvent.OnPlusClicked, UiEvent.OnMinusClicked, UiEvent.OnDivideClicked,
            UiEvent.OnTimesClicked -> {
                operate(event.operator)
            }

            is UiEvent.OnEgalClicked -> {
                egalize()
            }

            is UiEvent.OnClearAll -> {
                uiState.value = UiState()
            }
        }
    }

    private fun updateNumber(number: String) {
        if (uiState.value.answer.isNotEmpty()) {
            uiState.value = uiState.value.copy(
                firstNumber = "0",
                currentOperator = CalculationOperator.NONE,
                calculationExpression = ""
            )
        }
        if (uiState.value.currentOperator == CalculationOperator.NONE) {
            uiState.value = uiState.value.copy(
                firstNumber = uiState.value.firstNumber + number,
                answer = ""
            )
        } else {
            uiState.value = uiState.value.copy(
                calculationExpression = "${myFormatter(uiState.value.firstNumber.toDouble())} ${uiState.value.currentOperator.symbol}",
                secondNumber = uiState.value.secondNumber + number,
                answer = ""
            )

        }
        Log.d("MYAPP", uiState.value.toString())
    }

    private fun clear() {
        if (uiState.value.answer.isNotEmpty()) {
            return
        }
        if (uiState.value.currentOperator == CalculationOperator.NONE) {
            uiState.value = uiState.value.copy(
                firstNumber = uiState.value.firstNumber.dropLast(1)
            )
        } else {
            uiState.value = uiState.value.copy(
                secondNumber = uiState.value.secondNumber.dropLast(1)
            )

        }
        Log.d("MYAPP", uiState.value.toString())
    }

    private fun operate(operator: CalculationOperator) {
        if (uiState.value.currentOperator != CalculationOperator.NONE) {
            when (uiState.value.currentOperator) {
                CalculationOperator.ADDITION -> {
                    uiState.value = uiState.value.copy(
                        answer = (uiState.value.firstNumber.toDouble() * uiState.value.secondNumber.toDouble()).toString(),
                        currentOperator = CalculationOperator.NONE,
                        calculationExpression = "${uiState.value.firstNumber} ${uiState.value.currentOperator.symbol} ${uiState.value.secondNumber}"
                    )
                }

                CalculationOperator.MULTIPLICATION -> {
                    uiState.value = uiState.value.copy(
                        answer = (uiState.value.firstNumber.toDouble() * uiState.value.secondNumber.toDouble()).toString(),
                        currentOperator = CalculationOperator.NONE,
                        calculationExpression = "${uiState.value.firstNumber} ${uiState.value.currentOperator.symbol} ${uiState.value.secondNumber}"
                    )
                }

                CalculationOperator.SUBSTRACTION -> {
                    uiState.value = uiState.value.copy(
                        answer = (uiState.value.firstNumber.toDouble() - uiState.value.secondNumber.toDouble()).toString(),
                        currentOperator = CalculationOperator.NONE,
                        calculationExpression = "${uiState.value.firstNumber} ${uiState.value.currentOperator.symbol} ${uiState.value.secondNumber}"
                    )
                }

                CalculationOperator.DIVISION -> {
                    uiState.value = uiState.value.copy(
                        answer = "",
                        firstNumber = "${uiState.value.firstNumber.toDouble() / uiState.value.secondNumber.toDouble()}",
                        currentOperator = CalculationOperator.NONE,
                        calculationExpression = "${uiState.value.firstNumber} ${uiState.value.currentOperator.symbol} ${uiState.value.secondNumber}"
                    )
                }

                CalculationOperator.NONE -> {}

            }
        } else {
            uiState.value = uiState.value.copy(
                answer = "",
                currentOperator = operator,
                calculationExpression = "${DecimalFormat("###.#").format(uiState.value.firstNumber.toDouble())} ${operator.symbol}"
            )
        }

        Log.d("MYAPP", uiState.value.toString())

    }

    private fun egalize() {
        when (uiState.value.currentOperator) {
            CalculationOperator.ADDITION -> {
                uiState.value = uiState.value.copy(
                    answer = (uiState.value.firstNumber.toDouble() + uiState.value.secondNumber.toDouble()).toString(),
                    currentOperator = CalculationOperator.NONE,
                    calculationExpression = "${myFormatter(uiState.value.firstNumber.toDouble())} " +
                            "${uiState.value.currentOperator.symbol} " +
                            "${myFormatter(uiState.value.secondNumber.toDouble())} =",
                    firstNumber = (uiState.value.firstNumber.toDouble() + uiState.value.secondNumber.toDouble()).toString(),
                    secondNumber = "0"
                )
            }

            CalculationOperator.MULTIPLICATION -> {
                uiState.value = uiState.value.copy(
                    answer = (uiState.value.firstNumber.toDouble() * uiState.value.secondNumber.toDouble()).toString(),
                    currentOperator = CalculationOperator.NONE,
                    calculationExpression = "${myFormatter(uiState.value.firstNumber.toDouble())} " +
                            "${uiState.value.currentOperator.symbol} " +
                            "${myFormatter(uiState.value.secondNumber.toDouble())} =",
                    firstNumber = (uiState.value.firstNumber.toDouble() * uiState.value.secondNumber.toDouble()).toString(),
                    secondNumber = "0"
                )
            }

            CalculationOperator.SUBSTRACTION -> {
                uiState.value = uiState.value.copy(
                    answer = (uiState.value.firstNumber.toDouble() - uiState.value.secondNumber.toDouble()).toString(),
                    currentOperator = CalculationOperator.NONE,
                    calculationExpression = "${myFormatter(uiState.value.firstNumber.toDouble())} " +
                            "${uiState.value.currentOperator.symbol} " +
                            "${myFormatter(uiState.value.secondNumber.toDouble())} =",
                    firstNumber = (uiState.value.firstNumber.toDouble() - uiState.value.secondNumber.toDouble()).toString(),
                    secondNumber = "0"
                )
            }

            CalculationOperator.DIVISION -> {
                uiState.value = uiState.value.copy(
                    answer = (uiState.value.firstNumber.toDouble() / uiState.value.secondNumber.toDouble()).toString(),
                    currentOperator = CalculationOperator.NONE,
                    calculationExpression = "${myFormatter(uiState.value.firstNumber.toDouble())} " +
                            "${uiState.value.currentOperator.symbol} " +
                            "${myFormatter(uiState.value.secondNumber.toDouble())} =",
                    firstNumber = (uiState.value.firstNumber.toDouble() / uiState.value.secondNumber.toDouble()).toString(),
                    secondNumber = "0"
                )
            }

            CalculationOperator.NONE -> {}
        }
        Log.d("MYAPP", uiState.value.toString())
    }

    private fun myFormatter(input : Double): String {
        return DecimalFormat("###.#").format(input)
    }
}