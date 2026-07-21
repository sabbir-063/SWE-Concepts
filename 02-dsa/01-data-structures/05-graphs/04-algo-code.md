# 05. Graph Algorithms (Advanced Implementations)

এই ফাইলে গ্রাফের ৮টি সবচেয়ে গুরুত্বপূর্ণ অ্যাডভান্সড অ্যালগরিদমের কনসাইজ (Concise) জাভা ইমপ্লিমেন্টেশন দেওয়া হলো। ইন্টারভিউ বা কম্পিটিটিভ প্রোগ্রামিংয়ে এগুলো টেমপ্লেট হিসেবে ব্যবহার করা যায়।

---

## 1. Dijkstra's Algorithm (Shortest Path)
**টাইম কমপ্লেক্সিটি:** $O(E \log V)$ (PriorityQueue এর কারণে)।
**শর্ত:** নেগেটিভ ওয়েট থাকা যাবে না।

```java
import java.util.*;

class Node implements Comparable<Node> {
    int v, weight;
    public Node(int v, int weight) { this.v = v; this.weight = weight; }
    public int compareTo(Node other) { return this.weight - other.weight; } // ছোট ওয়েট আগে আসবে
}

public class Dijkstra {
    public static void dijkstra(List<List<Node>> adj, int source, int V) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(source, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.v;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.v;
                int weight = neighbor.weight;

                // Relaxation
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new Node(v, dist[v]));
                }
            }
        }
        
        System.out.println("Distances from Source " + source + ": " + Arrays.toString(dist));
    }
}
```

---

## 2. Bellman-Ford Algorithm (Shortest Path with Negative Weights)
**টাইম কমপ্লেক্সিটি:** $O(V \times E)$।
**শর্ত:** $V-1$ বার রিল্যাক্স করতে হবে। $V$ তম বারে যদি আপডেট হয়, তবে Negative Cycle আছে!

```java
class Edge { int u, v, weight; }

public class BellmanFord {
    public static void bellmanFord(List<Edge> edges, int V, int E, int source) {
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[source] = 0;

        // V - 1 বার সব এজ রিল্যাক্স করা
        for (int i = 1; i < V; i++) {
            for (Edge edge : edges) {
                if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                    dist[edge.v] = dist[edge.u] + edge.weight;
                }
            }
        }

        // Negative Cycle চেক করা
        for (Edge edge : edges) {
            if (dist[edge.u] != Integer.MAX_VALUE && dist[edge.u] + edge.weight < dist[edge.v]) {
                System.out.println("Graph contains negative weight cycle!");
                return;
            }
        }
        System.out.println("Distances from Source: " + Arrays.toString(dist));
    }
}
```

---

## 3. Floyd-Warshall Algorithm (All-Pairs Shortest Path)
**টাইম কমপ্লেক্সিটি:** $O(V^3)$।

```java
public class FloydWarshall {
    final static int INF = 99999; // Integer.MAX_VALUE দিলে যোগ করার সময় overflow হতে পারে

    public static void floydWarshall(int[][] graph, int V) {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                dist[i][j] = graph[i][j];

        // i থেকে j তে যাওয়ার জন্য k কে মাধ্যম (intermediate) হিসেবে ব্যবহার করা
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }
}
```

---

## 4. Union-Find / Disjoint Set (Cycle Detection in Undirected Graph)
**টাইম কমপ্লেক্সিটি:** $O(\alpha(V))$ (Path Compression এর কারণে প্রায় $O(1)$)।

```java
public class UnionFind {
    int[] parent, rank;

    public UnionFind(int n) {
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i; // শুরুতে সবাই নিজের প্যারেন্ট
    }

    // Path Compression
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]); 
    }

    // Union by Rank
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);

        if (rootX != rootY) {
            if (rank[rootX] < rank[rootY]) {
                parent[rootX] = rootY;
            } else if (rank[rootX] > rank[rootY]) {
                parent[rootY] = rootX;
            } else {
                parent[rootY] = rootX;
                rank[rootX]++;
            }
        }
    }
}
```

---

## 5. Kruskal's Algorithm (Minimum Spanning Tree)
**টাইম কমপ্লেক্সিটি:** $O(E \log E)$। 
**নোট:** এজগুলোকে ওয়েট অনুযায়ী সর্ট করে Union-Find ব্যবহার করতে হয়।

```java
// Edge ক্লাসটি Bellman-Ford এর মতোই, তবে Comparable ইমপ্লিমেন্ট করবে
class KruskalEdge implements Comparable<KruskalEdge> {
    int u, v, weight;
    public int compareTo(KruskalEdge other) { return this.weight - other.weight; }
}

public class KruskalMST {
    public static void kruskal(List<KruskalEdge> edges, int V) {
        Collections.sort(edges); // এজগুলোকে ছোট থেকে বড় সাজানো
        UnionFind uf = new UnionFind(V);
        int cost = 0;

        for (KruskalEdge edge : edges) {
            // যদি লুপ তৈরি না হয়, তবেই এজটি MST তে নেওয়া হবে
            if (uf.find(edge.u) != uf.find(edge.v)) {
                uf.union(edge.u, edge.v);
                cost += edge.weight;
                System.out.println(edge.u + " - " + edge.v + " : " + edge.weight);
            }
        }
        System.out.println("Total MST Cost: " + cost);
    }
}
```

---

## 6. Prim's Algorithm (Minimum Spanning Tree)
**টাইম কমপ্লেক্সিটি:** $O(E \log V)$।

```java
public class PrimsMST {
    public static void prims(List<List<Node>> adj, int V) {
        boolean[] inMST = new boolean[V];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        pq.add(new Node(0, 0)); // 0 নম্বর নোড থেকে শুরু
        int mstCost = 0;

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int u = current.v;

            if (inMST[u]) continue; // আগেই MST তে থাকলে স্কিপ

            inMST[u] = true;
            mstCost += current.weight;

            for (Node neighbor : adj.get(u)) {
                if (!inMST[neighbor.v]) {
                    pq.add(new Node(neighbor.v, neighbor.weight));
                }
            }
        }
        System.out.println("Total MST Cost: " + mstCost);
    }
}
```

---

## 7. Topological Sort (Using DFS)
**টাইম কমপ্লেক্সিটি:** $O(V + E)$।
**শর্ত:** শুধুমাত্র Directed Acyclic Graph (DAG) এ কাজ করে।

```java
public class TopologicalSort {
    private static void dfs(int v, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int neighbor : adj.get(v)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, stack);
            }
        }
        stack.push(v); // একদম শেষ প্রান্তে গিয়ে স্ট্যাকে ঢোকানো
    }

    public static void topoSort(List<List<Integer>> adj, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, adj, visited, stack);
            }
        }

        System.out.print("Topological Sort: ");
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
```

---

## 8. Kosaraju's Algorithm (Strongly Connected Components - SCC)
**টাইম কমপ্লেক্সিটি:** $O(V + E)$।
**কাজ:** Directed Graph-এ এমন এরিয়া খুঁজে বের করা যেখানে সব নোড একে অপরের কাছে পৌঁছাতে পারে।

```java
// সংক্ষেপে ৩টি ধাপ:
// 1. মেইন গ্রাফে DFS চালিয়ে শেষ হওয়ার টাইম অনুযায়ী নোডগুলোকে স্ট্যাকে রাখা (Topological sort এর মতো)।
// 2. গ্রাফের সব এজ উল্টে দেওয়া (Transpose the graph)।
// 3. স্ট্যাক থেকে পপ করে উল্টানো গ্রাফে DFS চালানো। প্রতিটি DFS কলই একটি নতুন SCC।

public class KosarajuSCC {
    // DFS 1: স্ট্যাক ফিল করা
    private static void fillOrder(int v, List<List<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[v] = true;
        for (int n : adj.get(v)) if (!visited[n]) fillOrder(n, adj, visited, stack);
        stack.push(v);
    }

    // DFS 2: উল্টানো গ্রাফ ট্রাভার্স করা
    private static void dfsTranspose(int v, List<List<Integer>> transAdj, boolean[] visited) {
        visited[v] = true;
        System.out.print(v + " ");
        for (int n : transAdj.get(v)) if (!visited[n]) dfsTranspose(n, transAdj, visited);
    }

    public static void getSCCs(List<List<Integer>> adj, int V) {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Step 1
        for (int i = 0; i < V; i++) if (!visited[i]) fillOrder(i, adj, visited, stack);

        // Step 2: Transpose graph তৈরি করা
        List<List<Integer>> transpose = new ArrayList<>();
        for (int i = 0; i < V; i++) transpose.add(new ArrayList<>());
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) transpose.get(neighbor).add(i); // i->neighbor কে neighbor->i করা
        }

        // Step 3
        Arrays.fill(visited, false);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            if (!visited[v]) {
                System.out.print("SCC: ");
                dfsTranspose(v, transpose, visited);
                System.out.println();
            }
        }
    }
}
```
