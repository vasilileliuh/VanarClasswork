package test;

import config.XMLConfigurationProvider;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.*;

public class NASAProviderTest {
    @Test
    void testConnection() throws Exception {
        String accessKey = XMLConfigurationProvider.getValue("key", "nasa.xml");
        String endpointURL = XMLConfigurationProvider.getValue("url", "nasa.xml");
        testURL(endpointURL + accessKey);
    }

    public void testURL(String endpointURL) throws Exception {
        try {
            URL url = new URL(endpointURL);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();

            assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());
        } catch (IOException e) {
            System.err.println("Error creating HTTP connection");
            e.printStackTrace();
            throw e;
        }
    }
}

