package kata.domain;

public class LockerSlot {

    private final int dimension;
    private final boolean free;

    public LockerSlot(int dimension, boolean free) {
        this.dimension = dimension;
        this.free = free;
    }

    public int getDimension() {
        return dimension;
    }

    public boolean isFree() {
        return free;
    }
}
