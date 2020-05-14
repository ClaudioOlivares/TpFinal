package com.example.tpfinal;

import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import androidx.lifecycle.ViewModel;

public class LoginViewModel extends ViewModel  {

public void validar(EditText email, EditText pass, Intent i, Context ct)
{
      if(email.getText().toString().equals("123@gmail.com") && pass.getText().toString().equals("123"))
      {
            ct.startActivity(i);
      }
      else
      {
            Toast.makeText(ct, "Datos Incorrectos", Toast.LENGTH_LONG).show();
      }
}
}

