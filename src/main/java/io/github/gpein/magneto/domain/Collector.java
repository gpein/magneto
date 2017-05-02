package io.github.gpein.magneto.domain;


import io.github.gpein.magneto.domain.magnet.Department;
import io.github.gpein.magneto.domain.magnet.NewCollectionMagnet;
import io.github.gpein.magneto.domain.magnet.OldCollectionMagnet;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Stream;

public class Collector {

    private String id = UUID.randomUUID().toString();

    private Set<NewCollectionMagnet> newDuplicates = new HashSet<>();

    private Set<NewCollectionMagnet> newSeeked = new HashSet<>();

    private Set<OldCollectionMagnet> oldDuplicates = new HashSet<>();

    private Set<OldCollectionMagnet> oldSeeked = new HashSet<>();

    public boolean seekForOldCollectionMagnetFor(Department department) {
        return oldSeeked.add(OldCollectionMagnet.of(department));
    }

    public boolean seekForNewCollectionMagnetFor(Department department) {
        return newSeeked.add(NewCollectionMagnet.of(department));
    }

    public boolean declareNewCollectionDuplicateFor(Department department) {
        return newDuplicates.add(NewCollectionMagnet.of(department));
    }

    public boolean declareOldCollectionDuplicateFor(Department department) {
        return oldDuplicates.add(OldCollectionMagnet.of(department));
    }

    public Stream<OldCollectionMagnet> oldSeeked() {
        return oldSeeked.stream();
    }

    public Stream<NewCollectionMagnet> newSeeked() {
        return newSeeked.stream();
    }

    public Stream<OldCollectionMagnet> oldDuplicates() {
        return oldDuplicates.stream();
    }

    public Stream<NewCollectionMagnet> newDuplicates() {
        return newDuplicates.stream();
    }

    public String id() {
        return id;
    }
}
