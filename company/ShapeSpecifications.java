package com.company;
import java.awt.*;
public class ShapeSpecifications
{
    Color color;
    int nPoints;
    int x;
    int y;
    int sides;
    int radius;
    String shapeType;

    public ShapeSpecifications(String shapeType,int x,int y,Color color, int sides, int radius) {
        this.x=x;
        this.y=y;
        this.color = color;
        this.sides = sides;
        this.radius = radius;
        this.shapeType = shapeType;
    }

    public ShapeSpecifications(int x,int y,Color color, int nPoints, int radius, String shapeType) {
        this.x=x;
        this.y=y;
        this.color = color;
        this.nPoints = nPoints;
        this.radius = radius;
        this.shapeType= shapeType;
    }

    public ShapeSpecifications(int x,int y,Color color, int radius, String shapeType) {
        this.x=x;
        this.y=y;
        this.color = color;
        this.radius = radius;
        this.shapeType = shapeType;
    }

    public Color getColor() {
        return color;
    }

    public int getnPoints() {
        return nPoints;
    }

    public int getSides() {
        return sides;
    }

    public int getRadius() {
        return radius;
    }

    public String getShapeType() {
        return shapeType;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
