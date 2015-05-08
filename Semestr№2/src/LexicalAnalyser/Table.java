package LexicalAnalyser;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Table {

    private Map<String, Integer> hm;
    private Integer i;
    private List<String> output;      //Список переменных, которые будут выводиться

    Table() {
        hm = new HashMap<String, Integer>();
        i = 0;
        output = new LinkedList<String>();
    }

    public void addToOutput(String variable) {     // добавляем переменную в список ,который нужно будет вывести
        if (!output.contains(variable))
            output.add(variable);
    }

    public int putVar(String variable) {  // добавляем переменную в таблицу, если раньше  ее не было
        if (hm.containsKey(variable))
            return hm.get(variable);
        else {
            hm.put(variable, i);
            i++;
            return i-1;
        }
    }

    public int getValue(String variable) {
        return hm.get(variable);
    }  // возвращаем значение переменной

    public List<String> getOutput() {
        return output;
    } // возвращаем список выводимых переменных

    public void putInt(String variable, Integer value) { // заменяем значение переменной на вычесленное.
        hm.put(variable, value);
    }

    public void printOut () {                            // выводим список переменных
        for (int i=0; i<output.size(); i++)
            System.out.println(output.get(i) + " = " + hm.get(output.get(i)));
    }

}