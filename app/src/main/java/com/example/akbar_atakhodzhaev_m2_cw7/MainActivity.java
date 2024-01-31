package com.example.akbar_atakhodzhaev_m2_cw7;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private Double firstOperand, secondOperand;
    private boolean ifOperationClicked;
    boolean plus;
    boolean minus;
    boolean multiplication;
    boolean division;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.result);
        button = findViewById(R.id.buttonContinue);
        button.setVisibility(View.INVISIBLE);
        button.setOnClickListener(v -> {
            String result = textView.getText().toString();
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("RESULT",result);
            startActivity(intent);
            finish();
        });
    }

    public void onNumberClick(View view) {
        button.setVisibility(View.INVISIBLE);
        if (view.getId() == R.id.reset) {
            textView.setText("0");
            firstOperand = 0.0;
            secondOperand = 0.0;
            ifOperationClicked = false;
        } else {
            String text = ((MaterialButton) view).getText().toString();
            if (text.equals(".")) {
                if (!textView.getText().toString().contains(".")) {
                    textView.append(text);
                }
            } else {
                if (textView.getText().toString().equals("0") || ifOperationClicked) {
                    textView.setText(text);
                } else {
                    textView.append(text);
                }
            }
            ifOperationClicked = false;
        }
    }

    @SuppressLint("SetTextI18n")
    public void onOperationClick(View view){
        button.setVisibility(View.INVISIBLE);
        if(view.getId()==R.id.plus){
            String data = textView.getText().toString();
            firstOperand = Double.valueOf(data);
            plus=true;
        }else if (view.getId()==R.id.minus){
            String data = textView.getText().toString();
            firstOperand = Double.valueOf(data);
            minus=true;
        }else if (view.getId()==R.id.multiplication){
            String data = textView.getText().toString();
            firstOperand = Double.valueOf(data);
            multiplication=true;
        }else if (view.getId()==R.id.divison){
            String data = textView.getText().toString();
            firstOperand = Double.valueOf(data);
            division=true;
        }
        else if (view.getId()==R.id.equal){
            button.setVisibility(View.VISIBLE);
            String data = textView.getText().toString();
            secondOperand = Double.valueOf(data);
            if (plus) {
                Double result = firstOperand + secondOperand;
                textView.setText(result.toString());
                resetEqual();
            }
            if (minus){
                Double result = firstOperand - secondOperand;
                textView.setText(result.toString());
                resetEqual();
            }
            if (multiplication){
                Double result = firstOperand * secondOperand;
                textView.setText(result.toString());
                resetEqual();
            }
            if (division){
                if (secondOperand != 0) {
                    Double result = firstOperand / secondOperand;
                    textView.setText(result.toString());
                } else {
                    textView.setText("Error");
                }
                resetEqual();
            }
        }
        ifOperationClicked=true;
    }

    public void resetEqual() {
        division = false;
        multiplication = false;
        minus = false;
        plus = false;

        double result = Double.parseDouble(textView.getText().toString());
        if (result == (int) result) {
            textView.setText(String.valueOf((int) result));
        } else {
            textView.setText(String.valueOf(result));
        }

        firstOperand = 0.0;
        secondOperand = 0.0;
    }
    public void onPercentageClick(View view) {
        String data = textView.getText().toString();
        Double operand = Double.valueOf(data);
        Double result = operand / 100;
        textView.setText(result.toString());
        resetEqual();
        ifOperationClicked = true;
    }
    public void onSignChangeClick(View view) {
        String data = textView.getText().toString();
        Double operand = Double.valueOf(data);
        operand = -operand;
        textView.setText(operand.toString());
        resetEqual();
        ifOperationClicked = true;
    }

}
