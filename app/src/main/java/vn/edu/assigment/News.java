package vn.edu.assigment;

public class News {
    String title;
    String description;
    String pubDate;
    String image;
    String link;

    public News(String title, String description, String pubDate, String image, String link) {
        this.title = title;
        this.description = description;
        this.pubDate = pubDate;
        this.image = image;
        this.link= link;
    }

    public News() {
    }
}
