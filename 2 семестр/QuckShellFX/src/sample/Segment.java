package sample;

public class Segment {
    private Point begin;
    private Point end;

    public Segment(Point begin, Point end){
        this.begin = begin;
        this.end = end;
    }

    public static boolean isTop(Segment segment1, Segment segment2){
        return (Math.sin(getAngle(segment1, segment2)) >= 0);
    }

    public static boolean isMid(Segment segment1, Segment segment2){
        return (Math.sin(getAngle(segment1, segment2)) == 0);
    }

    public static boolean isBot(Segment segment1, Segment segment2){
        return (Math.sin(getAngle(segment1, segment2)) <= 0);
    }

    public static Point getVector(Point begin, Point end){
        return new Point(end.getX() - begin.getX(), end.getY() - begin.getY());
    }

    public static double getLength(Segment segment){
        Point vector = getVector(segment.getBegin(), segment.getEnd());
        return  Math.sqrt(vector.getX() * vector.getX() + vector.getY() * vector.getY());
    }

    public static double getAngle(Segment segment1, Segment segment2){
        double length1 = getLength(segment1);
        double length2 = getLength(segment2);
        Point vector1 = getVector(segment1.getBegin(), segment1.getEnd());
        Point vector2 = getVector(segment2.getBegin(), segment2.getEnd());
        return Math.asin((vector1.getX() * vector2.getY() - vector1.getY() * vector2.getX()) / (length1 * length2));
    }

    public static boolean isClockArea(Point point1, Point point2, Point point3){
        return Segment.triangleArea(point1, point2, point3) > 0;
    }

    public static double triangleArea(Point point1, Point point2, Point point3){
        return (point2.getX() - point1.getX()) * (point3.getY() - point1.getY()) - (point2.getY() - point1.getY()) * (point3.getX() - point1.getX());
    }

    public Point getBegin() {
        return begin;
    }

    public Point getEnd() {
        return end;
    }
}
