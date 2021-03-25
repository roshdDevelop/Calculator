package com.my.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber1, tvNumber2, tvResult, tvOperator, tvEqual;
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
        calculate();


    }

    //main methods
    private void init() {
        tvNumber1=(TextView)findViewById(R.id.first_number);
        tvNumber2 =(TextView)findViewById(R.id.second_number);
        tvResult =(TextView)findViewById(R.id.result);
        tvOperator =(TextView)findViewById(R.id.operator);
        tvEqual =(TextView)findViewById(R.id.equal);

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
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn1.getText().toString());
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn2.getText().toString());
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn3.getText().toString());
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn4.getText().toString());
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn5.getText().toString());
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn6.getText().toString());
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn7.getText().toString());
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn8.getText().toString());
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                setNumbersForTextViews(btn9.getText().toString());
            }
        });
        btn_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (checkResult()) {
                    return;
                }
                initFloatNumber(btn_float.getText().toString());
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvResult.getText() != "") {
                    return;
                }
                if (tvOperator.getText()=="") {
                    if (stringNumber1 == "") {
                        return;
                    }
                    stringNumber1 += btn0.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.#################");
                    tvNumber1.setText(df.format(Double.parseDouble(stringNumber1)));

                }
                else
                {
                    if (stringNumber2 == "") {
                        return;
                    }
                    stringNumber2 += btn0.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.##################");
                    tvNumber2.setText(df.format(Double.parseDouble(stringNumber2)));
                }
            }
        });
    }

    private void calculate() {
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "") {
                    tvEqual.setText("=");

                    if (isSum) {
                        Double n1 = Double.parseDouble(stringNumber1);
                        Double n2 = Double.parseDouble(stringNumber2);
                        resultString = n1 + n2 + "";
                        if(resultString.endsWith(".0"))
                        {
                            resultString = resultString.substring(0, resultString.length() - 2);
                        }
                    } else if (isSub) {
                        Double n1 = Double.parseDouble(stringNumber1);
                        Double n2 = Double.parseDouble(stringNumber2);
                        resultString = n1 - n2 + "";
                        if(resultString.endsWith(".0"))
                        {
                            resultString = resultString.substring(0, resultString.length() - 2);
                        }

                    } else if (isMulti) {
                        Double n1 = Double.parseDouble(stringNumber1);
                        Double n2 = Double.parseDouble(stringNumber2);
                        resultString = n1 * n2 + "";
                        if(resultString.endsWith(".0"))
                        {
                            resultString = resultString.substring(0, resultString.length() - 2);
                        }

                    } else if (isDiv) {
                        Double n1 = Double.parseDouble(stringNumber1);
                        Double n2 = Double.parseDouble(stringNumber2);
                        resultString = n1 / n2 + "";
                        if(resultString.endsWith(".0"))
                        {
                            resultString = resultString.substring(0, resultString.length() - 2);
                        }

                    }
                    else if (isPercent) {
                        Double n1 = Double.parseDouble(stringNumber1);
                        Double n2 = Double.parseDouble(stringNumber2);
                        resultString = (n1 * n2)/100 + "";
                        if(resultString.endsWith(".0"))
                        {

                            resultString = resultString.substring(0, resultString.length() - 2);
                        }

                    }
                    else if (isPower) {
                        Double n1 = Double.parseDouble(stringNumber1);
                        Double n2 = Double.parseDouble(stringNumber2);
                        resultString =Math.pow(n1,n2)+"";
                        if(resultString.endsWith(".0"))
                        {
                            resultString = resultString.substring(0, resultString.length() - 2);
                        }


                    }
                        DecimalFormat df = new DecimalFormat("#,###.##");
                        tvResult.setText(df.format(Double.parseDouble(resultString)));
                }
                else
                {
                    return;
                }
            }
        });

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvNumber1.getText()==""|| stringNumber1.equals(".")|| stringNumber2.equals(".")||tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "")
                {
                    return;
                }
                tvOperator.setText(btn_sum.getText().toString());
                isSum=true;
            }
        });
        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvNumber1.getText()==""|| stringNumber1.equals(".")|| stringNumber2.equals(".")||tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "")
                {
                    return;
                }
                tvOperator.setText("p");
                isPower=true;
            }
        });
        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvNumber1.getText()==""|| stringNumber1.equals(".")|| stringNumber2.equals(".")||tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "")
                {
                    return;
                }
                tvOperator.setText(btn_percent.getText().toString());
                isPercent=true;
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvNumber1.getText()==""|| stringNumber1.equals(".")|| stringNumber2.equals(".")||tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "")
                {
                    return;
                }
                tvOperator.setText(btn_sub.getText().toString());
                isSub=true;
            }
        });
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvNumber1.getText()==""|| stringNumber1.equals(".")|| stringNumber2.equals(".")||tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "")
                {
                    return;
                }
                tvOperator.setText(btn_multi.getText().toString());
                isMulti=true;
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (tvNumber1.getText()==""|| stringNumber1.equals(".")|| stringNumber2.equals(".")||tvNumber1.getText() != "" && tvNumber2.getText() != "" && tvOperator.getText() != "")
                {
                    return;
                }
                tvOperator.setText(btn_div.getText().toString());
                isDiv=true;
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                stringNumber1 ="";
                stringNumber2 ="";
                tvNumber1.setText("");
                tvNumber2.setText("");
                tvOperator.setText("");
                tvResult.setText("");
                tvEqual.setText("");
                isDiv=false;
                isMulti=false;
                isSub=false;
                isSum=false;
                isPercent=false;
                isPower=false;
            }
        });

    }


    // secondary methods
    private boolean checkResult(){
        if (tvResult.getText() != "") {
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
        DecimalFormat df = new DecimalFormat("#,###,###.###########");
        return df.format(Double.parseDouble(number));
    }

    private boolean checkIfFloatPressed(String number){
        if (number.contains(".")) {
            return true;
        }
        return false;
    }

    private void initFloatNumber(String floatSample) {
        if (checkOperator()) {
            if (checkIfFloatPressed(stringNumber1)) {
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
            if (checkIfFloatPressed(stringNumber2)) {
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
}
