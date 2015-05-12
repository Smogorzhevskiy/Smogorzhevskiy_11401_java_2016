package Hash_Table;
import java.util.Scanner;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashTable<String, String> table = new ChainHashTable<String, String>();
        for(int i = 0; i < n;i++)
        {
            String s = sc.next();
            if(s.equals("push"))
            {
                String temp = sc.next();
                table.push(temp, temp);
            }
            if(s.equals("delete"))
            {
                String temp = sc.next();
                table.delete(temp);
            }
            if(s.equals("get"))
            {
                String temp = sc.next();
                System.out.println(table.get(temp));
            }
        }
    }
}