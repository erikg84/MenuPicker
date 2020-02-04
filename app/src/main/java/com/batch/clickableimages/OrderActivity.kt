package com.batch.clickableimages

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_order.*

const val sameDay = "same_day_radioButton"
const val nextDay = "next_day_radioButton"
const val pickUp = "pick_up_radioButton"

class OrderActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        val intent = getIntent()
        val message = intent.getStringExtra("message")
        recieved_message.text = message


        back_button.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
    fun radioButtonClicked(view: View){

        val radioButtonName = resources.getResourceEntryName(view.id)

        when(radioButtonName){
            sameDay -> Toast.makeText(this,R.string.same_day,Toast.LENGTH_LONG).show()
            nextDay -> Toast.makeText(this,R.string.next_day,Toast.LENGTH_LONG).show()
            pickUp -> Toast.makeText(this,R.string.pick_up,Toast.LENGTH_LONG).show()
        }
    }
}
