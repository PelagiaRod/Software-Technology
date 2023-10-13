package gr.aueb.sweng22.team07;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.io.IOException;


public class ArticleSubmissionTest {

    String username = "mpla";
    String password = "123456";
    String firstname = "MPLA";
    String lastname = "MPLA_SUR";
    String email = "mpla@gmail.com";
    String telephone = "090 626262";
    User user = new User(username, password, firstname, lastname, telephone, email);

    String url = "https://government.gov.gr/meso-gov-gr-katangelies-sti-dioxi-ilektronikou-egklimatos/";
    String title = "Μέσω gov.gr οι καταγγελίες στη Δίωξη Ηλεκτρονικού Εγκλήματος";

    Article article = new Article(title ,url ,user);

    ArticleSubmission articleSubmission;

    @Before
    public void init(){
        articleSubmission = new ArticleSubmission();
    }

    @Before
    public void submisssion_test() throws IOException {
        articleSubmission = new ArticleSubmission();
        articleSubmission.submission(title,url,user);
    }

    @Test
    public void articleApprove_test() {
        articleSubmission.articleApprove(article);
    }

    @Test
    public void articleDecline_test() {
        articleSubmission.articleDecline(article);
    }
}
