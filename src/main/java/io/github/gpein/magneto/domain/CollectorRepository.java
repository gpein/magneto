package io.github.gpein.magneto.domain;


import java.util.Collection;
import java.util.Optional;

public interface CollectorRepository {

    Optional<Collector> get(String id);

    void add(Collector collector);

    Collection<Collector> all();
}
