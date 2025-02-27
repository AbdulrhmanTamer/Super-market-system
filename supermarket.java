import java.util.*;

class Product {
    private String name;
    private double price;
    private boolean available;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
        this.available = true;
    }

    public String getName() {
         return name;
         }

    public double getPrice() { 
        return price; 
    }

    public boolean isAvailable() { 
        return available;
     }

    public void setPrice(double price) {
         this.price = price; 
        }

    public void setAvailable(boolean available) { 
        this.available = available; 
    }
}

class Cart {
   private boolean disc=false;
  public boolean getdisc()
   {
    return disc;
   }
    private List<Product> items = new ArrayList<>();

    public void addProduct(Product product) {
        if (product.isAvailable()) 
        {
            items.add(product);
            System.out.println(product.getName() + " added to cart.");
        } 
        
        else 
        {
            System.out.println("Product not available.");
        }
    }

    public double getTotal() 
    {
        double total=0;
        for (int index = 0; index < items.size(); index++) 
        {
            total+=items.get(index).getPrice();
            
        }
      
       if(total >= 20)
       {
        disc=true;
        return total -(total * 0.1);
       }
       else
       {
        return total;
       }
      
    }

    public void printReceipt()
     {
        System.out.println("\nReceipt:");

        for (Product p : items) 
        {
            System.out.println(p.getName() + " - $" + p.getPrice());
        }

        System.out.println("Total: $" + getTotal());
    }
}

class Employee {
    Scanner input = new Scanner(System.in);
    private String name;
    private List<Product> products;
    
    public Employee(String name, List<Product> products)
     {
        this.name = name;
        this.products = products;
    }

    public void modifyProductPrice(String productName, double newPrice) 
    {
        for (Product p : products) 
        {
            if (p.getName().equalsIgnoreCase(productName)) 
            {
                p.setPrice(newPrice);
                System.out.println("Price updated for " + p.getName());
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void markProductUnavailable(String productName)
     {
        for (Product p : products)
         {
            if (p.getName().equalsIgnoreCase(productName)) 
            {
                p.setAvailable(false);
                System.out.println(productName + " marked as unavailable.");
                return;
            }
        }

        System.out.println("Product not found.");
    }

    public void addmenu()
    {
        System.out.println("enter a new item name: ");
         String name= input.nextLine();
         System.out.println("enter a new item price: ");
        double price=input.nextDouble();
        products.add(new Product(name, price));
        System.out.println("item is added successfully");
        
    }

    public void removemenu()
    {
        showmenu();
        System.out.println("enter a num item to remove from menu:");
         int num= input.nextInt();
         if(num>=1 && num<=products.size())
         {
            products.remove(products.get(num-1));
            System.out.println("item is removed successfully");
         }
         else 
         {
            System.out.println("item not found");
         }
        
    }

    public void showmenu()
    {
        for (int i = 0; i < products.size(); i++)
         {
            System.out.println("\n"+(i + 1) + ". " + products.get(i).getName() + " - $" +  products.get(i).getPrice() +  ( products.get(i).isAvailable() ? "" : " (Unavailable)"));
        }

    }

    
        public String top(List<Product> products)
         {
            Map<Product, Integer> frequencyMap = new HashMap<>();
            String mostFrequent="" ;
            int maxCount = 0;
    
            for ( Product p : products)
             {
                int count = frequencyMap.getOrDefault(p, 0) + 1;
                frequencyMap.put(p, count);
    
                if (count > maxCount) 
                {
                    maxCount = count;
                    mostFrequent = p.getName();
                }
            }
            return mostFrequent;
        }
}

class Cashier {
    private double balance;

    public Cashier(double initialBalance) 
    {
        this.balance = initialBalance;
    }

    public void addTransaction(double amount) 
    {
        balance += amount;
    }

    public double getBalance()
     {
        return balance;
    }

    public void checkShortage(double expectedAmount) 
    {
        if (balance < expectedAmount)
         {
            System.out.println("Financial shortage detected: Missing $" + (expectedAmount - balance));
        } 

        else
         {
            System.out.println("No financial shortage detected.");
        }
    }
}


public class supermarket
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Product> incart = new ArrayList<>();
        List<Product> products = new ArrayList<>(Arrays.asList(

            new Product("Milk", 2.5),
            new Product("Cheese", 4.0),
            new Product("Yogurt", 1.8),
            new Product("Butter", 3.5),
            new Product("Cream", 2.7),

            new Product("Bread", 1.5),
            new Product("Croissant", 2.0),
            new Product("Baguette", 1.8),
            new Product("Donut", 1.2),
            new Product("Muffin", 2.5),
            
            new Product("Chicken Breast", 5.5),
            new Product("Beef Steak", 12.0),
            new Product("Lamb Chops", 14.5),
            new Product("Ground Beef", 7.0),
            new Product("Fish Fillet", 8.5),

            new Product("Apple", 1.2),
            new Product("Banana", 0.8),
            new Product("Orange", 1.0),
            new Product("Grapes", 2.2),
            new Product("Strawberry", 3.0),

            new Product("Tomato", 1.5),
            new Product("Cucumber", 1.0),
            new Product("Carrot", 1.3),
            new Product("Onion", 0.9),
            new Product("Potato", 1.1),

            new Product("Water Bottle", 0.5),
            new Product("Coca Cola", 1.8),
            new Product("Orange Juice", 2.5),
            new Product("Coffee", 3.0),
            new Product("Green Tea", 2.0)
        ));

        Cashier cashier = new Cashier(0.0);
        boolean dado=true;
       while(dado==true)
       {
        System.out.println("******************Welcome to Supermarket System********************");

        System.out.println("Are you a (1) Client or (2) Employee? (0 to finish programm...):");
       
        int choice = scanner.nextInt();
        scanner.nextLine();
        if(choice==0)
        {

        dado=false;
        System.out.println("SYSTEM CLOSED...");

        }
        if (choice == 1)
         {
            System.out.println("Enter your name:");
            String name = scanner.nextLine();
            Cart cart = new Cart();
            while (true) 
            {
                System.out.println("Available Products:");
                for (int i = 0; i < products.size(); i++) 
                {
                    Product p = products.get(i);
                    switch (i) 
                    {
                        case 0: System.out.println("\n dairy products:");
                            break;
                        case 5: System.out.println("\nbakery products:");
                            break;
                        case 10: System.out.println("\nbeefs products:");
                            break;
                         case 15: System.out.println("\nfruits products:");
                            break;
                        case 20: System.out.println("\nvegatables products:");
                            break;
                         case 25: System.out.println("\n1drinks products:");
                            break;
                        default:
                            break;
                    }
                    System.out.println("\n"+(i + 1) + ". " + p.getName() + " - $" + p.getPrice() +  (p.isAvailable() ? "" : " (Unavailable)"));
                }
                System.out.println("Select product number to add to cart (0 to finish):");
                System.out.println("u will get 10% discount if u buy with 20$ \n");

                int prodChoice = scanner.nextInt();
                if (prodChoice == 0) break;
                if (prodChoice > 0 && prodChoice <= products.size()) 
                {
                    cart.addProduct(products.get(prodChoice - 1));
                    incart.add(products.get(prodChoice - 1));
                }
            }
            cart.printReceipt();
            if(cart.getdisc()==true)
            {
                System.out.println("U GOT A 10% DISCOUNT!");
            }
            cashier.addTransaction(cart.getTotal());
        } 

        else if (choice == 2) 
        {
            Employee employee = new Employee("Admin", products);
            while (true)
             {
                System.out.println("Employee Menu:");
                System.out.println("1. Modify Product Price");
                System.out.println("2. Mark Product Unavailable");
                System.out.println("3. Check Cashier Balance");
                System.out.println("4. Check Financial Shortage");
                System.out.println("5. manage menu");
                System.out.println("6. find top product");
                System.out.println("7. Exit");
                int empChoice = scanner.nextInt();
                scanner.nextLine();
                if (empChoice == 7) break;

                switch (empChoice) 
                {
                    case 1:
                        System.out.println("Enter product name:");
                        String prodName = scanner.nextLine();
                        System.out.println("Enter new price:");
                        double newPrice = scanner.nextDouble();
                        employee.modifyProductPrice(prodName, newPrice);
                        break;

                    case 2:
                        System.out.println("Enter product name to mark unavailable:");
                        String unavailableProduct = scanner.nextLine();
                        employee.markProductUnavailable(unavailableProduct);
                        break;

                    case 3:
                        System.out.println("Current balance: $" + cashier.getBalance());
                        break;

                    case 4:
                        System.out.println("Enter expected amount:");
                        double expectedAmount = scanner.nextDouble();
                        cashier.checkShortage(expectedAmount);
                        break;
                    case 5: 
                     
                     while(true)
                     {
                    System.out.println("\nMenu Management:");
                     System.out.println("1. Add Item");
                     System.out.println("2. Remove Item");
                     System.out.println("3. show menu");
                     System.out.println("4. Exit");
                     System.out.println("Enter choice:");
                     int ch=scanner.nextInt();
                    if(ch==1)
                     {
                        employee.addmenu();
                     }

                     else if(ch==2)
                     {
                        employee.removemenu();
                     }

                     else if(ch==3)
                     {
                        employee.showmenu();
                     }

                     else if(ch==4)
                     {
                        break;
                     }

                     else
                     {
                        System.out.println("invalid choice");
                     }
                     }
                     break;
                    case 6:
                        System.out.println("top product is: "+employee.top(incart)); 
                        break;
                    default:
                            System.out.println("Invalid choice.");
                }
            }
        }
       }
       scanner.close();
    }
}
