package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Bai4Activity extends AppCompatActivity {

    EditText inputLength;
    TextView txtArray;
    Button btnGenerate;
    Button btnShowSquareNumber;
    ArrayList<Integer> array = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bai4);
        inputLength = (EditText) findViewById(R.id.inputLength);
        txtArray = (TextView) findViewById(R.id.txtArray);
        btnGenerate = (Button) findViewById(R.id.btnGenerate);
        btnShowSquareNumber = (Button) findViewById(R.id.btnShowSquareNumber);
        btnGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputLength.getText().toString().equals("")) {
                    return;
                }
                array = generateNumber(Integer.parseInt(inputLength.getText().toString()));
                String res = "";
                for(int i = 0;i < array.size();i++) {
                    res += array.get(i).toString() + " ";
                }
                txtArray.setText(res);
            }
        });

        btnShowSquareNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String res = "";
                for(int i = 0;i < array.size();i++) {
                    int temp = (int) Math.sqrt(array.get(i));
                    if(temp * temp == array.get(i)) {
                        res += array.get(i).toString() + " ";
                    }
                }
                Toast.makeText(Bai4Activity.this,"Square Numbers: " + res,Toast.LENGTH_LONG).show();
            }
        });
    }

    private ArrayList<Integer> generateNumber(int len) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for(int i = 0;i < len;i++) {
            Random random = new Random();
            int number = random.nextInt(100);
            numbers.add(number);
        }
        return numbers;
    }
}