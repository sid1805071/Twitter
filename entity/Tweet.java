package tech.codingclub.helix.entity;

public class Tweet {
    public String message;
    public Long created_at;
    public Long id;
    public Long author_id;

    public Tweet() {
    }

    public Tweet(String message, Long created_at, Long id, Long author_id) {
        this.message = message;
        this.created_at = created_at;
        this.id = id;
        this.author_id = author_id;
    }
}
