package nhm.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    private CalculatorCall calculatorCall;
    static String[] inputRecords;
    static String[] outputRecords;

    TextView textView;
    TextView textView2;

    boolean isPreview;
    int bracket;
    int size;

    String result;

    Button num0;
    Button num1;
    Button num2;
    Button num3;
    Button num4;
    Button num5;
    Button num6;
    Button num7;
    Button num8;
    Button num9;
    Button e;
    Button pi;

    Button plus;
    Button minus;
    Button mul;
    Button div;
    Button clear;
    Button bracket_left;
    Button bracket_right;
    Button mod;
    Button back;
    Button dot;
    Button log;
    Button power;

    Button equal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calculatorCall = new CalculatorCall();

        size = 0;
        int number = 25;
        int t = String.valueOf(Math.sqrt(number)).length();
        Log.d("test", "" + t + " ? " + String.valueOf(Math.sqrt(number)));

        isPreview = false;

        int[][] test = new int[5][4];
        setButton();
        setTextView();

    }

    private void setButton() {
        num0 = findViewById(R.id.num0);
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        e = findViewById(R.id.e);
        pi = findViewById(R.id.pi);


        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        mul = findViewById(R.id.mul);
        div = findViewById(R.id.div);
        clear = findViewById(R.id.clear);
        bracket_left = findViewById(R.id.bracket_left);
        bracket_right = findViewById(R.id.bracket_right);
        mod = findViewById(R.id.mod);
        back = findViewById(R.id.back);
        dot = findViewById(R.id.dot);
        log = findViewById(R.id.log);
        power = findViewById(R.id.power);

        equal = findViewById(R.id.equal);

        num0.setOnClickListener(numClickListener);
        num1.setOnClickListener(numClickListener);
        num2.setOnClickListener(numClickListener);
        num3.setOnClickListener(numClickListener);
        num4.setOnClickListener(numClickListener);
        num5.setOnClickListener(numClickListener);
        num6.setOnClickListener(numClickListener);
        num7.setOnClickListener(numClickListener);
        num8.setOnClickListener(numClickListener);
        num9.setOnClickListener(numClickListener);
        e.setOnClickListener(numClickListener);
        pi.setOnClickListener(numClickListener);

        plus.setOnClickListener(operClickListener);
        minus.setOnClickListener(operClickListener);
        mul.setOnClickListener(operClickListener);
        div.setOnClickListener(operClickListener);
        clear.setOnClickListener(operClickListener);
        bracket_left.setOnClickListener(operClickListener);
        bracket_right.setOnClickListener(operClickListener);
        mod.setOnClickListener(operClickListener);
        back.setOnClickListener(operClickListener);
        dot.setOnClickListener(operClickListener);
        log.setOnClickListener(operClickListener);
        power.setOnClickListener(operClickListener);

        equal.setOnClickListener(operClickListener);
    }


    // Number Button
    private Button.OnClickListener numClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.num0:
                    textView.append("0");
                    isPreview = true;
                    break;
                case R.id.num1:
                    textView.append("1");
                    isPreview = true;
                    break;
                case R.id.num2:
                    textView.append("2");
                    isPreview = true;
                    break;
                case R.id.num3:
                    textView.append("3");
                    isPreview = true;
                    break;
                case R.id.num4:
                    textView.append("4");
                    isPreview = true;
                    break;
                case R.id.num5:
                    textView.append("5");
                    isPreview = true;
                    break;
                case R.id.num6:
                    textView.append("6");
                    isPreview = true;
                    break;
                case R.id.num7:
                    textView.append("7");
                    isPreview = true;
                    break;
                case R.id.num8:
                    textView.append("8");
                    isPreview = true;
                    break;
                case R.id.num9:
                    textView.append("9");
                    isPreview = true;
                    break;
                case R.id.e:
                    textView.append("e");
                    isPreview = true;
                    break;
                case R.id.pi:
                    textView.append("P");
                    isPreview = true;
                    break;
            }

            preview();
        }
    };

    // operButton
    private Button.OnClickListener operClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.plus:
                    textView.append("+");
                    isPreview = false;
                    break;
                case R.id.minus:
                    textView.append("-");
                    isPreview = false;
                    break;
                case R.id.mul:
                    textView.append("*");
                    isPreview = false;
                    break;
                case R.id.div:
                    textView.append("/");
                    isPreview = false;
                    break;
                case R.id.mod:
                    textView.append("%");
                    isPreview = false;
                    break;
                case R.id.log:
                    textView.append("L");
                    isPreview = false;
                    break;
                case R.id.power:
                    textView.append("^");
                    isPreview = false;
                    break;
                case R.id.clear:
                    textView.setText("");
                    textView2.setText("");

                    calculatorCall = new CalculatorCall();
                    isPreview = false;
                    break;
                case R.id.bracket_left:
                    textView.append("(");
                    isPreview = false;

                    bracket +=1;
                    break;
                case R.id.bracket_right:
                    textView.append(")");
                    isPreview = false;
                    bracket -=1;

                    if(bracket == 0){
                        isPreview = true;
                        preview();
                    }
                    break;
                case R.id.back:
                    String text = textView.getText().toString();
                    if (text.length() == 0)
                        break;
                    else{
                        textView.setText(text.substring(0, text.length()-1));
                        isPreview = false;
                    }
                    break;
                case R.id.dot:
                    textView.append(".");
                    break;
                case R.id.equal:
                    String expression = textView.getText().toString();
                    result = calculatorCall.call(expression);
                    textView.setText(result);
                    textView2.setText("");
                    isPreview = false;
                    break;
            }
        }
    };


    private void preview() {
        if (isPreview) {
            if(bracket==0) {
                String expression = textView.getText().toString();
                String tmp = calculatorCall.call(expression);
                textView2.setText(tmp);
                }
            }
        }


    private void setTextView() {
        textView = findViewById(R.id.first_textView);
        textView2 = findViewById(R.id.second_textView);
    }
}
