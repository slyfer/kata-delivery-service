package kata;

import kata.domain.Hub;
import kata.domain.Locker;
import kata.domain.LockerBuilder;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class DeliveryServiceTest {

    private DeliveryService target;

    @Before
    public void setUp() {
        target = new DeliveryService();
    }

    @Test
    public void shouldReturnEmptyListIfNoCollectionsPointAreAdded() {

        // WHEN
        final List<String> lockers = target.collectionPointsNamesFor(10);

        // THEN
        Assertions.assertThat(lockers).isEmpty();
    }

    @Test
    public void shouldReturnTheHub() {

        // GIVEN
        target.addCollectionPoint(new Hub("hub1"));

        // WHEN
        final List<String> lockers = target.collectionPointsNamesFor(10);

        // THEN
        Assertions.assertThat(lockers).containsExactly("hub1");
    }

    @Test
    public void shouldReturnTheLockerWithSameDimension() {
        // GIVEN
        final Locker locker1 = LockerBuilder.aLocker("locker1")
            .withSlot(10)
            .build();

        target.addCollectionPoint(locker1);

        // WHEN
        final List<String> lockers = target.collectionPointsNamesFor(10);

        // THEN
        Assertions.assertThat(lockers).containsExactly("locker1");
    }

    @Test
    public void shouldReturnTheLockerWithBiggerDimension() {
        // GIVEN
        final Locker locker1 = LockerBuilder.aLocker("locker1")
            .withSlot(100)
            .build();

        target.addCollectionPoint(locker1);

        // WHEN
        final List<String> lockers = target.collectionPointsNamesFor(10);

        // THEN
        Assertions.assertThat(lockers).containsExactly("locker1");
    }

    @Test
    public void shouldReturnNothingForLockerWithLittleDimension() {
        // GIVEN
        final Locker locker1 = LockerBuilder.aLocker("locker1")
            .withSlot(5)
            .build();

        target.addCollectionPoint(locker1);

        // WHEN
        final List<String> lockers = target.collectionPointsNamesFor(10);

        // THEN
        Assertions.assertThat(lockers).isEmpty();
    }

    @Test
    public void shouldReturnHubAndLocker() {

        // GIVEN
        target.addCollectionPoint(new Hub("hub1"));

        final Locker locker1 = LockerBuilder.aLocker("locker1")
            .withSlot(100)
            .build();

        target.addCollectionPoint(locker1);

        // WHEN
        final List<String> lockers = target.collectionPointsNamesFor(10);

        // THEN
        Assertions.assertThat(lockers).containsOnly("hub1", "locker1");
    }

    @Test
    public void shouldReturnTwoLockers() {
        // GIVEN
        final Locker locker1 = LockerBuilder.aLocker("locker1")
            .withSlot(5)
            .build();

        target.addCollectionPoint(locker1);

        final Locker locker2 = LockerBuilder.aLocker("locker2")
            .withSlot(5)
            .build();

        target.addCollectionPoint(locker2);

        // WHEN
        final List<String> lockers = target.collectionPointsNamesFor(5);

        // THEN
        Assertions.assertThat(lockers).containsOnly("locker1", "locker2");
    }

    @Test
    public void shouldReturnLockerIfAtLeastOnSlotIsUsable() {
        // GIVEN
        final Locker locker1 = LockerBuilder.aLocker("locker1")
            .withSlot(5)
            .withSlot(10)
            .build();

        target.addCollectionPoint(locker1);

        // WHEN
        final List<String> lockers = target.collectionPointsNamesFor(7);

        // THEN
        Assertions.assertThat(lockers).containsOnly("locker1");
    }
}
