package tech.codingclub.helix.entity;

public class WikiResult {


    String query;
    String text_result;
    String image_Url;

    public WikiResult()
    {

    }
    public WikiResult(String query, String text_result, String image_Url) {
        this.query = query;
        this.text_result = text_result;
        this.image_Url = image_Url;
    }

    public String getQuery() {
        return query;
    }

    public String getText_result() {
        return text_result;
    }

    public String getImage_Url() {
        return image_Url;
    }


}
