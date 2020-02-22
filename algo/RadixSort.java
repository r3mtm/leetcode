class RadixSort {

    static int getMax(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; ++i) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    static void printArray(int []arr) {
        System.out.println();
        for (int i = 0; i < arr.length; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static int[] countingSort(int[] arr, int pos, int rad) {
        int count[] = new int[rad];
        int result[] = new int[arr.length];
        int index;

        for (int i = 0; i < arr.length; ++i) {
            count[(arr[i]/(int)Math.pow(rad, pos)) % rad]++;
        }

        for (int i = 1; i < count.length; ++i) {
            count[i] = count[i] + count[i - 1];
        }

        for (int i = arr.length - 1; i > -1; --i) {
            index = (arr[i]/(int)Math.pow(rad, pos)) % rad;
            count[index]--;
            result[count[index]] = arr[i];
        }

        return result;
    }

    static int[] radixSort(int[] arr, int radix) {
        int max = getMax(arr);
        int digits = (int) (Math.log(max)/Math.log(radix) + 1);
        for (int i = 0; i < digits; ++i) {
            arr = countingSort(arr, i, radix);
        }
        return arr;
    }

    public static void main (String[] args) {
        int radix = 10;
        int arr[] = {329, 457, 657, 839, 436, 720, 355};
        arr = radixSort(arr, radix);
        printArray(arr);
    }
}
