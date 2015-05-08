package LexicalAnalyser;

/**
 *
 * Если кол-во операндов равно 1, то выполняется только присваивание result = first_Operand;
 * Если кол-во операндов = 2, то выполняется арифметич.действие в зависимости от operation;
 *
 *
 */
public class Command {
    char condition_operation;         // операция условия < или =
    Value condition_first_Operand;    // правый операнд в условии
    Value condition_second_Operand;   // левый операнд в условии
    String T_result;                  // переменная при true
    Value T_first_Operand;            // правый операнд при true
    char T_operation;                 // операция +,-,*,/ при true
    Value T_second_Operand;           // левый операнд при true
    int T_operandNumber;              // хранит кол-во операндов при true
    String F_result;                  // переменная при false
    Value F_first_Operand;            // правый операнд при false
    char F_operation;                 //операция +,-,*,/ при false
    Value F_second_Operand;           // левый операнд при false
    int F_operandNumber;              //хранит кол-во операндов.


    public Command() {
        this.condition_first_Operand = new Value();
        this.condition_second_Operand = new Value();
        this.condition_operation = ' ';
        this.T_result = "";
        this.T_first_Operand = new Value();
        this.T_operation = ' ';
        this.T_second_Operand = new Value();
        this.T_operandNumber = 0;
        this.F_result = "";
        this.F_first_Operand = new Value();
        this.F_operation = ' ';
        this.F_second_Operand = new Value();
        this.F_operandNumber = 0;
    }

    public void run(Table table) {   // запускаем

        boolean f;
        int if_leftOperand;
        int if_rightOperand;
        if (condition_first_Operand.getType() == "number") {
            if_leftOperand = condition_first_Operand.getValue();
        } else if_leftOperand = table.getValue(condition_first_Operand.getName());
        if (condition_second_Operand.getType() == "number") {
            if_rightOperand = condition_second_Operand.getValue();
        } else if_rightOperand = table.getValue(condition_second_Operand.getName());
        if (condition_operation == '<') {
            if (if_leftOperand < if_rightOperand) {
                f = true;
            } else f = false;
        }else {
            if (if_leftOperand == if_rightOperand) {
                f = true;
            } else f = false;
        }
        if (f == true) {
            if (T_operandNumber == 1) {
                if (T_first_Operand.getType() == "variable") {
                    table.putInt(T_result, table.getValue(T_first_Operand.getName()));
                } else table.putInt(T_result, T_first_Operand.getValue());

            } else {
                int leftOp;       // Числовое значение первого операнда
                int rightOp;      // Числовое значение второго операнда
                if (T_first_Operand.getType() == "number") {
                    leftOp = T_first_Operand.getValue();
                } else leftOp = table.getValue(T_first_Operand.getName());     //Т.е. тип variable

                if (T_second_Operand.getType() == "number") {
                    rightOp = T_second_Operand.getValue();
                } else rightOp = table.getValue(T_second_Operand.getName());

                if (T_operation == '+')
                    table.putInt(T_result, leftOp + rightOp);
                else if (T_operation == '-')
                    table.putInt(T_result, leftOp - rightOp);
                else if (T_operation == '*')
                    table.putInt(T_result, leftOp * rightOp);
                else
                    table.putInt(T_result, leftOp / rightOp);
            }
        } else {

            if (F_operandNumber == 1) {
                if (F_first_Operand.getType() == "variable") {
                    table.putInt(F_result, table.getValue(F_first_Operand.getName()));
                } else table.putInt(F_result, F_first_Operand.getValue());

            } else {
                int leftOp;       // Числовое значение первого операнда
                int rightOp;      // Числовое значение второго операнда
                if (F_first_Operand.getType() == "number") {
                    leftOp = F_first_Operand.getValue();
                } else leftOp = table.getValue(F_first_Operand.getName());     //Т.е. тип variable

                if (F_second_Operand.getType() == "number") {
                    rightOp = F_second_Operand.getValue();
                } else rightOp = table.getValue(T_second_Operand.getName());

                if (F_operation == '+')
                    table.putInt(T_result, leftOp + rightOp);
                else if (F_operation == '-')
                    table.putInt(T_result, leftOp - rightOp);
                else if (F_operation == '*')
                    table.putInt(F_result, leftOp * rightOp);
                else
                    table.putInt(F_result, leftOp / rightOp);
            }
        }
    }
}