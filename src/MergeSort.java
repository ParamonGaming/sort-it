import java.util.List;

class MergeSort<T extends Comparable<T>>{
    private SortStrategy<T> strategy = new AscendingSortStrategy<>();
    public void setStrategy(SortStrategy strategy){
        this.strategy= strategy;
    }

    public List<T> sort(List<T> array) {
        try {
            return (strategy.sort(array));
        }
        catch(Exception e)
        {
            System.out.println("Data error");
            return null;
        }
    }
}
