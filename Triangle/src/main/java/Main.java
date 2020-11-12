import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        CheckTriangle check = new CheckTriangle();
        int a = Integer.MIN_VALUE;
        int b = Integer.MIN_VALUE;
        int c = Integer.MIN_VALUE;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input a, b, c (1<= a,b,c <= 100)");
        do{
            try{
                System.out.print("a = ");
                float tmp = input.nextFloat();
                if(tmp==(int)tmp){
                    a = (int)tmp;
                } else{
                    System.out.println("Please input an integer");
                }
            } catch(Exception ex){
                System.out.println("Please input a, b, c (1<= a,b,c <= 100)");
            }
        } while(a<1 || a>100);
        do{
            try{
                System.out.print("b = ");
                float tmp = input.nextFloat();
                if(tmp==(int)tmp){
                    b = (int)tmp;
                } else{
                    System.out.println("Please input an integer");
                }
            } catch(Exception ex){
                System.out.println("Please input a, b, c (1<= a,b,c <= 100)");
            }
        } while(b<1 || b>100);
        do{
            try{
                System.out.print("c = ");
                float tmp = input.nextFloat();
                if(tmp==(int)tmp){
                    c = (int)tmp;
                } else{
                    System.out.println("Please input an integer");
                }
            } catch(Exception ex){
                System.out.println("Please input a, b, c (1<= a,b,c <= 100)");
            }
        } while(c<1 || c>100);
        System.out.println(check.checkAll(a,b,c));
    }


}
