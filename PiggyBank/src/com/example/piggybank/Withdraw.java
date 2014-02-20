package com.example.piggybank;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Withdraw extends Activity {
	
	private double currentBalance;
	
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//button.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
		setContentView(R.layout.activity_withdraw);
	}
	
	public void onStart() {
		super.onStart();
		TextView money = (TextView) findViewById(R.id.balance);
		SharedPreferences account = getSharedPreferences("account", Context.MODE_PRIVATE);
		currentBalance = account.getFloat("account", 0);
		money.setText("$" + Double.toString(currentBalance));
	}
	
	
	public void save() {
		EditText money = (EditText) findViewById(R.id.drawMoney);
		SharedPreferences account = getSharedPreferences("account", Context.MODE_PRIVATE);
		currentBalance = account.getFloat("account", 0) - Double.parseDouble(money.getText().toString());
		TextView output = (TextView) findViewById(R.id.newBalance);
		output.setText("$" + Double.toString(currentBalance));
		SharedPreferences.Editor preditor = account.edit();
		preditor.putFloat("account", (float) currentBalance);
		preditor.commit();	
		
	}
	public void toMain(View view) {
		 Intent intent = new Intent(this, MainActivity.class);
		 startActivity(intent);
	}
	
	public double getBalance() {
		SharedPreferences account = getSharedPreferences("account", 0);
		float myBalance = account.getFloat("balance", 0);
		return myBalance;
	}
	
	public void drawMoney() {
		SharedPreferences account = getSharedPreferences("account", 0);
		double myBalance = account.getFloat("account", 0);
		EditText a = (EditText) findViewById(R.id.drawMoney);
		myBalance = myBalance - Double.parseDouble(a.getText().toString());;
		SharedPreferences.Editor editor = account.edit();
		editor.putFloat("account", (float) myBalance);
		editor.commit();
	}
}
