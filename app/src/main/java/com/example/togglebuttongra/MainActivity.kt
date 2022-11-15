package com.example.togglebuttongra

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Toast
import android.widget.ToggleButton
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var punkty = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var pom = 0
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

        val numbers: List<Int> = listOf(9,8,7,6,5,4,3,2,1)

        for (i in 0..przyciski.size-1){
            przyciski[i].setOnClickListener {
                if(i+1 != numbers[pom]){
                    for (j in 0..przyciski.size-1){
                        przyciski[j].isChecked = false
                        przyciski[j].setBackgroundResource(R.drawable.buttonback)
                    }
                    pom = 0
                }
                else{
                    pom+=1
                }
                zmiana_tla(przyciski[i])
                if(pom == numbers.size-1){

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
}