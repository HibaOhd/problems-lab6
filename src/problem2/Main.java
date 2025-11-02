package problem2;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        Costumer costumer = new Costumer("Hiba");
        costumer.credit(9.0);
        costumer.debit(5.0);
        Bank bank = new Bank("BANK");
        bank.addCostumer(costumer);
        bank.printTransactionsCostumer(costumer);
    }
}
