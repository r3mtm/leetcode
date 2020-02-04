class Sort {

    int left (int index) {
        return (2 * index + 1);
    }

    int right (int index) {
        return (2 * index + 2);
    }

    void max_heapify (int ar[], int i, int size) {
        int left, right, largest, temp;
        while (true) {
            left = left(i);
            right = right(i);
            if (left < size && ar[left] > ar[i]) {
                largest = left;
            } else {
                largest = i;
            }

            if (right < size && ar[right] > ar[largest]) {
                largest = right;
            }

            if (largest != i) {
                temp = ar[largest];
                ar[largest] = ar[i];
                ar[i] = temp;
                i = largest;
            } else {
                break;
            }
        }
    }

    void build_max_heap (int ar[]) {
        for (int i = (ar.length -1) / 2; i >= 0; --i) {
            max_heapify(ar, i, ar.length);
        }
    }

    void heapsort (int ar[]) {
        int size = ar.length, temp, max = 0;
        build_max_heap(ar);

        while(size > 0) {
            //swap a[1] and a[n]
            temp = ar[max];
            ar[max] = ar[size-1];
            ar[size-1] = temp;

            //Discarding last element
            --size;

            //Performing max_heapify for 1st element
            max_heapify(ar, max, size);
        }

        //printing array after sorting
        System.out.println("Sorted array\n");
        for (int i = 0; i < ar.length; ++i) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
    }
}

public class HeapSort {
    public static void main (String[] args) {
        int []ar = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7, 5};
        Sort srtObj = new Sort();
        srtObj.heapsort(ar);
    }
}