package com.example.acalc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Buttons {

    public static final int buttonCount = 50;

    public final Map<String, String> ButtonList = new HashMap<>();
    public final Map<String, String> EngeneerButtonList = new HashMap<>();

    public Buttons() {
        ButtonList.put("0", "0");
        ButtonList.put("1", "1");
        ButtonList.put("2", "2");
        ButtonList.put("3", "3");
        ButtonList.put("4", "4");
        ButtonList.put("5", "5");
        ButtonList.put("6", "6");
        ButtonList.put("7", "7");
        ButtonList.put("8", "8");
        ButtonList.put("9", "9");
        ButtonList.put("Dot", ".");
        ButtonList.put("Divide", "/");
        ButtonList.put("Multiply", "*");
        ButtonList.put("Subtract", "-");
        ButtonList.put("Add", "+");
        ButtonList.put("Root", "sqrt(");
        ButtonList.put("Pow", "^");
        ButtonList.put("Pi", "pi");
        ButtonList.put("Result", "=");
        ButtonList.put("Clear", "C");
        ButtonList.put("RBracket", ")");
        ButtonList.put("LBracket", "(");
        ButtonList.put("Hist", "Hist");
        ButtonList.put("Backspace", "BCK");
        EngeneerButtonList.put("MemClear", "MC");
        EngeneerButtonList.put("MemAdd", "M+");
        EngeneerButtonList.put("MemSub", "M-");
        EngeneerButtonList.put("MemPaste", "MP");
        EngeneerButtonList.put("Sin", "sin(");
        EngeneerButtonList.put("Cos", "cos(");
        EngeneerButtonList.put("Tg", "tg(");
        EngeneerButtonList.put("Ctg", "ctg(");
        EngeneerButtonList.put("ASin", "asin(");
        EngeneerButtonList.put("ACos", "acos(");
        EngeneerButtonList.put("ATg", "atg(");
        EngeneerButtonList.put("ACtg", "actg(");
        EngeneerButtonList.put("Ln", "ln(");
        EngeneerButtonList.put("Log", "log10(");
        EngeneerButtonList.put("Exp", "e");
        EngeneerButtonList.put("Fact", "!");
        EngeneerButtonList.put("Fabs", "abs(");
        EngeneerButtonList.put("Round", "ceil(");
        EngeneerButtonList.put("Random", "RND");
        EngeneerButtonList.put("Percent", "%");
    }
}
