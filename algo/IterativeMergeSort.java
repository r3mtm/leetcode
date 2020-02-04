public class IterativeMergeSort {
    public static void main(String[] args) {
        int[] num = { 10, 5, 4, 6, 3, 1, 7, 9, 50, 21, 34, 20, 18, 2, 8, 55, 39, -1, 20, -1 };
        Sort srt = new Sort();
        srt.sort(num);
    }
}

class Sort {

    public void sort(int num[]) {
        mergeSort(0, num.length-1, num);
        for(int i = 0; i < num.length; ++i){
                System.out.print(num[i]+" ");
        }
        System.out.println();
    }

    public void mergeSort(int leftStart, int rightEnd, int[] ar) {
        int leftEnd, rightStart;
        for(int ars = 1; ars < ar.length; ars*=2){
            for(int i = 0; i < ar.length-1; i+= 2 * ars){
                leftStart = i;
                leftEnd = Math.min(ar.length-1, i+ars-1);
                rightStart = leftEnd + 1;
                rightEnd = Math.min(ar.length-1, (i + 2 * ars - 1));
                merge(ar, leftStart, leftEnd, rightStart, rightEnd);
            }    
        }
    }

    public void merge(int []ar, int leftStart, int leftEnd, int rightStart, int rightEnd) {
        int size = (leftEnd - leftStart + 1) + (rightEnd - rightStart + 1);
        int []newAr = new int[size];
        int ls = leftStart;
        int le = leftEnd;
        int rs = rightStart;
        int re = rightEnd;
        int index = 0;
        while((ls <= le) && (rs <= re)) {
            if(ar[ls] < ar[rs]){
                newAr[index++] = ar[ls++];
            }else{
                newAr[index++] = ar[rs++];
            }
        }

        while(ls <= le) {
            newAr[index++] = ar[ls++];
        }
        while(rs <= re) {
            newAr[index++] = ar[rs++];
        }
        index = 0;
        
        for(int i = leftStart; i <= rightEnd; ++i, ++index) {
            ar[i] = newAr[index];
        }
    }
}