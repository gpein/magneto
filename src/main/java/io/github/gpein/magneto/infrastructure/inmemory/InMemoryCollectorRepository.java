package io.github.gpein.magneto.infrastructure.inmemory;

import io.github.gpein.magneto.domain.Collector;
import io.github.gpein.magneto.domain.CollectorRepository;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class InMemoryCollectorRepository implements CollectorRepository {

    private final Map<String, Collector> collectors = new ConcurrentHashMap<>();

    @Override
    public Optional<Collector> get(String id) {
        return Optional.ofNullable(collectors.get(id));
    }

    @Override
    public void add(Collector collector) {
        collectors.put(collector.id(), collector);
    }

    @Override
    public Collection<Collector> all() {
        return collectors.values();
    }
}
