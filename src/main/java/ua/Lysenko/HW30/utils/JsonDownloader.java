package ua.Lysenko.HW30.utils;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import ua.Lysenko.HW30.entity.LaureatesList;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JsonDownloader {

    public LaureatesList getLaureateList() throws URISyntaxException, IOException, InterruptedException {

        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://api.nobelprize.org/v1/laureate.json")).GET().build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();

        ObjectMapper mapper = JsonMapper.builder()
                .findAndAddModules()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .findAndAddModules()
                .build();

        return mapper.readValue(body, LaureatesList.class);

    }
}
