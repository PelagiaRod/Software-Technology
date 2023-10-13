package gr.aueb.sweng22.team07;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

public class UserTest {

    String username = "mpla";
    String password = "123456";
    String firstname = "MPLA";
    String lastname = "MPLA_SUR";
    String email = "mpla@gmail.com";
    String telephone = "090 626262";

    User user;

    @Before
    public void init(){
        user = new User(username, password, firstname, lastname, telephone, email);
    }

    @Test(expected = IllegalArgumentException.class)
    public void user_constructor() {
        new User(username, password, firstname, lastname, "6988457", "mplagmail");
    }
}
