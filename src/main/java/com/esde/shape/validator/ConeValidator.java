package com.esde.shape.validator;

import com.esde.shape.entity.Point;

public interface ConeValidator {
    boolean isValidLine(String line);

    boolean isPointValid(Point p1, Point p2);

    boolean isRadiusValid(double radius);
}
