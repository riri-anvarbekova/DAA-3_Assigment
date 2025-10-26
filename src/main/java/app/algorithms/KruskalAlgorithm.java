package main.java.app.algorithms;



import main.java.app.model.Edge;
import main.java.app.model.Graph;
import main.java.app.model.MSTResult;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KruskalAlgorithm {
    public static MSTResult kruskal(Graph graph) {
        long start = System.nanoTime();

        List<Edge> edges = new ArrayList<>(graph.edges);
        Collections.sort(edges);

        UnionFind uf = new UnionFind(graph.vertices);

        List<Edge> mstEdges = new ArrayList<>();
        int totalCost = 0, operations = 0;

        for (Edge e : edges) {
            operations++;
            if (uf.union(e.from, e.to)) {
                mstEdges.add(e);
                totalCost += e.weight;
            }
        }

        MSTResult res = new MSTResult();
        res.mstEdges = mstEdges;
        res.totalCost = totalCost;
        res.operationsCount = operations;
        res.executionTimeMs = (System.nanoTime() - start) / 1_000_000.0;
        return res;
    }
}
