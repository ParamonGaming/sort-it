class DescendingSortStrategy<T extends Comparable<T>> extends BaseSortStrategy<T> {
    public void sort(T[] array) {
        mergeSort(array, 0, array.length - 1);
    }

    protected boolean compare(T a, T b) {
        return a.compareTo(b) >= 0;
    }
}