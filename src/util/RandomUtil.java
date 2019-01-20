package util;

import java.util.*;

public final class RandomUtil {

    public static Set<Integer> getSetOfRandomNumbersInRange(int size, int min, int max){
        //List<Integer> randomNumbers = new ArrayList<>();
        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Set<Integer> uniqueRandomNumbers = new HashSet<>();
        Random random = new Random();
        while (uniqueRandomNumbers.size() < size){
            uniqueRandomNumbers.add(random.nextInt(max - min) + min);
        }

//        for(int i = 0; i < size; i++){
//            randomNumbers.add(random.nextInt(max - min) + min);
//        }
//        return randomNumbers;

        return uniqueRandomNumbers;
    }

    public static int getRandomNumberInRange(int min, int max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

    public static double getRandomNumberInRange(double min, double max) {

        if (min > max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return min + (max - min) * r.nextDouble();
    }



}
