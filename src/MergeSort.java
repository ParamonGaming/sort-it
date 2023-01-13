import java.lang.reflect.GenericDeclaration;
import java.util.List;

class MergeSort<T> {
    private SortStrategy<T> strategy;
    public void setStrategy(SortStrategy strategy){
        this.strategy= strategy;
    }

    public List<T> sort(List<T> array) {
       return ( strategy.sort(array));
    }
}
