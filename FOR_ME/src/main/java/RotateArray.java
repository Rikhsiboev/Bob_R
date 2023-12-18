public class RotateArray {


    public static int[] rotateArray(int []arr , int k){

        //create new array
        // formula (n+k)%size

        int[] answer= new int[arr.length];
        for(int i=0;i<arr.length;i++){
            answer[(i+k)%arr.length]=arr[i];
        }
        return answer;
    }

}
