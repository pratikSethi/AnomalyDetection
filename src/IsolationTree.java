import java.util.ArrayList;
import java.util.List;

/**
 * Definition : Isolation Tree
 *  Let T be a node of an isolation
 *  tree. T is either an external-node with no child, or an
 *  internal-node with one test and exactly two daughter nodes
 *  (Tl,Tr). A test consists of an attribute q and a split value p
 *  such that the test q < p divides data points into Tl and Tr.
 *
 *             T : Node : Isolation Tree            Test : (q < p)
 *               _____________________           _________________________
 *              | left | test | right |         | q (attr) | p (split val)|
 *              |_____________________|         |__________|______________|
 */

public class IsolationTree {

    private List<List<Double>> sampledData;
    private int currentTreeHeight;
    private int heightLimit;

    private Node root;

    public static final int TWO = 2;


    public IsolationTree(List<List<Double>> sampledData, int currentTreeHeight, int heightLimit) {
        this.sampledData = sampledData;
        this.currentTreeHeight = currentTreeHeight;
        this.heightLimit = heightLimit;

        this.root = new Node();
        createTree(root, sampledData);

        System.out.println("Inside Isolation Tree. sampledData :: " + this.sampledData + " currHeight" +
                this.currentTreeHeight + " height limit " + heightLimit);

    }

    public Node createTree(Node current, List<List<Double>> nodeData){


        // TODO: 1. Create Q a list of attributes in nodeData
        // TODO: 2.

        List<Integer> qAttributes = new ArrayList<>();
        for(int i = 0; i < nodeData.get(0).size(); i++){
            qAttributes.add(i);
        }

        System.out.println("Size of Q attributes is :: " + qAttributes.size() + " and values are " + qAttributes);


        if(currentTreeHeight >= heightLimit || sampledData.size() <= 1){
            return current;
        }
        // TODO: select attribute randomly

        // call filter()
        if(current == null){
            current = new Node();
        }
        return new Node();
    }

    public List<List<Double>> filter(){

        List<List<Double>> filteredData = new ArrayList<>();

        return filteredData;

    }


    /**
     *
     * @param x
     * @param n
     * @return
     */

    double calculateAnomalyScore(Instance x, int n){
        double anomalyScore = 0;
        double pathLength = calculatePathLength(x);
        double constantNormalizer = calculateConstantNormalizer(n);
        double expectation = calculateExpectation(pathLength);

        return anomalyScore;
    }

    double calculateExpectation(double pathLength){
        double expectation = 0;

        return expectation;
    }

    double calculatePathLength(Instance x){
        double pathLength = 0;

        return pathLength;
    }

    double calculateConstantNormalizer(int n){
        double normalizedValue = 0;

        return normalizedValue;
    }


}
