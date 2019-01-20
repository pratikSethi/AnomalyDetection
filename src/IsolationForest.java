import util.RandomUtil;

import java.util.*;

/**
 *
 * IF creates randomized decision trees
 * IF can work as supervised or unsupervised classifier
 * Is it a good practice to create objects of IsolationTree class inside constructor of Isolation Forest
 * If not what is another good way to achieve the same result
 * Throwing exception inside a class:
 *      https://stackoverflow.com/questions/6086334/is-it-good-practice-to-make-the-constructor-throw-an-exception
 */

public class IsolationForest {

    private int numberOfTrees;
    private int subSamplingSize;
    private List<List<Double>> nDimData;
    private Set<IsolationTree> trees;

    public IsolationForest(int numberOfTrees, int subSamplingSize, List<List<Double>> nDimData) {

        System.out.println("Inside IsolationForest(int, int, List<List<>>)");
        // check for exception conditions while passing the values from main()
        this.numberOfTrees = numberOfTrees;
        this.subSamplingSize = subSamplingSize;
        this.nDimData = nDimData;
        trees = new HashSet<>();

    }

//    public Set<IsolationTree> addTree(List<List<Double>> inputData, int initialTreeHeight, int heightLimit){
//        IsolationTree newTree = new IsolationTree();
//        this.trees.add(newTree);
//        return this.trees;
//
//    }

    /**
     *
     * @return return a set of trees |set| = numberOfTrees
     */
    public Set<IsolationTree> createForest(){
        System.out.println("Inside createForest()");
        int heightLimit = (int)Math.ceil(Math.log(this.subSamplingSize));
        for(int i = 0; i < this.numberOfTrees; i++){

            // subSampledData' <- sample(nDimData, subSamplingSize)
            List<List<Double>> subSampledData = sample();
            // after getting the sampled data create a tree and add it to the set
            //IsolationTree tempTree = new IsolationTree(subSampledData, 0, heightLimit);

            this.trees.add(new IsolationTree(subSampledData, 0, heightLimit));
            //System.out.println("SubSampledData is :: " + subSampledData);
        }
        return trees;
    }

    private List<List<Double>> sample(){
        //System.out.println("Inside subSampledData");
        List<List<Double>> subSampledData = new ArrayList<>();

        Set<Integer> randomUniqueIndexes = RandomUtil.getRandomNumbersInRange(subSamplingSize, 0, 5);
        for (Integer i : randomUniqueIndexes) {
            subSampledData.add(this.nDimData.get(i));

        }
        return subSampledData;
    }



}
