import util.RandomUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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


    public IsolationTree(List<List<Double>> sampledData, int heightLimit) {
        this.sampledData = sampledData;
        this.currentTreeHeight = currentTreeHeight;
        this.heightLimit = heightLimit;

        this.root = new Node();
        System.out.println("\n\n");
        System.out.println("Trees Data :: " + Arrays.toString(sampledData.toArray()));
//        System.out.println("Inside Isolation Tree. sampledData :: " + this.sampledData + " currHeight" +
//                this.currentTreeHeight + " height limit " + heightLimit);
        System.out.println("Inside isolation tree. Curr Height  :: " + currentTreeHeight + " height limit :: " + heightLimit);
        if(sampledData.size() > 0){
            createTree(root, sampledData, 0);
        }

    }

    public Node createTree(Node current, List<List<Double>> nodeData, int currht){
        System.out.println("NodeData :: " + nodeData.size());
        System.out.println("Create Tree - currHeight :: " + currht);

        if(currht >= heightLimit || nodeData.size() <= 1){
            return current;
        }

        if(current == null){
            // TODO: potential bug
            current = new Node();
            this.currentTreeHeight += 1;
        }

        // TODO: 1. Create Q a list of attributes in nodeData
        List<Integer> q = getQ(nodeData);
        // Do some checks here. I am assuming as per my code that q will always contain an integer from
        // [0, nodeData.get(0).size()]
        // TODO: 2. Randomly select attribute from Q
        int randQ = RandomUtil.getRandomNumberInRange(0, nodeData.get(0).size() - 1);
        System.out.println("randQ :: "+ randQ);

        // TODO: 3. randomly select a split point p from max and min
        //          values of attribute q in X
        List<Double> randAttributeVals = new ArrayList<>();

        for (List<Double> datapoints : nodeData){
            randAttributeVals.add(datapoints.get(randQ));
        }

        Double randSplitP = RandomUtil.getRandomNumberInRange(
                Collections.min(randAttributeVals), Collections.max(randAttributeVals));

        System.out.println("randSplitP :: " + randSplitP);


        List<List<Double>> leftNodeData = new ArrayList<>();
        List<List<Double>> rightNodeData = new ArrayList<>();

        // TODO: 4. Filter the data as per split value
        for (int i = 0; i < nodeData.size(); i++){
            if(nodeData.get(i).get(randQ) <= randSplitP){
                leftNodeData.add(nodeData.get(i));
            }else{
                rightNodeData.add(nodeData.get(i));
            }
        }

        for (List<Double> datapoint : leftNodeData){
            System.out.println("left datapoint :: " + datapoint);
        }
        for (List<Double> datapoint : rightNodeData){
            System.out.println("right datapoint :: " + datapoint);
        }

        current.setLeft(createTree(current.getLeft(), leftNodeData,currht+1));
        //this.currentTreeHeight -= 1;
        current.setRight(createTree(current.getRight(), rightNodeData,currht+1));


        return current;

    }

    public List<Integer> getQ(List<List<Double>> nodeData){
        List<Integer> q = new ArrayList<>();
        if(nodeData.size() > 0){
            for(int i = 0; i < nodeData.get(0).size(); i++){
                q.add(i);
            }
            return q;
        }else {
            return null;
        }
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
