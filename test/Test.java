import java.util.Scanner;
public class Test{

    public static void main(String args[]){
      Scanner in = new Scanner(System.in);
	  System.out.println("Enter a number: ");
	  int a = in.nextInt();
	  System.out.println("Enter another number: ");
	  int b = in.nextInt();
	  int c = a+b;
	  System.out.println(a + " + " + b + " = " + c);
    }

}



