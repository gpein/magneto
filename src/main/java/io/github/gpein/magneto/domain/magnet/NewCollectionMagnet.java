package io.github.gpein.magneto.domain.magnet;

public class NewCollectionMagnet extends Magnet {

    private NewCollectionMagnet(Department department) {
        super(department);
    }

    public static NewCollectionMagnet of(Department department) {
        return new NewCollectionMagnet(department);
    }
}
