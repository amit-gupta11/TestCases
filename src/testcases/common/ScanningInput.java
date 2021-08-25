package testcases.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import testcases.util.Logs;

public class ScanningInput {

    public final static void getInput() {
        String name;
        String age;
        String birthDate;
        String eMail;

        Scanner inputReader = new Scanner(System.in);
        while (true) {
            System.out.print("Enter Name: ");
            name = inputReader.nextLine();
            if (name.isEmpty()) {
                System.err.print("Name Can't be Null ! \n");
            }
            if ((name.matches(".*[^a-zA-Z ].*")) || name.length() > 20 || name.length() < 3) {
                System.err.print("Name length should not exceed 20 characters and should not accept less than 3 character \n");
                continue;
            } else {
                Logs.printLogs("Invalid Name:" + name);
                break;

            }
        }
        while (true) {
            System.out.print("Enter Age: ");
            age = inputReader.nextLine();
            if (age.isEmpty()) {
                System.err.print("Age Can't be Null ! \n");
            } else if ((age.matches(".*[^0-9].*")) || (Integer.parseInt(age) > 150 && Integer.parseInt(age) <= 0)) {
                System.err.print("Age should be numeric and between 0 to 150 \n");
                continue;
            } else {
                Logs.printLogs("Invalid Age:" + age);
                break;
            }

        }

        while (true) {
            System.out.print("Enter Date of Birth: ");
            birthDate = inputReader.nextLine();
            if ((birthDate == null) || birthDate.isEmpty()) {
                System.err.print("Date of Birth can't be NULL ! \n");
                continue;
            } else {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                try {
                    formatter.parse(birthDate);
                    break;
                } 
                catch (Exception e) {
                    System.err.print("Date of birth should be in DD/MM/YYYY format \n");
                    Logs.printLogs("Invalid Date of Birth:" + birthDate);
                }
            }
        }

        while (true) {
            System.out.print("Enter E-mail Address: ");
            eMail = inputReader.nextLine();
            Pattern validEmail = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
            Matcher matcher = validEmail.matcher(eMail);
            if (!matcher.find()) {
                System.err.println("Email cant be nullL or MissMatched");
                Logs.printLogs("Invalid E-mail:" + eMail);
            } else {
                break;
            }

        }
        
        System.out.println("User Name is = " + name + " " + "and Age is = " + age + " " + "and Birth Date is = " +birthDate + " " + "and E-mail is = " + eMail);
    }

}
