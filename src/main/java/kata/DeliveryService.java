package kata;

import kata.domain.CollectionPoint;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DeliveryService {

    private final List<CollectionPoint> collectionPoints;

    public DeliveryService() {
        this.collectionPoints = new ArrayList<>();
    }

    public void addCollectionPoint(CollectionPoint collectionPoint) {
        this.collectionPoints.add(collectionPoint);
    }

    public List<String> collectionPointsNamesFor(int maxPackageDimension) {
        return this.collectionPoints.stream()
            .filter(collectionPoint -> collectionPoint.isPackageAcceptable(maxPackageDimension))
            .map(CollectionPoint::getName)
            .collect(Collectors.toList());
    }

}
