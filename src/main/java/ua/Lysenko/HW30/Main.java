package ua.Lysenko.HW30;

import ua.Lysenko.HW30.entity.LaureatesList;
import ua.Lysenko.HW30.utils.JsonDownloader;
import ua.Lysenko.HW30.utils.PersonFullfiller;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

import static ua.Lysenko.HW30.FindAverage.dummyBenchmark;

public class Main {
    public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException, ParseException {
        JsonDownloader jsonDownloader = new JsonDownloader();
        LaureatesList laureateList = jsonDownloader.getLaureateList();
        PersonFullfiller fullfiller = new PersonFullfiller();
        List<BigInteger> ageList = fullfiller.getAgeList(laureateList);

        Runnable parallel = () -> {
            var commonPool = ForkJoinPool.commonPool();
            var result = commonPool.invoke(new FindAverage(ageList)).divide(BigInteger.valueOf(ageList.size()));

            System.out.println("Parallel Result is: " + result);
        };

        Runnable sequential = () -> {
            var acc = FindAverage.sequentialSum(ageList).divide(BigInteger.valueOf(ageList.size()));

            System.out.println("Sequential Result is: " + acc);
        };

        sequential.run();
        parallel.run();

        Thread.sleep(2000);

        System.out.println("#### After some JIT \n\n");

        dummyBenchmark(sequential);
        dummyBenchmark(parallel);

        Thread.sleep(2000);

        System.out.println("#### After more JIT \n\n");

        dummyBenchmark(sequential);
        dummyBenchmark(parallel);
    }


}
