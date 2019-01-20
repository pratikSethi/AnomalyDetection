import java.util.List;

public class Node {

    private Node left;
    private Node right;
    private double splitValue;  // p
    private int splitAtt;    // q
    int currht;

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public double getSplitValue() {
        return splitValue;
    }

    public void setSplitValue(double splitValue) {
        this.splitValue = splitValue;
    }

    public int getSplitAtt() {
        return splitAtt;
    }

    public void setSplitAtt(int splitAtt) {
        this.splitAtt = splitAtt;
    }
}
