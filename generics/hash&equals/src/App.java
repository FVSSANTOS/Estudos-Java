import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import entities.Student;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner in = new Scanner(System.in);

       String path = "C:\\projeto\\out.txt";

        

        try(BufferedReader br = new BufferedReader(new FileReader(path))){
            
            Set<Student> s = new HashSet<>();

            String line = br.readLine();
            while(line != null){

                String[] fields = line.split(",");
                String name = fields[0].toUpperCase();
                String cod = fields[1];
                String course = fields[2].toUpperCase();

                s.add(new Student(name,cod,course));

                line = br.readLine();
            }

            System.out.println("Total students: "+s.size());
            
        } catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        }
    }
}
