package com.example.acalc;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Map;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ArrayList<Button> buttonArray = new ArrayList<>();
    private TextView textExpression;
    private TextView textValue;
    private int lastInputLength = 0;
    private String memory = "";
    private String lastResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initButtons();
        textExpression = (TextView) findViewById(R.id.textExpression);
        textValue = (TextView) findViewById(R.id.textValue);
    }

    @SuppressLint({"ResourceType", "SetTextI18n"})
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn0:
                ButtonAction("0");
                EvaluateExpression();
                break;
            case R.id.btn1:
                ButtonAction("1");
                EvaluateExpression();
                break;
            case R.id.btn2:
                ButtonAction("2");
                EvaluateExpression();
                break;
            case R.id.btn3:
                ButtonAction("3");
                EvaluateExpression();
                break;
            case R.id.btn4:
                ButtonAction("4");
                EvaluateExpression();
                break;
            case R.id.btn5:
                ButtonAction("5");
                EvaluateExpression();
                break;
            case R.id.btn6:
                ButtonAction("6");
                EvaluateExpression();
                break;
            case R.id.btn7:
                ButtonAction("7");
                EvaluateExpression();
                break;
            case R.id.btn8:
                ButtonAction("8");
                EvaluateExpression();
                break;
            case R.id.btn9:
                ButtonAction("9");
                EvaluateExpression();
                break;
            case R.id.btnDot:
                ButtonAction("Dot");
                break;
            case R.id.btnPercent:
                EngineerButtonAction("Percent");
                EvaluateExpression();
                break;
            case R.id.btnDivide:
                ButtonAction("Divide");
                break;
            case R.id.btnMultiply:
                ButtonAction("Multiply");
                break;
            case R.id.btnSubtract:
                ButtonAction("Subtract");
                break;
            case R.id.btnAdd:
                ButtonAction("Add");
                break;
            case R.id.btnRoot:
                ButtonAction("Root");
                break;
            case R.id.btnPow:
                ButtonAction("Pow");
                break;
            case R.id.btnPi:
                ButtonAction("Pi");
                break;
            case R.id.btnResult:
                EvaluateExpression();
                lastResult = textValue.getText().toString();
                break;
            case R.id.btnClear:
                textExpression.setText("");
                textValue.setText("");
                break;
            case R.id.btnLBracket:
                ButtonAction("LBracket");
                break;
            case R.id.btnRBracket:
                ButtonAction("RBracket");
                EvaluateExpression();
                break;
            case R.id.btnHist:
                Toast.makeText(this, "Последний результат: " + lastResult, Toast.LENGTH_SHORT).show();
                break;
            case R.id.btnBackspace:
                Backspace();
                break;
            case R.id.btnMemClear:
                memory = "";
                break;
            case R.id.btnMemAdd:
                memory = EvaluateExpression(memory + "+" + textValue.getText().toString());
                break;
            case R.id.btnMemSub:
                memory = EvaluateExpression(memory + "-" + textValue.getText().toString());
                break;
            case R.id.btnMemPaste:
                textExpression.setText(textExpression.getText().toString() + memory);
                break;
            case R.id.btnSin:
                EngineerButtonAction("Sin");
                break;
            case R.id.btnCos:
                EngineerButtonAction("Cos");
                break;
            case R.id.btnTg:
                EngineerButtonAction("Tg");
                break;
            case R.id.btnCtg:
                EngineerButtonAction("Ctg");
                break;
            case R.id.btnASin:
                EngineerButtonAction("ASin");
                break;
            case R.id.btnACos:
                EngineerButtonAction("ACos");
                break;
            case R.id.btnATg:
                EngineerButtonAction("ATg");
                break;
            case R.id.btnACtg:
                EngineerButtonAction("ACtg");
                break;
            case R.id.btnLn:
                EngineerButtonAction("Ln");
                break;
            case R.id.btnLog:
                EngineerButtonAction("Log");
                break;
            case R.id.btnExp:
                EngineerButtonAction("Exp");
                break;
            case R.id.btnFact:
                EngineerButtonAction("Fact");
                break;
            case R.id.btnRound:
                EngineerButtonAction("Round");
                break;
            case R.id.btnRandom:
                AddExpressionOperand(String.valueOf(Math.random()));
                break;
            case R.id.btnFabs:
                EngineerButtonAction("Fabs");
                break;

        }
    }

    private void initButtons() {
        Buttons btns = new Buttons();

        for (Map.Entry<String, String> entry : btns.ButtonList.entrySet()) {
            String btnName = "btn" + entry.getKey();
            int resID = getResources().getIdentifier(btnName, "id",
                    "com.example.acalc");
            Button btn = findViewById(resID);
            btn.setOnClickListener(this);
            buttonArray.add(btn);
            Log.d(KEYS.KEY_LOG_DEBUG, "Init key: " + entry.getKey());
        }

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            for (Map.Entry<String, String> entry : btns.EngeneerButtonList.entrySet()) {
                String btnName = "btn" + entry.getKey();
                int resID = getResources().getIdentifier(btnName, "id",
                        "com.example.acalc");
                Button btn = findViewById(resID);
                btn.setOnClickListener(this);
                buttonArray.add(btn);
                Log.d(KEYS.KEY_LOG_DEBUG, "Init key: " + entry.getKey());
            }
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEYS.KEY_EXPRESSION, textExpression.getText().toString());
        outState.putString(KEYS.KEY_VALUE, textValue.getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        textValue.setText(savedInstanceState.getString(KEYS.KEY_VALUE));
        textExpression.setText(savedInstanceState.getString(KEYS.KEY_EXPRESSION));
    }

    private void ButtonAction(String key) {
        String text = textExpression.getText().toString();
        text += (new Buttons()).ButtonList.get(key);
        textExpression.setText(text);
    }

    private void EngineerButtonAction(String key) {
        String text = textExpression.getText().toString();
        text += (new Buttons()).EngeneerButtonList.get(key);
        textExpression.setText(text);
    }

    @SuppressLint("SetTextI18n")
    private void AddExpressionOperand(String expr)
    {
        textExpression.setText(textExpression.getText().toString() + expr);
    }


    private void EvaluateExpression() {

        String expr = textExpression.getText().toString();

//        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
//        try {
//            Log.d(KEYS.KEY_LOG_DEBUG, "expression: " + expr);
//            String result = engine.eval(expr).toString();
//            Log.d(KEYS.KEY_LOG_DEBUG, "result: " + result);
//            textValue.setText(result);
//        } catch (Exception e) {
//            Toast.makeText(this, "Неверное выражение", Toast.LENGTH_SHORT).show();
//            Log.d(KEYS.KEY_LOG_DEBUG_EX, e.toString());
//        }

        try {
            Expression ex = new Expression(expr);
            Log.d(KEYS.KEY_LOG_DEBUG, "expression: " + expr);
            String result = "" + ex.calculate();
            Log.d(KEYS.KEY_LOG_DEBUG, "result: " + result);
            textValue.setText(result);
        } catch (Exception e) {
            Toast.makeText(this, "Неверное выражение", Toast.LENGTH_SHORT).show();
            Log.d(KEYS.KEY_LOG_DEBUG_EX, e.toString());
        }

    }

    private String EvaluateExpression(String expr) {

        String result = "";
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");
        try {
            Log.d(KEYS.KEY_LOG_DEBUG, "expression: " + expr);
            result = engine.eval(expr).toString();
            Log.d(KEYS.KEY_LOG_DEBUG, "result: " + result);
        } catch (Exception e) {
            Toast.makeText(this, "Неверное выражение", Toast.LENGTH_SHORT).show();
            Log.d(KEYS.KEY_LOG_DEBUG_EX, e.toString());
        }
        return result;
    }

    private void Backspace() {
        String expr = textExpression.getText().toString();
        expr = expr.substring(0, expr.length() - 1);
        textExpression.setText(expr);
    }


}
