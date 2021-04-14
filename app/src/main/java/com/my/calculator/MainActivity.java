package com.my.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView tvNumber1, tvNumber2, tvOperator;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn0, btnSum, btnSub, btnDiv, btnMulti, btnResult, btnClear, btnPercent, btnFloat, btnPower;
    ImageButton imgBtnBackSpace;

    String stringNumber1 ="", stringNumber2 ="";
    String resultString ="";
    String zeroString ="0";
    String empty="";

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
        pressButtons();
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
        btnSum =(Button)findViewById(R.id.btn_sum);
        btnSub =(Button)findViewById(R.id.btn_sub);
        btnMulti =(Button)findViewById(R.id.btn_multi);
        btnDiv =(Button)findViewById(R.id.btn_div);
        btnClear =(Button)findViewById(R.id.btn_clear);
        btnResult =(Button)findViewById(R.id.btn_result);
        btnPercent =(Button)findViewById(R.id.btn_percent);
        btnFloat =(Button)findViewById(R.id.btn_float);
        btnPower =(Button)findViewById(R.id.btn_power);
        imgBtnBackSpace =(ImageButton) findViewById(R.id.btn_back_space);
    }

    private void pressButtons() {
        btn1.setOnClickListener(view -> {
            setNumbersForTextViews(btn1.getText().toString());     log();
        });
        btn2.setOnClickListener(view -> {
            setNumbersForTextViews(btn2.getText().toString());     log();
        });
        btn3.setOnClickListener(view -> {
            setNumbersForTextViews(btn3.getText().toString());     log();
        });
        btn4.setOnClickListener(view -> {
            setNumbersForTextViews(btn4.getText().toString());     log();
        });
        btn5.setOnClickListener(view -> {
            setNumbersForTextViews(btn5.getText().toString());     log();
        });
        btn6.setOnClickListener(view -> {
            setNumbersForTextViews(btn6.getText().toString());     log();
        });
        btn7.setOnClickListener(view -> {
            setNumbersForTextViews(btn7.getText().toString());     log();
        });
        btn8.setOnClickListener(view -> {
            setNumbersForTextViews(btn8.getText().toString());     log();
        });
        btn9.setOnClickListener(view -> {
            setNumbersForTextViews(btn9.getText().toString());     log();
        });
        btn0.setOnClickListener(view -> {
            setNumbersForTextViews(btn0.getText().toString());     log();
        });


        btnFloat.setOnClickListener(view-> {
            setFloatNumber(btnFloat.getText().toString());        log();
        });
        btnResult.setOnClickListener(view -> {
            if (ifAllViewsReadyForShowResult()) {
                calculateAndShowResult(stringNumber1, stringNumber2);     log();
            }
        });
        btnSum.setOnClickListener(view -> {
            if (checkAllViewsForPressOperator()) { return; }
            setOperator((String) btnSum.getTag(), btnSum.getText().toString());
        });
        btnPower.setOnClickListener(view -> {
            if (checkAllViewsForPressOperator()) { return; }
            setOperator((String) btnPower.getTag(), btnPower.getText().toString());
        });
        btnPercent.setOnClickListener(view -> {
            if (checkAllViewsForPressOperator()) { return; }
            setOperator((String) btnPercent.getTag(), btnPercent.getText().toString());
        });
        btnSub.setOnClickListener(view -> {
            if (checkAllViewsForPressOperator()) { return; }
            setOperator((String) btnSub.getTag(), btnSub.getText().toString());
        });
        btnMulti.setOnClickListener(view -> {
            if (checkAllViewsForPressOperator()) { return; }
            setOperator((String) btnMulti.getTag(), btnMulti.getText().toString());
        });
        btnDiv.setOnClickListener(view -> {
            if (checkAllViewsForPressOperator()) { return; }
            setOperator((String) btnDiv.getTag(), btnDiv.getText().toString());
        });

        btnClear.setOnClickListener(view ->  {
            resetViews();     log();
        });

        imgBtnBackSpace.setOnClickListener(view -> {
            backSpaceAct();     log();

        });

    }

    private void log() {
        Log.d("TAG", "Str1 " + stringNumber1);
        Log.d("TAG", "Str2 " + stringNumber2);
        Log.d("TAG", "result " + resultString);
    }


    // secondary methods
    private void setNumbersForTextViews(String btnNumber) {
        if (!ifOperatorClick()) {
            stringNumber1 += btnNumber;
            tvNumber1.setText(decimalNumber(stringNumber1));
        }
        else {
            stringNumber2 += btnNumber;
            tvNumber2.setText(decimalNumber(stringNumber2));
        }
    }

    private boolean ifOperatorClick(){
        if (tvOperator.getText()!=empty) {
            return true;
        }
        return false;
    }

    private void setFloatNumber(String floatSample) {
        if (!ifOperatorClick()) {
            if (stringNumber1.contains(floatSample)) {
                return;
            }
            if (stringNumber1.isEmpty()) {
                stringNumber1 += zeroString.concat(floatSample);
            }
            else{
                stringNumber1 += floatSample;
            }
            tvNumber1.setText(stringNumber1);
        }
        else {
            if (stringNumber2.contains(floatSample)) {
                return;
            }
            if (stringNumber2.isEmpty()) {
                stringNumber2 += zeroString.concat(floatSample);
            }
            else{
                stringNumber2 += floatSample;
            }
            tvNumber2.setText(stringNumber2);
        }
    }



    private boolean ifAllViewsReadyForShowResult() {
        if (!stringNumber1.isEmpty() && !stringNumber2.isEmpty() && tvOperator.getText() != empty) {
            return true;
        }
        return false;
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

        resetViews();
        controlAndAnimateResult();
    }

    private void controlAndAnimateResult(){
        if(resultString.endsWith(".0")) {
            resultString = resultString.substring(0, resultString.length() - 2);
        }
        stringNumber1=resultString;
        animateResult(stringNumber1);

    }

    private void animateResult(String result) {
        ObjectAnimator scaleX= ObjectAnimator.ofFloat(
          tvNumber1,
                "scaleX",
                1f,1.5f,1f
        );
        scaleX.setDuration(500);
        scaleX.start();
        ObjectAnimator scaleY= ObjectAnimator.ofFloat(
                tvNumber1,
                "scaleY",
                1f,1.5f,1f
        );
        scaleY.setDuration(500);
        scaleY.start();
        tvNumber1.setText(decimalNumber(result));
    }



    private String decimalNumber(String number) {
        DecimalFormat df = new DecimalFormat("#,###.####");
        return df.format(Double.parseDouble(number));
    }

    private void backSpaceAct() {
        if (ifOperatorClick()) {
            if (stringNumber2 == empty) {
                tvOperator.setText(empty);
            }
            if (tvNumber2.getText().toString() != empty) {
                if (stringNumber2.length() == 1) {
                    stringNumber2 = empty;
                    tvNumber2.setText(stringNumber2);
                    return;
                } else {
                    stringNumber2 = stringNumber2.substring(0, stringNumber2.length() - 1);
                    tvNumber2.setText(decimalNumber(stringNumber2));
                }
            }
        } else {
            if (stringNumber1 == empty) {
                return;
            }
            if (stringNumber1.length() == 1) {
                stringNumber1 = empty;
                tvNumber1.setText(stringNumber1);
                return;
            }
            stringNumber1 = stringNumber1.substring(0, stringNumber1.length() - 1);
            try {
                tvNumber1.setText(decimalNumber(stringNumber1));
            }catch (NumberFormatException e){
                stringNumber1=empty;
                tvNumber1.setText(stringNumber1);
            }

        }

    }

    private void setOperator(String operatorTag, String btnText) {
        tvOperator.setText(btnText);
        if (operatorTag.equals("+"))
        {
            isSum=true; isDiv=false; isMulti=false; isSub=false; isPercent=false; isPower=false;
        }
        if (operatorTag.equals("-"))
        {
            isSum=false; isDiv=false; isMulti=false; isSub=true; isPercent=false; isPower=false;
        }
        if (operatorTag.equals("*"))
        {
            isSum=false; isDiv=false; isMulti=true; isSub=false; isPercent=false; isPower=false;
        }
        if (operatorTag.equals("/"))
        {
            isSum=false; isDiv=true; isMulti=false; isSub=false; isPercent=false; isPower=false;
        }
        if (operatorTag.equals("percent"))
        {
            isSum=false; isDiv=false; isMulti=false; isSub=false; isPercent=true; isPower=false;
        }
        if (operatorTag.equals("power"))
        {
            isSum=false; isDiv=false; isMulti=false; isSub=false; isPercent=false; isPower=true;
        }

    }

    private boolean checkAllViewsForPressOperator() {
        if (stringNumber1.isEmpty()|| stringNumber1.equals(".")|| stringNumber2.equals(".")|| !stringNumber1.isEmpty() && !stringNumber2.isEmpty() && tvOperator.getText() != empty)
        {
            return true;
        }
        return false;
    }

    private void resetViews() {
        stringNumber1 =empty;
        stringNumber2 =empty;
        tvNumber1.setText(empty);
        tvNumber2.setText(empty);
        tvOperator.setText(empty);
        isDiv=false;
        isMulti=false;
        isSub=false;
        isSum=false;
        isPercent=false;
        isPower=false;
    }

}
