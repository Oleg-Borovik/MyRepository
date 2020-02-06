package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private String sNumm = "";
    private boolean isPoint = false;
    private boolean isPlusCleek = false;
    private boolean isMinusCleek = false;
    private boolean isMultiplicationCleek = false;
    private boolean isDivisionCleek = false;

    private double buff = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button1 = (Button) findViewById(R.id.button_1);
        Button button2 = (Button) findViewById(R.id.button_2);
        Button button3 = (Button) findViewById(R.id.button_3);
        Button button4 = (Button) findViewById(R.id.button_4);
        Button button5 = (Button) findViewById(R.id.button_5);
        Button button6 = (Button) findViewById(R.id.button_6);
        Button button7 = (Button) findViewById(R.id.button_7);
        Button button8 = (Button) findViewById(R.id.button_8);
        Button button9 = (Button) findViewById(R.id.button_9);
        Button button0 = (Button) findViewById(R.id.button_0);

        Button buttonClear = (Button) findViewById(R.id.button_clear);
        Button buttonRemove = (Button) findViewById(R.id.button_remove);
        Button buttonPercent = (Button) findViewById(R.id.button_percent);
        Button buttonDivision = (Button) findViewById(R.id.button_division);

        Button buttonMultiplication = findViewById(R.id.button_multiplication);
        Button buttonMinus = findViewById(R.id.button_minus);
        Button buttonPlus = findViewById(R.id.button_plus);
        Button buttonResult = findViewById(R.id.button_result);

        Button buttonPoint = (Button) findViewById(R.id.button_point);
        textView = (TextView) findViewById(R.id.text_view);

        View.OnClickListener onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(1);
            }

        };
        button1.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(2);
            }
        };
        button2.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(3);
            }
        };
        button3.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(4);
            }
        };
        button4.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(5);
            }
        };
        button5.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(6);
            }
        };
        button6.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(7);
            }
        };
        button7.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(8);
            }
        };
        button8.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(9);
            }
        };
        button9.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(0);
            }
        };
        button0.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isPoint) {
                    isPoint = true;
                    sNumm += ".";
                    textView.setText(sNumm);
                }
            }
        };
        buttonPoint.setOnClickListener(onClickListenerButton);

        //==============================================================
        //button management
        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zeroState();
            }
        };
        buttonClear.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!sNumm.equals("") && sNumm.length() != 1) {
                    sNumm = sNumm.replaceAll(".$", "");
                    textView.setText(sNumm);
                } else {
                    zeroState();
                }
            }
        };
        buttonRemove.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sNumm = String.valueOf((Double.parseDouble(sNumm) / 100.));//error but rounding not work
                textView.setText(sNumm);
            }
        };
        buttonPercent.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus();
            }
        };
        buttonPlus.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus();
            }
        };
        buttonMinus.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplication();
            }
        };
        buttonMultiplication.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                division();
            }
        };
        buttonDivision.setOnClickListener(onClickListenerButton);

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isPlusCleek) {
                    plus();
                }
                if (isMinusCleek) {
                    minus();
                }
                if (isMultiplicationCleek) {
                    multiplication();
                }
                if (isDivisionCleek) {
                    division();
                }
            }
        };
        buttonResult.setOnClickListener(onClickListenerButton);


    }
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("sNumm",sNumm);
        outState.putBoolean("isDivisionCleek", isDivisionCleek);
        outState.putBoolean("isMinusCleek", isMinusCleek);
        outState.putBoolean("isPlusCleek", isPlusCleek);
        outState.putBoolean("isMultiplicationCleek", isMultiplicationCleek);
        outState.putDouble("buff", buff);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        sNumm = savedInstanceState.getString("sNumm");
        isDivisionCleek = savedInstanceState.getBoolean("isDivisionCleek");
        isMinusCleek = savedInstanceState.getBoolean("isMinusCleek");
        isPlusCleek = savedInstanceState.getBoolean("isPlusCleek");
        isMultiplicationCleek = savedInstanceState.getBoolean("isMultiplicationCleek");
        buff = savedInstanceState.getDouble("buff");
        textView.setText(sNumm);
    }

    private void division() {

        if (sNumm.length() > 0) {
            if (!isDivisionCleek) {
                buff = Double.parseDouble(sNumm);
                sNumm = "";
                zeroState();
                isDivisionCleek = true;
            } else {
                sNumm = String.valueOf((Double.valueOf(sNumm) / buff));
                textView.setText(sNumm);
                isDivisionCleek = false;
            }
        }
    }

    private void multiplication() {

        if (sNumm.length() > 0) {
            if (!isMultiplicationCleek) {
                buff = Double.parseDouble(sNumm);
                sNumm = "";
                zeroState();
                isMultiplicationCleek = true;
            } else {
                sNumm = String.valueOf((Double.valueOf(sNumm) * buff));
                textView.setText(sNumm);
                isMultiplicationCleek = false;
            }
        }
    }

    private void minus() {
        if (sNumm.length() > 0) {
            if (!isMinusCleek) {
                buff = Double.parseDouble(sNumm);
                sNumm = "";
                isMinusCleek = true;
            } else {
                sNumm = String.valueOf((buff - Double.valueOf(sNumm)));
                textView.setText(sNumm);
                isMinusCleek = false;
            }
        }
    }

    private void plus() {

        if (sNumm.length() > 0) {
            if (!isPlusCleek) {
                buff = Double.parseDouble(sNumm);
                zeroState();
                isPlusCleek = true;
            } else {
                sNumm = String.valueOf((Double.valueOf(sNumm) + buff));
                textView.setText(sNumm);
                isPlusCleek = false;
            }
        }
    }

    private void zeroState() {
        sNumm = "";
        textView.setText("0");
        isPoint = false;
    }

    private void updateInNumm(int iNumm) {

        if (sNumm.length() < 15) {
            sNumm += String.valueOf(iNumm);
            textView.setText(sNumm);
        }
    }
}
