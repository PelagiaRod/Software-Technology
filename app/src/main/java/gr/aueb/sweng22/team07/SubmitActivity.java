package gr.aueb.sweng22.team07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class SubmitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        System.out.println("ACTIVITY SUBMIT CREATED SUCCESSFULLY.");

        ArticleSubmission articleSubmission = new ArticleSubmission();

        EditText url = (EditText)findViewById(R.id.url);
        EditText title = (EditText)findViewById(R.id.title);

        Button submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String tmpUrl = url.getText().toString();
                String tmpTitle = title.getText().toString();

                try {
                    articleSubmission.submission(tmpTitle, tmpUrl, new User("dummyUser","dummyPass"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Intent myIntent = new Intent(view.getContext(), UserActivity.class);
                startActivity(myIntent);
            }
        });

    }
}