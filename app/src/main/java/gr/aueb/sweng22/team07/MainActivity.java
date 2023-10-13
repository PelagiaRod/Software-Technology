package gr.aueb.sweng22.team07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import android.content.Context;



public class MainActivity extends AppCompatActivity {

    Admin admin = new Admin("admin", "admin", "admin", "admin", "6988457310", "admin@gmail.com");
    Authentication auth = new Authentication();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        System.out.println("ACTIVITY MAIN CREATED SUCCESSFULLY.");

        auth.signUp(admin);

        TextView myTextView = (TextView)findViewById(R.id.bestRating);

        if (Authentication.getAllUsers() != null && ArticleSubmission.getAllArticles() != null) {
            int bestRatiing = 0;
            User tmpUser = null;
            for (User user: Authentication.getAllUsers()) {
                if (user.getRating() >= bestRatiing) {
                    bestRatiing = user.getRating();
                    tmpUser = user;
                }
            }
            myTextView.setText(tmpUser.getUsername() + " has " + bestRatiing + " rating. The best yet!");
        } else {
            myTextView.setText("No best ratings yet!");
        }

        Button login = (Button) findViewById(R.id.logInBtn);
        login.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), LoginActivity.class);
                startActivity(myIntent);
            }

        });

        Button signup = (Button) findViewById(R.id.signUpBtn);
        signup.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SignUpActivity.class);
                startActivity(myIntent);
            }

        });

        ImageButton flow = (ImageButton) findViewById(R.id.flowButton);
        flow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FlowActivity.class);
                startActivity(myIntent);
            }

        });


    }

}
