package com.dev3.academia.abc.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

public interface Mapper<T, R> extends Function<T, R> {

    R map(T t);

    default R apply(T t) {
        return map(t);
    }

    default List<R> map(List<T> t) {
        if(isNull(t)) {
            return null;
        }
        return t.stream().map(this).collect(Collectors.toList());
    }

}
