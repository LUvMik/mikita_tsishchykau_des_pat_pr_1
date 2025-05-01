package com.esde.repository;

import com.esde.entity.Cone;
import com.esde.specification.ConeSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepository {
    private final List<Cone> cones = new ArrayList<>();

    public void add(Cone cone) {
        cones.add(cone);
    }

    public List<Cone> query(ConeSpecification spec) {
        return cones.stream()
                .filter(spec::specified)
                .collect(Collectors.toList());
    }

    public List<Cone> getAll() {
        return new ArrayList<>(cones);
    }

    public List<Cone> sortBy(Comparator<Cone> comparator) {
        return cones.stream().sorted(comparator).collect(Collectors.toList());
    }
}