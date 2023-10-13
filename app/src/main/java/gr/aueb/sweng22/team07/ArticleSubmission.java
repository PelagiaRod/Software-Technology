package gr.aueb.sweng22.team07;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;

public class ArticleSubmission {

    static ArrayList<Article> allArticles;
    static ArrayList<Article> approvedArticles; //timeLine
    private Article articleInDatabase;

    // submit an article
    public boolean submission(String title, String url, User userWhoSubmit) throws IOException {
        Article newArticle = new Article(title, url, userWhoSubmit);
        userWhoSubmit.setRating(1);

        if (this.allArticlesEmpty()) {
            allArticles = new ArrayList<>();
            allArticles.add(newArticle);
            return true;
        } else {
            if (validateArticle(newArticle)) {
                return false;
            } else {
                allArticles.add(newArticle);
                return true;
            }
        }
    }

    // approve an article
    public boolean articleApprove(Article articleToApprove) {
        if (this.validateArticle(articleToApprove)) {
            allArticles.remove(this.articleInDatabase);
            this.articleInDatabase.setState(Article.status.APPROVED);
            if (approvedArticlesEmpty()) {
                approvedArticles = new ArrayList<>();
                approvedArticles.add(this.articleInDatabase);
                return true;
            } else {
                approvedArticles.add(this.articleInDatabase);
                return true;
            }
        } else {
            return false;
        }
    }

    // decline an article
    public boolean articleDecline(Article articleToDecline) {
        if (this.validateArticle(articleToDecline)) {
            allArticles.remove(this.articleInDatabase);
            return true;
        } else {
            return false;
        }
    }

    // check if allArticles is empty
    private boolean allArticlesEmpty() {
        return allArticles == null;
    }

    // check if approvedArticles is empty
    private boolean approvedArticlesEmpty() {
        return approvedArticles == null;
    }

    // search given user
    private boolean validateArticle(Article articleToSearch) {
        for (Article article: allArticles){
            if (articleToSearch.getUrl().equals(article.getUrl())) {
                this.articleInDatabase = article;
                return true;
            }
        }
        return false;
    }

    // getters
    public static ArrayList<Article> getAllArticles() {
        return allArticles;
    }

    public static ArrayList<Article> getApprovedArticles() {
        return approvedArticles;
    }
}
