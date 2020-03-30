package kata.domain;

import java.util.List;

public class Locker extends NamedCollectionPoint {

    private final List<LockerSlot> slots;

    public Locker(String name, List<LockerSlot> slots) {
        super(name);
        this.slots = slots;
    }

    @Override
    public boolean isPackageAcceptable(int packageMaxDimension) {
        return slots.stream().anyMatch(slot -> slot.isFree() && slot.getDimension() >= packageMaxDimension);
    }
}
