package com.example.togglebuttongra

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var punkty = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPreferences = getSharedPreferences("sharedPrefs", Context.MODE_PRIVATE)
        var pom = 0
        var score = sharedPreferences.getInt("score", 0)
        val przyciski = listOf<ToggleButton>(
            findViewById(R.id.btn1),
            findViewById(R.id.btn2),
            findViewById(R.id.btn3),
            findViewById(R.id.btn4),
            findViewById(R.id.btn5),
            findViewById(R.id.btn6),
            findViewById(R.id.btn7),
            findViewById(R.id.btn8),
            findViewById(R.id.btn9)
        )
        val numbers = losuj_kolejnosc()

        findViewById<TextView>(R.id.textView).text = "Score: " + score.toString()

        for (i in 0..przyciski.size-1){
            przyciski[i].setOnClickListener {
                if(i+1 != numbers[pom]){
                    reset_przyciskow(przyciski)
                    pom = 0
                    Toast.makeText(applicationContext, "Coś źle", Toast.LENGTH_SHORT).show()
                }
                else{
                    pom+=1
                }
                zmiana_tla(przyciski[i])
                if(pom == numbers.size){
                    pom=0
                    score += 1
                    findViewById<TextView>(R.id.textView).text = "Score: " + score.toString()
                    reset_przyciskow(przyciski)
                    losuj_kolejnosc()
                    Toast.makeText(applicationContext, "Wylosowałem nową kolejność, Spróbuj teraz!", Toast.LENGTH_SHORT).show()
                    val editor = sharedPreferences.edit()
                    editor.apply{
                        putInt("score", score)
                    }.apply()
                }
            }
        }
    }

    fun zmiana_tla(przycisk: ToggleButton){
        if (przycisk.isChecked){
            przycisk.setBackgroundResource(R.drawable.buttonbackon)
        }
        else{
            przycisk.setBackgroundResource(R.drawable.buttonback)
        }
    }

    fun reset_przyciskow(przyciski: List<ToggleButton>){
        for (j in 0..przyciski.size-1){
            przyciski[j].isChecked = false
            przyciski[j].setBackgroundResource(R.drawable.buttonback)
        }
    }

    fun losuj_kolejnosc(): List<Int> {
        val lista: List<Int> = listOf(9,8,7,6,5,4,3,2,1)
        return lista
    }
}