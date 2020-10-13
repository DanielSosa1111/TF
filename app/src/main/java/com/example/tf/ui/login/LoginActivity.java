package com.example.tf.ui.login;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.tf.R;

public class LoginActivity extends AppCompatActivity {

    private EditText correo, password;
    private Button btnIngresar;
    private LoginActivityViewModel vm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login);

        correo=(EditText)findViewById(R.id.etCorreo);
        password=(EditText)findViewById(R.id.etPassword);
        btnIngresar=findViewById(R.id.btIngresar);



        vm=new ViewModelProvider(this).get(LoginActivityViewModel.class);

        vm.getBtIngresar().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String aBoolean) {
                Toast.makeText(getApplicationContext(),aBoolean+"",Toast.LENGTH_SHORT).show();
            }
        });



        btnIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vm.ingresar(correo.getText().toString(), password.getText().toString());
                correo.setText("");
                password.setText("");
            }
        });


    }
}