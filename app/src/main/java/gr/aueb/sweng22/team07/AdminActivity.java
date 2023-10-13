package gr.aueb.sweng22.team07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        System.out.println("ACTIVITY ADMIN CREATED SUCCESSFULLY.");

        ImageButton flow = (ImageButton) findViewById(R.id.flowButton);
        flow.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), FlowActivity.class);
                startActivity(myIntent);
            }
        });

        Button approve = (Button) findViewById(R.id.approveButton);
        approve.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), ApproveActivity.class);
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