package emailapp;

import java.util.Locale;
import java.util.Scanner;

public class email {
   private String firstName;
  private   String lastName;
  private   String password;
    private String department;
   private int mailboxCapacity = 500;
   private int defaultPasswordLength = 10;
   private String email;
   private String alternateEmail;
   private String companySuffix = "company.com";

   // constructor to receive the first name and last name
    public email(String firstName,String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
     //   System.out.println("Email created :" + this.firstName + " " + this.lastName);

        // Call a method asking for the department  -  return department
        this.department = setDepartment();
   //     System.out.println("Department: "+ this.department);
        // Call a method that return a random password
        this.password= randomPassword(defaultPasswordLength);
        System.out.println("Your password is: "+ this.password);
        // combine elements to generate email
        email = firstName.toLowerCase() + "." + lastName.toLowerCase() + "@" + department +"."+ companySuffix;
   //     System.out.println("Your email is: "+ email);
    }
   // Ask for the department
    private String setDepartment() {
        System.out.print("New worker: " + firstName +". DEPARTMENT CODE:\n1 for Sales\n2 for Development\n3 for Accounting\n0 for none\nEnter department code:");
        Scanner in = new Scanner(System.in);
     int depchoice = in.nextInt();
        if (depchoice ==1) {
            return "sales";
        } else if (depchoice ==2) {
            return "dev";
        } else if (depchoice == 3) {
            return "acct";
        }
        else {
            return "";
        }
    }
   // Generate a random password
    private String randomPassword(int length) {
        String passwordSet ="ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$";
        char[] password = new char[length];
        for (int i=0;i<length;i++) {
            int rand= (int) (Math.random() * passwordSet.length());
            password[i] = passwordSet.charAt(rand);

        }
        return new String(password);
    }
   // set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }
   // set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }
   // change the password
public void changePassword(String password) {
        this.password = password;
}
public int getMailboxCapacity() { return mailboxCapacity;}
    public String getAlternateEmail() { return alternateEmail;}
    public String getPassword() { return password;}
    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nMAILBOX CAPACITY: " +mailboxCapacity + "mb";
    }
}
