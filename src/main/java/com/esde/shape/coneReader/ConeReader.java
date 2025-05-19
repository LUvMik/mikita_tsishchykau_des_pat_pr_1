package com.esde.shape.coneReader;

import com.esde.shape.entity.Cone;
import com.esde.shape.parser.ConeParser;
import com.esde.shape.validator.ConeValidator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ConeReader {
    public List<Cone> readValidCones(String filename,
                                     ConeValidator coneValidator,
                                     ConeParser parser) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(
                Objects.requireNonNull(ConeReader.class.getClassLoader().getResourceAsStream(filename))))) {

            List<String> lines = reader.lines().toList();

            return lines.stream()
                    .filter(coneValidator::isValidLine)
                    .map(parser::parse)
                    .collect(Collectors.toList());
        }
    }
}
