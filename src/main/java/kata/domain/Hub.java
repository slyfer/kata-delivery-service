package kata.domain;

public class Hub extends NamedCollectionPoint {

    public Hub(String name) {
        super(name);
    }

    @Override
    public boolean isPackageAcceptable(int packageMaxDimension) {
        return true;
    }
}
