import java.util.Scanner;
public class KeyboardS {
    public static void main(String[] args) throws MyException {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<Integer>();
        Integer a;
        try {
            do {
                a = sc.nextInt();
                if (a > 0)
                    stack.push(a);
                else if (a != 0) {
                    if (Math.abs(a) == (stack.pop()))
                        System.out.println(true);
                    else stack.pop();
                }
            } while (a!= 0);
        } catch (MyException e){
            System.out.println("Issue: "+e);
        }
    }

}
