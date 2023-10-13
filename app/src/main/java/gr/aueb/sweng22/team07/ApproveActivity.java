package gr.aueb.sweng22.team07;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class ApproveActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        System.out.println("ACTIVITY APPROVE CREATED SUCCESSFULLY.");

        Article tmpArticle = null;
        String tmpText = "Nothing to approve!";
        boolean flag = false;
        if (ArticleSubmission.getAllArticles() != null) {
            for (Article article: ArticleSubmission.getAllArticles()) {
                if (article.getState() == Article.status.PENDING) {
                    tmpArticle = article;
                    tmpText = article.getTitle();
                    flag = true;
                    break;
                }
            }
        }

        if (flag) {

            setContentView(R.layout.activity_approve);

            TextView myTextView = (TextView)findViewById(R.id.article);
            myTextView.setText(tmpText);

            Button approve = (Button) findViewById(R.id.approveButton);
            Article finalTmpArticle = tmpArticle;

            approve.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    finalTmpArticle.setState(Article.status.APPROVED);
                    Intent myIntent = new Intent(view.getContext(), ApproveActivity.class);
                    startActivity(myIntent);
                }
            });

            Button deny = (Button) findViewById(R.id.denyButton);
            deny.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    finalTmpArticle.setState(Article.status.DECLINED);
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

        } else {
            Intent myIntent = new Intent(ApproveActivity.this, AdminActivity.class);
            Toast.makeText(ApproveActivity.this, "Nothing to approve", Toast.LENGTH_SHORT).show();
            startActivity(myIntent);
        }

    }
}