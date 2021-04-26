package nhm.preprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Postfix {

    List<String> fixedExpression = new ArrayList<>();
    static HashMap<String, Integer> opPriority = Splitter.getOpPriority();

    Stack<String> operators = new Stack<>();
    static int operCount;


    public Postfix(List<String> expression) {
        fixedExpression = initPostfix(expression);
    }


    private List<String> initPostfix(List<String> expression) {
        Stack<String> opStack = new Stack<>();

        for (String exp : expression) {
            if (isOperator(exp)) {

                if (exp.equals("(")) {
                    opStack.push(exp);
                } else if (exp.equals(")")) {

                    while (!opStack.peek().equals("(")) {
                        fixedExpression.add(opStack.pop());
                    }
                    opStack.pop();
                } else {
                    if (opStack.isEmpty()) {
                        opStack.push(exp);
                    } else {
                        if (opPriority.get(opStack.peek()) >= opPriority.get(exp)) {
                            fixedExpression.add(opStack.pop());
                        }

                        opStack.push(exp);
                    }
                }
                operCount += 1;
            } else {
                fixedExpression.add(exp);
            }
        }

        while (!opStack.isEmpty()) {
            fixedExpression.add(opStack.pop());
        }
        return fixedExpression;
    }


    boolean isOperator(String value) {
        if (value.equals(")")) {
            return true;
        }
        return opPriority.containsKey(value);
    }


    public List<String> getExpression() {
        return fixedExpression;
    }
}

