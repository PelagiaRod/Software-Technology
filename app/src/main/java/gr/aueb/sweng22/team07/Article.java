package gr.aueb.sweng22.team07;

import java.time.LocalDateTime;

public class Article {

    enum status {
        APPROVED, DECLINED, PENDING
    }
    final private String title;
    final private String url;
    final private User userSubmited;
    final private LocalDateTime realDatePublished;
    private status state;

    // Constructor
    public Article(String title, String url, User userSubmited) {
        this.title = title;
        this.url = url;

        if (userSubmited==null) {
            throw new IllegalArgumentException();
        }
        this.userSubmited = userSubmited;

        this.realDatePublished = LocalDateTime.now();
        this.state = status.PENDING;
    }

    // getters
    public String getTitle() {
        return this.title;
    }

    public String getUrl() {
        return this.url;
    }

    public User getUserSubmited() {
        return this.userSubmited;
    }

    public LocalDateTime getRealDatePublished() {
        return this.realDatePublished;
    }

    public status getState() {
        return this.state;
    }


    // setters
    public void setState(status state) {
        this.state = state;
    }
}
