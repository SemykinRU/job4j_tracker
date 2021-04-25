package ru.job4j.oop;

import junit.framework.TestCase;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;

public class TriangleTest extends TestCase {

    @Test
    public void testWhenA00B40C04Then8() {
        Point a = new Point(0, 0);
        Point b = new Point(4, 0);
        Point c = new Point(0, 4);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(8, 0.001));
    }

    @Test
    public void testWhenA04B22C33Then2() {
        Point a = new Point(0, 4);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(2, 0.001));
    }

    @Test
    public void testWhenA77B22C33ThenMinus1() {
        Point a = new Point(7, 7);
        Point b = new Point(2, 2);
        Point c = new Point(3, 3);
        Triangle triangle = new Triangle(a, b, c);
        double rsl = triangle.area();
        assertThat(rsl, closeTo(-1, 0.001));
    }
}