package graphs;

/**
 * Created by Joseph on 2/10/2016.
 */
public class MatrixGraph {

    private int numVertices;
    private int[][] weights;

    public MatrixGraph(int numVertices) {
        this.numVertices = numVertices;
        weights = new int[numVertices][numVertices];

        // Initialise all weights except down the diagonal to be infinite
        resetWeights();
    }

    private void resetWeights() {
        for (int i = 0; i < numVertices; ++i) for (int j = 0; j < numVertices; ++j) {
            if (i == j) {
                weights[i][j] = 0;
            } else {
                weights[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public int[][] getWeightMatrix() {
        int[][] copy = new int[numVertices][numVertices];
        for (int i = 0; i < numVertices; ++i) {
            copy[i] = weights[i].clone();
        }

        return copy;
    }

    public int size() {
        return numVertices;
    }

    public void addEdge(int v1, int v2, int weight) {
        weights[v1][v2] = weight;
    }

    public void addUndirectedEdge(int v1, int v2, int weight) {
        addEdge(v1, v2, weight);
        addEdge(v2, v1, weight);
    }

    public boolean hasEdge(int v1, int v2) {
        return weights[v1][v2] < Integer.MAX_VALUE;
    }

    public int getEdge(int v1, int v2) {
        return weights[v1][v2];
    }

    public static String matrixToString(int[][] matrix) {
        StringBuilder s = new StringBuilder();

        for (int from = 0; from < matrix.length; ++from) {
            String sep = "";
            for (int to = 0; to < matrix[from].length; ++to) {
                s.append(sep);
                if (matrix[from][to] < Integer.MAX_VALUE) {
                    s.append(matrix[from][to]);
                } else {
                    s.append('x');
                }
                sep = " ";
            }
            s.append('\n');
        }

        return s.toString();
    }

    public String toString() {
        return matrixToString(weights);
    }

}
