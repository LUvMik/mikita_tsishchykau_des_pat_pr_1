package com.esde.specification;

import com.esde.entity.Cone;

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