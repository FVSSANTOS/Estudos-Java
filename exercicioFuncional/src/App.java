import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Employee;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter full file path: ");
        String path = in.next();

        System.out.print("Enter Salary: ");
        Double salary = in.nextDouble();

        try(BufferedReader br = new BufferedReader(new FileReader(path))){

            List<Employee> list = new ArrayList<>();
            String line = br.readLine();

            while(line != null){
                String[] fields = line.split(",");
                list.add(new Employee(fields[0], fields[1], Double.parseDouble(fields[2])));
            }

           Comparator<String> comp = (emp1,emp2) -> emp1.toUpperCase().compareTo(emp2.toUpperCase());

            List<String> newList = list.stream()
                                   .filter(e -> e.getSalary() > salary)
                                   .map(e -> e.getEmail())
                                   .sorted(comp)
                                   .collect(Collectors.toList());
            newList.forEach(System.out::println);
                                   
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
