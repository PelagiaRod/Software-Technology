package gr.aueb.sweng22.team07;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;


public class FlowActivity extends AppCompatActivity {

    // actionbar
    private ActionBar actionBar;

    // UI Views
    private ViewPager viewPager;

    private ArrayList<MyModel> modelArrayList;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

        System.out.println("ACTIVITY FLOW CREATED SUCCESSFULLY.");

        ArticleSubmission articleSubmission = new ArticleSubmission();

        // init actionbar
        actionBar = getSupportActionBar();

        // init UI views
        viewPager = findViewById(R.id.viewPager);
        loadCards();

        //set viewpager change listerner
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                // just change the tilte of actionbar
                String title = modelArrayList.get(position).getTitle();
                actionBar.setTitle(title);
            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void loadCards() {
        //init list
        modelArrayList = new ArrayList<>();
        int counter = 0;

        if (ArticleSubmission.getAllArticles() != null) {
            for (Article article: ArticleSubmission.getAllArticles()) {
                if (article.getState() == Article.status.APPROVED) {
                    String tmpTitle = article.getTitle();
                    String tmpDesc = article.getUrl();
                    String tmpDate = article.getRealDatePublished().toString();
                    if (counter % 2 == 0) {
                        modelArrayList.add(new MyModel(
                                tmpTitle,
                                tmpDesc,
                                tmpDate,
                                R.drawable.news1));
                        counter++;
                    } else {
                        modelArrayList.add(new MyModel(
                                tmpTitle,
                                tmpDesc,
                                tmpDate,
                                R.drawable.news2));
                        counter++;
                    }
                }
            }
        }

        //add items to list
        modelArrayList.add(new MyModel(
                "Mykonos Island",
                "https://mykonos.gr/",
                "03/06/2022",
                R.drawable.island));
        modelArrayList.add(new MyModel(
                "Ministry of Defence",
                "https://www.mod.mil.gr",
                "15/02/2022",
                R.drawable.soldier));
        modelArrayList.add(new MyModel(
                "GreenArmedForces",
                "https://www.greenarmedforces.mil.gr/simantikes-perivallontikes-draseis-me-to-koinofeles-idryma-athanasios-k-laskaridis/",
                "10/02/2022",
                R.drawable.header3));
        modelArrayList.add(new MyModel(
                "Book Zakynthos",
                "https://www.greeka.com/ionian/zakynthos/",
                "01/08/2021",
                R.drawable.header2));


        //setup adapter
        myAdapter = new MyAdapter(this, modelArrayList);
        //set adapter to view pager
        viewPager.setAdapter(myAdapter);
        //set default padding
        viewPager.setPadding(100,0,100,0);
    }


}