package test;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class NASAProviderTest {
    private final static int ELEMENT_COUNT = 82;

    @Test
    void checkConnection() {

        String readResult = readXMLFile();

        String[] splitKeyValue = readResult.split("<apikey>|</apikey>");
        String accessKey = splitKeyValue[1];
        String endpointURL = Arrays.asList(readResult.split("<endpoint>|</endpoint>")).get(1);

        String urlData = readURLAddress(endpointURL, accessKey);

        JSONObject data = new JSONObject(urlData);
        int count = data.getInt("element_count");
        assertFalse(count != ELEMENT_COUNT, "File data mismatch");
    }

    private static String readXMLFile() {
        File file = new File("src\\main\\resources\\test.xml");
        Scanner fileIn = null;
        try {
            fileIn = new Scanner(file);
        } catch (FileNotFoundException e) {
            fail("XML file not found");
        }
        String readResult = "";
        while (fileIn.hasNextLine()) {
            readResult += fileIn.nextLine();
        }
        return readResult;
    }

    private static String readURLAddress(String endpointURL, String accessKey) {
        URL oracle = null;
        try {
            oracle = new URL(endpointURL + accessKey);
        } catch (MalformedURLException e) {
            fail("No internet connection or wrong URL address");
        }
        BufferedReader in;
        String data = "";
        try {
            in = new BufferedReader(new InputStreamReader(oracle.openStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                data += inputLine;
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}

