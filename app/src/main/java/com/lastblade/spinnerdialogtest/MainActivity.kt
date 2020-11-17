/*
 * Copyright (c) 2020.
 * Ashiqul Islam
 */

package com.lastblade.spinnerdialogtest

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.content.ContextCompat
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
                title("Title", ContextCompat.getColor(context, R.color.colorPrimaryDark))
                listValues(data) { text, position ->
                    this@MainActivity.tv.text = "Selected item: $text"
                }

                negativeButton(textColor = resources.getColor(R.color.colorAccent))
            }
        }


    }


}