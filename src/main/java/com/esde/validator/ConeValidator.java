package com.esde.validator;

import com.esde.entity.Point;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConeValidator {
    private static final Logger logger = LoggerFactory.getLogger(ConeValidator.class);

    public static boolean isValidLine(String line) {
        String[] tokens = line.split(";");
        if (tokens.length != 8) {
            logger.warn("ConeValidator:Error: 8 values expected, received {}", tokens.length);
            return false;
        }

        for (int i = 1; i < tokens.length; i++) {
            String t = tokens[i].trim();
            try {
                Double.parseDouble(t);
            } catch (NumberFormatException e) {
                logger.warn("ConeValidator:Error: value “{}” is not a number", t);
                return false;
            }
        }

        double x1 = Double.parseDouble(tokens[1].trim());
        double y1 = Double.parseDouble(tokens[2].trim());
        double z1 = Double.parseDouble(tokens[3].trim());

        double x2 = Double.parseDouble(tokens[4].trim());
        double y2 = Double.parseDouble(tokens[5].trim());
        double z2 = Double.parseDouble(tokens[6].trim());

        double radius = Double.parseDouble(tokens[7].trim());

        if (radius <= 0) {
            logger.warn("ConeValidator:Error: the radius must be positive, received {}", radius);
            return false;
        }

        Point base = new Point(x1, y1, z1);
        Point apex = new Point(x2, y2, z2);

        if (base.equals(apex)) {
            logger.warn("ConeValidator:Error: the base and vertex coincide: {}", base);
            return false;
        }

        return true;
    }

    public static boolean isPointValid(Point p1, Point p2) {
        return (p1.getX() != p2.getX() && p1.getY() == p2.getY() && p1.getZ() == p2.getZ());
    }

    public static boolean isRadiusValid(double radius) {
        return radius > 0;
    }
}
