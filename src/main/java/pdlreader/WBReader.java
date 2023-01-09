package pdlreader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class WBReader {
    public String parse(String url) throws IOException {
        List links = new ArrayList();
        Document doc = Jsoup.connect(url).userAgent("Chrome").get();
        Elements newsHeadlines = doc.getElementsByAttribute("title");
        System.out.println(url);
        String newUrl1 = String.valueOf(url.charAt(42)).toUpperCase(Locale.ROOT);
        String newUrl2 = String.valueOf(url.charAt(43)).toUpperCase(Locale.ROOT);
        String newUrl = newUrl1 + newUrl2;
        for (Element headline : newsHeadlines) {
            if (headline.absUrl("title").endsWith(newUrl)){
                links.add(headline.absUrl("title"));
            }
        }
        if (links.size() == 0){
            System.out.println("Opps, there aren't any appartments in " + newUrl);
            return null ;
        }
        else {System.out.println(links.toString());
        return links.toString();}
    }

}
