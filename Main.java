import java.lang.annotation.Annotation;
import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int monthInYear = 12;
        int percent = 100;
        int amount;
        float annualRate;
        float monthlyRate;
        int years;
        int numberOfPayments;

        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.print("Amount to loan (1k - 10M): ");
            amount = scan.nextInt();
            if (amount >= 1000 && amount <= 10000000) {
                break;
            } else {
                System.out.println("Please enter an amount between 1,000 and 10,000,000");
            }
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualRate = scan.nextFloat();
            if (annualRate >= 1 && annualRate <= 15) {
                monthlyRate = annualRate / percent / monthInYear;
                break;
            } else {
                System.out.println("Please enter a valid interest rate.");
            }
        }

        while (true) {
            System.out.print("Period (years): ");
            years = scan.nextInt();
            if (years >= 1 && years <= 30) {
                numberOfPayments = years * monthInYear;
                break;
            } else {
                System.out.println("Please enter an number between 1 and 30.");
            }
        }
        double mortgage = amount * (monthlyRate * Math.pow(1 + monthlyRate, numberOfPayments))
                / (Math.pow(1 + monthlyRate, numberOfPayments) - 1);

        String mortgageFormatted = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Monthly payment: " + mortgageFormatted);

        float totalAmountPaid = (float) mortgage * monthInYear * years;
        String totalAmountPaidFormatted = NumberFormat.getCurrencyInstance().format(totalAmountPaid);
        System.out.println("Total amount paid to the bank in " + years + " years: " + totalAmountPaidFormatted);

        float InterestPaid = totalAmountPaid - amount;
        String InterestPaidFormatted = NumberFormat.getCurrencyInstance().format(InterestPaid);
        System.out.println("Total interest paid in " + years + " years: " + InterestPaidFormatted);

    }
}
