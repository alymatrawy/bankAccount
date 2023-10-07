import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BankAccountMain {

    public static void main(String[] args){

        List<Account> accounts = new LinkedList<>();
        //read a csv file and create new accounts based on that data

        String csvFileName = "NewBankAccounts.csv";
        String csvFile = System.getProperty("user.dir") + "/" + csvFileName;

        List<String[]> records = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line into fields using a comma as the separator
                String[] fields = line.split(",");

                // Add the fields array to the records list
                records.add(fields);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

      // Now, you can access the records list for further processing
        for (String[] record : records) {
            String name = record[0];
            String securityNumber = record[1];
            String accountType = record[2];
            double initDeposit = Double.parseDouble(record[3]);


            if(accountType.equals("Savings")){
                accounts.add(new Savings(name,securityNumber,initDeposit));
            }
            else if(accountType.equals("Checking")){
                accounts.add(new Checking(name,securityNumber,initDeposit));
            }
        }


        for(Account acc: accounts){
            acc.showInfo();
        }
   }






    }

