package io.github.gpein.magneto.domain;

import io.github.gpein.magneto.domain.magnet.Department;
import io.github.gpein.magneto.domain.magnet.NewCollectionMagnet;
import io.github.gpein.magneto.domain.magnet.OldCollectionMagnet;
import org.assertj.core.api.Assertions;
import org.junit.Test;


public class CollectorTest {


    @Test
    public void shouldLookForOldMagnet() {

        Collector collector = new Collector();

        Department gironde = Department.of(33).get();

        collector.lookForOldMagnet(gironde);

        Assertions.assertThat(collector.oldSeeked()).containsExactly(OldCollectionMagnet.of(gironde));
    }

    @Test
    public void shouldLookForNewMagnet() {

        Collector collector = new Collector();

        Department gironde = Department.of(33).get();

        collector.lookForNewMagnet(gironde);

        Assertions.assertThat(collector.newSeeked()).containsExactly(NewCollectionMagnet.of(gironde));
    }

    @Test
    public void shouldAddNewDuplicate() {
        Collector collector = new Collector();

        Department gironde = Department.of(33).get();

        collector.newDuplicate(gironde);

        Assertions.assertThat(collector.newDuplicates()).containsExactly(NewCollectionMagnet.of(gironde));
    }

    @Test
    public void shouldAddOldDuplicate() {

        Collector collector = new Collector();

        Department gironde = Department.of(33).get();

        collector.oldDuplicate(gironde);

        Assertions.assertThat(collector.oldDuplicates()).containsExactly(OldCollectionMagnet.of(gironde));
    }
}