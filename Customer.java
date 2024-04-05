import java.util.*;
public class Customer {
    Scanner in=new Scanner(System.in);
    public void getData(Map<Integer,Account> data){
      isAccount(data);
    }
    public void isAccount(Map<Integer,Account> data){
        System.out.println("Enter your Account ID:");
        int Accnum=in.nextInt();
        if(data.containsKey(Accnum)){
            System.out.println("Enter your 4 digit pin:");
            int pass=in.nextInt();
            if(data.get(Accnum).pin!=pass){
                System.out.println("Your password doesn't match");
            }
            else{
                customerOptionsDisplay(Accnum,data);
            }
        }
        else{
            System.out.println("Invalid account number");
        }
    }
    public void customerOptionsDisplay(int accnum,Map<Integer,Account> data){
        boolean end=false;
        while(!end){
            System.out.println("Enter your choice");
            System.out.println("1.Withdraw");
            System.out.println("2.Deposit");
            System.out.println("3.Balance Enquiry");
            System.out.println("4.Exit");
            System.out.println("Enter one choice");
            int choice=in.nextInt();
            try{
                switch(choice){
                    case 1:{
                        System.out.println("Enter the amount:");
                        int amount=in.nextInt();
                        withdraw(amount,accnum,data);
                        break;
                    }
                    case 2:{
                        System.out.println("Enter the amount:");
                        int amount=in.nextInt();
                        deposit(amount,accnum,data);
                        break;
                    }
                    case 3:{
                        balanceEnquiry(accnum,data);
                        break;
                    }
                    case 4: {
                        end=true;break;
                    }
                    default:
                        System.out.println("Enter valid choice");
                }
            }catch(InputMismatchException e){
                System.out.println("Invalid Choice");
                in.next();
            }

        }


    }
    public void withdraw(int amount,int accnum,Map<Integer,Account> data){
        int balance=data.get(accnum).balance;
        if(amount>balance){
            System.out.println("Insuffcient Balance");
        }
        else{
            System.out.println("Please Wait while we are processing your amount");
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Your current balance is: Rs"+ (balance-amount));
            Account account=data.get(accnum);
            account.balance=balance-amount;
            System.out.println("Please Collect your cash");
            System.out.println("-----------------------------------------------------------------");
        }

    }
    public void deposit(int amount,int accnum,Map<Integer,Account> data){
        int balance=data.get(accnum).balance;
        Account account=data.get(accnum);
        account.balance=balance+amount;
        System.out.println("Your amount is deposited successfully");
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Your current account balance is: Rs"+(balance+amount));
        System.out.println("-----------------------------------------------------------------");
    }
    public void balanceEnquiry(int accnum,Map<Integer,Account> data){
        int balance=data.get(accnum).balance;
        System.out.println("-----------------------------------------------------------------");
        System.out.println("Your current account balance is: Rs"+balance);
        System.out.println("-----------------------------------------------------------------");
    }


}
