package com.example.sumansinghrajput.dreamtreasure;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Suman Singh Rajput on 08-04-2018.
 */

public class Login extends AppCompatActivity implements View.OnClickListener {
    CardView login;
    TextView wel;
    EditText eml;
    EditText pas;
    Button log;
    TextView reg;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        login= (CardView) findViewById(R.id.login);
        wel=(TextView)findViewById(R.id.wel);
        eml=(EditText)findViewById(R.id.eml);
        pas=(EditText)findViewById(R.id.pas);
        log=(Button)findViewById(R.id.log);
        log.setOnClickListener(this);
        reg=(TextView)findViewById(R.id.reg);
        reg.setOnClickListener(this);
        mAuth= FirebaseAuth.getInstance();




    }
    @Override
    public void onClick(View v) {
        int id=v.getId();
        if(id==R.id.reg)
        {
            Intent intent = new Intent("android.intent.action.SIGN");
            startActivity(intent);
        }

        if (eml != null && !eml.getText().toString().equals("")) {


        }
        else  {
            Toast.makeText(this, "Enter email Id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (pas != null && !pas.getText().toString().equals("")) {

        } else {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }



        mAuth.signInWithEmailAndPassword(eml.getText().toString(), pas.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (!task.isSuccessful()) {
                            Toast.makeText(getBaseContext(), "Register first", Toast.LENGTH_SHORT).show();
                        } else {
                            FirebaseUser user = mAuth.getCurrentUser();
                            //String name = user.getEmail();
                            if(!user.isEmailVerified()) {
                                Toast.makeText(getBaseContext(), "Verify Your Email First", Toast.LENGTH_SHORT).show(); return;
                            }
                            Toast.makeText(getBaseContext(),"Successfully logged In",Toast.LENGTH_SHORT).show();



                        }

                    }
                });


    }
}
