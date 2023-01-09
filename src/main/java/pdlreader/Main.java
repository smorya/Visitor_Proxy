package pdlreader;

import org.json.JSONObject;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException {
        CachedReader parser = new CachedReader();
        parser.parse("https://www.newhomesource.com/communities/nm/las-cruces-area/las-cruces");
        String result = parser.parse("https://www.newhomesource.com/communities/wa/seattle-bellevue-area/king-county");
        parser.parse("https://www.newhomesource.com/communities/nm/las-cruces-area/las-cruces");
        parser.parse("https://www.newhomesource.com/communities/ks/topeka-area/manhattan");

    }
}
