package io.github.gpein.magneto.domain.magnet;

public class OldCollectionMagnet extends Magnet {

    private OldCollectionMagnet(Department department) {
        super(department);
    }

    public static OldCollectionMagnet of(Department department) {
        return new OldCollectionMagnet(department);
    }
}
