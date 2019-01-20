package util;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Utility class for file IO
 * How can I create an utility class
 * Stack overflow: https://stackoverflow.com/questions/25223553/how-can-i-create-an-utility-class
 */

/**
 * TODO: Implement this utility
 * TODO: Check some boundary conditions like
 * TODO: 1) If all lines have same number of elements after split
 * TODO: 2) If all the elements in a line are of same type
 */

public final class FileUtil {

    private FileUtil(){}
    private static final String COMMA_DELIMITER = ",";

    public static List<String> readFile(String filename){
        List<String> datapoints = new ArrayList<>();
        BufferedReader reader = null;
        String line = "";
        try {
            reader = new BufferedReader(new FileReader(filename));
            while ((line = reader.readLine()) != null) {
                datapoints.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return datapoints;
    }

    /**
     *
     *
     * @param datapoints - lines of the test-data file in String format
     * @return formattedDataPoints - List<Point> where Point is List<data>
     */
    public static List<List<Double>> formatData(List<String> datapoints){
        System.out.println("Initial datapoints are :: " + datapoints);
        List<List<Double>> formattedDataPoints = new ArrayList<>();
        for (String str : datapoints) {
            String[] splitVals;
            splitVals = str.split(COMMA_DELIMITER);
            List<Double> datapoint = new ArrayList<>();
            for (String elem: splitVals) {
                datapoint.add(Double.parseDouble(elem));

            }
            formattedDataPoints.add(datapoint);
        }

        System.out.println("datapoints :: " + formattedDataPoints);

        return formattedDataPoints;
    }

    public boolean isFileFormatValid(List<String> datapoints){

        //TODO: Implement this later on and understand the purpose this code

        int numberOfDataPoints = datapoints.size();
        // check out t10.dat test case under professor's directory
        System.out.println("Number of Datapoints in the File are :: " + numberOfDataPoints);
        return false;
    }

    public boolean doAllElementsHaveSameDimension(){

        //TODO: Implement this later on

        return true;
    }


}
