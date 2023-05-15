package Practice_Code;

public class ArrayOFStringWithMaxAndMin {
    public static void main(String[] args) {

        //we have same String []={Bob,Kamal,Denis,Aynur}
        String [] arrayOfString = {"Bob","Kamal","Denis","Aynur","Doniyor"};
        System.out.println(arrayOfString[minWordsInIndex(arrayOfString)]);
        System.out.println(arrayOfString[maxWordsInIndex(arrayOfString)]);


    }

    public static int maxWordsInIndex(String[] array){
        int minNumberOfIndex = array[0].length();
        int indexOfArray=0;
        for (int i = 0; i <array.length ; i++) {
            if (array[i].length()>minNumberOfIndex){
                minNumberOfIndex=array.length;
                indexOfArray=i;
            }
        }

        return indexOfArray;
    }










    public static int minWordsInIndex(String [] array){
        int min = array[0].length();
        int index= 0;
        for (int i = 0; i < array.length ; i++) {
            if (array[i].length()<min){
                min= array[i].length();
                index=i;
            }
        }
        return index;
    }


}
