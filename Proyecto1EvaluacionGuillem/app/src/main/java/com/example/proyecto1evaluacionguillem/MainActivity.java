package com.example.proyecto1evaluacionguillem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button login;
    TextView forgot;
    EditText usuario;
    EditText pass;
    Switch cambio;
    TextInputLayout inputEmail;
    TextInputLayout inputPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login = findViewById(R.id.login);
        forgot = findViewById(R.id.forgot);
        usuario = findViewById(R.id.nombreUsuario);
        pass = findViewById(R.id.password);
        cambio = findViewById(R.id.switch1);
        inputEmail = findViewById(R.id.imputEmail);
        inputPass = findViewById(R.id.imputPass);

        login.setOnClickListener(this);
        cambio.setOnClickListener(this);
        forgot.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        inputPass.setHelperText(null);
        inputEmail.setError(null);
        switch (view.getId()){

            case R.id.login:

                provaContra(view);
                break;

            case R.id.forgot:
                inputPass.setHelperText("1234");
                inputPass.setHelperTextColor(ColorStateList.valueOf(getResources().getColor(R.color.blanco)));
                break;
            case R.id.switch1:
                if (cambio.isChecked()){

                    pass.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }else{
                    pass.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
        }





    }

    private void provaContra(View view) {
        if (view.getId()== login.getId()){

            if (!Patterns.EMAIL_ADDRESS.matcher(usuario.getText().toString()).matches()){
                inputEmail.setError("Correo invalido!");

            }else{
                inputEmail.setError(null);
            }
        }
    }
}
