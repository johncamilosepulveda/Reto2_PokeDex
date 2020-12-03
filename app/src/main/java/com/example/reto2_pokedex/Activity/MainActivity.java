package com.example.reto2_pokedex.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.reto2_pokedex.R;

import control.MainController;

public class MainActivity extends AppCompatActivity {

    private Button loginBtn;
    private EditText userNameTextPlain;
    private MainController mainController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginBtn = findViewById(R.id.buttonIngresar);
        userNameTextPlain = findViewById(R.id.editTextUsername);

        mainController = new MainController(this);
    }

    public Button getLoginBtn() {
        return loginBtn;
    }

    public void setLoginBtn(Button loginBtn) {
        this.loginBtn = loginBtn;
    }

    public EditText getUserNameTextPlain() {
        return userNameTextPlain;
    }

    public void setUserNameTextPlain(EditText userNameTextPlain) {
        this.userNameTextPlain = userNameTextPlain;
    }
}