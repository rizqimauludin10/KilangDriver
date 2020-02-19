package com.rizqimauludin.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button login = findViewById(R.id.login_button);
        Button register = findViewById(R.id.register_button);

        login.setOnClickListener(v->{
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                    LoginActivity.this, R.style.BottomSheetDialogTheme
            );

            View bottomsheet_login = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.bottomsheet_login, findViewById(R.id.bottomsheet_login));

            bottomsheet_login.findViewById(R.id.closeLogin).setOnClickListener(v1 -> {
                bottomSheetDialog.dismiss();
            });

            bottomSheetDialog.setCanceledOnTouchOutside(false);
            bottomSheetDialog.setContentView(bottomsheet_login);
            bottomSheetDialog.show();
        });

        register.setOnClickListener(v -> {
            BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(
                    LoginActivity.this, R.style.BottomSheetDialogTheme
            );

            View bottomsheet_register = LayoutInflater.from(getApplicationContext())
                    .inflate(R.layout.bottomsheet_register, findViewById(R.id.bottomsheet_register));

            bottomsheet_register.findViewById(R.id.closeRegister).setOnClickListener(v1 -> {
                bottomSheetDialog.dismiss();
            });

            bottomSheetDialog.setCanceledOnTouchOutside(false);
            bottomSheetDialog.setContentView(bottomsheet_register);
            bottomSheetDialog.show();
        });
    }
}
