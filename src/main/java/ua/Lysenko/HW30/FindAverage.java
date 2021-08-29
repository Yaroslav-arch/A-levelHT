package ua.Lysenko.HW30;

import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class FindAverage extends RecursiveTask<BigInteger> {
    private static final long serialVersionUID = 1L;
    private final static int THRESHOLD = 100;

    private List<BigInteger> ageList;

    public FindAverage(List<BigInteger> nums) {
        this.ageList = nums;
    }

    @Override
    protected BigInteger compute() {
        var size = ageList.size();
        if (size < THRESHOLD) {
            return sequentialSum(ageList);
        } else {
            var x = new FindAverage(ageList.subList(0, size / 2));
            var y = new FindAverage(ageList.subList(size / 2, size));
            x.fork();
            y.fork();
            var xResult = x.join();
            var yResult = y.join();
            return yResult.add(xResult);
        }
    }

    public static BigInteger sequentialSum(List<BigInteger> ageList) {
        var acc = BigInteger.ZERO;
        for (var value : ageList) {
            acc = acc.add(value);
        }
        return acc;
    }

    static void getHot(Runnable runnable) {
        runnable.run();
    }

    static void dummyBenchmark(Runnable runnable) {
        var before = System.currentTimeMillis();
        runnable.run();
        var after = System.currentTimeMillis();
        System.out.println("Executed in: " + (after - before));
        System.out.println("######\n");
    }
}
