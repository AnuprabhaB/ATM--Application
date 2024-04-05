import java.util.*;
public class Bank {
    Scanner in=new Scanner(System.in);
    public void getData(Map<Integer,Account> data){
        System.out.println("Enter your bank name:");
        String name=in.next();
        if(isvalidBank(name)){
            System.out.println("Customer Details of "+name+" bank");
            System.out.println("-----------------------------------------------------------------");
            for (Map.Entry<Integer, Account> entry : data.entrySet()) {
                Account account = entry.getValue();
                if(account.bank_name.equals(name)){
                    System.out.println(account.name+" "+account.accnum);
                }
            }
            System.out.println("-----------------------------------------------------------------");
            System.out.println("Do you wish to continue? yes/no");
            String input=in.next();
            if(input.equals("yes")||input.equals("YES")||input.equals("y")) getData(data);
            else return;
        }
        else{
            return;
        }

    }
    public boolean isvalidBank(String name){
        Map<String,List<Integer>> bankMap=new HashMap<>();
        bankMap.put("HDFC",Arrays.asList(123456,9871));
        bankMap.put("ICI",Arrays.asList(758463,3452));
        bankMap.put("CANARA",Arrays.asList(903567,5671));
        bankMap.put("IOB",Arrays.asList(267489,5679));
        if(bankMap.containsKey(name)){
            System.out.println("Enter your bank id:");
            int id=in.nextInt();
            List<Integer> list=bankMap.get(name);
            if(list.get(0)==id){
                System.out.println("Enter your pin:");
                int pin=in.nextInt();
                if(list.get(1)==pin){
                    return true;
                }
                else {
                    System.out.println("Your pin doesn't match");
                    return false;
                }
            }
            else{
                System.out.println("Invalid id");
                return false;
            }
        }
        else{
            System.out.println("Your bank name doesn't exist");
            return false;
        }
    }
}
