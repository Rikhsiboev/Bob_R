public class FindKthLargest {
    public static void main(String[] args) {
        int[] numbers= {7,2,4,6,1,9,-1};
        System.out.println(findKthLargest(numbers, 3));
    }
    public static int findKthLargest(int[] array, int k){
        for(int i=0;i<k;i++){

            for (int j = 0; j < array.length-1; j++) {
                if (array[j]>array[j+1]) {
                    swap (array, j,j+1);
                }
            }

        }
        return array[array.length-k];
    }
    public static void swap(int[] array, int idx1, int idx2){
        int temp=array[idx1];
        array[idx1]=array[idx2];
        array[idx2]=temp;
    }
}
