package nhm.calculator;

import java.util.HashMap;
import java.util.Map;

public enum Operation {
    PLUS("+") {
        public double operate(double x, double y) { return x + y; }
    },
    MINUS("-") {
        public double operate(double x, double y) { return x - y; }
    },
    MULTIPLY("*") {
        public double operate(double x, double y) { return x * y; }
    },
    DIVIDE("/") {
        public double operate(double x, double y) {
            if (y == 0) {
                throw new ArithmeticException("0으로 나눌 수 없습니다.");
            }
            return x / y;
        }
    },
    MOD("%"){
        public double operate(double x, double y) { return x % y; }
    },
    POWER("^"){
        public double operate(double x, double y) { return Math.pow(x, y); }
    },
    LOG("L"){
        public double operate(double x, double y) {
            if (y == 1) {
                throw new ArithmeticException("로그 밑이 1일 수 없습니다.");
            }
            else if (y < 0) {
                throw new ArithmeticException("로그 밑이 0보다 커야합니다.");
            }
            return Math.log(x) / Math.log(y); }
    };

    private String symbol;
    private static final Map<String, Operation> BY_SYMBOL = new HashMap<>();

    Operation(String symbol) {
        this.symbol = symbol;
    }

    static {
        for (Operation operation : values()) {
            BY_SYMBOL.put(operation.symbol, operation);
        }
    }

    public static Operation getType(String symbol) {
        return BY_SYMBOL.get(symbol);
    }

    public abstract double operate(double x, double y);
}
