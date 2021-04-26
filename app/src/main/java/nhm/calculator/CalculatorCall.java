package nhm.calculator;

import java.util.List;
import nhm.preprocess.Postfix;
import nhm.preprocess.Splitter;

public class CalculatorCall {

    public static String result;

    public String call(String expression) {

        Calculator calculator = new Calculator();

        String input = expression;

        Splitter splitter = new Splitter(input);
        List<String> preprocessed = splitter.getExpression();

        Postfix postfix = new Postfix(preprocessed);
        preprocessed = postfix.getExpression();

        result = calculator.calculate(preprocessed);

        return result;
    }

}
