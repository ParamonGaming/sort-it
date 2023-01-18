public class MergeSort<T> {
    private SortStrategy<T> strategy;
    public void setStrategy(SortStrategy strategy){
        this.strategy= strategy;
    }
    public void sort(T[] array) {
        strategy.sort(array);
    }
}
