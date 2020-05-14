package com.example.tpfinal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
private EditText etEmail;
private EditText etPassword;
private LoginViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_main);
        asignarValores();
        vm = ViewModelProviders.of(this).get(LoginViewModel.class);
    }

    private void asignarValores()
    {
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPass);

    }

    public void validar(View v)
    {

        Intent i = new Intent(this, MenuActivity.class);
        vm.validar(etEmail,etPassword,i,this);
    }
}
