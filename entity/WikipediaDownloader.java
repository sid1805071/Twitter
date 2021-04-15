package tech.codingclub.helix.entity;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class WikipediaDownloader {

    private String keyword;

    public WikipediaDownloader() {

    }

    public WikipediaDownloader(String keyword) {
        this.keyword = keyword;
    }

    public WikiResult getResult() {

        //1.get clean keyword !
        // 2.GEt url for wikipedia
        // 3. make a get request to wikipedia !
        // 4. parsing the useful result using jsoup
        // Showing the result !

        if (this.keyword == null || this.keyword.length() == 0) {
            return null;
        }

        // Step 1
        this.keyword = this.keyword.trim().replaceAll("[ ]+", "_");

        // STep 2

        String wikiUrl = getWikipediaForQuery(this.keyword);
        String response = "";
        String imgURl = "";

        try {

            // Step 3
            String wikipediaResponseHTML = HttpURLConnectionExample.sendGet(wikiUrl);

            // System.out.println(wikipediaResponseHTML);
            // Step 4

            Document document = Jsoup.parse(wikipediaResponseHTML, "https://en.wikipedia.org");
            Elements childElements = document.body().select(".mw-parser-output > *");

            int state = 0;
            for (Element childElement : childElements) {

                if (state == 0) {
                    if (childElement.tagName().equals("table")) {
                        state = 1;
                    }
                } else if (state == 1) {
                    if (childElement.tagName().equals("p")) {
                        state = 2;
                        response = childElement.text();
                        break;
                    }
                }
            }
            try {
                imgURl = document.body().select(".infobox img").get(0).attr("src");
            } catch (Exception ec) {
                ec.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        WikiResult wikiResult = new WikiResult(this.keyword, response, imgURl);

        return wikiResult;

    }

    private String getWikipediaForQuery(String cleanKeyword) {
        return "https://en.wikipedia.org/wiki/" + cleanKeyword;
    }


}

