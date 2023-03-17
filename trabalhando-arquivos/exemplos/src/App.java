import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        System.err.println("Enter a file path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        System.out.println("getName: "+ path.getName());
        






        //Manipulando pastas e arquivos
        /* System.out.println("Enter a folder path: ");
        String strPath = sc.nextLine();

        File path = new File(strPath);

        File[] folders = path.listFiles(File::isDirectory);
        System.out.println("FOLDERS:");
        for(File folder : folders){
            System.out.println(folder);
        }
        
        File[] files = path.listFiles(File::isFile);
        System.out.println("FILES:");
        for(File file : files){
            System.out.println(file);
        }

        //Criando uma subpasta
        boolean sucess = new File(strPath + "\\subdir").mkdir(); */
        
        sc.close();

        //Criando e escrevendo em um arquivo

        /* 
        String[] lines = new String[] {"eu", "me", "amo"};
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))){
            for(String line : lines){
                bw.write(line);
                bw.newLine();
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
         */






        //Lendo arquivo utilizando FileReader e BufferedReader

       /*  
       String path = "c:\\projeto\\out.txt";
       try(Bu folfferedReader br = new BufferedReader(new FileReader(path))){
            String line = br.readLine();

            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }
        catch(IOException e){
            System.out.println("Error: "+ e.getMessage());
        } */







        //Lendo arquivo utilizando a classe File

        /* File file = new File("c:\\projeto\\in.txt");
        Scanner sc = null;
        
        try{
            sc = new Scanner(file);
            while(sc.hasNextLine()){
                System.out.println(sc.nextLine());
            }
        }catch(IOException e){
            System.out.println("Error:" + e.getMessage());
        }
        finally{
            if(sc != null){
                sc.close();
            }
        } */
        
    }
}
