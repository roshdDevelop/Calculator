package com.my.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber1, tvNumber2, tvOperator;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btn_sum,btn_sub,btn_div,btn_multi,btn_result,btn_clear,btn_percent,btn_float,btn_power;

    String stringNumber1 ="", stringNumber2 ="";
    String resultString ="";
    String zeroString ="0";

    boolean isSum=false;
    boolean isSub=false;
    boolean isMulti=false;
    boolean isDiv=false;
    boolean isPercent=false;
    boolean isPower=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        pressNumButton();
        pressCalculateNum();
    }

    //main methods
    private void init() {
        tvNumber1=(TextView)findViewById(R.id.first_number);
        tvNumber2 =(TextView)findViewById(R.id.second_number);
        tvOperator =(TextView)findViewById(R.id.operator);

        btn1=(Button)findViewById(R.id.btn_first_number);
        btn2=(Button)findViewById(R.id.btn_second_number);
        btn3=(Button)findViewById(R.id.btn_third_number);
        btn4=(Button)findViewById(R.id.btn_four_number);
        btn5=(Button)findViewById(R.id.btn_five_number);
        btn6=(Button)findViewById(R.id.btn_six_number);
        btn7=(Button)findViewById(R.id.btn_seven_number);
        btn8=(Button)findViewById(R.id.btn_eight_number);
        btn9=(Button)findViewById(R.id.btn_nine_number);
        btn0=(Button)findViewById(R.id.btn_zero_number);
        btn_sum=(Button)findViewById(R.id.btn_sum);
        btn_sub=(Button)findViewById(R.id.btn_sub);
        btn_multi=(Button)findViewById(R.id.btn_multi);
        btn_div=(Button)findViewById(R.id.btn_div);
        btn_clear=(Button)findViewById(R.id.btn_clear);
        btn_result=(Button)findViewById(R.id.btn_result);
        btn_percent=(Button)findViewById(R.id.btn_percent);
        btn_float=(Button)findViewById(R.id.btn_float);
        btn_power=(Button)findViewById(R.id.btn_power);
    }

    private void pressNumButton() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn1.getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn2.getText().toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn3.getText().toString());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn4.getText().toString());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn5.getText().toString());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn6.getText().toString());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn7.getText().toString());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn8.getText().toString());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn9.getText().toString());
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (checkAndControlResult()) { return; }
                setNumbersForTextViews(btn0.getText().toString());
            }
        });

        btn_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAndControlResult()) {
                    return;
                }
                setFloatNumber(btn_float.getText().toString());
            }
        });

    }

    private void pressCalculateNum() {
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAllViewsForShowResult();
                if (checkAllViewsForShowResult()) {

                    calculateAndShowResult(stringNumber1, stringNumber2);
                }
            }
        });

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAllViewsForPressOperator();

                if (checkAllViewsForPressOperator()) { return; }
                setTextForOperatorTextView((String) btn_sum.getTag(),btn_sum.getText().toString());
            }
        });
        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAllViewsForPressOperator()) { return; }
                setTextForOperatorTextView((String) btn_power.getTag(),btn_power.getText().toString());
            }
        });
        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAllViewsForPressOperator()) { return; }
                setTextForOperatorTextView((String) btn_percent.getTag(),btn_percent.getText().toString());
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAllViewsForPressOperator()) { return; }
                setTextForOperatorTextView((String) btn_sub.getTag(),btn_sub.getText().toString());
            }
        });
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAllViewsForPressOperator()) { return; }
                setTextForOperatorTextView((String) btn_multi.getTag(),btn_multi.getText().toString());
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkAllViewsForPressOperator()) { return; }
                setTextForOperatorTextView((String) btn_div.getTag(),btn_div.getText().toString());
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetViews();
            }
        });

    }

    private void calculateAndShowResult(String number1, String number2) {
        Double n1 = Double.parseDouble(number1);
        Double n2 = Double.parseDouble(number2);
        if (isSum) {
            resultString = n1 + n2 + "";
        }
        else if (isSub) {
            resultString = n1 - n2 + "";

        }
        else if (isMulti) {
            resultString = n1 * n2 + "";

        } else if (isDiv) {
            resultString = n1 / n2 + "";
        }
        else if (isPercent) {
            resultString = (n1 * n2)/100 + "";

        }
        else if (isPower) {
            resultString =Math.pow(n1,n2)+"";
        }
        checkAndControlResult();
        resetViews();
        stringNumber1=resultString;
        tvNumber1.setText(decimalNumber(stringNumber1));
    }


    // secondary methods
    private boolean checkAndControlResult(){
        if(resultString.endsWith(".0")) {
            resultString = resultString.substring(0, resultString.length() - 2);
        }
        return false;
    }

    private boolean checkAllViewsForShowResult() {
        if (tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "") {
            return true;
        }
        return false;
    }

    private boolean checkEmptyTextView(String number){
        if (number == "") {
            return true;
        }
        return false;
    }

    private boolean checkOperator(){
        if (tvOperator.getText()!="") {
            return false;
        }
        return true;
    }

    private void setNumbersForTextViews(String btnNumber) {
        if (checkOperator()) {
            stringNumber1 += btnNumber;
            tvNumber1.setText(decimalNumber(stringNumber1));
        }
        else {
            stringNumber2 += btnNumber;
            tvNumber2.setText(decimalNumber(stringNumber2));
        }
    }

    private String decimalNumber(String number) {
        DecimalFormat df = new DecimalFormat("#,###.####");
        return df.format(Double.parseDouble(number));
    }

    private boolean checkIfFloatPressed(String number,String floatNumber){
        if (number.contains(floatNumber)) {
            return true;
        }
        return false;
    }

    private void setFloatNumber(String floatSample) {
        if (checkOperator()) {
            if (checkIfFloatPressed(stringNumber1,floatSample)) {
                return;
            }
            if (checkEmptyTextView(tvNumber1.getText().toString())) {
                stringNumber1 += zeroString.concat(floatSample);
            }
            else{
                stringNumber1 += floatSample;
            }
            tvNumber1.setText(stringNumber1);
        }
        else {
            if (checkIfFloatPressed(stringNumber2,floatSample)) {
                return;
            }
            if (checkEmptyTextView(tvNumber2.getText().toString())) {
                stringNumber2 += zeroString.concat(floatSample);
            }
            else{
                stringNumber2 += floatSample;
            }
            tvNumber2.setText(stringNumber2);
        }
    }

    private void setTextForOperatorTextView(String operatorTag,String btnText) {
        tvOperator.setText(btnText);
        if (operatorTag.equals("+"))
        {
            isSum=true;
            isDiv=false;
            isMulti=false;
            isSub=false;
            isPercent=false;
            isPower=false;
        }
        if (operatorTag.equals("-"))
        {
            isSum=false;
            isDiv=false;
            isMulti=false;
            isSub=true;
            isPercent=false;
            isPower=false;
        }
        if (operatorTag.equals("*"))
        {
            isSum=false;
            isDiv=false;
            isMulti=true;
            isSub=false;
            isPercent=false;
            isPower=false;
        }
        if (operatorTag.equals("/"))
        {
            isSum=false;
            isDiv=true;
            isMulti=false;
            isSub=false;
            isPercent=false;
            isPower=false;
        }
        if (operatorTag.equals("percent"))
        {
            isSum=false;
            isDiv=false;
            isMulti=false;
            isSub=false;
            isPercent=true;
            isPower=false;
        }
        if (operatorTag.equals("power"))
        {
            isSum=false;
            isDiv=false;
            isMulti=false;
            isSub=false;
            isPercent=false;
            isPower=true;
        }

    }

    private boolean checkAllViewsForPressOperator() {
        if (tvNumber1.getText()==""|| stringNumber1.equals(".")|| stringNumber2.equals(".")||tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "")
        {
            return true;
        }
        return false;
    }

    private void resetViews() {
        stringNumber1 ="";
        stringNumber2 ="";
        tvNumber1.setText("");
        tvNumber2.setText("");
        tvOperator.setText("");
        isDiv=false;
        isMulti=false;
        isSub=false;
        isSum=false;
        isPercent=false;
        isPower=false;
    }

}
