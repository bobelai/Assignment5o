
/**
 * a binary tree used to convert morse code to english
 * implements the LinkedConverterTreeInterface
 * builds and traverses the morse code tree
 *
 * @author Leul Belay
 */
import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {

    /**
     * the root node of the tree
     */
    private TreeNode<String> root;

    /**
     * constructor initializes the tree and calls buildTree
     */
    public MorseCodeTree() {
        root = new TreeNode<>("");
        buildTree();
    }

    /**
     * builds the morse code tree by inserting nodes
     */
    @Override
    public void buildTree() {
        insert(".", "e");
        insert("-", "t");
        insert("..", "i");
        insert(".-", "a");
        insert("-.", "n");
        insert("--", "m");
        insert("...", "s");
        insert("..-", "u");
        insert(".-.", "r");
        insert(".--", "w");
        insert("-..", "d");
        insert("-.-", "k");
        insert("--.", "g");
        insert("---", "o");
        insert("....", "h");
        insert("...-", "v");
        insert("..-.", "f");
        insert(".-..", "l");
        insert(".--.", "p");
        insert(".---", "j");
        insert("-...", "b");
        insert("-..-", "x");
        insert("-.-.", "c");
        insert("-.--", "y");
        insert("--..", "z");
        insert("--.-", "q");
    }

    /**
     * inserts a new letter into the tree based on morse code
     *
     * @param code the morse code for the letter
     * @param letter the letter to be added
     */
    @Override
    public void insert(String code, String letter) {
        addNode(root, code, letter);
    }

    /**
     * recursively adds a node to the tree based on morse code
     *
     * @param root the current node
     * @param code the morse code for the letter
     * @param letter the letter to be added
     */
    @Override
    public void addNode(TreeNode<String> root, String code, String letter) {
        if (code.length() == 1) {
            if (code.equals(".")) {
                root.setLeftChild(new TreeNode<>(letter));
            } else if (code.equals("-")) {
                root.setRightChild(new TreeNode<>(letter));
            }
        } else {
            if (code.charAt(0) == '.') {
                if (root.getLeftChild() == null) {
                    root.setLeftChild(new TreeNode<>(""));
                }
                addNode(root.getLeftChild(), code.substring(1), letter);
            } else if (code.charAt(0) == '-') {
                if (root.getRightChild() == null) {
                    root.setRightChild(new TreeNode<>(""));
                }
                addNode(root.getRightChild(), code.substring(1), letter);
            }
        }
    }

    /**
     * fetches the letter corresponding to a given morse code
     *
     * @param code the morse code
     * @return the corresponding letter
     */
    @Override
    public String fetch(String code) {
        return fetchNode(root, code);
    }

    /**
     * recursively fetches the letter corresponding to a given morse code
     *
     * @param root the current node
     * @param code the morse code
     * @return the corresponding letter
     */
    @Override
    public String fetchNode(TreeNode<String> root, String code) {
        if (code.length() == 1) {
            return code.equals(".") ? root.getLeftChild().getData() : root.getRightChild().getData();
        } else {
            if (code.charAt(0) == '.') {
                return fetchNode(root.getLeftChild(), code.substring(1));
            } else {
                return fetchNode(root.getRightChild(), code.substring(1));
            }
        }
    }

    /**
     * returns an array list of the tree's contents in LNR order
     *
     * @return an ArrayList of the tree's contents
     */
    @Override
    public ArrayList<String> toArrayList() {
        ArrayList<String> list = new ArrayList<>();
        LNRoutputTraversal(root, list);
        return list;
    }

    /**
     * recursively adds nodes to an array list in LNR order
     *
     * @param root the current node
     * @param list the array list to hold the nodes
     */
    @Override
    public void LNRoutputTraversal(TreeNode<String> root, ArrayList<String> list) {
        if (root != null) {
            LNRoutputTraversal(root.getLeftChild(), list);
            list.add(root.getData());
            LNRoutputTraversal(root.getRightChild(), list);
        }
    }

    @Override
    public TreeNode<String> getRoot() {
        return root;
    }

    @Override
    public void setRoot(TreeNode<String> newNode) {
        this.root = newNode;
    }

    @Override
    public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Delete operation is not supported.");
    }

    @Override
    public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
        throw new UnsupportedOperationException("Update operation is not supported.");
    }
}
