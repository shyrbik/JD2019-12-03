package by.it.samuseva.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parset {
    Var calc (String expression){
        expression = expression.replace("\\s+", "");
        Pattern pat = Pattern.compile(Patterns.OPERATION);
        Matcher mat = pat.matcher(expression);
        if (mat.find()){
            String operation = mat.group();
            String[] operands = expression.split(Patterns.OPERATION, 2);
            Var operandOne = Var.createVar(operands[0]);
            Var operandTwo = Var.createVar(operands[1]);
            if ((operandOne != null ) || (operandTwo != null)){
                switch (operation){
                    case "+": return operandOne.add(operandTwo);
                    case "-": return operandOne.sub(operandTwo);
                    case "*": return operandOne.mul(operandTwo);
                    case "/": return operandOne.div(operandTwo);
                }
            }
        }
        return null;
    }
}
