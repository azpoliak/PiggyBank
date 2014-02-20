package com.example.piggybank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Deposit extends Activity{
	
	private double currentBalance;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//button.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
		setContentView(R.layout.activity_deposit);
	}
	
	public void onStart() {
		super.onStart();
		TextView money = (TextView) findViewById(R.id.balance);
		SharedPreferences account = getSharedPreferences("account", Context.MODE_PRIVATE);
		currentBalance = account.getFloat("account", 0);
		money.setText("$" + Double.toString(currentBalance));
	}
	
	public void toMain(View view) {
		 Intent intent = new Intent(this, MainActivity.class);
		 startActivity(intent);
	}
	
	public void save() {
	/*	EditText input = (EditText) findViewById(R.id.inputMoney);
		double addedMoney = Double.parseDouble(input.getText().toString());
		
		TextView money1 = (TextView) findViewById(R.id.newBalance);
		money1.setText(Double.toString(currentBalance + addedMoney));
		*/
	}
	
	public double getBalance() {
		SharedPreferences account = getSharedPreferences("account", 0);
		float myBalance = account.getFloat("account", 0);
		return myBalance;
	}
	
	public void addMoneyCommand() {
		//SharedPreferences account = getSharedPreferences("account", 0);
		
		//EditText a = (EditText) findViewById(R.id.inputMoney);
		/*currentBalance = currentBalance + Double.parseDouble(a.getText().toString());
		
		SharedPreferences.Editor editor = account.edit();
		editor.putFloat("account", (float) currentBalance);
		editor.commit(); */
	}
	
	public void onStop() {
		super.onStop();
		SharedPreferences account = getSharedPreferences("account", Context.MODE_PRIVATE);
		SharedPreferences.Editor preditor = account.edit();
		preditor.putFloat("account", (float) currentBalance);
		preditor.commit();		
	}
}
