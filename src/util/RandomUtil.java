package util;

import java.util.*;

public final class RandomUtil {

    public static Set<Integer> getRandomNumbersInRange(int size, int start, int end){
        //List<Integer> randomNumbers = new ArrayList<>();
        Set<Integer> uniqueRandomNumbers = new HashSet<>();
        Random random = new Random();
        while (uniqueRandomNumbers.size() < size){
            uniqueRandomNumbers.add(random.nextInt(end - start) + start);
        }

//        for(int i = 0; i < size; i++){
//            randomNumbers.add(random.nextInt(end - start) + start);
//        }
//        return randomNumbers;

        return uniqueRandomNumbers;


    }
}
