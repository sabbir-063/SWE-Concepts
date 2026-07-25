# 03. Graph Traversal: BFS & DFS (Code & Implementations)

এই ফাইলে আমরা জাভাতে গ্রাফের BFS এবং DFS (Recursive & Iterative) এর একদম ক্লিন ইমপ্লিমেন্টেশন দেখবো। গ্রাফকে আমরা **Adjacency List** দিয়ে রিপ্রেজেন্ট করবো।

## 1. Graph Representation (Adjacency List)
BFS বা DFS চালানোর আগে একটি গ্রাফ ক্লাস তৈরি করে নেওয়া ভালো।

```java
import java.util.*;

class Graph {
    int V; // Vertices (নোড সংখ্যা)
    List<List<Integer>> adj; // Adjacency List

    public Graph(int V) {
        this.V = V;
        adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>()); // প্রতিটি নোডের জন্য একটি খালি লিস্ট
        }
    }

    // Undirected গ্রাফে এজ অ্যাড করা
    public void addEdge(int u, int v) {
        adj.get(u).add(v);
        adj.get(v).add(u);
    }
}
```

---

## 2. Breadth-First Search (BFS)
**Data Structure:** `Queue` এবং `boolean[] visited`।
**লজিক:** প্রথমে সোর্স নোড Queue তে ঢোকান এবং ভিজিটেড মার্ক করুন। তারপর Queue থেকে একটা একটা করে বের করুন এবং তার যেসব প্রতিবেশী ভিজিট করা হয়নি, তাদেরকে Queue তে ঢুকিয়ে ভিজিটেড মার্ক করুন।

```java
public class BFSTraversal {
    public static void bfs(Graph graph, int startNode) {
        boolean[] visited = new boolean[graph.V];
        Queue<Integer> queue = new LinkedList<>();

        // ১. সোর্স নোড পুশ এবং ভিজিটেড মার্ক
        visited[startNode] = true;
        queue.add(startNode);

        System.out.print("BFS Traversal: ");

        while (!queue.isEmpty()) {
            // ২. Queue থেকে বের করা
            int current = queue.poll();
            System.out.print(current + " ");

            // ৩. প্রতিবেশীদের চেক করা
            for (int neighbor : graph.adj.get(current)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true; // Queue তে ঢোকানোর আগেই ভিজিটেড মার্ক করতে হয়!
                    queue.add(neighbor);
                }
            }
        }
        System.out.println();
    }
}
```

---

## 3. Depth-First Search (DFS) - Recursive Approach
সবচেয়ে সহজ এবং বেশি ব্যবহৃত উপায়।
**Data Structure:** Function Call Stack এবং `boolean[] visited`।

```java
public class DFSRecursive {
    // Helper/Utility Function
    private static void dfsUtil(Graph graph, int current, boolean[] visited) {
        // ১. ভিজিটেড মার্ক এবং প্রিন্ট
        visited[current] = true;
        System.out.print(current + " ");

        // ২. প্রতিবেশীদের কাছে গভীরে যাওয়া
        for (int neighbor : graph.adj.get(current)) {
            if (!visited[neighbor]) {
                dfsUtil(graph, neighbor, visited); // Recursive call
            }
        }
    }

    public static void dfs(Graph graph, int startNode) {
        boolean[] visited = new boolean[graph.V];
        System.out.print("DFS (Recursive): ");
        dfsUtil(graph, startNode, visited);
        System.out.println();
    }
}
```

---

## 4. Depth-First Search (DFS) - Iterative Approach
ইন্টারভিউতে যদি রিকার্সন ছাড়া DFS লিখতে বলে, তবে স্ট্যাক (Stack) ব্যবহার করতে হবে।
**Data Structure:** `Stack` এবং `boolean[] visited`।

```java
public class DFSIterative {
    public static void dfs(Graph graph, int startNode) {
        boolean[] visited = new boolean[graph.V];
        Stack<Integer> stack = new Stack<>();

        // ১. সোর্স নোড পুশ করা
        stack.push(startNode);

        System.out.print("DFS (Iterative): ");

        while (!stack.isEmpty()) {
            // ২. Stack থেকে পপ করা
            int current = stack.pop();

            // ৩. যদি ভিজিট না হয়ে থাকে, তবেই প্রসেস করবো (Stack এ ডুপ্লিকেট থাকতে পারে)
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");
            }

            // ৪. প্রতিবেশীদের স্ট্যাকে পুশ করা (ডান থেকে বামে পুশ করলে, পপ হবে বাম থেকে ডানে)
            List<Integer> neighbors = graph.adj.get(current);
            for (int i = neighbors.size() - 1; i >= 0; i--) {
                int neighbor = neighbors.get(i);
                if (!visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
        System.out.println();
    }
}
```

---

## 5. Connected Components (Disconnected Graph Handling)
ইন্টারভিউতে প্রায়ই বলা হয় "গ্রাফটি ডিসকানেক্টেড (Disconnected) হতে পারে"। অর্থাৎ একটি নোড থেকে শুরু করলে পুরো গ্রাফ ভিজিট নাও হতে পারে। এর জন্য আমাদের একটি লুপ চালিয়ে চেক করতে হয় কোনো নোড আনভিজিটেড আছে কি না।

```java
public class ConnectedComponents {
    public static void findComponents(Graph graph) {
        boolean[] visited = new boolean[graph.V];
        int count = 0;

        for (int i = 0; i < graph.V; i++) {
            if (!visited[i]) {
                count++;
                System.out.print("Component " + count + ": ");
                // এখানে BFS বা DFS যেকোনো একটি কল করা যায়
                DFSRecursive.dfsUtil(graph, i, visited); 
                System.out.println();
            }
        }
        System.out.println("Total Connected Components: " + count);
    }
}
```

---

## 6. Shortest Path on Unweighted Graph (Using BFS)
BFS দিয়ে সোর্স থেকে সব নোডের শর্টেস্ট ডিস্টেন্স বের করা যায়।

```java
public class ShortestPathBFS {
    public static void shortestPath(Graph graph, int startNode) {
        int[] distance = new int[graph.V];
        Arrays.fill(distance, -1); // -1 মানে এখনো পৌঁছায়নি

        Queue<Integer> queue = new LinkedList<>();
        
        distance[startNode] = 0; // সোর্সের দূরত্ব 0
        queue.add(startNode);

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int neighbor : graph.adj.get(current)) {
                if (distance[neighbor] == -1) { // আনভিজিটেড
                    // প্যারেন্টের ডিস্টেন্স + 1
                    distance[neighbor] = distance[current] + 1; 
                    queue.add(neighbor);
                }
            }
        }

        System.out.println("Shortest distances from " + startNode + ": " + Arrays.toString(distance));
    }
}
```
