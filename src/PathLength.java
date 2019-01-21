import sun.jvm.hotspot.memory.LinearAllocBlock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class PathLength {

    List<List<Double>> dataPnts;
    Set<IsolationTree> itrees;

    PathLength(List<List<Double>> dataPnts, Set<IsolationTree> itrees){
        System.out.println("Received!");
        this.dataPnts = dataPnts;
        this.itrees = itrees;
    }

    public List<Integer> traverse(List<Double> point){
        List<Integer> path = new ArrayList<>();
        for(IsolationTree itr: itrees){
            Node cur = itr.getRoot();
            int curPath = 1;
            while(cur!=null){
                if (point.get(cur.getSplitAtt())<= cur.getSplitValue()){
                    cur = cur.getLeft();
                    curPath++;
                }
                else{
                    cur = cur.getRight();
                    curPath++;
                }
            }
            //System.out.println("tree traversed ::" + itr.getRoot().getSplitValue());
            //System.out.println("current path " + curPath);
            path.add(curPath);
        }
        return path;
    }

    public void findAnomalies(int numOfAnomaly){
        List<Integer> pathLengths ;

        for (List<Double> pt : dataPnts){
            pathLengths = traverse(pt);
            double avgPath = pathLengths.stream().mapToInt(val -> val).average().orElse(0.0);
            double n = dataPnts.size();
            double cn = (2*Math.log(n-1)) - (2*(n-1)/n);
            double score = Math.pow(2,((-1)*(avgPath)/cn));

            //System.out.println("Pathlengths of each point  "+Arrays.toString(pathLengths.toArray()));
            System.out.println("Average path length for each path "+avgPath);
            System.out.println("score "+score);
        }
    }
}
