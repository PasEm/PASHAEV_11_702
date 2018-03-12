package ru.itis;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;

public class TopologicalSorter {
    private ArrayList<ArrayList<Integer>> graph;
    private ArrayList<Pair<Integer, Integer>> used;
    private ArrayList<Integer> answer;
    private long time;
    private long iteration;
    private boolean checkCycle;

    private TopologicalSorter(Edge[] input, boolean checkCycle){
        this.checkCycle = checkCycle;
        this.used = new ArrayList<>();
        this.graph = new ArrayList<>();
        if (!checkCycle) {
            this.answer = new ArrayList<>();
            this.time = 0;
            this.iteration = 0;
        }
        ArrayList<Edge> input1 = new ArrayList<>();
        for (Edge edge : input) {
            if (edge == null)
                break;
            if (!input1.contains(edge))
                input1.add(edge);
            if (!used.contains(new Pair<>(edge.getBegin(), 0)))
                used.add(new Pair<>(edge.getBegin(), 0));
            if (!used.contains(new Pair<>(edge.getEnd(), 0)))
                used.add(new Pair<>(edge.getEnd(), 0));
        }
        used.sort(((o1, o2) -> {
            if (o1.getKey() > o2.getKey())
                return 1;
            return -1;
        }));
        input1.sort(((o1, o2) -> {
            if (o1.getBegin() > o2.getBegin())
                return 1;
            if (o1.getBegin() == o2.getBegin() && o1.getEnd() > o2.getEnd())
                return 0;
            return -1;
        }));
       for (int i = 0; i < used.size(); i++)
            graph.add(new ArrayList<>());
        for (int i = 0; i < input1.size(); i++) {
            graph.get(used.indexOf(new Pair<>(input1.get(i).getBegin(), 0))).add(input1.get(i).getEnd());
        }
    }

    private void dfs(int v){
        used.set(v, new Pair<>(used.get(v).getKey(), 1));
        for (int i = 0; i < graph.get(v).size(); i++, this.iteration++) {
            int to = graph.get(v).get(i);
            if (used.contains(new Pair<>(to, 0))) {
                dfs(used.indexOf(new Pair<>(to, 0)));
            }else if(used.contains(new Pair<>(to, 1)))
                throw new IllegalArgumentException();
        }
        used.set(v, new Pair<>(used.get(v).getKey(), 2));
        if (!this.checkCycle)
            answer.add(used.get(v).getKey());
    }

    private void topologicalSort() {
        for (int i = 0; i < used.size(); i++, this.iteration++)
            if (used.get(i).getValue() == 0)
                dfs(i);
        if (!this.checkCycle)
            Collections.reverse(answer);
    }

    public static ArrayList<Integer> getSort(Edge[] input){
        TopologicalSorter sorter = new TopologicalSorter(input, false);
        sorter.time = System.currentTimeMillis();
        sorter.topologicalSort();
        sorter.time = System.currentTimeMillis() - sorter.time;
        DataWriter.writeData(input.length, sorter.iteration, sorter.time);
        return sorter.answer;
    }

    public static boolean checkCyclic(Edge[] input){
        TopologicalSorter sorter = new TopologicalSorter(input, true);
        try {
            sorter.topologicalSort();
        }
        catch (IllegalArgumentException e){
            return true;
        }
        return false;
    }

    public long getIteration() {
        return iteration;
    }

    public long getTime() {
        return time;
    }
}
