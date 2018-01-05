import java.util.*;

/**
 * Implementation of a node in a binary tree.
 * Includes a depth attribute that indicates nodes depth in the tree.
 * Author: Robert Saunders
 */
class BinaryTreeNode {
    int value;
    BinaryTreeNode right;
    BinaryTreeNode left;

    BinaryTreeNode(int value) {
        this.value = value;
    }

    BinaryTreeNode(int value, BinaryTreeNode left, BinaryTreeNode right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}

/**
 * Node depth helper class to help determine if a tree is super balanced.
 */
class BinaryTreeNodeDepthPair {
    BinaryTreeNode node;
    int depth;

    BinaryTreeNodeDepthPair(BinaryTreeNode node, int depth) {
        this.node = node;
        this.depth = depth;
    }
}

/**
 * Implementation of a binary tree and helper methods.
 * See the readme for why a binary tree is a good or bad data structure.
 * NOTE: Using this class you can implement a binary tree or a binary search tree.
 */
public class BinaryTree {

    BinaryTreeNode rootNode;

    /**
     * Basic constructor for a binary tree.
     * @param node The root node of the tree.
     */
    BinaryTree(BinaryTreeNode node) {
        this.rootNode = node;
    }

    /////////////////
    /* Traversals */
    ///////////////

    /**
     * Recursively traverses a binary tree inorder.
     * @param node The reference node for traversal.
     */
    public void inorderRecursive(BinaryTreeNode node) {

        // base case
        if (node == null) {
            return;
        }

        inorderRecursive(node.left); // traverse the left subtree
        System.out.print(node.value + " "); // print the node value
        inorderRecursive(node.right); // traverse the right subtree
    }

    /**
     * Iterative inorder traversal of binary tree.
     * Depth first traversal so implement with stack.
     */
    public void inorderIterative() {

        // first check if the tree is empty
        if (rootNode == null) {
            throw new IllegalArgumentException("The tree must have something in it!");
        }

        // create a stack to use for traversal
        Stack<BinaryTreeNode> nodes = new Stack<>();
        // initialize the current node to be root node
        BinaryTreeNode currentNode = rootNode;

        // set current node to be the leftmost node
        // push all other nodes onto the stack
        while(currentNode != null) {
            nodes.push(currentNode);
            currentNode = currentNode.left;
        }

        // traverse the tree
        if (!nodes.isEmpty()) {
            // take the first node in the stack
            // print the value or do whatever you want
            currentNode = nodes.pop();
            System.out.print(currentNode.value + " ");

            // check if the left most node has a right subtree
            if (currentNode.right != null) {
                currentNode = currentNode.right;

                // push right subtree onto the stack
                while(currentNode != null) {
                    nodes.push(currentNode);
                    currentNode = currentNode.left;
                }
            }
        }
    }

    /**
     * Recursively traverse the binary tree in preorder.
     * Leverages call stack to achieve traversal.
     * @param node The reference node for traversal.
     */
    public void preorderRecursive(BinaryTreeNode node) {

        // base case
        if (node == null) {
            return;
        }

        System.out.print(node.value + " "); // print the value
        preorderRecursive(node.left); // traverse left subtree
        preorderRecursive(node.right); // traverse right subtree
    }

    /**
     * Traverses a binary tree in preorder iteratively.
     * Uses a stack to implement depth first traversal.
     */
    public void preorderIterative() {

        // check if the tree is empty
        if (rootNode == null) {
            throw new IllegalArgumentException("The tree must have something in it!");
        }

        // create a stack for the nodes
        Stack<BinaryTreeNode> nodes = new Stack<>();
        // push the root onto the stack
        nodes.push(rootNode);

        // traverse the tree
        while(!nodes.isEmpty()) {
            // get the current node off of the stack
            // print the current node values
            BinaryTreeNode currentNode = nodes.pop();
            System.out.print(currentNode.value + " ");

            // add children nodes to the stack
            if (currentNode.right != null) {
                nodes.push(currentNode.right);
            }
            if (currentNode.left != null) {
                nodes.push(currentNode.left);
            }
        }
    }

    /**
     * Recursively traverses the binary tree in post order.
     * Leverages call stack to achieve traversal.
     * @param node The reference node for traversal.
     */
    public void postorderRecursive(BinaryTreeNode node) {

        // base case
        if (node == null) {
            return;
        }

        postorderRecursive(node.left); // traverse the left subtree
        postorderRecursive(node.right); // traverse the right subtree
        System.out.print(node.value + " "); // print the value
    }

    /**
     * Traverses a binary tree in postorder iteratively.
     * Uses a stack to implement depth first traversal.
     */
    public void postorderIterative() {

        // check if the tree is empty
        if (rootNode == null) {
            throw new IllegalArgumentException("The tree must have something in it!");
        }

        //
        Stack<BinaryTreeNode> nodes = new Stack<>();

        BinaryTreeNode currentNode = nodes.pop();

        // find leftmost node
        while (currentNode != null) {
            nodes.push(currentNode);
            currentNode = currentNode.left;
        }

        while (!nodes.isEmpty()) {
            currentNode = nodes.pop();

            if (currentNode.right != null) {
                currentNode = currentNode.right;

                while (currentNode != null) {
                    nodes.push(currentNode);
                    currentNode = currentNode.left;
                }
            }

            System.out.print(currentNode.value + " ");
        }
    }

    /**
     *
     */
    public void levelorderIterative() {

        if (rootNode == null) {
            throw new IllegalArgumentException("The tree must have something in it!");
        }

        Queue<BinaryTreeNode> nodes = new LinkedList<>();

        nodes.add(rootNode);

        while(!nodes.isEmpty()) {
            BinaryTreeNode current = nodes.peek();
            nodes.remove();

            System.out.print(current.value + " ");

            if (current.left != null) {
                nodes.add(current.left);
            }
            if (current.right != null) {
                nodes.add(current.right);
            }
        }
    }

    /**
     * Inserts a node into a binary tree at the first available position in level order.
     * The first position can be characterized as the first child position on a node we are at in our traversal.
     * Nodes always get inserted as leaf nodes.
     * @param value The value to be inserted into the tree.
     */
    public void insertNodeLevelOrder(int value) {

        // if the tree is empty lets create it
        if (rootNode == null) {
            rootNode = new BinaryTreeNode(value);
        }

        // create a queue for level order traversal
        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        // lets start our traversal at the beginning of the tree
        nodes.add(rootNode);

        // traverse the tree
        while(!nodes.isEmpty()) {

            // dequeue the current node
            BinaryTreeNode currentNode = nodes.poll();

            if (currentNode.left == null) {
                currentNode.left = new BinaryTreeNode(value);
            } else {
                nodes.add(currentNode.left);
            }

            if (currentNode.right == null) {
                currentNode.right = new BinaryTreeNode(value);
            } else {
                nodes.add(currentNode.right);
            }
        }
    }

    /**
     * Checks if a binary tree is super balanced.
     * Super balanced is when a trees depth never differs by more than one.
     * @param rootNode The root node of the tree.
     * @return True if the tree is super balanced.
     */
    public Boolean isSuperBalanced(BinaryTreeNode rootNode) {

        // an empty tree is super balanced
        if (rootNode == null) {
            return true;
        }

        // contains a list of depths
        // if there are more than two depths it is not balanced
        // if there are two depths that are greater than 1 apart
        List<Integer> depths = new ArrayList<>();

        // holds a list of nodes during search
        // depth first uses a stack, breath uses a queue
        Stack<BinaryTreeNodeDepthPair> nodes = new Stack<>();
        nodes.push(new BinaryTreeNodeDepthPair(rootNode, 0));

        // begin traversal
        while(!nodes.isEmpty()) {

            BinaryTreeNodeDepthPair nodeDepthPair = nodes.pop();
            BinaryTreeNode node = nodeDepthPair.node;
            int depth = nodeDepthPair.depth;

            // case that is a leaf node
            if (node.left != null && node.right != null) {

                if (!depths.contains(depth)) {
                    depths.add(depth);

                    if ((depths.size() > 2) || (depths.size() == 2 && Math.abs(depths.get(0) - depths.get(1)) > 1)) {
                        return false;
                    }
                }

            } else {
                if (node.left != null) {
                    nodes.push(new BinaryTreeNodeDepthPair(node.left, depth+1));
                }
                if (node.right != null) {
                    nodes.push(new BinaryTreeNodeDepthPair(node.right, depth + 1));
                }
            }
        }

     return true;
    }

    /**
     * Checks if a binary tree is a valid binary search tree.
     * Binary search tree are sorted based on values.
     * @param rootNode The root node of the tree.
     * @return True if the tree is BST.
     */
    public Boolean isValidBinarySearchTree(BinaryTreeNode rootNode) {

        if (rootNode == null) {
            return true;
        }

        Stack<NodeBounds> nodes = new Stack<>();
        nodes.push(new NodeBounds(rootNode, Integer.MAX_VALUE, Integer.MIN_VALUE));

        while(!nodes.empty()) {

            NodeBounds nodeBounds = nodes.pop();
            BinaryTreeNode node = nodeBounds.node;
            int lowerBound = nodeBounds.lowerBound;
            int upperBound = nodeBounds.upperBound;

            if (node.value <= lowerBound || node.value >= upperBound) {
                return false;
            }

            if (node.right != null) {
                nodes.push(new NodeBounds(node.right, upperBound, node.value));
            }

            if (node.left != null) {
                nodes.push(new NodeBounds(node.left, node.value, lowerBound));
            }

        }

        return true;
    }

    boolean checkBST(Node root) {
        return check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    boolean check(Node root, int upperBound, int lowerBound) {
        if (root == null) {
            return true;
        }

        if (root.data >= upperBound || root.data <= lowerBound) {
            return false;
        }

        return check(root.left, root.data, lowerBound) && check(root.right, upperBound, root.data);
    }

}
