package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    // private String sNumm = "";
    private StringBuffer numm = new StringBuffer();
    private boolean isPoint = false;
    private boolean isPlusCleek = false;
    private boolean isMinusCleek = false;
    private boolean isMultiplicationCleek = false;
    private boolean isDivisionCleek = false;
    private int oper;
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

        View.OnClickListener onClickListenerButton;

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(6);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(7);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(8);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(9);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateInNumm(0);
            }
        });
        buttonPoint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!numm.toString().contains(".")) {
                    //  sNumm += '.';
                    numm.append('.');
                    textView.setText(numm);
                }
            }
        });

        //==============================================================
        //button management
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zeroState();
                buff = 0;
            }
        });
        buttonRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numm.length() > 1) {
                    // sNumm = sNumm.replaceAll(".$", "");
                    numm.deleteCharAt(numm.length() - 1);
                    textView.setText(numm);
                } else {
                    zeroState();
                    buff = 0;
                }
            }
        });
        buttonPercent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //  sNumm = String.valueOf((Double.parseDouble(sNumm) / 100.));//error but rounding not work
                buff = (Double.parseDouble(numm.toString()) / 100.);
                zeroState();
                numm.append(buff);
                textView.setText(numm);
            }
        });
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                plus();
            }
        });
        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minus();
            }
        });
        buttonMultiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                multiplication();
            }
        });
        buttonDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                division();
            }
        });

        onClickListenerButton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (oper) {
                    case 1:
                        plus();
                        break;
                    case 2:
                        minus();
                        break;
                    case 3:
                        multiplication();
                        break;
                    case 4:
                        division();
                        break;
                    default:
                        zeroState();
                        break;
                }
            }
        };
        buttonResult.setOnClickListener(onClickListenerButton);


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("numm", numm.toString());
        outState.putBoolean("isDivisionCleek", isDivisionCleek);
        outState.putBoolean("isMinusCleek", isMinusCleek);
        outState.putBoolean("isPlusCleek", isPlusCleek);
        outState.putBoolean("isMultiplicationCleek", isMultiplicationCleek);
        outState.putDouble("buff", buff);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        numm.append(savedInstanceState.getString("numm"));
        isDivisionCleek = savedInstanceState.getBoolean("isDivisionCleek");
        isMinusCleek = savedInstanceState.getBoolean("isMinusCleek");
        isPlusCleek = savedInstanceState.getBoolean("isPlusCleek");
        isMultiplicationCleek = savedInstanceState.getBoolean("isMultiplicationCleek");
        buff = savedInstanceState.getDouble("buff");
        textView.setText(numm);
    }

    private void division() {

        if (numm.length() > 0) {
            if (!isDivisionCleek) {
                buff = Double.parseDouble(numm.toString());
                zeroState();
                oper = 4;
                isDivisionCleek = true;
            } else {
                buff = (buff / Double.valueOf(numm.toString()));
                zeroState();
                numm.append(buff);
                textView.setText(numm);
                isDivisionCleek = false;
            }
        }
    }

    private void multiplication() {

        if (numm.length() > 0) {
            if (!isMultiplicationCleek) {
                buff = Double.parseDouble(numm.toString());
                zeroState();
                oper = 3;
                isMultiplicationCleek = true;
            } else {
                buff = (Double.valueOf(numm.toString()) * buff);
                zeroState();
                numm.append(buff);
                textView.setText(numm);
                isMultiplicationCleek = false;
            }
        }
    }

    private void minus() {

        if (numm.length() > 0) {
            if (!isMinusCleek) {
                buff = Double.parseDouble(numm.toString());
                zeroState();
                oper = 2;
                isMinusCleek = true;
            } else {
                buff = (buff - Double.valueOf(numm.toString()));
                zeroState();
                numm.append(buff);
                textView.setText(numm);
                isMinusCleek = false;
            }
        }
    }

    private void plus() {

        if (numm.length() > 0) {
            if (!isPlusCleek) {
                buff = Double.parseDouble(numm.toString());
                zeroState();
                oper = 1;
                isPlusCleek = true;
            } else {
                buff = (Double.valueOf(numm.toString()) + buff);
                zeroState();
                numm.append(buff);
                textView.setText(numm);
                isPlusCleek = false;
            }
        }
    }

    private void zeroState() {
//        sNumm = "";
        numm.delete(0, numm.length());
        oper = 1;
        textView.setText("0");
        isPoint = false;
    }

    private void updateInNumm(int iNumm) {

        if (numm.length() < 15) {
            //sNumm += String.valueOf(iNumm);
            numm.append(iNumm);
            textView.setText(numm);
        }
    }
}
