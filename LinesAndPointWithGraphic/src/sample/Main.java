package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.File;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Lines");
        File input = new File("C:\\Users\\bloof\\Desktop\\PASHAEV_11_702\\LinesAndPointWithGraphic\\src\\sample\\input.txt");
        Scanner scanner = new Scanner(input);
        LinkedList<Point> points = new LinkedList<>();
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        LinkedList<XYChart.Series> seriesList = new LinkedList<>();
        while(scanner.hasNext()){
            points.add(new Point(scanner.nextInt(),scanner.nextInt()));
        }
        points.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.getX() > o2.getX()) {
                    return 0;
                }
                if (o2.getX() == o1.getX() && o1.getY() > o2.getY()){
                    return 0;
                }
                return -1;
            }
        });
        int index = 0;
        for (int i = 0; i < points.size();){
            Line line = new Line();
            line.addPoint(points.get(0));
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(line.getLastPoint().getX(), line.getLastPoint().getY()));
            points.remove(0);
            for (int j = 0; j < points.size(); j++)
            {
                if (line.getLastPoint().getY() <= points.get(j).getY() && line.getLastPoint().getX() <= points.get(j).getX()){
                    line.addPoint(points.get(j));
                    series.getData().add(new XYChart.Data(line.getLastPoint().getX(), line.getLastPoint().getY()));
                    points.remove(j);
                    j--;
                }
            }
            series.setName("Line" + ++index);
            seriesList.add(series);
        }
        for (XYChart.Series s : seriesList){
            lineChart.getData().add(s);
        }
        primaryStage.setScene(new Scene(lineChart, 1080, 720));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
