package io.github.gpein.magneto.domain;

import io.github.gpein.magneto.domain.magnet.Department;
import io.github.gpein.magneto.domain.magnet.NewCollectionMagnet;
import io.github.gpein.magneto.domain.magnet.OldCollectionMagnet;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CollectorTest {


    @Test
    public void seekForOldCollectionMagnetFor() throws Exception {

        Collector collector = new Collector();

        Department gironde = Department.of(33).get();

        collector.seekForOldCollectionMagnetFor(gironde);

        Assertions.assertThat(collector.oldSeeked()).containsExactly(OldCollectionMagnet.of(gironde));
    }

    @Test
    public void seekForNewCollectionMagnetFor() throws Exception {

        Collector collector = new Collector();

        Department gironde = Department.of(33).get();

        collector.seekForNewCollectionMagnetFor(gironde);

        Assertions.assertThat(collector.newSeeked()).containsExactly(NewCollectionMagnet.of(gironde));
    }

    @Test
    public void declareNewCollectionDuplicateFor() throws Exception {
        Collector collector = new Collector();

        Department gironde = Department.of(33).get();

        collector.declareNewCollectionDuplicateFor(gironde);

        Assertions.assertThat(collector.newDuplicates()).containsExactly(NewCollectionMagnet.of(gironde));
    }

    @Test
    public void declareOldCollectionDuplicateFor() throws Exception {

        Collector collector = new Collector();

        Department gironde = Department.of(33).get();

        collector.declareOldCollectionDuplicateFor(gironde);

        Assertions.assertThat(collector.oldDuplicates()).containsExactly(OldCollectionMagnet.of(gironde));
    }

}