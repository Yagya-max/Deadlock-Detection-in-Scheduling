import java.util.*;

public class DeadlockDetector {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Number of processes must be positive!");
            sc.close();
            return;
        }

        WaitForGraph graph = new WaitForGraph(n);

        System.out.println("\n=== Add Wait-For Edges ===");
        System.out.println("(from -> to means 'from' is waiting for resource held by 'to')");
        System.out.println("Enter -1 as 'From process' to finish adding edges.\n");

        while (true) {
            System.out.print("From process (0 to " + (n-1) + ", or -1 to stop): ");
            int from = sc.nextInt();

            if (from == -1) {
                break;
            }

            if (from < 0 || from >= n) {
                System.out.println("Invalid 'from' process! Must be between 0 and " + (n-1) + ".\n");
                continue;
            }

            System.out.print("To process (0 to " + (n-1) + "): ");
            int to = sc.nextInt();

            if (to < 0 || to >= n) {
                System.out.println("Invalid 'to' process! Must be between 0 and " + (n-1) + ".\n");
                continue;
            }

            graph.addWaitForEdge(from, to);
            System.out.println("Added edge: " + from + " -> " + to + "\n");
        }

        // Show the graph
        graph.printGraph();

        // Detect deadlock
        List<Integer> cycle = graph.detectDeadlock();

        if (cycle != null && !cycle.isEmpty()) {
            System.out.println("*** DEADLOCK DETECTED! ***");
            System.out.print("One cycle causing deadlock: ");
            for (int i = 0; i < cycle.size(); i++) {
                System.out.print(cycle.get(i));
                if (i < cycle.size() - 1) System.out.print(" -> ");
            }
            System.out.println("\n");
        } else {
            System.out.println("No deadlock detected. The system is safe.\n");
        }

        // Pre-defined test cases (always shown)
        System.out.println("=== Pre-defined Test Cases ===");

        System.out.println("\nTest Case 1: Deadlock (cycle 0→1→2→0)");
        WaitForGraph g1 = new WaitForGraph(3);
        g1.addWaitForEdge(0, 1);
        g1.addWaitForEdge(1, 2);
        g1.addWaitForEdge(2, 0);
        g1.printGraph();
        List<Integer> c1 = g1.detectDeadlock();
        if (c1 != null) {
            System.out.print("Deadlock cycle: ");
            for (int i = 0; i < c1.size(); i++) {
                System.out.print(c1.get(i) + (i < c1.size()-1 ? " -> " : ""));
            }
            System.out.println("\n");
        }

        System.out.println("Test Case 2: No deadlock (chain)");
        WaitForGraph g2 = new WaitForGraph(4);
        g2.addWaitForEdge(0, 1);
        g2.addWaitForEdge(1, 2);
        g2.addWaitForEdge(2, 3);
        g2.printGraph();
        if (g2.detectDeadlock() == null) {
            System.out.println("No deadlock detected.\n");
        }

        sc.close();
    }
}