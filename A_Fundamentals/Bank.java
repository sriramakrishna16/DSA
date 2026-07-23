package A_Fundamentals;
//creation, amount , withdrawl...
class Account{
    long accountNo;
    String name;
    double balance;
    Account(String name , double balance){
        long number = (long) (Math.random() * 10000000000L);
        this.accountNo = number;
        this.name = name;
        this.balance = balance;
    }
}

class Customer extends Account{
    Customer(String name, double balance){
        super(name,balance);
    }

    void withdraw(double amount){
        if(amount > balance) System.out.println("insufficient balance");
        else balance -= amount;
    }

    void deposit(double amount){
        if(amount < 0) System.out.println("deposit failed");
        else balance += amount;
    }

    void printDetails(){
        System.out.println("name : " + name);
        System.out.println("account no : " + accountNo);
        System.out.println("balance : " + balance);
    }
}

class Bank{
    public static void main(String args[]){
        Customer c1 = new Customer("ram", 5000);
        c1.withdraw(5000);
        c1.deposit(1000);
        c1.printDetails();
    }
}
