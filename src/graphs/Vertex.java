package graphs;

import java.util.HashMap;
import java.util.Iterator;

/**
 * Created by Joseph on 2/10/2016.
 */
public class Vertex<V> {

    private HashMap<Vertex<V>, Integer> neighbours;
    private V value;

    public Vertex(V value) {
        neighbours = new HashMap<>();
        this.value = value;
    }

    public Vertex() {
        this(null);
    }

    public boolean hasValue() {
        return value != null;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public void addNeighbour(Vertex<V> vertex, int weight) {
        neighbours.put(vertex, weight);
    }

    public void addNeighbour(Vertex<V> vertex) {
        addNeighbour(vertex, 0);
    }

    public boolean hasNeighbour(Vertex<V> vertex) {
        return neighbours.containsKey(vertex);
    }

    public int getWeightToNeighbour(Vertex<V> vertex) {
        return neighbours.getOrDefault(vertex, Integer.MAX_VALUE);
    }

    public Iterator<Vertex<V>> neighbourIterator() {
        return neighbours.keySet().iterator();
    }

}
