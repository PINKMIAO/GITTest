package strategy;

/**
 * @author Baven
 */
public class CatHeightComparator implements Comparator<Cat> {
    @Override
    public int compare(Cat o1, Cat o2) {
        // return Integer.compare(o1.weight, o2.weight);
        if (o1.height > o2.height) {
            return -1;
        } else if (o1.height < o2.height) {
            return 1;
        } else {
            return 0;
        }
    }
}
