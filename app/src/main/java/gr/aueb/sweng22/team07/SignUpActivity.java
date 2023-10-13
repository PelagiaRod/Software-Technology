package gr.aueb.sweng22.team07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.Serializable;

public class SignUpActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        System.out.println("ACTIVITY SIGN UP CREATED SUCCESSFULLY.");

        Authentication auth = new Authentication();

        EditText username = (EditText)findViewById(R.id.user);
        EditText password = (EditText)findViewById(R.id.pass);
        EditText firstName = (EditText)findViewById(R.id.firstName);
        EditText lastName = (EditText)findViewById(R.id.lastName);
        //    EditText phone = (EditText)findViewById(R.id.editTextPhone);
        EditText email = (EditText)findViewById(R.id.email);


        Button signup = (Button) findViewById(R.id.signup);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                String f_name = firstName.getText().toString();
                String l_name = lastName.getText().toString();
                String e_mail = email.getText().toString();
                User new_user = new User(user,pass,f_name,l_name,"6988457310",e_mail);
                boolean check = auth.signUp(new_user);
                if (!check) {
                    System.out.println(new_user + " did not signed up because exists.");
                } else {
                    System.out.println(new_user + " signed up successfuully.");
                }
                System.out.println(Authentication.getAllUsers());

                Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
//                startActivityForResult(myIntent, 0);
                startActivity(myIntent);
            }

        });

    }
}