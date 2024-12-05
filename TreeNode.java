/**
 * represents a single node in the binary tree
 * stores data and references to left and right children
 *
 * @author Leul Belay
 */
public class TreeNode<T> {

    /**
     * the data stored in the node
     */
    private T data;

    /**
     * reference to the left child
     */
    private TreeNode<T> leftChild;

    /**
     * reference to the right child
     */
    private TreeNode<T> rightChild;

    /**
     * creates a new TreeNode with data and null children
     *
     * @param dataNode the data to be stored in the node
     */
    public TreeNode(T dataNode) {
        this.data = dataNode;
        this.leftChild = null;
        this.rightChild = null;
    }

    /**
     * gets the data stored in the node
     *
     * @return the data of the node
     */
    public T getData() {
        return data;
    }

    /**
     * gets the left child of the node
     *
     * @return the left child
     */
    public TreeNode<T> getLeftChild() {
        return leftChild;
    }

    /**
     * sets the left child of the node
     *
     * @param left the new left child
     */
    public void setLeftChild(TreeNode<T> left) {
        this.leftChild = left;
    }

    /**
     * gets the right child of the node
     *
     * @return the right child
     */
    public TreeNode<T> getRightChild() {
        return rightChild;
    }

    /**
     * sets the right child of the node
     *
     * @param right the new right child
     */
    public void setRightChild(TreeNode<T> right) {
        this.rightChild = right;
    }
}
