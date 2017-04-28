package io.github.gpein.magneto.domain.magnet;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;


public class DepartmentTest {

    @Test
    public void should_map_departments() throws Exception {

        Optional<Department> gironde = Department.of(33);

        Assertions.assertThat(gironde).isNotNull();
        Assertions.assertThat(gironde).isPresent();
        Assertions.assertThat(gironde).containsSame(Department.Gironde);

        Optional<Department> unrecognized = Department.of(666);
        Assertions.assertThat(unrecognized).isNotNull();
        Assertions.assertThat(unrecognized).isNotPresent();
    }
}