package LexicalAnalyser;

import LexicalAnalyser.Command;
import LexicalAnalyser.Table;

import java.util.List;
import java.util.Scanner;

class Interpreter {

    //Считывая значения переменных из input, записывать их в таблицу значений,
    // заменяя значение при ключе String на это числовое значение
    private List<String> input;           //список переменных, значения которых необходимо ввести
    private List<Command> commands;       //список трехадресных команд
    private Scanner sc;
    private Table table;                 //таблица значений

    public Interpreter(List<String> input, List<Command> commands, Scanner sc, Table table) {
        this.input = input;
        this.commands = commands;
        this.sc = sc;
        this.table = table;
    }
    public void run() {
        for (int i = 0; i < input.size(); i++) {
            System.out.println(input.get(i)+" - неизвестно ");
            table.putInt(input.get(i), sc.nextInt());
        }

        for (int i=0; i<commands.size(); i++) {
            commands.get(i).run(table);
        }
    }


}