import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int monthInYear = 12;
        int percent = 100;

        Scanner scan = new Scanner(System.in);

        System.out.print("Amount to loan: ");
        int amount = scan.nextInt();

        System.out.print("Annual Interest Rate: ");
        float annualRate = scan.nextFloat();
        float monthlyRate = annualRate / percent / monthInYear;

        System.out.print("Period (years): ");
        int years = scan.nextInt();
        int numberOfPayments = years * monthInYear;

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
