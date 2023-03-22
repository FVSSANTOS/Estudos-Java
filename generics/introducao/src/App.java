import java.util.Scanner;

import service.PrintService;


public class App {
    public static void main(String[] args) throws Exception {

        Scanner in = new Scanner(System.in);

        PrintService<Integer> ps = new PrintService<>();

        System.out.print("How many value?");
        int n = in.nextInt();

        for(int i = 0; i < n;i++){
            int value = in.nextInt();
            ps.addValue(value);
        }

        ps.print();
        System.out.println("First: "+ps.first());
    }
}
