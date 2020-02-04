class ShellSort {

    public static void main (String []args) {
        int []ar = {2, -1};
        Sorting sort = new Sorting ();
        sort.sort(ar);
        sort.printArray(ar);
    }

}

class Sorting {

    void sort (int []ar) {
        //Start with a gap, here it is n/2, where n is the
        //no. of elements. 
        for (int g = ar.length / 2; g > 0; g = g / 2) {
            for (int i = 0; (i + g) < ar.length; ++i) {
                //Each element is compared with the element 'g' away from it
                if (ar[i] > ar[i+g]) {
                    swap(ar, i, i+g);
                    //If a swap is made the smallest element index is again 
                    //comapared to elements in multiple of 'g' backward, until
                    //it hits zero or less.
                    for (int k = i; k >= 0; k -= g) {
                        if (k-g >= 0 && ar[k-g] > ar[k]) {
                            swap(ar, k - g, k);
                        } else {
                            //can stop checking backward if the current element is not small.
                            break;
                        }
                    }
                }
            }
        }
    }

    void swap (int []ar, int pos_1, int pos_2) {
        int temp = ar[pos_1];
        ar[pos_1] = ar[pos_2];
        ar[pos_2] = temp;
    }

    void printArray (int []ar) {
        for (int i = 0; i < ar.length; ++i) {
            System.out.print(ar[i] + " ");
        }
        System.out.println();
    }

}