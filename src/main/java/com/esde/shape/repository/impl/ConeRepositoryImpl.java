package com.esde.shape.repository.impl;

import com.esde.shape.entity.Cone;
import com.esde.shape.repository.ConeRepository;
import com.esde.shape.specification.ConeSpecification;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ConeRepositoryImpl implements ConeRepository {
    private final List<Cone> cones = new ArrayList<>();

    @Override
    public boolean add(Cone cone) {
        return cones.add(cone);
    }

    @Override
    public List<Cone> query(ConeSpecification spec) {
        return cones.stream()
                .filter(spec::specified)
                .collect(Collectors.toList());
    }

    @Override
    public List<Cone> getAll() {
        return new ArrayList<>(cones);
    }

    @Override
    public List<Cone> sortBy(Comparator<Cone> comparator) {
        return cones.stream().sorted(comparator).collect(Collectors.toList());
    }
}