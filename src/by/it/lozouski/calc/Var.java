package by.it.lozouski.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> varsMap = new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException();
    }

    Var add(Scalar otherScalar) throws CalcException {
        throw new CalcException("Operation addition " + otherScalar + " + " + this + " isn't possible.");
    }

    Var add(Vector otherVector) throws CalcException {
        throw new CalcException("Operation addition " + otherVector + " + " + this + " isn't possible.");
    }

    Var add(Matrix otherMatrix) throws CalcException {
        throw new CalcException("Operation addition " + otherMatrix + " + " + this + " isn't possible.");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException();
    }

    Var sub(Scalar otherScalar) throws CalcException{
        throw new CalcException("Operation addition " + otherScalar + " - " + this + " isn't possible.");
    }

    Var sub(Vector otherVector) throws CalcException {
        throw new CalcException("Operation addition " + otherVector + " - " + this + " isn't possible.");
    }

    Var sub(Matrix otherMatrix) throws CalcException {
        throw new CalcException("Operation addition " + otherMatrix + " - " + this + " isn't possible.");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException();
    }

    Var mul(Scalar otherScalar) throws CalcException {
        throw new CalcException("Operation multiplication " + otherScalar + " * " + this + " isn't possible.");
    }

    Var mul(Vector otherVector) throws CalcException {
        throw new CalcException("Operation multiplication " + otherVector + " * " + this + " isn't possible.");
    }

    Var mul(Matrix otherMatrix) throws CalcException {
        throw new CalcException("Operation multiplication " + otherMatrix + " * " + this + " isn't possible.");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException();
    }

    Var div(Scalar otherScalar) throws CalcException {
        throw new CalcException("Operation division " + otherScalar + " / " + this + " isn't possible.");
    }

    Var div(Vector otherVector) throws CalcException{
        throw new CalcException("Operation division " + otherVector + " / " + this + " isn't possible.");
    }


    static Var createVar(String operand) throws CalcException {
        try {
            operand = operand.trim().replace("\\s+", "");
            if (operand.matches(Patterns.SCALAR)) return new Scalar(operand);
            else if (operand.matches(Patterns.VECTOR)) return new Vector(operand);
            else if (operand.matches(Patterns.MATRIX)) return new Matrix(operand);
            else return varsMap.get(operand);
        } catch (RuntimeException e) {
            throw new CalcException("ERROR: " + operand);
        }
    }

    static void saveVar(String key, Var value) {
        varsMap.put(key, value);
    }
}
