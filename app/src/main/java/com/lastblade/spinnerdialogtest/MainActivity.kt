package com.lastblade.spinnerdialogtest

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.lastblade.rvdialog.RvDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val data = arrayListOf("Orange", "Apple", "Mango")

        btnShowDialog.setOnClickListener {
            RvDialog(this).show {
                title("Title")
                listValues(data) { text, position ->
                    this@MainActivity.tv.text = "Selected item: $text"

                    dismiss()
                }

                negativeButton()
            }
        }


    }


}