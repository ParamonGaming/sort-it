abstract class BaseSortStrategy<T> implements SortStrategy<T> {
    protected void mergeSort(T[] array, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;
            mergeSort(array, left, middle);
            mergeSort(array, middle + 1, right);
            merge(array, left, middle, right);
        }
    }

    protected void merge(T[] array, int left, int middle, int right) {
        int sizeLeft = middle - left + 1;
        int sizeRight = right - middle;

        T[] leftArray = (T[]) new Object[sizeLeft];
        T[] rightArray = (T[]) new Object[sizeRight];

        for (int i = 0; i < sizeLeft; i++) {
            leftArray[i] = array[left + i];
        }
        for (int i = 0; i < sizeRight; i++) {
            rightArray[i] = array[middle + 1 + i];
        }

        int i = 0, j = 0, k = left;
        while (i < sizeLeft && j < sizeRight) {
            if (compare(leftArray[i], rightArray[j])) {
                array[k] = leftArray[i];
                i++;
            } else {
                array[k] = rightArray[j];
                j++;
            }
            k++;
        }

        while (i < sizeLeft) {
            array[k] = leftArray[i];
            i++;
            k++;
        }

        while (j < sizeRight) {
            array[k] = rightArray[j];
            j++;
            k++;
        }
        for(T s : array){
            System.out.println(s.toString());
        }
    }

    protected abstract boolean compare(T a, T b);
}