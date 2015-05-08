package LexicalAnalyser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;


public class LexicalAnalyser {

    List<Lexeme> list;
    BufferedReader bf;
    private String lastSymbol;
    private String signNumber;
    private  Table table;



    public LexicalAnalyser() throws FileNotFoundException {
        this.list = new LinkedList<Lexeme>();
        this.bf = new BufferedReader(new FileReader("/Users/User/Desktop/11111111111.txt"));
        this.table = new Table();
        lastSymbol="";
        signNumber="plus";

    }





    public Table getTov(){
        return table;
    }     // возвращает таблицу

    public List<String> getOutput() {
        return table.getOutput();
    } // возвращает список переменных, которые нужно вывести

    boolean isOperator(char sym) {
        return ((sym == '+') || (sym == '-') || (sym == '*') || (sym == '/'))&&(lastSymbol!="operator"); // оператор
    }

    boolean isCharacter(char sym) {
        return (((sym >= 'A') && (sym <= 'Z')) || ((sym >= 'a') && (sym <= 'z')));  // буква
    }

    boolean isNumber (char sym) {
        return ((sym >= '0') && (sym <= '9'));
    }    //число

    String symbolType(char sym) {
        if (((sym == '+') || (sym == '-')) && ((lastSymbol == "operator") || (lastSymbol == "assign")||(lastSymbol=="less")||(lastSymbol=="openBkt")||(lastSymbol=="equally")))
            return "numberSign";       // тип числа положительный или отрицательный
        else if (isOperator(sym))
            return "operator";        // оператор
        else if (isCharacter(sym))
            return "variable";         // буква
        else if (isNumber(sym))
            return "number";           // число
        else if (sym=='<')
            return  "less";            // <
        else if ((sym == '[') || (sym == ']'))
            return "bracket";          // скобки
        else if (sym == ':')
            return "colon";            // :
        else if (sym == '=')
            return "assign";          // =
        else if (sym == ';')
            return "semicolon";       // ;
        else if ((sym == ' ') || (sym == '\n') || (sym == '\r'))
            return "gap";        // пробел
        else if (sym == '.')
            return "dot";        // точка
        else {
            throw new  MyError("Неизвестный знак");
        }
    }


    public List<Lexeme> lexAnalyse() throws IOException{

        int bfInt = bf.read();           // считываем по одному
        char symbol = (char) bfInt;      // символу


        while ((bfInt!=-1)&&(symbol!='.')) {

            Lexeme lexeme = new Lexeme();

            String variable = "";
            int number;
            String numberString = "";

            if (lastSymbol != "colon") {                  // Если не :
                if (symbolType(symbol) == "operator") {  // Если (+ - * /) при условии, что перед этим нет одного из этих же символов
                        if ((lastSymbol == "variable") || (lastSymbol == "number")) {  //(+ - / * )могут стоять только после переменных и чисел

                            if (symbol == '+') {
                                lexeme.type = Lexeme.Type.PLUS;
                                list.add(lexeme);
                            }
                            if (symbol == '-') {
                                lexeme.type = Lexeme.Type.MINUS;
                                list.add(lexeme);
                            }
                            if (symbol == '*') {
                                lexeme.type = Lexeme.Type.MULT;
                                list.add(lexeme);
                            }
                            if (symbol == '/') {
                                lexeme.type = Lexeme.Type.DEVIDE;
                                list.add(lexeme);
                            }
                            lastSymbol = "operator";

                            bfInt = bf.read();
                            if (bfInt != -1)
                                symbol = (char) bfInt;

                        } else {

                            throw new MyError("Операторы(+ - * /) повторяются");
                        }
                    } else if (symbolType(symbol) == "numberSign") { // если символ не оператор, то он может быть символом числа
                    // символ числа может стоять после оператора, присваивания,левой скобки,<,=
                    if ((lastSymbol == "operator") || (lastSymbol == "assign") || (lastSymbol == "openBkt")||(lastSymbol=="less")||(lastSymbol=="equally")) {
                            if (symbol == '+')
                                signNumber = "plus";
                            else
                                signNumber = "minus";
                            lastSymbol = "numberSign";
                            bfInt = bf.read();
                            if (bfInt != -1)
                                symbol = (char) bfInt;
                        } else {
                            throw new MyError("Операторы(+ - * /) повторяются");
                        }
                    } else if (symbol == ';') {
                        if ((lastSymbol == "closeBkt")) {
                            lexeme.type = Lexeme.Type.SEMICOLON;
                            lastSymbol = "semicolon";

                            list.add(lexeme);
                            bfInt = bf.read();
                            if (bfInt != -1)
                                symbol = (char) bfInt;
                        } else {

                            throw new MyError("(;) может стоять только после (])");
                        }
                    } else if (symbol == '[') {
                        if ((lastSymbol == "variable") || (lastSymbol == "number") || (lastSymbol == "closeBkt")) {
                            lexeme.type = Lexeme.Type.LBRACKET;
                            lastSymbol = "openBkt";
                            list.add(lexeme);
                            bfInt = bf.read();
                            if (bfInt != -1)
                                symbol = (char) bfInt;
                        } else {
                            throw new MyError("([) может стоять только после переменной, числа,(])");
                        }
                    } else if (symbol == ']') {
                        if ((lastSymbol == "variable") || (lastSymbol == "number")) {
                            lexeme.type = Lexeme.Type.RBRACKET;
                            lastSymbol = "closeBkt";
                            list.add(lexeme);
                            bfInt = bf.read();
                            if (bfInt != -1)
                                symbol = (char) bfInt;
                        } else {
                            throw new MyError("(]) может стоять только после числа или переменной");
                        }
                    } else if (symbol == ':') {
                        if (lastSymbol == "variable") {
                            lastSymbol = "colon";
                            bfInt = bf.read();
                            if (bfInt != -1)
                                symbol = (char) bfInt;
                        } else {
                            throw new MyError("(:) может стоять только после переменной");
                        }
                    }
                else if (symbol=='='){
                    if ((lastSymbol=="variable")||(lastSymbol=="number")){
                        lexeme.type = Lexeme.Type.EQUALLY;
                        lastSymbol = "equally";
                        list.add(lexeme);
                        bfInt = bf.read();
                        if (bfInt != -1)
                            symbol = (char) bfInt;

                    }else {
                        throw new MyError("(=) может стоять только после числа или переменной");
                    }
                }
                else if (symbol=='<'){
                    if ((lastSymbol=="variable")||(lastSymbol=="number")){
                        lexeme.type=Lexeme.Type.LESS;
                        lastSymbol="less";
                        list.add(lexeme);
                        bfInt=bf.read();
                        if (bfInt!=-1)
                            symbol=(char) bfInt;
                    }else {
                        throw new MyError("(<) может стоять только после числа или переменной");
                    }
                }

                else if (isCharacter(symbol)) {
                        if ((lastSymbol == "assign") || (lastSymbol == "openBkt") || (lastSymbol == "semicolon") || (lastSymbol == "operator") || (lastSymbol == "")||(lastSymbol=="less")||(lastSymbol=="equally")) {
                            variable += symbol;
                            bfInt = bf.read();
                            if (bfInt != -1)
                                symbol = (char) bfInt;
                            while ((bfInt != -1) && ((isCharacter(symbol)) || (isNumber(symbol)))) {
                                variable += symbol;
                                bfInt = bf.read();
                                if (bfInt != -1)
                                    symbol = (char) bfInt;
                            }
                            lexeme.type = Lexeme.Type.VAR;
                            lexeme.variable = table.putVar(variable);
                            list.add(lexeme);
                            if ((lastSymbol == "semicolon") || (lastSymbol == ""))
                                table.addToOutput(variable);
                            lastSymbol = "variable";
                            if (variable.length() > 4) {
                                throw new MyError("В перменной больше 4 символов ");
                            }
                        } else {
                            throw new MyError("Буква стоит не на правильном месте");
                        }
                    } else if (isNumber(symbol)) {
                        if ((lastSymbol == "numberSign")) {
                            numberString += symbol;
                            bfInt = bf.read();
                            if (bfInt != -1)
                                symbol = (char) bfInt;
                            while ((bfInt != -1) && (isNumber(symbol))) {
                                numberString += symbol;
                                bfInt = bf.read();
                                if (bfInt != -1)
                                    symbol = (char) bfInt;
                            }
                            if ((lastSymbol == "numberSign") && (signNumber == "minus")) {
                                number = -(Integer.valueOf(numberString));
                            } else number = Integer.valueOf(numberString);
                            lexeme.type = Lexeme.Type.INT;
                            lexeme.number = number;
                            list.add(lexeme);
                            lastSymbol = "number";
                            if (numberString.length() != 5) {
                                throw new MyError("В числе больше 5 чисел");
                            }
                        } else {
                            throw new MyError("Перед числом должен стоять (+)/(-)");
                        }
                    } else if ((symbolType(symbol) == "gap")) {
                        bfInt = bf.read();
                        if (bfInt != -1)
                            symbol = (char) bfInt;
                    } else {
                      throw new MyError();
                    }

                } else if (symbol == '=') {
                        lexeme.type = Lexeme.Type.ASSIGN;
                    lastSymbol = "assign";
                    list.add(lexeme);
                    bfInt = bf.read();
                    if (bfInt != -1)
                        symbol = (char) bfInt;

            }else {

                throw new MyError("После (:) должно стоять (=)");
            }
        }
        if (symbol == '.') {
            if ((lastSymbol == "closeBkt")) {
                Lexeme lexeme = new Lexeme();
                lexeme.type = Lexeme.Type.DOT;
                lastSymbol = "dot";
                list.add(lexeme);
            } else {

                throw new MyError("Программа может быть закончена только если предпоследний символ (])");
            }
        } else {

            throw new MyError("Последний символ не точка");
        }
        return list;
    }

}