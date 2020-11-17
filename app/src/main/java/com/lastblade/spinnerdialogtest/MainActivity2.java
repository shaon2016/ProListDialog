/*
 * Copyright (c) 2020.
 * Ashiqul Islam
 */

package com.lastblade.spinnerdialogtest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.lastblade.rvdialog.RvDialog;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        ArrayList items = new ArrayList<String>();
        items.add("Mango");
        items.add("Apple");


        TextView tv = findViewById(R.id.tv);

        findViewById(R.id.btnShowDialog).setOnClickListener(v -> {
            new RvDialog(this)
                    .title("Title")
                    .negativeButton()
                    .listValues(items, (item, index) -> {
                        tv.setText(item);
                        return null;
                    })
                    .show();
        });


    }
}