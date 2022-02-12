package com.volumesquare.mycalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var textCalc : TextView? = null
    private var dotPresent : Boolean = false
    private var trickVariable : Int = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textCalc = findViewById(R.id.calc_text)
        textCalc?.text = ""
    }
    fun onDigitClicked(view:View){
        if((view as Button).text == "." ){
            if(!dotPresent){
                textCalc?.append((view as Button).text)
                dotPresent = true
            }
        }else if((view as Button).text == "0") {
            if (!textCalc?.text.toString().isNullOrEmpty()) {
                print("true -> executing")
                textCalc?.append((view as Button).text)
            }
        }else{
            textCalc?.append((view as Button).text)
        }
    }
    fun onCLear(view : View){
        textCalc?.text = ""
        dotPresent = false
    }
    fun subtract(view: View){

        if(!textCalc?.text?.toString().isNullOrEmpty()){
            if(textCalc?.text?.length == 1 && ((textCalc?.text?.last() == '+' || textCalc?.text?.last() == '-' || textCalc?.text?.last() == '*' || textCalc?.text?.last() == '/'))){
            }

            else if(textCalc?.text?.last() == '+' || textCalc?.text?.last() == '-' || textCalc?.text?.last() == '*' || textCalc?.text?.last() == '/'){
                textCalc?.text = textCalc?.text?.toString()?.dropLast(1)
                textCalc?.append("-")

            }
            else if(textCalc?.text?.startsWith('-') == true){
                if(textCalc?.text?.toString()?.drop(1)?.contains("+") == true || textCalc?.text?.toString()?.drop(1)?.contains("-") == true ||textCalc?.text?.toString()?.drop(1)?.contains("*") == true || textCalc?.text?.toString()?.drop(1)?.contains("/") == true){
                    getResult(view)
                    textCalc?.append("-")
                }else{
                    textCalc?.append("-")
                }
            }
            else{
                if(textCalc?.text?.toString()?.contains("+") == true || textCalc?.text?.toString()?.contains("-") == true ||textCalc?.text?.toString()?.contains("*") == true || textCalc?.text?.toString()?.contains("/") == true){
                    getResult(view)
                    textCalc?.append("-")
                }else{
                    textCalc?.append("-")
                }
            }
        }else{
            textCalc?.append("-")
        }
    }
    fun add(view: View){

        if(!textCalc?.text?.toString().isNullOrEmpty()){
            if(textCalc?.text?.length == 1 && ((textCalc?.text?.last() == '+' || textCalc?.text?.last() == '-' || textCalc?.text?.last() == '*' || textCalc?.text?.last() == '/'))){

            }
            else if(textCalc?.text?.last() == '+' || textCalc?.text?.last() == '-' || textCalc?.text?.last() == '*' || textCalc?.text?.last() == '/'){
                textCalc?.text = textCalc?.text?.toString()?.dropLast(1)
                textCalc?.append("+")

            }
            else if(textCalc?.text?.startsWith('-') == true){
                if(textCalc?.text?.toString()?.drop(1)?.contains("+") == true || textCalc?.text?.toString()?.drop(1)?.contains("-") == true ||textCalc?.text?.toString()?.drop(1)?.contains("*") == true || textCalc?.text?.toString()?.drop(1)?.contains("/") == true){
                    getResult(view)
                    textCalc?.append("+")
                }else{
                    textCalc?.append("+")
                }
            }
            else{
                if(textCalc?.text?.toString()?.contains("+") == true || textCalc?.text?.toString()?.contains("-") == true ||textCalc?.text?.toString()?.contains("*") == true || textCalc?.text?.toString()?.contains("/") == true){
                    getResult(view)
                    textCalc?.append("+")
                }else{
                    textCalc?.append("+")
                }
            }
        }
    }
    fun multiply(view: View){

        if(!textCalc?.text?.toString().isNullOrEmpty()){
            if(textCalc?.text?.length == 1 && (textCalc?.text?.last() == '+' || textCalc?.text?.last() == '-' || textCalc?.text?.last() == '*' || textCalc?.text?.last() == '/')){

            }

            else if(textCalc?.text?.last() == '+' || textCalc?.text?.last() == '-' || textCalc?.text?.last() == '*' || textCalc?.text?.last() == '/'){
                textCalc?.text = textCalc?.text?.toString()?.dropLast(1)
                textCalc?.append("*")

            }
            else if(textCalc?.text?.startsWith('-') == true){
                if(textCalc?.text?.toString()?.drop(1)?.contains("+") == true || textCalc?.text?.toString()?.drop(1)?.contains("-") == true ||textCalc?.text?.toString()?.drop(1)?.contains("*") == true || textCalc?.text?.toString()?.drop(1)?.contains("/") == true){
                    getResult(view)
                    textCalc?.append("*")
                }else{
                    textCalc?.append("*")
                }
            }
            else{
                if(textCalc?.text?.toString()?.contains("+") == true || textCalc?.text?.toString()?.contains("-") == true ||textCalc?.text?.toString()?.contains("*") == true || textCalc?.text?.toString()?.contains("/") == true){
                    getResult(view)
                    textCalc?.append("*")
                }else{
                    textCalc?.append("*")
                }
            }
        }
    }
    fun divide(view: View){


        if(!textCalc?.text?.toString().isNullOrEmpty()){
            if(textCalc?.text?.length == 1 && (textCalc?.text?.last() == '+' || textCalc?.text?.last() == '-' || textCalc?.text?.last() == '*' || textCalc?.text?.last() == '/')){

            }
            else if(textCalc?.text?.last() == '+' || textCalc?.text?.last() == '-' || textCalc?.text?.last() == '*' || textCalc?.text?.last() == '/'){
                textCalc?.text = textCalc?.text?.toString()?.dropLast(1)
                textCalc?.append("/")

            }
            else if(textCalc?.text?.startsWith('-') == true){
                if(textCalc?.text?.toString()?.drop(1)?.contains("+") == true || textCalc?.text?.toString()?.drop(1)?.contains("-") == true ||textCalc?.text?.toString()?.drop(1)?.contains("*") == true || textCalc?.text?.toString()?.drop(1)?.contains("/") == true){
                    getResult(view)
                    textCalc?.append("/")
                }else{
                    textCalc?.append("/")
                }
            }
            else{
                if(textCalc?.text?.toString()?.contains("+") == true || textCalc?.text?.toString()?.contains("-") == true ||textCalc?.text?.toString()?.contains("*") == true || textCalc?.text?.toString()?.contains("/") == true){
                    getResult(view)
                    textCalc?.append("/")
                }else{
                    textCalc?.append("/")
                }
            }
        }
    }
    fun deleteOne(view: View) {
        if(!textCalc?.text?.toString().isNullOrEmpty()){
            textCalc?.text = textCalc?.text?.toString()?.dropLast(1)
        }
    }
    fun getResult(view: View) {
        var computedText = textCalc?.text
        if(textCalc?.text?.startsWith('-')==true){
            trickVariable = -1
         computedText = textCalc?.text?.toString()?.drop(1)
        }else{
            trickVariable = 1
        }
        when {
            computedText?.contains("+") == true -> {
                var splitString = textCalc?.text?.toString()?.split("+")
                textCalc?.text = "${
                    (splitString?.get(0)?.toInt()?.times(trickVariable) )
                        ?.plus(splitString?.get(1)?.toInt()!!)
                }"

            }
            computedText?.contains("-") == true -> {
                var splitString = textCalc?.text?.toString()?.split("-")
                textCalc?.text = "${
                    (splitString?.get(0)?.toInt()?.times(trickVariable) )
                        ?.minus(splitString?.get(1)?.toInt()!!)
                }"

            }
            computedText?.contains("/") == true -> {
                try {
                    var splitString = textCalc?.text?.toString()?.split("/")
                    textCalc?.text = "${
                        (splitString?.get(0)?.toInt()?.times(trickVariable) )
                            ?.div(splitString?.get(1)?.toInt()!!)
                    }"
                } catch (e: Exception) {
                    Toast.makeText(this, "Operation Not Permitted", Toast.LENGTH_SHORT).show()
                }

            }
            computedText?.contains("*") == true -> {
                var splitString = textCalc?.text?.toString()?.split("*")
                textCalc?.text = "${
                    (splitString?.get(0)?.toInt()?.times(trickVariable) )
                        ?.times(splitString?.get(1)?.toInt()!!)
                }"

            }
        }

    }
}