import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
       
        List<Integer> myInts = Arrays.asList(1,2,3,4);
        List<Double> myDoubles = Arrays.asList(3.14,6.28);
        List<Object> myObjs = new ArrayList<Object>();

        copy(myInts, myObjs);
        printList(myObjs);
        copy(myDoubles,myObjs);
        printList(myObjs);
   }

   //A primeira lista é um exemplo de covariância(a lista pode receber qualquer subtipo de Number)
   //A segunda lista é um exemplo de contravariância(a lista pode receber qualquer super tipo de Number)
   public static void copy(List<? extends Number> source, List<? super Number> destiny){
    for(Number number : source){
        destiny.add(number);
    }
   }

   public static void printList(List<?> list){
    for(Object obj : list){
        System.out.print(obj+" ");
    }
    System.out.println();
   }
}
