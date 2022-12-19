 import java.util.Scanner;

 public class Nate1 {
     public static void main(String args[]) {
       final byte MONTHS_IN_YEAR = 12;
       final byte PERCENT = 100;

       Scanner scanner = new Scanner(System.in);

       System.out.println("House Price : ");
       int principal = scanner.nextInt();

       System.out.print("Annual Interest Rate: ");
       float annualInterest = scanner.nextFloat();
       float monthlyInterest = annualInterest / PERCENT / MONTHS_IN_YEAR;

       System.out.print("Period (Years): ");
       byte years = scanner.nextByte();
       int numberOfPayments = years * MONTHS_IN_YEAR;

       double mortgage = principal
                 * (monthlyInterest * Math.pow(1 + monthlyInterest, numberOfPayments))
                 / (Math.pow(1 + monthlyInterest, numberOfPayments) - 1);

       //String mortgageFormatted = NumberFormat.getCurrencyInstance();
       System.out.println("Mortgage payment is: $" + String.format("%.2f", mortgage));
     }
 }
