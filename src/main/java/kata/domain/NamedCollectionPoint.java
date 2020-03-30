package kata.domain;

public abstract class NamedCollectionPoint implements CollectionPoint {

    private final String name;

    public NamedCollectionPoint(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }
}
