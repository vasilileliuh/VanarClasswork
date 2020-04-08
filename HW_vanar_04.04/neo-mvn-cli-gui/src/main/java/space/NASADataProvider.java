package space;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class NASADataProvider {
    private final static String ACCESS_KEY = "O07j4jScumz9is0SsljvW1ORhEQ8l4W4RN9o6zca";
    private final static String NEO_ENDPOINT = "https://api.nasa.gov/neo/rest/v1/feed";
    private final static int ONE_MILLION = 1_000_000;
    private final static byte INDEX_ZERO = 0;

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
        final DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        final LocalDate startLocalDate = LocalDate.parse(startDate, dtf);
        final LocalDate endLocalDate = LocalDate.parse(endDate, dtf);

        Period period = Period.between(startLocalDate, endLocalDate);
        int diff = period.getDays();
        System.out.println("Period= " + (diff + 1) + " days");

        JSONObject data = new JSONObject(stringData);
        int count = data.getInt("element_count");
        System.out.println("Found " + count + " results.");

        List<Asteroid> asteroids = new ArrayList<>();
        LocalDate day = startLocalDate;
        for (int i = 0; i < diff + 1; i++) {
            int arrayLength = data.getJSONObject("near_earth_objects")
                    .getJSONArray(day.toString()).length();
            for (int j = 0; j < arrayLength; j++)
                asteroids.add(new Asteroid(day, getMissDistance(data, day, j), getDiameter(data, day, j), getIsHazardous(data, day, j)));
            day = day.plusDays(1);
        }
        printResult(asteroids);

    }

    private float getDiameter(JSONObject data, LocalDate date, int index) {
        return data.getJSONObject("near_earth_objects")
                .getJSONArray(date.toString())
                .getJSONObject(index)
                .getJSONObject("estimated_diameter")
                .getJSONObject("kilometers")
                .getFloat("estimated_diameter_min");
    }

    private boolean getIsHazardous(JSONObject data, LocalDate date, int index) {
        return data.getJSONObject("near_earth_objects")
                .getJSONArray(date.toString())
                .getJSONObject(index)
                .getBoolean("is_potentially_hazardous_asteroid");
    }

    private float getMissDistance(JSONObject data, LocalDate date, int index) {
        return data.getJSONObject("near_earth_objects")
                .getJSONArray(date.toString())
                .getJSONObject(index)
                .getJSONArray("close_approach_data")
                .getJSONObject(INDEX_ZERO)
                .getJSONObject("miss_distance")
                .getFloat("kilometers");
    }

    private void printResult(List<Asteroid> asteroids) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        for (Asteroid asteroid : asteroids) {
            System.out.printf("%s - %4.1fmln km from earth, %.2fkm diameter, %s%n",
                    asteroid.getDate().format(formatter),
                    asteroid.getDistance() / ONE_MILLION, asteroid.getDiameter(),
                    asteroid.getHazardous() ? "it is hazardous!" : "it's not hazardous!");
        }
    }
}




