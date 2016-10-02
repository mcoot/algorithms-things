package graphs;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by Joseph on 2/10/2016.
 */
public class Graph<V> {

    private List<Vertex<V>> vertices;

    public Graph() {
        vertices = new ArrayList<>();
    }

    public int addVertex(V value) {
        vertices.add(new Vertex<>(value));
        return vertices.size() - 1;
    }

    public int addVertex(Vertex<V> vertex) {
        vertices.add(vertex);
        return vertices.size() - 1;
    }

    public Vertex get(int index) {
        return vertices.get(index);
    }

    public int size() {
        return vertices.size();
    }

}
