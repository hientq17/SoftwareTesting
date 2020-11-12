import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException  {
        Scanner input = new Scanner(System.in);
        int choice;
        do{
            System.out.println(">>>> SELENIUM TESTING <<<<");
            System.out.println("> 1. Calculator Testing ");
            System.out.println("> 2. Login Testing ");
            System.out.println("> 0. Exit");
            System.out.println("--------------------------");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice){
                case 1:
                    new CalculatorTesting().test();
                    break;
                case 2:
                    new LoginTesting().test();
                    break;
                case 0: return;
            }
        } while(choice == 1 || choice ==2);
    }
}
