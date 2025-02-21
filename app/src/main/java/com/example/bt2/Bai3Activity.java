package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class Bai3Activity extends AppCompatActivity {

    EditText inputArray;
    Button btnShowPrimeNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bai3);
        inputArray = (EditText) findViewById(R.id.inputArray);
        btnShowPrimeNumber = (Button) findViewById(R.id.btnShowPrimeNumber);
        btnShowPrimeNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                findPrimeNumbers(inputArray.getText().toString());
            }
        });
    }

    private Boolean checkPrimeNumber(int number) {
        if(number < 2) return false;
        for(int i = 2; i * i <= number; i++) {
            if(number % i == 0) {
                return false;
            }
        }
        return true;
    }
    private void findPrimeNumbers(String string) {
        String[] numbersArray = string.split("\\s+");
        for(int i = 0; i < numbersArray.length; i++) {
            int num = Integer.parseInt(numbersArray[i]);
            if(checkPrimeNumber(num)) {
                Log.d("Prime Number: ", num + "");
            }
        }
    }
}