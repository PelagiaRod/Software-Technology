package gr.aueb.sweng22.team07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class UserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        System.out.println("ACTIVITY USER CREATED SUCCESSFULLY.");

        ImageButton flow = (ImageButton) findViewById(R.id.flowButton);
        flow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FlowActivity.class);
                startActivity(myIntent);
            }
        });

        Button submit = (Button) findViewById(R.id.submitButton);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), SubmitActivity.class);
                startActivity(myIntent);
            }
        });

        ImageButton logout = (ImageButton) findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), MainActivity.class);
                startActivity(myIntent);
            }
        });

    }
}