package providers;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class NASADataProvider {
    private final static String ACCESS_KEY = "O07j4jScumz9is0SsljvW1ORhEQ8l4W4RN9o6zca";
    private final static String NEO_ENDPOINT = "https://api.nasa.gov/neo/rest/v1/feed";
    private static String startDate = "2020-03-01";
    private static String endDate = "2020-03-07";

    public void getNeoAsteroids(String startDate, String endDate) throws IOException {
// 1. connect to nasa API
        URL oracle = new URL(NEO_ENDPOINT + "?start_date=" + startDate + "&end_date=" + endDate + "&api_key=" + ACCESS_KEY);
        BufferedReader in = new BufferedReader(
                new InputStreamReader(oracle.openStream()));
// 2. read data
        String stringData = "";
        String inputLine;
        while ((inputLine = in.readLine()) != null)
//            System.out.println(inputLine.replace("}", "}\n"));
            stringData += inputLine;
        in.close();
        // 3. parse JSON
        JSONObject data = new JSONObject(stringData);
        int count = data.getInt("element_count");
        System.out.println("Found " + count + " results.");

        float diameter = data.getJSONObject("near_earth_objects")
                .getJSONArray("2020-03-07")
                .getJSONObject(0)
                .getJSONObject("estimated_diameter")
                .getJSONObject("kilometers")
                .getFloat("estimated_diameter_min");
        System.out.println("Diameter in km " + diameter);

    }


// 4. test some data


}



