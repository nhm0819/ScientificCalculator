package nhm.preprocess;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Splitter {

    private List<String> splitExpression = new ArrayList<>();

    private String number = "";

    static HashMap<String, Integer> opPriority;

    {
        opPriority = new HashMap<>();
        getOpPriority().put("(", 0);
        getOpPriority().put("+", 1);
        getOpPriority().put("-", 1);
        getOpPriority().put("*", 2);
        getOpPriority().put("/", 2);
        getOpPriority().put("%", 2);
        getOpPriority().put("^", 3);
        getOpPriority().put("L", 3);
    }

    public Splitter(String expression) {
        splitExpression = initSplitter(expression);
    }


    public List<String> initSplitter(String expression) {

        for(int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(isOperator(ch)) {
                addNumber(number);
                addOperator(Character.toString(ch));
            }
            else {
                number = number + ch;
            }
        }
        if(!number.equals("")) {
            addNumber(number);
        }
        splitExpression.remove("");
        return splitExpression;
    }


    boolean isOperator(char ch){
        String value = String.valueOf(ch);
        if(value.equals(")")){
            return true;
        }
        return getOpPriority().containsKey(value);
    }



    private void addNumber(String number) {
        splitExpression.add(number);
        clearNumber();
    }

    private void clearNumber() {
        number = "";
    }

    private void addOperator(String operator) {
        splitExpression.add(operator);
    }

    public List<String> getExpression() {
        return splitExpression;
    }


    public static HashMap<String, Integer> getOpPriority() {
        return opPriority;
    }
}
