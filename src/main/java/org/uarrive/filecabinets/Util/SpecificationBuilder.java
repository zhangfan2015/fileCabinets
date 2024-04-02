package org.uarrive.filecabinets.Util;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Path;
import jakarta.persistence.criteria.Root;
import org.hibernate.query.sqm.ComparisonOperator;
import org.springframework.data.jpa.domain.Specification;
//import javax.persistence.criteria.*;
import java.util.function.Function;

public abstract class SpecificationBuilder<T> {

    protected abstract Class<T> getEntityClass();

    // 其他方法和枚举
    public Specification<T> withCondition(String fieldName, Object value, ComparisonOperator operator) {
        return (root, query, criteriaBuilder) -> {
            Path<Object> fieldPath = root.get(fieldName);
            switch (operator) {
                case EQUAL:
                    return criteriaBuilder.equal(fieldPath, value);
                case NOT_EQUAL:
                    return criteriaBuilder.notEqual(fieldPath, value);
                case GREATER_THAN:
                    return criteriaBuilder.greaterThan(fieldPath.as(Comparable.class), (Comparable) value);
                case LESS_THAN:
                    return criteriaBuilder.lessThan(fieldPath.as(Comparable.class), (Comparable) value);
                // ... 其他操作
                default:
                    throw new IllegalArgumentException("Unsupported comparison operator: " + operator);
            }
        };
    }
    public enum ComparisonOperator {
        EQUAL, NOT_EQUAL, GREATER_THAN, LESS_THAN // ... 其他比较操作符
    }
    // 一个辅助方法来创建左联接
    protected <Z, X> Join<Z, X> leftJoin(Root<T> root, String attributeName) {
        return root.join(attributeName, JoinType.LEFT);
    }
}