package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator.databinding.ActivityMainBinding
import com.github.keelar.exprk.Expressions

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var resultText: String = ""
    private var currentBracket: String = "("

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupOnclickListeners()
    }

    @SuppressLint("SetTextI18n")
    private fun setupOnclickListeners() {
        binding.button0.setOnClickListener {
            resultText += "0"
            binding.result.text = resultText
        }
        binding.button1.setOnClickListener {
            resultText += "1"
            binding.result.text = resultText
        }
        binding.button2.setOnClickListener {
            resultText += "2"
            binding.result.text = resultText
        }
        binding.button3.setOnClickListener {
            resultText += "3"
            binding.result.text = resultText
        }
        binding.button4.setOnClickListener {
            resultText += "4"
            binding.result.text = resultText
        }
        binding.button5.setOnClickListener {
            resultText += "5"
            binding.result.text = resultText
        }
        binding.button6.setOnClickListener {
            resultText += "6"
            binding.result.text = resultText
        }
        binding.button7.setOnClickListener {
            resultText += "7"
            binding.result.text = resultText
        }
        binding.button8.setOnClickListener {
            resultText += "8"
            binding.result.text = resultText
        }
        binding.button9.setOnClickListener {
            resultText += "9"
            binding.result.text = resultText
        }
        binding.buttonPlus.setOnClickListener {
            resultText += "+"
            binding.result.text = resultText
        }
        binding.buttonSubtract.setOnClickListener {
            resultText += "-"
            binding.result.text = resultText
        }
        binding.buttonMultiply.setOnClickListener {
            resultText += "*"
            binding.result.text = resultText
        }
        binding.buttonDivide.setOnClickListener {
            resultText += "/"
            binding.result.text = resultText
        }
        binding.buttonEquals.setOnClickListener {
            try {
                binding.result.text = "= ${Expressions().evalToString(resultText)}"
            } catch (e: Exception) {
                Toast.makeText(this, "Invalid expression", Toast.LENGTH_LONG).show()
            }
            resultText = ""
        }
        binding.buttonBrackets.setOnClickListener {
            if (currentBracket == ")") {
                resultText += "("
                currentBracket = "("
            } else {
                resultText += ")"
                currentBracket = ")"
            }
            binding.result.text = resultText
        }
        binding.buttonDelete.setOnClickListener {
            if (resultText.isNotEmpty()) {
                resultText = resultText.substring(0, resultText.length - 1)
                binding.result.text = resultText
            }
        }
        binding.buttonClear.setOnClickListener {
            resultText = "0"
            binding.result.text = resultText
        }
    }

}