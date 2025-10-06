package com.ggdos.mp1_tic_tac_toe_ostol

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import kotlin.random.Random


class MainActivity : AppCompatActivity(), View.OnClickListener {


    private lateinit var boardButtons: Array<Button>
    private lateinit var statusText: TextView
    private lateinit var startGroup: RadioGroup
    private lateinit var radioPlayer: RadioButton
    private lateinit var radioComputer: RadioButton
    private lateinit var btnRestart: Button


    // 'X' => player, 'O' => computer, '' => empty
    private var board = Array(9) { "" }
    private var playerSymbol = "X"
    private var computerSymbol = "O"
    private var currentTurnIsPlayer = true
    private var gameActive = true


    private val winningLines = arrayOf(
        intArrayOf(0, 1, 2),
        intArrayOf(3, 4, 5),
        intArrayOf(6, 7, 8),
        intArrayOf(0, 3, 6),
        intArrayOf(1, 4, 7),
        intArrayOf(2, 5, 8),
        intArrayOf(0, 4, 8),
        intArrayOf(2, 4, 6)
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


// Views
        statusText = findViewById(R.id.statusText)
        startGroup = findViewById(R.id.startGroup)
        radioPlayer = findViewById(R.id.radioPlayer)
        radioComputer = findViewById(R.id.radioComputer)
        btnRestart = findViewById(R.id.btnRestart)


// Buttons array
        boardButtons = Array(9) { i ->
            val id = resources.getIdentifier("btn\$i", "id", packageName)
            val btn: Button = findViewById(id)
            if (win != null)