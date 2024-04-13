package application;

import enities.CompanyTax;
import enities.IndividualTax;
import enities.TaxPayer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List <TaxPayer> list = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of tax payers: ");
        int n = sc.nextInt();
        for (int i=0; i<n; i++){
             System.out.print("Enter if is company or individual payer: (i/c) ");
             char typeOfPayer = sc.next().charAt(0);
             sc.nextLine();
             System.out.print("Name: ");
             String name = sc.nextLine();
             System.out.print("Anual income: ");
             double anualIncome = sc.nextDouble();
             if (typeOfPayer == 'i'){
                 System.out.print("Health expenditures: ");
                 double healthExpenditures = sc.nextDouble();
                 list.add(new IndividualTax(name, anualIncome, healthExpenditures));
             }else{
                 System.out.print("Number of employees: ");
                 int numberOfEmployees = sc.nextInt();
                 list.add(new CompanyTax(name, anualIncome, numberOfEmployees));
             }
        }

        System.out.println("TAXES PAID:");
        for (TaxPayer tax: list) {
            System.out.printf("%s: $ %.2f%n", tax.getName(), tax.tax());
        }

        double sum = 0;
        for (TaxPayer totalTax: list) {
            sum += totalTax.tax();
        }

        System.out.println("TOTAL TAXES: " + sum);


        sc.close();

    }
}