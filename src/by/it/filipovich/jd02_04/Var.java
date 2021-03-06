package by.it.filipovich.jd02_04;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    static Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Operating for "+this+" + "+ other + " is impossible");

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Operating for "+this+" - "+ other + " is impossible");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Operating for "+this+" * "+ other + " is impossible");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Operating for "+this+" / "+ other + " is impossible");
    }

    @Override
    public String toString(){
        return "Я метод Var, я не хочу ничего решать!";
    }

    static Var createVar(String operand) throws CalcException {
        String a = operand.replaceAll("\\s", "");
        if(a.matches(Patterns.SCALAR))
            return new Scalar(a);
        else if(a.matches(Patterns.VECTOR))
            return new Vector(a);
        else if(a.matches(Patterns.MATRIX))
            return new Matrix(a);
        else{
            Var var = vars.get(a);
            if (var != null) {
                return var;
            } else
                throw new CalcException("Unknown expression: "+operand);
        }
    }

    static void save(String key, Var value) throws CalcException {
        vars.put(key,value);
        VarToFile.save(vars);
    }
}
