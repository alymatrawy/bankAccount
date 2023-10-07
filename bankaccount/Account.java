import java.util.Random;

public abstract class Account implements iBaseRate{
    //common properties for savings and checking accounts

    private String name;
    private String securityNumber;
    private double balance;
    static int index=10000;
    protected String accountNumber;
    protected double rate;

    // constructor to set base properties and init the account
    public Account(String name, String securityNumber, double initDeposit){
        this.name= name;
        this.securityNumber = securityNumber;
        this.balance = initDeposit;


        //set account number
        index++;
        this.accountNumber = setAccountNumber();



        setRate();
    }


    //set interest rate
    public abstract void setRate();



    //set account method
    private String setAccountNumber(){

        Random random = new Random();
        int code = random.nextInt(900) +100;
        String lastTwo = securityNumber.substring(securityNumber.length()-2, securityNumber.length());
        return lastTwo + index+ code;
    }


    public void compound(){
        double accruedInterest = balance * (rate/100);
        balance = balance + accruedInterest;
        System.out.println("----------------");
        System.out.println("Accrued interest: $" + accruedInterest);
        printBalance();

    }

    //show account info
    public void showInfo(){


        System.out.println("----------------");
        String firstDigit = String.valueOf(accountNumber.charAt(0));

        if(firstDigit.equals("1")){
            System.out.println("SAVINGS ACCOUNT: ");
        }
        else{
           System.out.println("CHECKINGS ACCOUNT: ");
        }
        System.out.println("Name: "+ name + "\nAccount No.: "+ accountNumber + "\nBalance: "+ balance + "\nRate: " + rate+"%");

    }



    //common methods - transactions


    public void deposit(double amount){
        balance = balance +amount;
        System.out.println("----------------");
        System.out.println("Depositing: $" + amount);
        printBalance();
    }

    public void withdraw(double amount){
        balance = balance -amount;
        System.out.println("----------------");
        System.out.println("Withdrawing: $" + amount );
        printBalance();
    }


    public void transfer(String toWhere, double amount){
        balance = balance -amount;
        System.out.println("----------------");
        System.out.println("Transfer " + amount + "$ to "+ toWhere);
        printBalance();
    }


    public void printBalance(){
        System.out.println("Current Balance: $" +balance);
    }


}
