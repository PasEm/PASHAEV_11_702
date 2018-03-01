package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Shell");
        ArrayList<Point> points = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(new File("input.txt")))){
            while(reader.ready()){
                String input = reader.readLine();
                double first, second;
                first = Double.parseDouble(input.substring(0, input.indexOf(' ')));
                second = Double.parseDouble(input.substring(input.indexOf(' ') + 1));
                points.add(new Point(first, second));
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        ArrayList<Point> result = Shell.getShell(points);
        points.removeAll(result);
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        final LineChart<Number,Number> lineChart = new LineChart<>(xAxis,yAxis);
        ArrayList<XYChart.Series> seriesList = new ArrayList<>();
        seriesList.add(new XYChart.Series());
        seriesList.add(new XYChart.Series());
        seriesList.get(0).setName("ShellTop");
        seriesList.get(1).setName("ShellBot");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(new File("output.txt")))){
            for (Point aResult : result) {
                writer.write(String.valueOf(aResult.getX()) + ' ' + aResult.getY());
                writer.write('\n');
            }
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
        int index = -1;
        for (int i = 0; i < result.size() - 1; i++){
            seriesList.get(0).getData().add(new XYChart.Data(result.get(i).getX(), result.get(i).getY()));
            if (result.get(i).getX() > result.get(i + 1).getX()){
                index = i;
                break;
            }
        }
        for (int i = index; i < result.size(); i++){
            seriesList.get(1).getData().add(new XYChart.Data(result.get(i).getX(), result.get(i).getY()));
        }
        seriesList.get(1).getData().add(new XYChart.Data(result.get(0).getX(), result.get(0).getY()));
        for (int i = 0; i < points.size(); i++){
            seriesList.add(new XYChart.Series());
            seriesList.get(i + 2).getData().add(new XYChart.Data(points.get(i).getX(), points.get(i).getY()));
        }
        for (XYChart.Series s : seriesList)
            lineChart.getData().add(s);
        primaryStage.setScene(new Scene(lineChart, 1080, 720));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
