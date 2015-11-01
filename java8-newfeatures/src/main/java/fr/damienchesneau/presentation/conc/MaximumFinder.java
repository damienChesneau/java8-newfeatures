package fr.damienchesneau.presentation.conc;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 * @author Damien Chesneau - contact@damienchesneau.fr
 */
public class MaximumFinder extends RecursiveTask<Integer> {
    private static final int SEQUENTIAL_THRESHOLD = 5;
    private final int[] data;
    private final int start;
    private final int end;

    public MaximumFinder(int[] data, int start, int end) {
        this.data = data;
        this.start = start;
        this.end = end;
    }

    public MaximumFinder(int[] data) {
        this(data, 0, data.length);
    }

    @Override
    protected Integer compute() {
        final int length = end - start;
        if (length < SEQUENTIAL_THRESHOLD) {
            return computeDirectly();
        }
        final int split = length / 2;
        final MaximumFinder left = new MaximumFinder(data, start, start + split);
        left.fork();
        final MaximumFinder right = new MaximumFinder(data, start + split, end);
        return Math.max(right.compute(), left.join());
    }

    private Integer computeDirectly() {
        System.out.println(Thread.currentThread() + " ' computing: '" + start
                + "' to '" + end);
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Random e = new Random();
        final int[] data = e.ints(1_000_000).toArray();
        final ForkJoinPool pool = new ForkJoinPool(8);
        final MaximumFinder finder = new MaximumFinder(data);
        System.out.println(pool.invoke(finder) + " finded with " + pool.getPoolSize() + " Threads.");
    }
}
