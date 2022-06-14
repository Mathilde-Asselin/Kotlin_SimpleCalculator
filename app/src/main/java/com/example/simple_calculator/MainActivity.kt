package com.example.simple_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_add.setOnClickListener(){
            add()
        }

        button_substract.setOnClickListener(){
            substract()
        }

        button_multiply.setOnClickListener(){
            multiply()
        }

        button_divide.setOnClickListener(){
            divide()
        }
    }

    //Initialize The Addition Operation
    fun add(){
        if(inputIsNotEmpty()){
            val input1 = edit1.text.toString().trim().toBigDecimal()
            val input2 = edit2.text.toString().trim().toBigDecimal()
            result.text = input1.add(input2).toString()
        }
    }

    //Initialize The Substarction Operation
    fun substract(){
        if(inputIsNotEmpty()){
            val input1 = edit1.text.toString().trim().toBigDecimal()
            val input2 = edit2.text.toString().trim().toBigDecimal()
            result.text = input1.subtract(input2).toString()
        }
    }

    //Initialize The Multiplication Operation
    fun multiply(){
        if(inputIsNotEmpty()){
            val input1 = edit1.text.toString().trim().toBigDecimal()
            val input2 = edit2.text.toString().trim().toBigDecimal()
            result.text = input1.multiply(input2).toString()
        }
    }

    //Initialize The Division Operation
    fun divide(){
        if(inputIsNotEmpty()){
            val input1 = edit1.text.toString().trim().toBigDecimal()
            val input2 = edit2.text.toString().trim().toBigDecimal()
            if (input2.compareTo(BigDecimal.ZERO) == 0){
                edit2.error = "Invalid input"
            }else{
                result.text = input1.divide(input2, 2, RoundingMode.HALF_UP).toString()
            }
        }
    }

    //If Text is empty => Error
    fun inputIsNotEmpty() : Boolean{
        var b = true
        if(edit1.text.toString().trim().isEmpty()){
            edit1.error = "Required"
            b = false
        }
        if(edit2.text.toString().trim().isEmpty()){
            edit2.error = "Required"
            b = false
        }
        return b
    }
}