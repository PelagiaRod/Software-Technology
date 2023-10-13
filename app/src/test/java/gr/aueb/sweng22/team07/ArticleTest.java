package gr.aueb.sweng22.team07;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class ArticleTest {

    String username = "mpla";
    String password = "123456";
    String firstname = "MPLA";
    String lastname = "MPLA_SUR";
    String email = "mpla@gmail.com";
    String telephone = "090 626262";

    String url = "https://government.gov.gr/meso-gov-gr-katangelies-sti-dioxi-ilektronikou-egklimatos/";
    String title = "Μέσω gov.gr οι καταγγελίες στη Δίωξη Ηλεκτρονικού Εγκλήματος";

    User user = new User(username, password, firstname, lastname, telephone, email);

    Article article;

    @Before
    public void init(){
        article = new Article(title, url, user);
    }

    @Test(expected = IllegalArgumentException.class)
    public void article_constructor() {
        new Article("", "", null);
    }

}
