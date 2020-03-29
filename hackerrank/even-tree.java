import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

public class Solution {

    static class Node {
        int index;
        LinkedList<Node> children = new LinkedList<>();

        public Node(int index) {
            this.index = index;
        }
    }

    static int findNodeCount(Node root) {
        int r = 1;
//        System.out.println(root.index);
        for (Node n : root.children) {
            r += findNodeCount(n);
        }
        return r;
    }

    static int evenForest() {
        int c = 0;
       for (Map.Entry<Integer, Node> entry : nodes.entrySet()) {
           if (findNodeCount(entry.getValue()) % 2 == 0) {
               c += 1;
           }
       }
       return c - 1;
    }

    static TreeMap<Integer, Node> nodes = new TreeMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        String[] tNodesEdges = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int tNodes = Integer.parseInt(tNodesEdges[0]);
        for (int i = 1; i <= tNodes; ++i) {
            nodes.put(i, new Node(i));
        }

        int tEdges = Integer.parseInt(tNodesEdges[1]);

        for (int i = 0; i < tEdges; ++i) {
            String[] input = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");
            int child = Integer.parseInt(input[0]);
            int parent = Integer.parseInt(input[1]);
            nodes.get(parent).children.add(nodes.get(child));
        }

        int res = evenForest();
        bufferedWriter.write(String.valueOf(res));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
