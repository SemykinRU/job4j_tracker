package ru.job4j.oop;

public class Triangle {

    private Point first;
    private Point second;
    private Point third;

    public Triangle(Point ap, Point bp, Point cp) {
        this.first = ap;
        this.second = bp;
        this.third = cp;
    }

    public double period(double a, double b, double c) {
        return (a + b + c) / 2;
    }


    public boolean exist(double ab, double ac, double bc) {
        return (ab + ac) > bc && (ac + bc) > ab && (bc + ab) > ac;
    }

    public double area() {
        double ab = first.distance(second);
        double ac = first.distance(third);
        double bc = second.distance(third);
        if (this.exist(ab, ac, bc)) {
          return Math.sqrt(this.period(ab, ac, bc) * (this.period(ab, ac, bc) - ab) * (this.period(ab, ac, bc) - ac) * (this.period(ab, ac, bc) - bc));
        }
        return -1;
    }
}
