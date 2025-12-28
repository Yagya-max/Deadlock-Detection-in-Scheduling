import java.util.*;

public class WaitForGraph {
    private int numProcesses;
    private List<List<Integer>> adjList;

    public WaitForGraph(int numProcesses) {
        this.numProcesses = numProcesses;
        adjList = new ArrayList<>();
        for (int i = 0; i < numProcesses; i++) {
            adjList.add(new ArrayList<>());
        }
    }

    public void addWaitForEdge(int fromProcess, int toProcess) {
        adjList.get(fromProcess).add(toProcess);
    }

    // Improved cycle detection: returns a clean simple cycle
    private boolean dfsCycleDetect(int node, boolean[] visited, boolean[] recStack, 
                                   Deque<Integer> path, List<Integer> cycle) {
        visited[node] = true;
        recStack[node] = true;
        path.addLast(node);

        for (int neighbor : adjList.get(node)) {
            if (!visited[neighbor]) {
                if (dfsCycleDetect(neighbor, visited, recStack, path, cycle)) {
                    return true;
                }
            } else if (recStack[neighbor]) {
                // Cycle found! Extract from neighbor back to neighbor
                boolean started = false;
                for (Integer p : path) {
                    if (p == neighbor) started = true;
                    if (started) cycle.add(p);
                }
                cycle.add(neighbor);  // close the cycle
                return true;
            }
        }

        recStack[node] = false;
        path.removeLast();
        return false;
    }

    public List<Integer> detectDeadlock() {
        boolean[] visited = new boolean[numProcesses];
        boolean[] recStack = new boolean[numProcesses];
        List<Integer> cycle = new ArrayList<>();

        for (int i = 0; i < numProcesses; i++) {
            if (!visited[i]) {
                Deque<Integer> path = new ArrayDeque<>();
                if (dfsCycleDetect(i, visited, recStack, path, cycle)) {
                    return cycle;  // return the first found cycle
                }
            }
        }
        return null;
    }

    public void printGraph() {
        System.out.println("Current Wait-For Graph:");
        for (int i = 0; i < numProcesses; i++) {
            System.out.print("Process " + i + " waits for -> ");
            if (adjList.get(i).isEmpty()) {
                System.out.print("nothing");
            } else {
                for (int neighbor : adjList.get(i)) {
                    System.out.print(neighbor + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}