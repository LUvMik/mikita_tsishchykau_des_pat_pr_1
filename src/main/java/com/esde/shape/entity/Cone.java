package com.esde.shape.entity;

import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cone cone = (Cone) o;
        return Double.compare(radius, cone.radius) == 0 && Objects.equals(id, cone.id) &&
                Objects.equals(baseCenter, cone.baseCenter) && Objects.equals(apex, cone.apex);
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(id);
        result = 31 * result + Objects.hashCode(baseCenter);
        result = 31 * result + Objects.hashCode(apex);
        result = 31 * result + Double.hashCode(radius);
        return result;
    }
}