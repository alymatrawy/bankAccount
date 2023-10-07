public class Savings extends Account{

    // list properties specific to a savings account
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;


    //constructor to init savings account properties
    public Savings(String name, String securityNumber, double initDeposit){
        super(name, securityNumber, initDeposit);

        setSafetyDepositBox();

        this.accountNumber = "1" + accountNumber;
    }


    //set up interest rate

    public void setRate(){
        rate = getBaseRate() -.25 ;
    }


    //setting up account detail specific to the savings account

    private void setSafetyDepositBox(){
        safetyDepositBoxID = (int) (Math.random() * Math.pow(10,3));
        safetyDepositBoxKey = (int) (Math.random() * Math.pow(10,4));
    }


    //outputting data to the screen

    public void showInfo(){


        super.showInfo();

        System.out.println("Your Savings Account features: \nID: " +safetyDepositBoxID);
        System.out.println("Key: " + safetyDepositBoxKey);



    }
}