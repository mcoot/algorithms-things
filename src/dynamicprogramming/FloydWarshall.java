package dynamicprogramming;

import graphs.*;

import java.io.IOException;

/**
 * Created by Joseph on 2/10/2016.
 */
public class FloydWarshall {

    public static void main(String[] args) throws IOException {
        MatrixGraph g = MatrixGraphIO.read("matrixgraphs/matrixGraph1");
        System.out.print(g.toString());
    }



}
