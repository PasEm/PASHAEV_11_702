package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Lines");
        Scanner scanner;
        try {
            File input = new File("input.txt");
            scanner = new Scanner(input);
        }
        catch (FileNotFoundException e){
            System.err.println("No input File in program");
            throw new RuntimeException(e);
        }
        LinkedList<Point> points = new LinkedList<>();
        LinkedList<Line> lines = new LinkedList<>();
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        LinkedList<XYChart.Series> seriesList = new LinkedList<>();
        while(scanner.hasNext()){
            points.add(new Point(scanner.nextInt(),scanner.nextInt()));
        }
        points.sort((o1, o2) -> {
            if (o1.getX() > o2.getX()) {
                return 1;
            }
            if (o2.getX() == o1.getX() && o1.getY() > o2.getY()){
                return 1;
            }
            return -1;
        });
        int pointCount = points.size();
        for (Point point: points) {
            int index = binLineFounder(lines, point, 0, lines.size() - 1);
            if (index != -1) {
                lines.get(index).addPoint(point);
            } else {
                lines.add(new Line());
                lines.get(lines.size() - 1).addPoint(point);
            }
        }
        int currentLineIndex, index, pointIndex;
        index = pointIndex = currentLineIndex = 0;
        seriesList.add(new XYChart.Series());
        seriesList.get(currentLineIndex).setName("Line" + ++index);
        for (int i = 0; i < pointCount; i++){
            if (pointIndex != lines.get(currentLineIndex).getCount()){
                seriesList.get(currentLineIndex).getData().add(new XYChart.Data(lines.get(currentLineIndex).getPoint(pointIndex).getX(), lines.get(currentLineIndex).getPoint(pointIndex).getY()));
                pointIndex++;
            } else {
                currentLineIndex++;
                pointIndex = 0;
                seriesList.add(new XYChart.Series());
                seriesList.get(currentLineIndex).setName("Line" + ++index);
                seriesList.get(currentLineIndex).getData().add(new XYChart.Data(lines.get(currentLineIndex).getPoint(pointIndex).getX(), lines.get(currentLineIndex).getPoint(pointIndex).getY()));
                pointIndex++;
            }
        }
        for (XYChart.Series s : seriesList){
            lineChart.getData().add(s);
        }
        primaryStage.setScene(new Scene(lineChart, 1080, 720));
        primaryStage.show();
    }

    public static int binLineFounder(LinkedList<Line> lines, Point point, int left, int right){
        int length;
        if (lines.size() == 0){
            return -1;
        }
        while (right - left > 1)
        {
            int mid = left + (right - left) / 2;
            length = lines.get(mid).getCount() - 1;
            if (lines.get(mid).getPoint(length).getY() > point.getY()){
                left = mid;
            } else{
                right = mid;
            }
        }
        length = lines.get(left).getCount() - 1;
        if (point.getY() >= lines.get(left).getPoint(length).getY() && point.getX() >= lines.get(left).getPoint(length).getX()){
            right = left;
        } else {
            length = lines.get(right).getCount() - 1;
            if (point.getY() < lines.get(right).getPoint(length).getY() || point.getX() < lines.get(right).getPoint(length).getX()) {
                right = -1;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        launch(args);
    }
}