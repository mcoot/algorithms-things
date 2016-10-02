package dynamicprogramming;

import graphs.*;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Joseph on 2/10/2016.
 */
public class AllPairsShortestPath {

    public static void main(String[] args) throws IOException {
        MatrixGraph g = MatrixGraphIO.read("matrixgraphs/graphFromWikipedia");
        System.out.print(g.toString());
        System.out.println("PATHS:");
        System.out.println(MatrixGraph.matrixToString(slowAPSP(g)));
    }

    /**
     * A dynamic programming implementation of APSP, with no optimisation
     * Complexity: O(n^4)
     */
    public static int[][] slowAPSP(MatrixGraph graph) {
        int n = graph.size();

        // Store the dp cache in a 3D array
        // For indices (i,j,k) paths[k][i][j] is the shortest path from i to j using at most k edges
        // Graph is initialised with infinite values (O(n^3))
        int[][][] paths = initWeightValuesToInfinite(n);

        // Initialise matrix 0 to be 0 along the diagonal, infinite elsewhere
        // O(n)
        for (int i = 0; i < n; ++i) {
            paths[0][i][i] = 0;
        }
        // Initialise matrix 1 to be the weights
        // O(n^2)
        paths[1] = graph.getWeightMatrix();

        // Iterate over all possible path lengths
        for (int m = 2; m < n; ++m) {
            int[][] prev = paths[m - 1];
            int[][] current = paths[m];

            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    for (int k = 0; k < n; ++k) {
                        if (graph.hasEdge(k, j) && prev[i][k] < Integer.MAX_VALUE) {
                            current[i][j] = Math.min(current[i][j], prev[i][k] + graph.getEdge(k, j));
                        }
                    }
                }
            }
        }

        // Return the shortest paths for all pairs with at most n - 1 edges
        return paths[n - 1];
    }

    private static int[][][] initWeightValuesToInfinite(int size) {
        int[][][] result = new int[size][][];

        for (int k = 0; k < size; ++k) {
            result[k] = new int[size][size];
            for (int i = 0; i < size; ++i) {
                Arrays.fill(result[k][i], Integer.MAX_VALUE);
            }
        }

        return result;
    }

}
