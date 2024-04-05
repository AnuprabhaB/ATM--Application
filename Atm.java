import java.util.*;
public class Atm {
    public static void main(String[] args){
    Scanner in=new Scanner(System.in);
    int cash=50000;//cash in atm
    Customer cus=new Customer();
    Admin ad=new Admin();
    Bank ban=new Bank();
        Map<Integer,Account> data=new HashMap<>();
            data.put(1234890,new Account("Anu","HDFC",123456,1000,1234));
            data.put(3456780,new Account("Selvi","ICI",456789,1000,1234));
            data.put(1234780,new Account("Arthi","CANARA",452781,1000,1234));
            data.put(1234420,new Account("Akshaya","IOB",913476,1000,1234));
        //System.out.println(data.get(1234890).name);
        System.out.println("----------------------WELCOME TO OUR ATM-----------------------");
        System.out.println("Please Insert the card");
        System.out.println("Please select login options");
        System.out.println("1.Admin");
        System.out.println("2.Customer");
        System.out.println("3.Bank");
        System.out.println("Enter any one choice");
        int choice=in.nextInt();
        switch(choice){
            case 1:{
                ad.getData(data,cash);
                break;
            }
            case 2:{
                cus.getData(data);
                break;
            }
            case 3:{
                ban.getData(data);
               break;
            }
            default:
                System.out.println("Invalid");
        }



    }
}

