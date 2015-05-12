package Trees;

/**
 * Created by PCuser on 24.03.2015.
 */

import java.util.List;

import W1.DList;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Admin on 24.03.2015.
 */


class Node<T> {
    T elem;
    Node<T> left;
    Node<T> right;
}

class OpNum {
    boolean isOperator;
    char operator;
    int number;
    public String toString() {
        if (isOperator)
            return String.valueOf(operator);
        else
            return String.valueOf(number);
    }
}

class Command {
    String result;
    String left;
    char op;
    String right;
    public String toString() {
        return left+" "+right+" "+op+" ";
    }
}
public class LRTree<T> {
    public Node<T> root;
    int next=0;
    List<Command> commands=new LinkedList<Command>();


    public Node<Integer> input(Scanner sc) {    //Заполняется дерево по введенной строке. 23400050602409. 0 = null.
        Integer x = sc.nextInt();               //Для деревьев, содержащих только числа.
        if (x == 0)
            return null;
        else {
            Node<Integer> root = new Node<Integer>();
            root.elem = x;
            root.left = input(sc);
            root.right = input(sc);
            return root;
        }
    }

    public void output(Node<Integer> root) {
        if (root == null)
            System.out.print("0 ");
        else {
            System.out.print(root.elem + " ");
            output(root.left);
            output(root.right);
        }
    }

    public void output_v2(Node<Integer> root, int probel) {
        if (root!=null)
            System.out.println();
        for (int i=0; i<probel; i++)
            System.out.print(" ");
        System.out.print(root.elem);
        output_v2(root.left, probel+2);
        output_v2(root.right, probel+2);
    }

    public Node<OpNum> inputExpr(Scanner sc){    //Вводится строка. После 1 - знак, после 0 - число.
        int x=sc.nextInt();
        Node<OpNum> p=new Node<OpNum>();
        p.elem=new OpNum();
        p.elem.isOperator=(x!=0);
        if (x==0) {
            p.elem.number=sc.nextInt();
            p.left=null;
            p.right=null;

        } else {
            String op=sc.next();
            p.elem.operator=op.charAt(0);
            p.left=inputExpr(sc);
            p.right=inputExpr(sc);
        }
        return p;

    }

    public boolean isSame(Node<OpNum> t1, Node<OpNum> t2) {
        if (t1.elem!=t2.elem)
            return false;
        if (!t1.elem.isOperator)
            return true;
        boolean ll=isSame(t1.left, t2.left);
        boolean lr=isSame(t1.left, t2.right);
        boolean rl=isSame(t1.right, t2.left);
        boolean rr=isSame(t1.right, t2.right);
        if (t1.elem.operator=='-')
            return ll&&rr;
        else
            return (ll&&rr)||(lr&&rl);
    }

    Node<OpNum> replace (Node<OpNum> expr, Node<OpNum> search, Node<OpNum> replacement) {
        if (isSame(expr, search))
            return replacement;
        expr.left=replace(expr.left, search, replacement);
        expr.right=replace(expr.right, search, replacement);
        return expr;
    }

    int eval(Node<OpNum> root) {
        if (root==null)
            return 0;
        if (!root.elem.isOperator)
            return root.elem.number;
        int l=eval(root.left);
        int r=eval(root.right);
        switch(root.elem.operator) {
            case '+':
                return l+r;
            case '-':
                return l-r;
            default:
                return l*r;
        }
    }


    //Представить выражение по частям.
    List<Command> compile(Node<OpNum> root) {
        compile1(root);
        return commands;
    }

    String compile1(Node<OpNum> root) {
        if (!root.elem.isOperator) {
            return new Integer(root.elem.number).toString();
        }
        else {
            Command c=new Command();
            c.result="r"+next;           //чтобы переменная каждый раз была новая
            next++;
            c.left=compile1(root.left);
            c.op=root.elem.operator;
            c.right=compile1(root.right);
            commands.add(c);
            return c.result;
        }
    }


    //Дерево преобразовать в обратную польскую запись, сохранив в list.
    DList<OpNum> treeToOPN(Node<OpNum> root, DList<OpNum> OPN) {
        DList<OpNum> list=OPN;
        if (root.elem.isOperator) {
            treeToOPN(root.left, list);
            treeToOPN(root.right, list);
            list.addEnd(root.elem);
        }
        else {
            list.addEnd(root.elem);
        }
        return list;
    }

}