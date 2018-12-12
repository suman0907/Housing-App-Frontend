package com.example.sumansinghrajput.dreamtreasure;
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
 * Created by Suman Singh Rajput on 17-04-2018.
 */

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    CardView sigup;
    TextView sign;
    EditText name;
    EditText emal;
    EditText passwrd;
    EditText mbl;
    Button regr;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup);
        sigup = (CardView) findViewById(R.id.sigup);
        sign = (TextView) findViewById(R.id.sign);
        name = (EditText) findViewById(R.id.name);
        emal = (EditText) findViewById(R.id.emal);
        passwrd = (EditText) findViewById(R.id.passwrd);
        mbl = (EditText) findViewById(R.id.mbl);
        regr = (Button) findViewById(R.id.regr);
        regr.setOnClickListener(this);
        mAuth= FirebaseAuth.getInstance();
    }

    @Override
    public void onClick(View v) {

        if (name != null && !name.getText().toString().equals("")) {


        }
        else {
            Toast.makeText(this, "Enter name", Toast.LENGTH_SHORT).show();
            return;
        }
        if (emal != null && !emal.getText().toString().equals("")) {


        }
        else  {
            Toast.makeText(this, "Enter email Id", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passwrd != null && !passwrd.getText().toString().equals("")) {

        } else {
            Toast.makeText(this, "Enter password", Toast.LENGTH_SHORT).show();
            return;
        }

        if (mbl != null && !mbl.getText().toString().equals("")) {

        } else {
            Toast.makeText(this, "Enter mobile number", Toast.LENGTH_SHORT).show();
            return;
        }


        mAuth.createUserWithEmailAndPassword(emal.getText().toString(), passwrd.getText().toString())
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {


                            Toast.makeText(getBaseContext(), "SignUp successfully",
                                    Toast.LENGTH_SHORT).show();

                            FirebaseUser user = mAuth.getCurrentUser();
                            user.sendEmailVerification()
                                    .addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if (task.isSuccessful()) {
                                                Toast.makeText(getBaseContext(), "Email Sent",
                                                        Toast.LENGTH_SHORT).show();
                                            }
                                        }
                                    });




                        } else {
                            Toast.makeText(getBaseContext(), "SignUp failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                });


    }
}
