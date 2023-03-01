import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception 
    {
        
        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int n = scanner.nextInt();

        for(int i = 1; i <= n; i++)
        {
            System.out.println("--- Product #" + i + " data --- ");
            System.out.print("Common, used or imported (c/u/i)? ");
            char type = scanner.next().charAt(0);


            scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Price: ");
            Double price = scanner.nextDouble();

            switch(type){
                case 'c':
                    products.add(new Product(name, price));
                    break;
                case 'u':
                    System.out.print("Manufacture date (DD/MM/YYYY): ");
                    LocalDate date = LocalDate.parse(scanner.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                    
                    products.add(new UsedProduct(name, price, date));
                    break;
                case 'i':
                    System.out.print("Customs fee: ");
                    Double customsFee = scanner.nextDouble();
                    
                    products.add(new ImportedProduct(name, price, customsFee));
                    break;
            }
        }

        System.out.println("-------");
        System.out.println("PRICE TAGS: ");
        for(Product p : products)
        {
            System.out.println(p.priceTag());
        }

        scanner.close();
        
    }

}
