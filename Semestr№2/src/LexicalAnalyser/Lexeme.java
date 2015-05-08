package LexicalAnalyser;
public class Lexeme {
    public enum Type {

    VAR,          // переменная
    INT,          // число
    ASSIGN,       // :=
    SEMICOLON,    // ;
    LBRACKET,     // левая скобка
    RBRACKET,     // правая скобка
    MINUS,        // -
    PLUS,         // +
    MULT,         // *
    DEVIDE,       // /
    LESS,         // <
    EQUALLY,      // =
    DOT           // .
    }
    public Type type;
    int variable;   // хранится номер-ссылка на таблицу
    int number;
public Type getType(){                        // возвращает типы лексем
    if ((type!=Type.VAR)&&(type!=Type.INT)){
        return type;

    }
    else
        if (type==Type.VAR)
            return Type.VAR;
    else return Type.INT;
}



}