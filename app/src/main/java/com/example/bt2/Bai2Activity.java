package com.example.bt2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Bai2Activity extends AppCompatActivity {

    Button btnLogIn;
    EditText inputUserName;
    EditText inputPassword;
    TextView txtNotification;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bai2);

        inputUserName = (EditText) findViewById(R.id.inputUserName);
        inputPassword = (EditText) findViewById(R.id.inputPassword);
        txtNotification = (TextView) findViewById(R.id.txtNotification);
        btnLogIn = (Button) findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputUserName.getText().toString().equals("admin") && inputPassword.getText().toString().equals("admin")) {
                    txtNotification.setText("Đăng nhập thành công");
                }else{
                    txtNotification.setText("Đăng nhập thất bại");
                }
            }
        });
    }
}