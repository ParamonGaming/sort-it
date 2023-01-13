import java.util.List;

interface SortStrategy<T> {
    List<T> sort(List<T> array);
}