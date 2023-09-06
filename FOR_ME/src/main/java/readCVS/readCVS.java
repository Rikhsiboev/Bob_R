package readCVS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class readCVS {
    public static final  String COMMA_DELIMITER=",";
    public static final  String Path="/Users/rikhsiboevgmail.com/IdeaProjects/java-version-updates/Bob_R/Bob_R/FOR_ME/src/main/java/readCVS/CVSfile";

    public static void main(String[] args) {
        List<Transaction> result = readTransactionsCsv(Path);
        System.out.println(result);
    }

    public static List<Transaction> readTransactionsCsv(String filename){
        List<Transaction> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(COMMA_DELIMITER);
                Transaction transaction=new Transaction();
                transaction.setTxHash(values[0]);
                transaction.setBlockNumber(values[1]);
                transaction.setDateTime(values[2]);
                transaction.setFromAccount(values[4]);
                transaction.setToAccount(values[5]);
                transaction.setQuantity(values.length<7?null:values[6]);
                transaction.setMethod(values.length<8?null:values[7]);

                transactions.add(transaction);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        transactions.remove(0);

        //return transactions.stream().filter(transaction -> transaction.getMethod().equals("Multicall")).limit(5).collect(Collectors.toList());
        return transactions.stream().collect(Collectors.toList());
    }
}
