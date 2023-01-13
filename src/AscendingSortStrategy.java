import java.util.List;

class AscendingSortStrategy<T extends Comparable<T>> extends BaseSortStrategy<T> {
    public List<T> sort(List<T> array) {
        return mergeSort(array, 0, array.size() - 1);
    }

    protected boolean compare(T a, T b) {
        return a.compareTo(b) <= 0;
    }
}