package problem2;
import java.util.ArrayList;
public class Costumer {
    private String name;
    private ArrayList<Double> transactions = new ArrayList();

    public Costumer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
    public void credit(Double amount){
        if(amount > 0 ){
            transactions.add(amount);
        }
    }
    public void debit(Double amount){
        if(amount>0){
            transactions.add(-amount);
        }
    }
}
