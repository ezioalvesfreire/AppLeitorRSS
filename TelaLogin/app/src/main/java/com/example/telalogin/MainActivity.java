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


        Button buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {


            @Override
                public void alterarTexto(View view){
                   TextView tUser = (TextView) findViewById(R.id.tUser);
                   TextView tPassword = (TextView) findViewById(R.id.tPassword);
                   String login = tUser.getText().toString();
                   String senha = tPassword.getText().toString();

                    TextView texto = findViewById(R.id.tStatusLogin);
                    if(login.equals("Ezio")&&senha.equals("8426")){
                        texto.setText("Login efetuado com sucesso");
                    } else {
                        texto.setText("Usuario ou senha invalido");
                    }

                }


        });
}
    private void alert (String s) {
    Toast.makeText(this, s, Toast.LENGTH_LONG).show();

    }
}