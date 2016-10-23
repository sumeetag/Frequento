package com.example.frequento;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

public class Calculator extends Activity implements OnClickListener {

	private Button one, two, zero, three, four, five, six, seven, eight, nine,
			dot, mul, add, sub, div, equal, clear, edit;
	private EditText edittest1;
	ArrayList<Float> math = new ArrayList<Float>();
	float m1;
	float m2;
	float temp;

	int currentOperation = 0;
	int nextOperation;

	final static int ADD = 1;
	final static int SUBTRACT = 2;
	final static int MULTIPLY = 3;
	final static int DIVISION = 4;
	final static int EQUALS = 0;
	final static int CLEAR = 1;
	final static int DONT_CLEAR = 0;
	int clearDisplay = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.calculator);
		init();
		one.setOnClickListener(this);
		zero.setOnClickListener(this);
		two.setOnClickListener(this);
		three.setOnClickListener(this);
		four.setOnClickListener(this);
		five.setOnClickListener(this);
		six.setOnClickListener(this);
		seven.setOnClickListener(this);
		eight.setOnClickListener(this);
		nine.setOnClickListener(this);
		dot.setOnClickListener(this);
		mul.setOnClickListener(this);
		add.setOnClickListener(this);
		sub.setOnClickListener(this);
		div.setOnClickListener(this);
		equal.setOnClickListener(this);
		clear.setOnClickListener(this);
		edit.setOnClickListener(this);

	}

	private void init() {
		// TODO Auto-generated method stub
		one = (Button) findViewById(R.id.b1);
		zero = (Button) findViewById(R.id.b0);
		two = (Button) findViewById(R.id.b2);
		three = (Button) findViewById(R.id.b3);
		four = (Button) findViewById(R.id.b4);
		five = (Button) findViewById(R.id.b5);
		six = (Button) findViewById(R.id.b6);
		seven = (Button) findViewById(R.id.b7);
		eight = (Button) findViewById(R.id.b8);
		nine = (Button) findViewById(R.id.b9);
		add = (Button) findViewById(R.id.badd);
		sub = (Button) findViewById(R.id.bsub);
		mul = (Button) findViewById(R.id.bmul);
		div = (Button) findViewById(R.id.bdiv);
		equal = (Button) findViewById(R.id.bequal);
		dot = (Button) findViewById(R.id.bdot);
		clear = (Button) findViewById(R.id.bClear);
		edit = (Button) findViewById(R.id.bEdit);
		edittest1 = (EditText) findViewById(R.id.editText1);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.b0:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("0");

			break;
		case R.id.b1:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("1");
			break;

		case R.id.b2:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("2");
			break;

		case R.id.b3:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("3");
			break;
		case R.id.b4:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("4");
			break;
		case R.id.b5:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("5");
			break;
		case R.id.b6:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("6");
			break;
		case R.id.b7:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("7");
			break;
		case R.id.b8:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("8");
			break;
		case R.id.b9:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append("9");
			break;
		case R.id.bClear:
			edittest1.setText("0");
			m1 = 0;
			m2 = 0;
			math.removeAll(math);
			currentOperation = 0;
			nextOperation = 0;
			break;
		case R.id.bEdit:
			String str = edittest1.getText().toString();

			if (str.length() != 0) {
				str = str.substring(0, str.length() - 1);

				edittest1.setText(str);
				
			}
			break;
		case R.id.bmul:
			calcLogic(MULTIPLY);
			break;
		case R.id.bdiv:
			calcLogic(DIVISION);
			break;
		case R.id.bsub:
			calcLogic(SUBTRACT);
			break;
		case R.id.badd:
			calcLogic(ADD);
			break;
		case R.id.bequal:
			InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.hideSoftInputFromWindow(edittest1.getWindowToken(), 0);
			calcLogic(EQUALS);
			break;
		case R.id.bdot:
			if (clearDisplay == CLEAR) {
				edittest1.setText("");
			}
			clearDisplay = DONT_CLEAR;
			edittest1.append(".");
			break;

		}
	}

	private void calcLogic(int operator) {
		math.add(Float.parseFloat(edittest1.getText().toString()));

		if (operator != EQUALS) {
			nextOperation = operator;
		} else if (operator == EQUALS) {
			nextOperation = 0;
			// operator=' ';
		}

		switch (currentOperation) {
		case ADD:
			m1 = math.get(0);
			m2 = math.get(1);

			math.removeAll(math);

			math.add(m1 + m2);

			edittest1.setText(String.format("%.3f", math.get(0)));

			break;
		case SUBTRACT:
			m1 = math.get(0);
			m2 = math.get(1);

			math.removeAll(math);

			math.add(m1 - m2);

			edittest1.setText(String.format("%.3f", math.get(0)));
			break;
		case MULTIPLY:
			m1 = math.get(0);
			m2 = math.get(1);

			math.removeAll(math);

			math.add(m1 * m2);

			edittest1.setText(String.format("%.3f", math.get(0)));
			break;
		case DIVISION:
			m1 = math.get(0);
			m2 = math.get(1);

			math.removeAll(math);

			math.add(m1 / m2);

			edittest1.setText(String.format("%.3f", math.get(0)));
			break;
		}

		clearDisplay = CLEAR;
		currentOperation = nextOperation;
		if (operator == EQUALS) {
			m1 = 0;
			m2 = 0;
			math.removeAll(math);
		}

	}
}
