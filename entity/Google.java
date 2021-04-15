package tech.codingclub.helix.entity;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Scanner;

public class Google {
   public String alphabet;

    public Google() {
    }

    public Google(String alphabet) {
        this.alphabet = alphabet;
    }

    public String[] getSuggestions() throws Exception {
        String url = "https://en.wikipedia.org/w/api.php?action=query&format=json&generator=prefixsearch&prop=pageprops%7Cpageimages%7Cdescription&redirects=&ppprop=displaytitle&piprop=thumbnail&pithumbsize=80&pilimit=6&gpssearch=how%20to%20" + this.alphabet + "&gpsnamespace=0&gpslimit=6";

        int k = 0;
        String getHTML = HttpURLConnectionExample.sendGet(url);
        String[] str1 = getHTML.split("\"title\":\"");
        String[] arr = new String[str1.length];
        for (String s : str1) {
            String s2 = s.split("\"")[0];
            arr[k++] = s2;
        }
        String[] arr2 = new String[k - 1];
        k = 0;
        for (int i = 1; i < arr.length; i++) {
            arr2[k++] = arr[i];
        }
       return arr2;
    }

}
