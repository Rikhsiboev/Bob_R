public class AnagramForAllChar {

    public static boolean anagram(String str1, String str2) {

      int [] arr = new int[255];

      for(int i = 0; i < str1.length();i++){
          arr[i]++;
      }

      for(int i = 0; i<str2.length();i++){
          arr[i]--;
      }

      for(int i = 0; i<arr.length;i++){
          if (i!=0){
              return false;
          }
      }

      return true;
    }
}
