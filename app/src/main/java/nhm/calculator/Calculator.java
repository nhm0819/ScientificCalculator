package nhm.calculator;

import java.util.List;
import java.util.Stack;
import java.lang.Math;
import nhm.preprocess.Splitter;

public class Calculator {

    public String calculate(List<String> expression) {

        Double num1;
        Double num2;
        Double result = 0.0;
        Stack<String> numStack = new Stack<>();

        for(String exp : expression) {
            if (isOperator(exp)) {
                num1 = convertToNum(numStack.pop());
                num2 = convertToNum(numStack.pop());
                result = Operation.getType(exp).operate(num2, num1);

                numStack.add(String.valueOf(result));

            }
            else {
                numStack.add(exp);
            }
        }
        return numStack.pop();
    }

    boolean isOperator(String value){
        return Splitter.getOpPriority().containsKey(value);
    }

    double convertToNum(String pop){
        if(pop.equals("e")){
            return Math.E;
        }
        else if(pop.equals("P")){
            return Math.PI;
        }
        else{
            return Double.parseDouble(pop);
        }
    }

}