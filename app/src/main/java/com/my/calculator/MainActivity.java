package com.my.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView number1,number2,result,operator,equal;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0,btn_sum,btn_sub,btn_div,btn_multi,btn_result,btn_clear,btn_percent,btn_float,btn_power;
    String number_1="",number_2="";
    String result_number="";
    String zero="0";
    String s="2220";
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

    private void calculate() {
        btn_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.getText() != "" && number2.getText() != "" && operator.getText() != "") {
                    equal.setText("=");

                    if (isSum) {
                        Double n1 = Double.parseDouble(number_1);
                        Double n2 = Double.parseDouble(number_2);
                        result_number = n1 + n2 + "";
                        if(result_number.endsWith(".0"))
                        {
                            result_number=result_number.substring(0, result_number.length() - 2);
                        }
                    } else if (isSub) {
                        Double n1 = Double.parseDouble(number_1);
                        Double n2 = Double.parseDouble(number_2);
                        result_number = n1 - n2 + "";
                        if(result_number.endsWith(".0"))
                        {
                            result_number=result_number.substring(0, result_number.length() - 2);
                        }

                    } else if (isMulti) {
                        Double n1 = Double.parseDouble(number_1);
                        Double n2 = Double.parseDouble(number_2);
                        result_number = n1 * n2 + "";
                        if(result_number.endsWith(".0"))
                        {
                            result_number=result_number.substring(0, result_number.length() - 2);
                        }

                    } else if (isDiv) {
                        Double n1 = Double.parseDouble(number_1);
                        Double n2 = Double.parseDouble(number_2);
                        result_number = n1 / n2 + "";
                        if(result_number.endsWith(".0"))
                        {
                            result_number=result_number.substring(0, result_number.length() - 2);
                        }

                    }
                    else if (isPercent) {
                        Double n1 = Double.parseDouble(number_1);
                        Double n2 = Double.parseDouble(number_2);
                        result_number = (n1 * n2)/100 + "";
                        if(result_number.endsWith(".0"))
                        {

                            result_number=result_number.substring(0, result_number.length() - 2);
                        }

                    }
                    else if (isPower) {
                        Double n1 = Double.parseDouble(number_1);
                        Double n2 = Double.parseDouble(number_2);
                        result_number=Math.pow(n1,n2)+"";
                        if(result_number.endsWith(".0"))
                        {
                            result_number=result_number.substring(0, result_number.length() - 2);
                        }


                    }
                        DecimalFormat df = new DecimalFormat("#,###.##");
                        result.setText(df.format(Double.parseDouble(result_number)));
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
                if (number1.getText()==""||number_1.equals(".")||number_2.equals(".")||number1.getText() != "" && number2.getText() != "" && operator.getText() != "")
                {
                    return;
                }
                operator.setText(btn_sum.getText().toString());
                isSum=true;
            }
        });
        btn_power.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.getText()==""||number_1.equals(".")||number_2.equals(".")||number1.getText() != "" && number2.getText() != "" && operator.getText() != "")
                {
                    return;
                }
                operator.setText("p");
                isPower=true;
            }
        });
        btn_percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.getText()==""||number_1.equals(".")||number_2.equals(".")||number1.getText() != "" && number2.getText() != "" && operator.getText() != "")
                {
                    return;
                }
                operator.setText(btn_percent.getText().toString());
                isPercent=true;
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.getText()==""||number_1.equals(".")||number_2.equals(".")||number1.getText() != "" && number2.getText() != "" && operator.getText() != "")
                {
                    return;
                }
                operator.setText(btn_sub.getText().toString());
                isSub=true;
            }
        });
        btn_multi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.getText()==""||number_1.equals(".")||number_2.equals(".")||number1.getText() != "" && number2.getText() != "" && operator.getText() != "")
                {
                    return;
                }
                operator.setText(btn_multi.getText().toString());
                isMulti=true;
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.getText()==""||number_1.equals(".")||number_2.equals(".")||number1.getText() != "" && number2.getText() != "" && operator.getText() != "")
                {
                    return;
                }
                operator.setText(btn_div.getText().toString());
                isDiv=true;
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                number_1="";
                number_2="";
                number1.setText("");
                number2.setText("");
                operator.setText("");
                result.setText("");
                equal.setText("");
                isDiv=false;
                isMulti=false;
                isSub=false;
                isSum=false;
                isPercent=false;
                isPower=false;
            }
        });

    }

    private void pressNumButton() {
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    number_1 += btn1.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.###########");
                    number1.setText(df.format(Double.parseDouble(number_1)));
                }
                else
                {
                    number_2 += btn1.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.###########");
                    number2.setText(df.format(Double.parseDouble(number_2)));

                }
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    number_1 += btn2.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.###########");
                    number1.setText(df.format(Double.parseDouble(number_1)));

                }
                else
                {
                    number_2 += btn2.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.###########");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    number_1 += btn3.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.##########");
                    number1.setText(df.format(Double.parseDouble(number_1)));
                }
                else
                {
                    number_2 += btn3.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.###########");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }

                if (operator.getText()=="") {
                    number_1 += btn4.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.############");
                    number1.setText(df.format(Double.parseDouble(number_1)));

                }
                else
                {
                    number_2 += btn4.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.##########");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    number_1 += btn5.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.##########");
                    number1.setText(df.format(Double.parseDouble(number_1)));

                }
                else
                {
                    number_2 += btn5.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.##########");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    number_1 += btn6.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.#############");
                    number1.setText(df.format(Double.parseDouble(number_1)));

                }
                else
                {
                    number_2 += btn6.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.#############");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    number_1 += btn7.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.#############");
                    number1.setText(df.format(Double.parseDouble(number_1)));

                }
                else
                {
                    number_2 += btn7.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.###############");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    number_1 += btn8.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.###############");
                    number1.setText(df.format(Double.parseDouble(number_1)));

                }
                else
                {
                    number_2 += btn8.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.################");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    number_1 += btn9.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.##############");
                    number1.setText(df.format(Double.parseDouble(number_1)));

                }
                else
                {
                    number_2 += btn9.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.#################");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
        btn_float.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (number1.getText() != "" && number2.getText() != "" && result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    if (number_1.contains(".")) {
                        return;
                    }
                    if (number1.getText()=="") {

                        number_1 += zero.concat(btn_float.getText().toString());
                    }
                    else{
                        number_1 += btn_float.getText().toString();

                    }

                    number1.setText(number_1);
                }
                else
                {
                    if (number_2.contains(".")) {
                        return;
                    }
                    if (number2.getText()=="") {
                        number_2 += zero.concat(btn_float.getText().toString());
                    }
                    else{
                        number_2 += btn_float.getText().toString();
                    }
                    number2.setText(number_2);
                }
            }
        });
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (result.getText() != "") {
                    return;
                }
                if (operator.getText()=="") {
                    if (number_1 == "") {
                        return;
                    }
                    number_1 += btn0.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.#################");
                    number1.setText(df.format(Double.parseDouble(number_1)));

                }
                else
                {
                    if (number_2 == "") {
                        return;
                    }
                    number_2 += btn0.getText().toString();
                    DecimalFormat df = new DecimalFormat("#,###,###.##################");
                    number2.setText(df.format(Double.parseDouble(number_2)));
                }
            }
        });
    }



    private void init() {
        number1=(TextView)findViewById(R.id.first_number);
        number2=(TextView)findViewById(R.id.second_number);
        result=(TextView)findViewById(R.id.result);
        operator=(TextView)findViewById(R.id.operator);
        equal=(TextView)findViewById(R.id.equal);

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
}
