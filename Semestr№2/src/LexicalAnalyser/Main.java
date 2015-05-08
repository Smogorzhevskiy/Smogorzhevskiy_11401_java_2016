package LexicalAnalyser;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        LexicalAnalyser lexAn = new LexicalAnalyser();
        Scanner sc=new Scanner(System.in);
        List<Lexeme> list = lexAn.lexAnalyse();
        List<Command> commands = new LinkedList<Command>();
        Table table = lexAn.getTov();
        List<String> output = lexAn.getOutput();
        List<String> input = new LinkedList<String>(); // список переменных без значения
        input.add("A1");
        input.add("X");
        input.add("A");
        input.add("B");
        input.add("Z");
        input.add("Y");






        System.out.println("Лексемы: ");
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getType()==Lexeme.Type.INT){
                System.out.print(list.get(i).number+"  ");
            }
           else if (list.get(i).getType()==Lexeme.Type.VAR){
                System.out.print(list.get(i).variable+"  ");
            }
            else  System.out.print(list.get(i).getType()+"  ");

        }
        System.out.println();
        System.out.println("Неизвестные переменные:");
        Command com1 = new Command();   //Первая трехадресная команда
        com1.condition_operation='<';
        com1.condition_first_Operand.setType("number");
        com1.condition_first_Operand.setValue(-100);
        com1.condition_second_Operand.setType("variable");
        com1.condition_second_Operand.setName("A1");
        com1.T_result = "X";
        com1.T_operandNumber = 1;
        com1.T_first_Operand.setType("number");
        com1.T_first_Operand.setValue(-10203);
        com1.F_result = "X";
        com1.F_operandNumber = 2;
        com1.F_first_Operand.setType("variable");
        com1.F_first_Operand.setName("X");
        com1.F_operation = '+';
        com1.F_second_Operand.setType("number");
        com1.F_second_Operand.setValue(-35010);

        commands.add(com1);

        Command com2 = new Command();
        com2.condition_operation='=';
        com2.condition_first_Operand.setType("variable");
        com2.condition_first_Operand.setName("A");
        com2.condition_second_Operand.setType("variable");
        com2.condition_second_Operand.setName("B");

        com2.T_result = "Y";
        com2.T_operandNumber = 2;
        com2.T_first_Operand.setType("variable");
        com2.T_first_Operand.setName("X");
        com2.T_operation = '*';
        com2.T_second_Operand.setType("variable");
        com2.T_second_Operand.setName("Z");
        com2.F_result = "Y";
        com2.F_operandNumber = 2;
        com2.F_first_Operand.setType("variable");
        com2.F_first_Operand.setName("X");
        com2.F_operation = '/';
        com2.F_second_Operand.setType("variable");
        com2.F_second_Operand.setName("Y");

        commands.add(com2);


        Interpreter interpreter = new Interpreter(input, commands, sc, table);
        interpreter.run();

        System.out.println();

        table.printOut();
    }
}