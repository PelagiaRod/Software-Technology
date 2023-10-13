package gr.aueb.sweng22.team07;

import org.junit.Assert;
import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;


public class AuthenticationTest {

    String username = "mpla";
    String password = "123456";
    String firstname = "MPLA";
    String lastname = "MPLA_SUR";
    String email = "mpla@gmail.com";
    String telephone = "090 626262";
    User user = new User(username, password, firstname, lastname, telephone, email);

    Authentication authentication;

    @Before
    public void init(){
        authentication = new Authentication();
    }

    @Before
    public void signUp_test(){
        authentication.signUp(user);
    }

    @Test
    public void login_test(){
        authentication.logIn(user);
    }

}
