package graphs;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Reads in a weighted adjacency matrix from a file with space separated rows
 *
 * An non number value in a matrix position indicates no edge
 */
public class MatrixGraphIO {

    public static MatrixGraph read(String filename) throws IOException {

        List<String> rows = Files.readAllLines(Paths.get(filename));

        // Discard empty lines
        rows.removeAll(Collections.singleton(""));

        MatrixGraph g = new MatrixGraph(rows.size());

        for (int from = 0; from < rows.size(); ++from) {
            // Split on any number of spaces
            String[] values = rows.get(from).split(" +");

            for (int to = 0; to < Math.min(rows.size(), values.length); ++to) {
                try {
                    g.addEdge(from, to, Integer.parseInt(values[to].trim()));
                } catch (NumberFormatException e) {}
            }
        }

        return g;
    }

    public static void write(MatrixGraph g, String filename) throws IOException {
        PrintWriter writer = new PrintWriter(filename);

        writer.print(g.toString());

        writer.close();
    }

}
