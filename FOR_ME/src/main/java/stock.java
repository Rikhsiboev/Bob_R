public class stock {
    public static void main(String[] args) {
        int[] stockPrice = {5, 3, 5, 7, 8};
        int kMonth = 3;
        System.out.println(calculationOfMaxMonthStocks(stockPrice, kMonth));

    }

    public static int calculationOfMaxMonthStocks(int[] stockPrice, int kMonth) {
        int sum =0;
        int sumOfStocks;
        for (int i = 0; i < stockPrice.length-kMonth; i++) {
            sum=i+kMonth-1;
            }
        return sum;
    }
}
