package gr.aueb.sweng22.team07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        System.out.println("ACTIVITY LOG IN CREATED SUCCESSFULLY.");

        Authentication auth = new Authentication();

        EditText username = (EditText)findViewById(R.id.user);
        EditText password = (EditText)findViewById(R.id.pass);

        Button login = (Button) findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();
                User tmp_user = new User(user, pass);

                User check = auth.logIn(tmp_user);
                if (check == null) {
                    System.out.println(tmp_user + " did not log in because of wrong credentials.");
                    Toast.makeText(LoginActivity.this, "Wrong username or password!", Toast.LENGTH_SHORT).show();
                } else {
                    if (check.getUsername().equals("admin")) {
                        Intent myIntent = new Intent(view.getContext(), AdminActivity.class);
                        System.out.println(check + " is connected okk.");
                        startActivity(myIntent);
                    } else {
                        Intent myIntent = new Intent(view.getContext(), UserActivity.class);
                        System.out.println(check + " is connected okk.");
                        startActivity(myIntent);
                    }
                }
            }

        });

    }




}