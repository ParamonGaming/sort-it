import java.util.ArrayList;
import java.util.List;

abstract class BaseSortStrategy<T> implements SortStrategy<T> {
    protected List<T> mergeSort(List<T> array, int left, int right) {
        if (left < right) {
            try {
                int middle = (left + right) / 2;
                mergeSort(array, left, middle);
                mergeSort(array, middle + 1, right);
                return merge(array, left, middle, right);
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Error: Invalid index in array");
            }
            finally {
                return array;
            }
        }
        return array;
    }

    public List<T> sort(List<T> array) {
        try{
        return mergeSort(array, 0, array.size() - 1);
        } catch (NullPointerException e) {
        System.out.println("Error: Array is empty or null");
        return new ArrayList<>();
        }
    }
    protected List<T> merge(List<T> array, int left, int middle, int right) {
        try {
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        T[] leftArray = (T[]) new Object[sizeLeft];
        T[] rightArray = (T[]) new Object[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i] = array.get(left + i);
        }
        for (int i = 0; i < sizeRight; i++) {
            rightArray[i] = array.get(middle + 1 + i);
        }

        int i = 0, j = 0, k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (compare(leftArray[i], rightArray[j])) {
                array.set(k,leftArray[i]);
                i++;
            } else {
                array.set(k,rightArray[j]);
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            array.set(k,leftArray[i]);
            i++;
            k++;
        }

        while (j < sizeRight) {
            array.set(k, rightArray[j]);
            j++;
            k++;
        }
    } catch (IndexOutOfBoundsException e) {
        System.out.println("Error: Invalid index in array");
    }
        finally {
            return array;
        }
    }

    protected abstract boolean compare(T a, T b);
}