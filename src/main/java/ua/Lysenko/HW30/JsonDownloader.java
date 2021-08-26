package ua.Lysenko.HW30;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonDownloader {

    public LaureatesList getLaureateList() throws URISyntaxException, IOException, InterruptedException {
//        LaureatesList laureatesList = new LaureatesList();

        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://api.nobelprize.org/v1/laureate.json")).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        ObjectMapper mapper = new ObjectMapper()

                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        return mapper.readValue(body, LaureatesList.class);
//            mapper.readValue("https://api.nobelprize.org/v1/laureate.json",)

    }
}
