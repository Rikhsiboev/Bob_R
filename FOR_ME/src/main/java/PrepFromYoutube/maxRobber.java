package PrepFromYoutube;

public class maxRobber {
    public static void main(String[] args) {
        int[] houses1 = {1, 2, 3, 1};
        System.out.println(robberHouses(houses1)); // 1
        int[] houses2 = {2, 7, 9, 3, 1};
        System.out.println(robberHouses(houses2)); // 12

    }

    public static int robberHouses(int[] houses) {
        if (houses.length == 0) return 0;
        if (houses.length == 1) return houses[0];

        int still = 0;
        int notStill = 0;

        for (int i = 0, j=i+1; i < houses.length; i++,j++) {
            int temp = still;
            still = Math.max(notStill+houses[i], still);
            notStill = temp;
        }

        return still;
    }
}
