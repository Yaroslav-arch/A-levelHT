package ua.Lysenko.HW30;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
        JsonDownloader jsonDownloader = new JsonDownloader();
        LaureatesList laureateList = jsonDownloader.getLaureateList();
        System.out.println(laureateList.getLaureates());
//        ChronoLocalDate empty = new ChronoLocalDate();
//        empty.setYear(0000);
//        laureateList.getLaureates().stream().filter((l) -> l.getBorn().isEqual(empty))

    }
}
