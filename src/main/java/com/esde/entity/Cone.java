package com.esde.entity;

public class Cone {
    private final String id;
    private Point baseCenter;
    private Point apex;
    private double radius;

    public Cone(String id, Point baseCenter, Point apex, double radius) {
        this.id = id;
        this.baseCenter = baseCenter;
        this.apex = apex;
        this.radius = radius;
    }

    public String getId() {
        return id;
    }

    public Point getBaseCenter() {
        return baseCenter;
    }

    public Point getApex() {
        return apex;
    }

    public double getRadius() {
        return radius;
    }

    public void setBaseCenter(Point baseCenter) {
        this.baseCenter = baseCenter;
    }

    public void setApex(Point apex) {
        this.apex = apex;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Cone{" +
                "id='" + id + '\'' +
                ", baseCenter=" + baseCenter +
                ", apex=" + apex +
                ", radius=" + radius +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cone cone = (Cone) obj;
        return id.equals(cone.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}