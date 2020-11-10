package com.example.telalogin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btLogin = (Button) findViewById(R.id.buttonLogin);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tLogin = (TextView) findViewById(R.id.tUser);
                TextView tSenha = (TextView) findViewById(R.id.tPassword);
                String login = tLogin.getText().toString();
                String senha = tSenha.getText().toString();

                if(login.equals("Ezio")&&senha.equals("8426")){
                    alert("login realizado com sucesso");
                } else {
                    alert("Login ou senha incorreto, tente novamente");
                }
            }
        });
}
    private void alert (String s) {
        Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}