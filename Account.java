public class Account {
    String name;
    String bank_name;
    int accnum;
    int balance;
   int pin;
    Account(String name,String bank_name,int accnum,int bal,int pin){
        this.name=name;
        this.bank_name=bank_name;
        this.accnum=accnum;
        this.balance=bal;
        this.pin=pin;
    }
    Account(int accnum,int bal,int amount){
        this.accnum=accnum;
        this.balance=bal-amount;

    }
    Account(int accnum,int amount){
        this.accnum=accnum;
        this.balance=balance+amount;
    }

}

