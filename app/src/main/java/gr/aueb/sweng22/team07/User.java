package gr.aueb.sweng22.team07;

public class User {

    final private String username;
    final private int password;
    final private String firstName;
    final private String lastName;
    final private String telephone;
    final private String email;
    private int rating = 0;

    // Constructor
    public User(String username, String password, String firstName, String lastName, String telephone, String email) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.username = username;

        if (password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.password = password.hashCode();

        if (firstName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.firstName = firstName;

        if (lastName.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.lastName = lastName;

        if (telephone.length() != 10) {
            throw new IllegalArgumentException();
        }
        this.telephone = telephone;

        if (email.isEmpty() || !email.contains("@")) {
            throw new IllegalArgumentException();
        }
        this.email = email;
    }

    public User(String username, String password) {
        if (username.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.username = username;

        if (password.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.password = password.hashCode();
        this.firstName = "";
        this.lastName = "";
        this.telephone = "";
        this.email = "";
    }


    // setters
    public void setRating(int rating) {
        this.rating += rating;
    }

    // getters
    public String getUsername() {
        return this.username;
    }

    public int getPassword() {
        return this.password;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getEmail() {
        return this.email;
    }

    public int getRating() {
        return this.rating;
    }
}
