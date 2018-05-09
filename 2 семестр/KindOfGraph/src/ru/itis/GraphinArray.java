package ru.itis;

import javafx.util.Pair;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class GraphinArray {
    private ArrayList<Pair<Integer, Integer>> edges;
    private int countVertex;
    private int arraySize;
    private int[] graph;

    public GraphinArray(String fileName){
        this.edges = new ArrayList<>();
        this.countVertex = this.arraySize = 0;
        initialization(fileName);
        buildGraph();
    }

    private void initialization(String fileName){
        try (BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)))){
            while(reader.ready()){
                String edge = reader.readLine();
                int vertex = Integer.parseInt(edge.substring(0, edge.indexOf(' ')));
                int to = Integer.parseInt(edge.substring(edge.indexOf(' ') + 1));
                edges.add(new Pair<>(vertex, to));
                countVertex = Math.max(countVertex, Math.max(vertex, to));
                arraySize++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        graph = new int[++countVertex + arraySize];
        for (int i = 0; i < graph.length; i++)
            graph[i] = -1;
    }

    private void buildGraph(){
        for (Pair<Integer, Integer> edge: edges){
            graph[edge.getKey()] = (graph[edge.getKey()] == -1) ? 1 : graph[edge.getKey()] + 1;
        }
        int indexVertexEdges = countVertex;
        for (int i = 0; i < countVertex; i++){
            if (graph[i] != -1) {
                int countEdges = graph[i];
                graph[i] = indexVertexEdges;
                indexVertexEdges += countEdges;
            }
        }
        for (Pair<Integer, Integer> edge: edges){
            if (graph[graph[edge.getKey()]] != -1){
                int emptyPlace = graph[edge.getKey()] + 1;
                for (; graph[emptyPlace] != -1; emptyPlace++);
                graph[emptyPlace] = edge.getValue();
            } else {
                graph[graph[edge.getKey()]] = edge.getValue();
            }
        }
    }

    public void printGraph(){
        System.out.println(Arrays.toString(graph));
    }
}
