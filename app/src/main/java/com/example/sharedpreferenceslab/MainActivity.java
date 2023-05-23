package com.example.sharedpreferenceslab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    Button btn_red, btn_beige,btn_green;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        androidx.appcompat.widget.Toolbar toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.toolbar);
        btn_red=findViewById(R.id.button_red);
        btn_beige=findViewById(R.id.button_beige);
        btn_green=findViewById(R.id.button_green);

        if(getColor()!=getResources().getColor(com.google.android.material.R.color.design_default_color_primary)) {
            toolbar.setBackgroundColor(getColor());
        }

        btn_red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.red));
                getWindow().setStatusBarColor(getResources().getColor(R.color.red));
                storeColor(getResources().getColor(R.color.red));
            }
        });


        btn_beige.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.beige));
                getWindow().setStatusBarColor(getResources().getColor(R.color.beige));
                storeColor(getResources().getColor(R.color.beige));
            }
        });


        btn_green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toolbar.setBackgroundColor(getResources().getColor(R.color.green));
                getWindow().setStatusBarColor(getResources().getColor(R.color.green));
                storeColor(getResources().getColor(R.color.green));
            }
        });
    }

    private void storeColor (int color) {
        SharedPreferences shared = getSharedPreferences("ColorTool", MODE_PRIVATE);
        SharedPreferences.Editor editor=shared.edit();
        editor.putInt("color",color);
        editor.apply();
    }

    private int getColor () {
        SharedPreferences shared =getSharedPreferences("ColorTool", MODE_PRIVATE);
        int currentColor =shared.getInt("color",getResources().getColor(com.google.android.material.R.color.design_default_color_primary));
        return currentColor;
    }
}