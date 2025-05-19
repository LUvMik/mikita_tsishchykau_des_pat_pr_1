package com.esde.shape.repository;

import com.esde.shape.entity.Cone;
import com.esde.shape.specification.ConeSpecification;

import java.util.Comparator;
import java.util.List;

public interface ConeRepository {
    boolean add(Cone cone);

    List<Cone> query(ConeSpecification spec);

    List<Cone> getAll();

    List<Cone> sortBy(Comparator<Cone> comparator);
}
