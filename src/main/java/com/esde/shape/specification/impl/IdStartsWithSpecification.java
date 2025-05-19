package com.esde.shape.specification.impl;

import com.esde.shape.entity.Cone;
import com.esde.shape.specification.ConeSpecification;

public class IdStartsWithSpecification implements ConeSpecification {
    private final String prefix;

    public IdStartsWithSpecification(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public boolean specified(Cone cone) {
        return cone.getId().startsWith(prefix);
    }
}