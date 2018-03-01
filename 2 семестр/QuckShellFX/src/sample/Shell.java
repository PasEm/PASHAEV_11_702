package sample;

import java.util.ArrayList;

public class Shell {
    private ArrayList<Point> points;
    private ArrayList<Point> top;
    private ArrayList<Point> bot;
    private ArrayList<Point> mid;

    public Shell(ArrayList<Point> points){
        this.points = new ArrayList<>();
        this.points.addAll(points);
        this.points.sort((o1, o2) ->{
            if (o1.getX() > o2.getX())
                return 1;
            if (o1.getX() == o2.getX() && o1.getY() > o2.getY())
                return 1;
            return -1;
        });
        top = new ArrayList<>();
        bot = new ArrayList<>();
        mid = new ArrayList<>();
    }

    public void createQuickShell(){
        createArray();
        ArrayList<Point> pointsTop = new ArrayList<>();
        ArrayList<Point> pointsBot = new ArrayList<>();
        pointsTop.add(points.get(0));
        pointsTop.add(points.get(points.size() - 1));
        if (top.size() != 0)
            createPoints(new Segment(points.get(0), points.get(points.size() - 1)), top, pointsTop, 0, top.size(), false);
        else
            pointsTop.addAll(mid);
        pointsTop.sort((o1, o2) -> {
            if (o1.getX() > o2.getX())
                return 1;
            if (o1.getX() == o2.getX() && o1.getY() > o2.getY())
                return 1;
            return -1;
        });
        if (bot.size() != 0) {
            pointsBot.add(points.get(0));
            pointsBot.add(points.get(points.size() - 1));
            createPoints(new Segment(points.get(0), points.get(points.size() - 1)), bot, pointsBot, 0, bot.size(), true);
            pointsBot.remove(0);
            pointsBot.remove(0);
        } else
            pointsBot.addAll(mid);
        pointsBot.sort((o1, o2) -> {
            if (o1.getX() < o2.getX())
                return 1;
            if (o1.getX() == o2.getX() && o1.getY() < o2.getY())
                return 1;
            return -1;
        });
        points.clear();
        points.addAll(pointsTop);
        points.addAll(pointsBot);
    }

    public static ArrayList<Point> getShell(ArrayList<Point> points) {
        Shell shell = new Shell(points);
        shell.createQuickShell();
        return shell.points;
    }

    public void createArray() {
        for (int i = 1; i < points.size() - 1; i++){
            if (Segment.isTop(new Segment(points.get(0), points.get(points.size() - 1)), new Segment(points.get(0), points.get(i)))){
                if (Segment.isMid(new Segment(points.get(0), points.get(points.size() - 1)), new Segment(points.get(0), points.get(i)))) {
                    mid.add(points.get(i));
                } else
                    top.add(points.get(i));
            } else {
                bot.add(points.get(i));
            }
        }
    }

    public void createPoints(Segment edge, ArrayList<Point> points, ArrayList<Point> result, int begin, int end, boolean clockWise){
        double maxArea = -1;
        double maxAngle = -1;
        Point maxPoint = edge.getBegin();
        Segment segmentLeft, segmentRight;
        segmentLeft = segmentRight = edge;
        for (int i = begin; i < end; i++) {
            double angle = Segment.getAngle(new Segment(points.get(i), edge.getBegin()), new Segment(edge.getBegin(), edge.getEnd()));
            double area = Math.abs(Segment.triangleArea(edge.getBegin(), points.get(i), edge.getEnd()));
            if (check(segmentLeft, new Segment(edge.getBegin(), points.get(i)), clockWise) || check(new Segment(points.get(i), edge.getEnd()), segmentRight, clockWise)) {
                if (area >= maxArea) {
                    maxPoint = (area > maxArea || (maxArea == area && angle > maxAngle)) ? points.get(i) : maxPoint;
                    segmentLeft = (area > maxArea || (maxArea == area && angle > maxAngle)) ? new Segment(edge.getBegin(), maxPoint) : segmentLeft;
                    segmentRight = (area > maxArea || (maxArea == area && angle > maxAngle)) ? new Segment(maxPoint, edge.getEnd()) : segmentRight;
                    maxAngle = (area > maxArea || (maxArea == area && angle > maxAngle)) ? angle : maxAngle;
                    maxArea = area;
                }
            } else {
                points.remove(i--);
                end--;
            }
        }
        if (maxPoint != result.get(0) && maxPoint != result.get(1))
            result.add(maxPoint);
        int index = 0;
        while(points.contains(maxPoint)) {
            index = points.lastIndexOf(maxPoint);
            points.remove(maxPoint);
        }
        if (index <= points.size() && points.size() != 0 && index != 0) {
            if (segmentLeft.getBegin() != result.get(0)){
                segmentLeft = new Segment(result.get(0), segmentLeft.getEnd());
            }
            createPoints(segmentLeft, points, result, begin, index, clockWise);
        }
        if (index < points.size()) {
            if (segmentRight.getEnd() != result.get(1)){
                segmentRight = new Segment(segmentRight.getBegin(), result.get(1));
            }
            createPoints(segmentRight, points, result, index, points.size(), clockWise);
        }
    }

    private boolean check(Segment segment1, Segment segment2, boolean clockWise){
        return (!clockWise) ? Segment.isTop(segment1, segment2) : Segment.isBot(segment1, segment2);
    }
}
