package readCVS;

import lombok.Data;
import lombok.Getter;

@Data
public class Transaction {
    private String TxHash;
    private String BlockNumber;
    private String DateTime;
    private String FromAccount;
    private String ToAccount;
    private String Quantity;
    private String Method;

}
