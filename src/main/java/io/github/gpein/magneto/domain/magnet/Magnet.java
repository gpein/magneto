package io.github.gpein.magneto.domain.magnet;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

@RequiredArgsConstructor
@EqualsAndHashCode
@Accessors(fluent = true)
abstract class Magnet {

    @Getter
    @NonNull
    private Department department;
}
