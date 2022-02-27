package com.example.tictactoeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun butClick(view: android.view.View) {
        val butSelected: Button = view as Button
        var cellId = 0
        when(butSelected.id){
            R.id.but1 -> cellId = 1
            R.id.but2 -> cellId = 2
            R.id.but3 -> cellId = 3
            R.id.but4 -> cellId = 4
            R.id.but5 -> cellId = 5
            R.id.but6 -> cellId = 6
            R.id.but7 -> cellId = 7
            R.id.but8 -> cellId = 8
            R.id.but9 -> cellId = 9

        }
        //Log.d("butClick" ,butSelected.id.toString())
        //Log.d("butClick: cellId:", cellId.toString())
        playGame(cellId,butSelected)
    }
    var activePlayer = 1
    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    fun playGame(cellId:Int, butSelected:Button){
        if(activePlayer == 1){
            butSelected.text = "X"
            butSelected.setBackgroundResource(R.color.blue)
            player1.add(cellId)
            activePlayer = 2
            autoPlay()
        }else{
            butSelected.text = "O"
            butSelected.setBackgroundResource(R.color.red)
            player2.add(cellId)
            activePlayer = 1
        }
        butSelected.isEnabled = false
        checkWiner()

    }
    fun checkWiner(){
        var winer = 0
        //row1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winer = 2
        }
        //row2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winer = 2
        }
        //row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winer = 2
        }

        //col1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winer = 2
        }
        //col2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winer = 2
        }
        //col3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winer = 2
        }

        if(winer == 1){
            player1WinsCounts += 1
            Toast.makeText(this,"player 1 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        }else if(winer == 2){
            player2WinsCounts += 1
            Toast.makeText(this,"player 2 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        }
    }
    fun autoPlay(){
        var emptyCells = ArrayList<Int>()
        for( cellId: Int in 1..9){
            if (!(player1.contains(cellId) || player2.contains(cellId))){
                emptyCells.add(cellId)
            }
        }
        val r = Random()
        val randIndex:Int = r.nextInt(emptyCells.size)
        val cellId:Int = emptyCells[randIndex]

        val but1: Button = findViewById(R.id.but1)
        val but2: Button = findViewById(R.id.but2)
        val but3: Button = findViewById(R.id.but3)
        val but4: Button = findViewById(R.id.but4)
        val but5: Button = findViewById(R.id.but5)
        val but6: Button = findViewById(R.id.but6)
        val but7: Button = findViewById(R.id.but7)
        val but8: Button = findViewById(R.id.but8)
        val but9: Button = findViewById(R.id.but9)
        var butSelected:Button?
        butSelected = when(cellId){
            1 -> but1
            2 -> but2
            3 -> but3
            4 -> but4
            5 -> but5
            6 -> but6
            7 -> but7
            8 -> but8
            9 -> but9
            else ->{but1}
        }
        playGame(cellId,butSelected)
    }

    var player1WinsCounts = 0
    var player2WinsCounts = 0
    fun restartGame(){
        activePlayer = 1
        player1.clear()
        player2.clear()
        val but1: Button = findViewById(R.id.but1)
        val but2: Button = findViewById(R.id.but2)
        val but3: Button = findViewById(R.id.but3)
        val but4: Button = findViewById(R.id.but4)
        val but5: Button = findViewById(R.id.but5)
        val but6: Button = findViewById(R.id.but6)
        val but7: Button = findViewById(R.id.but7)
        val but8: Button = findViewById(R.id.but8)
        val but9: Button = findViewById(R.id.but9)

        for (cellId :Int in 1..9){

            var butSelected:Button? = when(cellId){
                1 -> but1
                2 -> but2
                3 -> but3
                4 -> but4
                5 -> but5
                6 -> but6
                7 -> but7
                8 -> but8
                9 -> but9
                else ->{but1}
            }
            butSelected!!.text = ""
            butSelected!!.setBackgroundResource(R.color.whiteBut)
            butSelected!!.isEnabled = true

        }
        Toast.makeText(this,"player1: $player1WinsCounts , player2: $player2WinsCounts",Toast.LENGTH_LONG).show()
    }
}