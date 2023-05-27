package exercise;

import java.util.List;

// BEGIN
public class Segment {
    private Point begin;
    private Point end;
    public Segment() {
    }
    public Segment(Point begin, Point end) {
        this.begin = begin;
        this.end = end;
    }
    public Point getBeginPoint() {
        return begin;
    }
    public Point getEndPoint() {
        return end;
    }
    public Point getMidPoint() {
        var midX = (begin.getX() + end.getX()) / 2;
        var midY = (begin.getY() + end.getY()) / 2;
        return new Point(midX, midY);
    }
}
// END
