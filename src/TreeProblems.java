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
    BinaryTreeNode parent;

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
 * Node depth helper class to help determine if a tree is balanced.
 * The alternative to using this is to recurse with bounds.
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
class BinaryTree {

    BinaryTreeNode rootNode;

    BinaryTree(BinaryTreeNode node) {
        this.rootNode = node;
    }
}

/**
 * Implementation of various different binary tree problems.
 */
class BinaryTreeProblems {

    // problems to work through
    // largest independant set problem
    // closest path to various sets of nodes, along with being able to detect levels of all nodes as efficiently as possible. 
    // maximum tree length
    // longest path from leafs, diameter
    // Print all the possible paths of a binary tree  
    // range of sum in binary search tree
    // Find the k-th smallest element in a BST 
    // paths that sum to that value
    // is tree a subtree of the other

    /////////////////
    /* TRAVERSALS */
    ///////////////

    /**
     * Recursively traverses a binary tree inorder.
     * @param node The reference node for traversal.
     */
    public static void inorderRecursive(BinaryTreeNode node) {

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
    public static void inorderIterative(BinaryTreeNode rootNode) {

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
    public static void preorderRecursive(BinaryTreeNode node) {

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
    public static void preorderIterative(BinaryTreeNode rootNode) {

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
    public static void postorderRecursive(BinaryTreeNode node) {

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
     * @param rootNode The root of the binary tree to be traversed.
     */
    public static void postorderIterative(BinaryTreeNode rootNode) {

        // check if the tree is empty
        if (rootNode == null) {
            throw new IllegalArgumentException("The tree must have something in it!");
        }

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
     * Traverses the tree in a level order manner.
     * @param rootNode The root of the binary tree to be traversed.
     */
    public static void levelorderIterative(BinaryTreeNode rootNode) {

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

    /////////////////
    /* INSERTIONS */
    ///////////////

    /**
     * Inserts a node into a binary tree at the first available position in level order.
     * The first position can be characterized as the first child position on a node we are at in our traversal.
     * Nodes always get inserted as leaf nodes.
     * @param rootNode The root of the binary tree to insert into
     * @param value The value to be inserted into the tree.
     */
    public void insertNodeLevelOrder(BinaryTreeNode rootNode, int value) {

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
     * Recursively inserts a node into a tree.
     * @param root The root of the binary tree to insert into.
     * @param value The value to insert into the tree.
     * @return The root of the tree.
     */
    public static BinaryTreeNode InsertR(BinaryTreeNode root, int value) {

        if (root == null) {
            root = new BinaryTreeNode();
            root.value = value;
            return root;
        }

        if (value < root.value) {
            root.left = InsertR(root.left, value);
        } else {
            root.right = InsertR(root.right, value);
        }

        return root;
    }

    /**
     * Inserts into a binary tree using a iterative traversal.
     * @param root The root of the tree to insert into.
     * @param value The value to insert into the tree.
     * @return The root of the binary tree.
     */
    public static BinaryTreeNode Insert(BinaryTreeNode root, int value) {

        BinaryTreeNode newNode = new BinaryTreeNode();
        newNode.value = value;

        if (root == null) {
            root = newNode;
            return root;
        }

        Stack<BinaryTreeNode> nodes = new Stack<>();
        nodes.push(root);

        while(!nodes.isEmpty()) {

            BinaryTreeNode current = nodes.pop();

            if (value < current.value) {
                if (current.left == null) {
                    current.left = newNode;
                } else {
                    nodes.push(current.left);
                }
            } else {
                if (current.right == null) {
                    current.right = newNode;
                } else {
                    nodes.push(current.right);
                }
            }
        }

        return root;
    }

    //////////////
    /* HELPERS */
    ////////////

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
                if (node.right != null) {
                    nodes.push(new BinaryTreeNodeDepthPair(node.right, depth + 1));
                }
                if (node.left != null) {
                    nodes.push(new BinaryTreeNodeDepthPair(node.left, depth + 1));
                }
            }
        }

     return true;
    }

    /**
     * Another method to see if a tree is balanced.
     * @param root The root of the binary tree to check.
     * @return True if the tree is balanced.
     */
    public static boolean isBalanced(BinaryTreeNode root) {
        return (maxDepth(root) - minDepth(root)) <= 1;
    }

    /**
     * Calculates the max depth of a tree recursively.
     * @param root The root of the binary tree to get depth of.
     * @return The depth of the tree.
     */
    public static int maxDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    /**
     * Calculates the min depth of a tree recursively.
     * @param root The root of the binary tree to get depth of.
     * @return The depth of the tree.
     */
    public static int minDepth(BinaryTreeNode root) {
        if (root == null) {
            return 0;
        }

        return 1 + Math.min(minDepth(root.left), minDepth(root.right));
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

    /**
     * Wrapper around recursive implementation.
     * @param root The root of the binary tree to check.
     * @return True if a valid binary search tree.
     */
    public static boolean checkBST(BinaryTreeNode root) {
        return check(root, Integer.MAX_VALUE, Integer.MIN_VALUE);
    }

    /**
     * Recursive helper to check if a binary tree is a valid one.
     * @param root The root of the binary tree to check.
     * @param upperBound The upper bound check with.
     * @param lowerBound The lower bound to check with.
     * @return True if value, false otherwise.
     */
    private static boolean check(BinaryTreeNode root, int upperBound, int lowerBound) {
        if (root == null) {
            return true;
        }

        if (root.value >= upperBound || root.value <= lowerBound) {
            return false;
        }

        return check(root.left, root.value, lowerBound) && check(root.right, upperBound, root.value);
    }

    /**
     * Finds the lowest common ancestor of two nodes in a binary tree.
     * @param root The root of the binary tree to check.
     * @param v1 One node of the pair.
     * @param v2 Second node of the pair.
     * @return The node that is the lowest common ancestor.
     */
    public static BinaryTreeNode lca(BinaryTreeNode root, int v1, int v2) {

        if (root == null) {
            return null;
        }

        if (root.value > v1 && root.value > v2) {
            return lca(root.left, v1, v2);
        }

        if (root.value < v1 && root.value < v2) {
            return lca(root.right, v1, v2);
        }

        return root;
    }

    /**
     * Creates an array of linked lists, each list is a level in the binary tree.
     * This is a good way to print the tree level by level too.
     * @param rootNode The root node of the tree.
     * @return The list of lists.
     */
    public static ArrayList<LinkedList<BinaryTreeNode>> getLevelsOfTreeAsLinkedLists(BinaryTreeNode rootNode) {

        if (rootNode == null) {
            return new ArrayList<>();
        }

        ArrayList<LinkedList<BinaryTreeNode>> levels = new ArrayList<>();
        Queue<BinaryTreeNode> nodes = new LinkedList<>();
        nodes.add(rootNode);

        while(true) {

            int levelCount = nodes.size();
            if (levelCount == 0) {
                break;
            }

            LinkedList<BinaryTreeNode> currentLevelList = new LinkedList<>();

            while(levelCount > 0) {
                BinaryTreeNode current = nodes.poll();
                currentLevelList.add(current);

                if (current.left != null) {
                    nodes.add(current.left);
                }

                if (current.right != null) {
                    nodes.add(current.right);
                }
                levelCount--;
            }

            levels.add(currentLevelList);
        }

        return levels;
    }

    /**
     * Converts a sorted array to a minimal height tree.
     * @param sortedArray The sorted array of numbers to convert to a tree.
     * @return The root node of the new tree.
     */
    public static BinaryTreeNode sortedArrayToBinaryTreeMinimalHeight(int[] sortedArray) {
        return addToTree(sortedArray, 0, sortedArray.length-1);
    }

    /**
     * Recursive helper method to add an element into a minimal height tree.
     * @param sortedArray The array of numbers to be added into the tree.
     * @param startIndex The starting index of segment of array.
     * @param endIndex The ending index of segment of array.
     * @return The new node being added.
     */
    private static BinaryTreeNode addToTree(int[] sortedArray, int startIndex, int endIndex) {
        if (startIndex < endIndex) {
            return null;
        }

        int middleIndex = sortedArray.length/2;
        BinaryTreeNode newNode = new BinaryTreeNode(sortedArray[middleIndex]);
        newNode.left = addToTree(sortedArray, startIndex, middleIndex-1);
        newNode.right = addToTree(sortedArray, middleIndex+1, endIndex);

        return newNode;
    }

    /**
     * Finds the successor of a node (i.e. next node inorder).
     * @param nodeToCheck The node to get the successor of.
     * @return The successor of the node we were passed.
     */
    public static BinaryTreeNode findSuccessor(BinaryTreeNode nodeToCheck) {

        if (nodeToCheck == null) {
            return null;
        }

        BinaryTreeNode successor;
        if (nodeToCheck.parent == null || nodeToCheck.right != null) {
            successor = leftMostElement(nodeToCheck.right);
        } else {
            while((successor = nodeToCheck.parent) != null) {
                if (successor.left == nodeToCheck) {
                    return successor;
                }
                nodeToCheck = successor;
            }
            return successor;
        }
    }

    /**
     * Gets the left most connected element to the past in tree node.
     * @param node The node to retrieve the left most element from.
     * @return The left most connected element.
     */
    private static BinaryTreeNode leftMostElement(BinaryTreeNode node) {
        if (node == null) return null;
        while(node.left != null) {
            node = node.left;
        }
        return node;
    }

    //////////////
    /* TESTING */
    ////////////

    /**
     * Main execution method used for testing.
     * @param args The arguments passed into exection.
     */
    public static void main(String[] args) {

    }
}
