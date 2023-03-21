package application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {
    public static void main(String[] args) throws ParseException {
        
        Locale.setDefault(Locale.US);
        Scanner in = new Scanner(System.in);

        
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.println("Enter contract data:");
        System.out.print("Number:");
        Integer number = in.nextInt();

        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(in.next());

        System.out.print("Contarct value: ");
        Double totalValue = in.nextDouble();

        Contract contract = new Contract(number,date,totalValue);

        ContractService cs = new ContractService(new PaypalService());

        System.out.print("Enter number of installments: ");
        Integer numberInstallments = in.nextInt();

        cs.processContract(contract, numberInstallments);

        System.out.println("Installments:");
        for(Installment it : contract.getInstallments()){
            System.out.println(it);
        }
       

        in.close();
    }
}
