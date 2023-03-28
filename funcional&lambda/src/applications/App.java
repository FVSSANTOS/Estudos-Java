package applications;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import entities.Product;
import model.services.ProductService;
import util.PriceUpdate;
import util.ProductPredicate;
import util.UpperCaseName;

public class App {
    public static void main(String[] args) throws Exception {
        
        
        List<Product> list = new ArrayList<>();

        list.add(new Product("Tv", 900.00));
        list.add(new Product("Mouse", 50.00));
        list.add(new Product("Tablet", 350.00));
        list.add(new Product("HD Case", 89.90));

        //predicate
        list.removeIf(p -> p.getPrice() >= 100);

        for(Product p : list){
            System.out.println(p);
        }

        //consumer
        list.forEach(new PriceUpdate());
        list.forEach(System.out::println);

        //Function
        List<String> names = list.stream().map(new UpperCaseName()).collect(Collectors.toList());
        names.forEach(System.out::println);

        //Criando funções que recebem funções como argumento
        ProductService ps = new ProductService();

        double sum = ps.filterSum(list, p -> p.getName().charAt(0) == 'T');

        System.out.println("Sum = "+String.format("%.2f",sum));

        //Stream
        List<Integer> list1 = Arrays.asList(3,4,5,10,7);

        Stream<Integer> st1 = list1.stream()
        .map(x -> x * 10);
        System.out.println(Arrays.toString(st1.toArray()));

        Stream<String> st2 = Stream.of("Maria", "Alex", "Bob");
        System.out.println(Arrays.toString(st2.toArray()));

        Stream<Integer> st3 = Stream.iterate(0, x -> x + 2);
        System.out.println(Arrays.toString(st3.limit(10).toArray()));

        Stream<Long> st4 = Stream.iterate(new Long[] {0L, 1L}, p -> new Long[]{p[1], p[0]+p[1]}).map(p -> p[0]);
        System.out.println(Arrays.toString(st4.limit(10).toArray()));

        //Pipeline
        List<Integer> list2 = Arrays.asList(3,4,5,10,7);

        Stream <Integer> st = list2.stream().map(x -> x * 10);
        System.out.println(Arrays.toString(st.toArray()));

        int sum2 = list2.stream().reduce(0, (x,y) -> x + y);
        System.out.println("Sum = "+ sum);

        List<Integer> newList = list2.stream()
        .filter(x -> x%2 == 0)
        .map(x -> x * 10)
        .collect(Collectors.toList());
        System.out.println(Arrays.toString(newList.toArray()));
    }
}
