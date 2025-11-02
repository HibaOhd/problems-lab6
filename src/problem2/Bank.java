package problem2;
import java.util.ArrayList;
public class Bank {
    public String name;
    private ArrayList<Costumer> costumers= new ArrayList();
    public Bank(String name){
        this.name = name;
    }
    public void addCostumer(Costumer newCostumer){
        for(Costumer costumer:costumers){
            if(costumer.getName().equalsIgnoreCase(newCostumer.getName())){
                return ;
            }
        }
        costumers.add(newCostumer);
    }
    public boolean addTransaction(Costumer costumer1,Costumer costumer2,Double amount){
        if(!costumers.contains(costumer1) || !costumers.contains(costumer2)){
            return false;
        }
        costumer1.debit(amount);
        costumer2.credit(amount);
        return true;
    }
    public void printTransactionsCostumer(Costumer costumer){
        System.out.println("the transactions of the costumer "+costumer.getName()+" :");
        for(Double amount: costumer.getTransactions()){
            System.out.print(amount +"| ");
        }
    }

}
