public class Checking extends Account{

    // list properties specific to a checking account
    private int debitCardNumber;
    private int pin;

    //constructor to init checking account properties
    public Checking(String name, String securityNumber, double initDeposit){
        super(name, securityNumber, initDeposit);
        this.accountNumber = "2"+accountNumber;
        setDebitCard();
    }

    //setting interest rate

    public void setRate(){
        rate = getBaseRate() * .15;
    }

    //setting up account details specific to the checking account

    private void setDebitCard(){
        debitCardNumber = (int)(Math.random() * Math.pow(10,12));
        pin = (int)(Math.random() * Math.pow(10,4));
    }




    //outputting data to the screen
    public void showInfo(){
        super.showInfo();

        System.out.println("Checking Account Info: \nDebit Card Number: " + debitCardNumber);
        System.out.println("Pin: "+ pin);
    }
}