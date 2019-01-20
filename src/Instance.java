import java.util.List;

/**
 *
 * Yet to identify the structure of Instance
 * The instances are basically n-dimensional data points.
 */

public class Instance {

    private List<Double> dataPoint;

    public Instance(List<Double> dataPoint){
        this.dataPoint = dataPoint;
    }

    public List<Double> getDataPoint() {
        return dataPoint;
    }

    public void setDataPoint(List<Double> dataPoint) {
        this.dataPoint = dataPoint;
    }

    public void printInstance(){
        for (Double dim :dataPoint) {
            System.out.println(dim);
        }
    }
}
