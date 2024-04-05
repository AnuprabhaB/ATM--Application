import java.util.*;
public class Admin {
    Scanner in=new Scanner(System.in);
    public void getData(Map<Integer,Account> data,int cash) {
        Map<Integer,Integer> adminMap=new HashMap<>();
        adminMap.put(123456,9177);
        adminMap.put(987654,5643);
        boolean end=false;
        while(!end){
            try{
                if(isAdmin(adminMap)){
                    System.out.println("Choose the details you want to know:");
                    System.out.println("1.Bank Details");
                    System.out.println("2.Customer Details");
                    System.out.println("3.Cash Details");
                    System.out.println("4.Deposit Amount");
                    System.out.println("5.Exit");
                    System.out.println("Enter Choice:");
                    int choice = in.nextInt();
                    switch (choice) {
                        case 1: {
                            bankDetails(data);
                            break;
                        }
                        case 2: {
                            customerDetails(data);
                            break;
                        }
                        case 3: {
                            cashDetails(cash,data);
                            break;
                        }
                        case 4: {
                            System.out.println("enter amount to deposit");
                            int amount = in.nextInt();
                            depositCash(cash, amount,data);
                            break;
                        }
                        case 5:
                            return;
                    }
                }
                else{
                    System.out.println("Please check your id and pin or you don't have access as admin");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid Choice");
                in.next();
            }

        }


    }
    public boolean isAdmin(Map<Integer,Integer> adminMap){
        System.out.println("Enter your admin id:");
        int id=in.nextInt();
        if(adminMap.containsKey(id)){
            System.out.println("Enter your pin:");
            int pin=in.nextInt();
            if(adminMap.get(id)!=pin) System.out.println("Your pin doesn't match");
            else{
                return true;
            }
        }
        else{
            System.out.println("Invalid pin");
            return false;
        }
        return false;
    }
    public void bankDetails(Map<Integer,Account> data){
        System.out.println("The List of Active Banks");
        for (Map.Entry<Integer, Account> entry : data.entrySet()) {
            Account account = entry.getValue();
            System.out.println(account.bank_name);
        }
        System.out.println("Enter the bank name to know more details");
        String b_name=in.next();
        switch(b_name.toUpperCase()){
            case "HDFC":{
                hdfcDetails(data);
              break;
            }
            case "ICI":{
                iciDetails(data);
                break;
            }
            case "CANARA":{
                canaraDetails(data);
                break;
            }
            case "IOB":{
                iobDetails(data);
                break;
            }
            default:{
                System.out.println("Invalid Choice");
            }
        }
    }
    public void hdfcDetails(Map<Integer,Account> data){
        System.out.println("HDF customer details");
        System.out.println("-----------------------------------------------------------------");
        for (Map.Entry<Integer, Account> entry : data.entrySet()) {
            Account account = entry.getValue();
            if(account.bank_name.equals("HDFC")){
                System.out.println(account.name+" "+account.accnum);
            }
        }
        System.out.println("-----------------------------------------------------------------");

    }
    public void iciDetails(Map<Integer,Account> data){
        System.out.println("ICI customer details");
        System.out.println("-----------------------------------------------------------------");
        for (Map.Entry<Integer, Account> entry : data.entrySet()) {
            Account account = entry.getValue();
            if(account.bank_name.equals("ICI")){
                System.out.println(account.name+" "+account.accnum);
            }
        }
        System.out.println("-----------------------------------------------------------------");
    }
    public void canaraDetails(Map<Integer,Account> data){
        System.out.println("CANARA customer details");
        System.out.println("-----------------------------------------------------------------");
        for (Map.Entry<Integer, Account> entry : data.entrySet()) {
            Account account = entry.getValue();
            if(account.bank_name.equals("CANARA")){
                System.out.println(account.name+" "+account.accnum);
            }
        }
        System.out.println("-----------------------------------------------------------------");
    }
    public void iobDetails(Map<Integer,Account> data){
        System.out.println("IOB customer details");
        System.out.println("-----------------------------------------------------------------");
        for (Map.Entry<Integer, Account> entry : data.entrySet()) {
            Account account = entry.getValue();
            if(account.bank_name.equals("IOB")){
                System.out.println(account.name+" "+account.accnum);
            }
        }
        System.out.println("-----------------------------------------------------------------");
    }
    public void customerDetails(Map<Integer,Account> data){
        System.out.println("ALL CUSTOMERS DETAILS");
        System.out.println("-----------------------------------------------------------------");
        for (Map.Entry<Integer, Account> entry : data.entrySet()) {
            Account account = entry.getValue();
            System.out.println(account.name+" "+account.bank_name+" "+account.accnum);
        }
        System.out.println("-----------------------------------------------------------------");
    }
    public void cashDetails(int cash,Map<Integer,Account> data){
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Total available cash in the machine is : "+cash);
        System.out.println("-----------------------------------------------------------------");
    }
    public void depositCash(int cash,int amount,Map<Integer,Account> data){
        cash=cash+amount;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Total Cash available in the machine is : "+cash);
        System.out.println("-----------------------------------------------------------------");
    }

}
