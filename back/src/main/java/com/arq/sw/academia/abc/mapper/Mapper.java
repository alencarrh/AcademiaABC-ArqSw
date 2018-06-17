package com.arq.sw.academia.abc.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

public interface Mapper<T, R> extends Function<T, R> {

    R map(T t);

    default R apply(T t) {
        return map(t);
    }

    default List<R> map(List<T> t) {
        return ofNullable(t).orElse(emptyList()).stream().map(this).collect(Collectors.toList());
    }

}
