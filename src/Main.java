import util.FileUtil;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        // TODO: Decide the following hyperparameters. They depend on data size but take any value for now
        final int NUM_OF_TREES = 3;
        final int SUBSAMPLING_SIZE = 5;

        System.out.println("Hello World!");
        System.out.println("Number of Trees :: " + NUM_OF_TREES);
        System.out.println("Sub-sampling size :: " + SUBSAMPLING_SIZE);

        String fileName = (args[0]);
        List<String> unformattedDataPoints = FileUtil.readFile(fileName);
        // check if there are more than 1 elems in 1st row
        //boolean validFile = (unformattedDataPoints.get(0).length() == 1) ? true : true;

        int topAnomalies = Integer.parseInt(unformattedDataPoints.get(0));
        System.out.println("topAnomalies are :: " + topAnomalies);
        // if this is a valid file, combine this line with the above statements
        unformattedDataPoints.remove(0);

//        for (String datapoint : unformattedDataPoints) {
//            System.out.println(datapoint);
//        }
//        for (String str : unformattedDataPoints){
//            System.out.println(str);
//        }

        List<List<Double>> formattedDataPoints = FileUtil.formatData(unformattedDataPoints);
        //System.out.println("Formatted Data Size is :: " + formattedDataPoints.size());

        // ----------------------------------------------------------------------------------


        // test cases here to handle where numTrees <= 0, nDimData = null
        // /home/mwang2/bin/nDdata.py
        // /home/<login>/test

        // Training Stage
        // TODO: 1. Create Forest

        IsolationForest isolationForest = new IsolationForest(NUM_OF_TREES, SUBSAMPLING_SIZE, formattedDataPoints);
        // TODO: 2. Initialize Forest
        isolationForest.createForest();




        // Evaluating Stage
        //2. Derive an anomaly score



    }
}
