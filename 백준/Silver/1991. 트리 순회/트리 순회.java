import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

class Node {
    char data;
    Node left, right;

    Node(char item) {
        data = item;
        left = right = null;
    }
}

class BinaryTree {
    Node root;

    BinaryTree() {
        root = null;
    }

    // 전위 순회
    void preorderTraversal(Node node) {
        if (node != null) {
            System.out.print(node.data);
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // 중위 순회
    void inorderTraversal(Node node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.data);
            inorderTraversal(node.right);
        }
    }

    // 후위 순회
    void postorderTraversal(Node node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.data);
        }
    }

    Node buildTree(char[] data, char[] leftChild, char[] rightChild, int n) {
        Node[] nodeArray = new Node[n];
        HashMap<Character, Node> nodeMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            nodeArray[i] = new Node(data[i]);
            nodeMap.put(data[i], nodeArray[i]);
        }

        for (int i = 0; i < n; i++) {
            if (leftChild[i] != '.') {
                nodeArray[i].left = nodeMap.get(leftChild[i]);
            }
            if (rightChild[i] != '.') {
                nodeArray[i].right = nodeMap.get(rightChild[i]);
            }
        }

        return nodeArray[0];
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        char[] data = new char[n];
        char[] leftChild = new char[n];
        char[] rightChild = new char[n];

        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            data[i] = input[0].charAt(0);
            leftChild[i] = input[1].charAt(0);
            rightChild[i] = input[2].charAt(0);
        }

        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(data, leftChild, rightChild, n);

        // 전위 순회 출력
        tree.preorderTraversal(root);
        System.out.println();

        // 중위 순회 출력
        tree.inorderTraversal(root);
        System.out.println();

        // 후위 순회 출력
        tree.postorderTraversal(root);
    }
}
