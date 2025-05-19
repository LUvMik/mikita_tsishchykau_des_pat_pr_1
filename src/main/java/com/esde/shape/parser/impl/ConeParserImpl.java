package com.esde.shape.parser.impl;

import com.esde.shape.entity.Cone;
import com.esde.shape.entity.Point;
import com.esde.shape.factory.ConeFactory;

public class ConeParserImpl implements com.esde.shape.parser.ConeParser {
    @Override
    public Cone parse(String line) {
        String[] tokens = line.split(";");
        String id = tokens[0].trim();

        Point base = new Point(
                Double.parseDouble(tokens[1].trim()),
                Double.parseDouble(tokens[2].trim()),
                Double.parseDouble(tokens[3].trim())
        );

        Point apex = new Point(
                Double.parseDouble(tokens[4].trim()),
                Double.parseDouble(tokens[5].trim()),
                Double.parseDouble(tokens[6].trim())
        );

        double radius = Double.parseDouble(tokens[7].trim());

        return ConeFactory.create(id, base, apex, radius);
    }
}