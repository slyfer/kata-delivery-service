package kata.domain;

import java.util.ArrayList;
import java.util.List;

public final class LockerBuilder {

    private String name;
    private List<LockerSlot> slots;

    private LockerBuilder(String name) {
        this.name = name;
        this.slots = new ArrayList<>();
    }

    public static LockerBuilder aLocker(String name) {
        return new LockerBuilder(name);
    }

    public LockerBuilder withSlot(int dimension) {
        this.slots.add(new LockerSlot(dimension, true));
        return this;
    }

    public Locker build() {
        return new Locker(name, slots);
    }
}
