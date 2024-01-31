package com.example.akbar_atakhodzhaev_m2_cw7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.jaredrummler.materialspinner.MaterialSpinner;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ImageButton heartButton;;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        String result = getIntent().getStringExtra("RESULT");
        TextView answer = findViewById(R.id.answer);
        answer.setText(result);
        heartButton = findViewById(R.id.heartButton);
        MaterialSpinner spinner = (MaterialSpinner) findViewById(R.id.spinner);
        spinner.setItems("1", "2", "3", "4", "5");
        spinner.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {
            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
    }
    public void onHeartButtonClick(View view) {
        heartButton.setSelected(!heartButton.isSelected());
        int imageResource = heartButton.isSelected() ? R.drawable.heart : R.drawable.heart__1_;
        heartButton.setImageResource(imageResource);
    }
    public void onNextButtonClick(View view){
        finish();
        Intent intent = new Intent(SecondActivity.this, MainActivity.class);
        finish();
    }
}