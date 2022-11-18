package com.example.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    var notedc: EditText? = null
    var noteds: EditText? = null
    var notetp: EditText? = null
    var result: TextView? = null
    var moyenneResult: String? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        notedc = findViewById(R.id.notedc)
        noteds = findViewById(R.id.noteds)
        notetp = findViewById(R.id.notetp)
        result = findViewById(R.id.result)
    }

    fun pourc(note: Double, pour: Double): Double {
        return note * pour / 100
    }

    fun CalculerMoyenne(view: View?) {
        // convertion du champs de saisie en text
        val n1 = notedc!!.text.toString()
        val n2 = noteds!!.text.toString()
        val n3 = notetp!!.text.toString()
        //convertion du text en number
        val ndc = n1.toDouble()
        val nds = n2.toDouble()
        val ntp = n3.toDouble()

        //calcule de note selon le pourcentage
        val ndcf = pourc(ndc, 40.0)
        val ndsf = pourc(nds, 60.0)
        val ntpf = pourc(ntp, 20.0)
        val sumDSDC = ndcf + ndsf
        val ndsdcf = pourc(sumDSDC, 80.0)
        //resultat du calcule moyenne
        val moyenne = ndsdcf + ntpf
        moyenneResult = "Votre Moyenne est: $moyenne"
        result!!.text = moyenneResult
    }
}