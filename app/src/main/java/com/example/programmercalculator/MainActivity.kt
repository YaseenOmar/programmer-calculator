package com.example.programmercalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener

class MainActivity : AppCompatActivity() {
    lateinit var spinner: Spinner
    lateinit var binary_input : EditText
    lateinit var octal_input: EditText
    lateinit var decimal_input: EditText
    lateinit var hexDecimal_input: EditText
    lateinit var binary_output : TextView
    lateinit var octal_output : TextView
    lateinit var decimal_output : TextView
    lateinit var hexDecimal_output: TextView
    lateinit var convert :Button
    lateinit var result: LinearLayout
    lateinit var selectTextView: TextView
//    lateinit var radioGroup: RadioGroup
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    initialize()


    var choice = 0
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                choice = position

                when (position){
                    0->{
                        convert.setVisibility(View.GONE)
                        selectTextView.setVisibility(View.VISIBLE)
                        binary_input.setVisibility(View.GONE)
                        octal_input.setVisibility(View.GONE)
                        decimal_input.setVisibility(View.GONE)
                        hexDecimal_input.setVisibility(View.GONE)
                    }

                    1 -> {
                        convert.setVisibility(View.VISIBLE)
                        selectTextView.setVisibility(View.GONE)
                        binary_input.setVisibility(View.VISIBLE)
                        octal_input.setVisibility(View.GONE)
                        decimal_input.setVisibility(View.GONE)
                        hexDecimal_input.setVisibility(View.GONE)
                    }
                    2 -> {
                        convert.setVisibility(View.VISIBLE)
                        selectTextView.setVisibility(View.GONE)
                        binary_input.setVisibility(View.GONE)
                        octal_input.setVisibility(View.VISIBLE)
                        decimal_input.setVisibility(View.GONE)
                        hexDecimal_input.setVisibility(View.GONE)
                    }
                    3 -> {
                        convert.setVisibility(View.VISIBLE)
                        selectTextView.setVisibility(View.GONE)
                        binary_input.setVisibility(View.GONE)
                        octal_input.setVisibility(View.GONE)
                        decimal_input.setVisibility(View.VISIBLE)
                        hexDecimal_input.setVisibility(View.GONE)
                    }
                    4 ->{
                        convert.setVisibility(View.VISIBLE)
                        selectTextView.setVisibility(View.GONE)
                        binary_input.setVisibility(View.GONE)
                        octal_input.setVisibility(View.GONE)
                        decimal_input.setVisibility(View.GONE)
                        hexDecimal_input.setVisibility(View.VISIBLE)
                    }

                }

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Do nothing
            }
        }

    convert.setOnClickListener{
        result.setVisibility(View.VISIBLE)
        when(choice){
            1->{
                try {
                    binary_output.text = binary_input.text.toString()
                    decimal_output.text = binaryToDecimal(binary_input.text.toString()).toString()
                    octal_output.text = binaryToOctal(binary_input.text.toString())
                    hexDecimal_output.text = binaryToHexadecimal(binary_input.text.toString())
                }catch (e: java.lang.NumberFormatException){
                    Toast.makeText(this , "The entered number is not a binary number" , Toast.LENGTH_SHORT).show()
                    convert.setVisibility(View.GONE)
                    selectTextView.setVisibility(View.VISIBLE)
                    binary_input.setVisibility(View.GONE)
                    octal_input.setVisibility(View.GONE)
                    decimal_input.setVisibility(View.GONE)
                    hexDecimal_input.setVisibility(View.GONE)

                }


            }
            2-> {
                try {


                    octal_output.text = octal_input.text.toString()
                    binary_output.text = octalToBinary(octal_input.text.toString())
                    decimal_output.text = octalToDecimal(octal_input.text.toString()).toString()
                    hexDecimal_output.text = octalToHexadecimal(octal_input.text.toString())
                }catch (e: java.lang.NumberFormatException){
                    Toast.makeText(this , "The entered number is not a octal number" , Toast.LENGTH_SHORT).show()
                    convert.setVisibility(View.GONE)
                    selectTextView.setVisibility(View.VISIBLE)
                    binary_input.setVisibility(View.GONE)
                    octal_input.setVisibility(View.GONE)
                    decimal_input.setVisibility(View.GONE)
                    hexDecimal_input.setVisibility(View.GONE)

                }
            }
            3-> {
                try {


                    decimal_output.text = decimal_input.text.toString()
                    binary_output.text = decimalToBinary(decimal_input.text.toString())
                    octal_output.text = decimalToOctal(decimal_input.text.toString())
                    hexDecimal_output.text = decimalToHexadecimal(decimal_input.text.toString())

                }catch (e: java.lang.NumberFormatException){
                    Toast.makeText(this , "The entered number is not a decimal number" , Toast.LENGTH_SHORT).show()
                    convert.setVisibility(View.GONE)
                    selectTextView.setVisibility(View.VISIBLE)
                    binary_input.setVisibility(View.GONE)
                    octal_input.setVisibility(View.GONE)
                    decimal_input.setVisibility(View.GONE)
                    hexDecimal_input.setVisibility(View.GONE)

                }
            }
            4-> {
                try {
                hexDecimal_output.text = hexDecimal_input.text.toString()
                binary_output.text = hexadecimalToBinary(hexDecimal_input.text.toString())
                octal_output.text = hexadecimalToOctal(hexDecimal_input.text.toString())
                decimal_output.text =
                    hexadecimalToDecimal(hexDecimal_input.text.toString()).toString()
            }catch (e: java.lang.NumberFormatException){
            Toast.makeText(this , "The entered number is not a hexadecimal number" , Toast.LENGTH_SHORT).show()
            convert.setVisibility(View.GONE)
            selectTextView.setVisibility(View.VISIBLE)
            binary_input.setVisibility(View.GONE)
            octal_input.setVisibility(View.GONE)
            decimal_input.setVisibility(View.GONE)
            hexDecimal_input.setVisibility(View.GONE)

        }
            }
        }


    }




    }

    fun initialize(){
        binary_input = findViewById(R.id.binary_input)
        octal_input = findViewById(R.id.octal_input)
        decimal_input = findViewById(R.id.decimal_input)
        hexDecimal_input = findViewById(R.id.hexDecimal_input)
        binary_output = findViewById(R.id.binary_output)
        octal_output = findViewById(R.id.octal_output)
        decimal_output = findViewById(R.id.decimal_output)
        hexDecimal_output = findViewById(R.id.hexDecimal_output)
        convert = findViewById(R.id.button)
        result = findViewById(R.id.result)
        spinner = findViewById(R.id.spinner)
        selectTextView = findViewById(R.id.selectText)



    }

    // TODO Convert from binary functions
    fun binaryToDecimal(binary: String): Int {
        return binary.toInt(2)
    }
    fun binaryToOctal(binary: String): String {
        val decimalNumber = binary.toInt(2)
        return decimalNumber.toString(8)
    }
    fun binaryToHexadecimal(binary: String): String {
        val decimalNumber = binary.toInt(2)
        return decimalNumber.toString(16)
    }

    // TODO Convert from octal functions
    fun octalToBinary(octal: String): String {
        // Convert octal to decimal
        val decimalNumber = octal.toInt(8)

        // Convert decimal to binary
        return decimalNumber.toString(2)
    }

    fun octalToDecimal(octal: String): Int {
        return octal.toInt(8)
    }
    fun octalToHexadecimal(octal: String): String {
        val decimalNumber = octal.toInt(8)
        return decimalNumber.toString(16)
    }

    // TODO Convert from decimal functions
    fun decimalToBinary(decimal: String): String {
       val decimalInt= decimal.toInt()
        return decimalInt.toString(2)
    }

    fun decimalToOctal(decimal: String): String {
        val decimalInt= decimal.toInt()
        return decimalInt.toString(8)
    }

    fun decimalToHexadecimal(decimal: String): String {
        val decimalInt= decimal.toInt()
        return decimalInt.toString(16)
    }


    // TODO Convert from hexadecimal functions

    fun hexadecimalToBinary(hexadecimal: String): String {
        val decimalNumber = hexadecimal.toInt(16)
        return decimalNumber.toString(2)
    }

    fun hexadecimalToOctal(hexadecimal: String): String {
        val decimalNumber = hexadecimal.toInt(16)
        return decimalNumber.toString(8)
    }

    fun hexadecimalToDecimal(hexadecimal: String): Int {
        return hexadecimal.toInt(16)
    }

}



