package ru.itis;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class GraphCreater {
    private Random random;
    private int size;
    private static final GraphCreater instance;
    private String fileName;

    private GraphCreater(){
        this.random = new Random();
        this.size = 100;
        this.fileName = "Resources/Input/input";
     //   create();
    }

    public void create(){
        this.size = 4700;
        for (int j = 46; j < 50; j++, this.size += 100) {
            int count = 0;
            Edge[] graph = new Edge[this.size];
            ArrayList<Edge> edges = new ArrayList<>();
            ArrayList<Integer>  vertex = new ArrayList<>();
            for (int i = 0; i < this.size; i++){
                int begin = random.nextInt(this.size), end = random.nextInt(this.size);
                while(end == begin || begin < 0 || end < 0 || edges.contains(new Edge(end, begin)) || edges.contains(new Edge(end, begin))){
                    if (begin < 0)
                        begin = random.nextInt(this.size);
                    if (end == begin || end < 0 || edges.contains(new Edge(end, begin)) || edges.contains(new Edge(begin, end)))
                    end = random.nextInt(this.size);
                }
                graph[count++] = new Edge(begin, end);
                while(TopologicalSorter.checkCyclic(graph)) {
                    end = end + random.nextInt(this.size) + this.size / 2;
                    graph[count - 1] = new Edge(graph[count - 1].getBegin(), end);
                }
                edges.add(new Edge(begin, end));
                if (!vertex.contains(begin))
                    vertex.add(begin);
                if (!vertex.contains(end))
                    vertex.add(end);
            }
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName + (j + 1) + ".txt"))){
                for (Edge edge: graph){
                    writer.write(String.valueOf(edge.getBegin()) + ' ' + String.valueOf(edge.getEnd()));
                    writer.newLine();
                }
            }
            catch (IOException e){
                throw new RuntimeException();
            }
        }
        this.size = 100;
    }

    public Edge[] getInput(){
        Edge[] result = new Edge[this.size];
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName + (this.size / 100) + ".txt"))) {
            for (int i = 0; i < this.size; i++) {
                String input = reader.readLine();
                int begin = Integer.parseInt(input.substring(0, input.indexOf(' ')));
                int end = Integer.parseInt(input.substring(input.indexOf(' ') + 1));
                result[i] = new Edge(begin, end);
            }
        }
        catch (IOException e) {
            throw new RuntimeException();
        }
        this.size += 100;
        return result;
    }

    static {
        instance = new GraphCreater();
    }

    public static GraphCreater getGraphCreater(){
        return instance;
    }
}
