package testcases.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScanningInput {

    public static void getInput() {
        Scanner inputReader = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Name: ");
            String userName = inputReader.nextLine();
            if ((userName == null) || (userName.matches(".*[^a-zA-Z].*")) || userName.length() > 20 || userName.length() < 3) {
                System.err.print("Name length should not exceed 20 characters and should not accept less than 3 character \n");
                continue;
            } else {
                break;
            }
        }
        while (true) {
            System.out.print("Enter Age: ");
            String age = inputReader.nextLine();
            if(age.isEmpty()){
                System.err.print("Age Can't be Null ! \n");
            }
            else if ( (age.matches(".*[^0-9].*"))|| (Integer.parseInt(age)>150 && Integer.parseInt(age)<=0)) {
                System.err.print("Age should be numeric and between 0 to 150 \n");
                continue;
            } else {
                break;
            }
        }

        while (true) {
            System.out.print("Enter Date of Birth: ");
            String birthDate = inputReader.nextLine();
            if ((birthDate == null) || birthDate.isEmpty()) {
                System.err.print("Date of Birth can't be NULL ! \n");
                continue;
            } else {
                SimpleDateFormat dateFormat = new SimpleDateFormat("DD-MM-YYYY");
                try {
                    Date coorectBirthdate = dateFormat.parse(birthDate);
                    break;
                } catch (ParseException e) {
                    System.err.print("Date of birth should be in DD-MM-YYYY format \n");
                }

            }
        }

        while (true) {
            System.out.print("Enter E-mail Address: ");
            String eMail = inputReader.nextLine();
            Pattern validEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = validEmail.matcher(eMail);
        if(!matcher.find()){
            System.err.println("Email cant be nullL or MissMatched");
        }
      
       else{
           break;
       }

        }

    }
}
