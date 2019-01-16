package com.stackroute.domain;

public class Triangle {
    private Point pointA;
    private Point pointB;
    private Point pointC;

    public void setPointA(Point pointA) {
        this.pointA = pointA;
    }

    public void setPointB(Point paintB) {
        this.pointB = paintB;
    }

    public void setPointC(Point pointC) {
        this.pointC = pointC;
    }

    public Point getPointA() {
        return pointA;
    }

    public Point getPointB() {
        return pointB;
    }

    public Point getPointC() {
        return pointC;
    }

    public String getMyPoints(){
        return pointA.getX()+" "+pointA.getY()+" "+pointB.getX()+" "+pointB.getY()+" "+pointC.getX()+" "+pointC.getY();
    }
}
