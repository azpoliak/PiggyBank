package com.example.piggybank;

import android.os.Bundle;
import android.app.ActionBar.LayoutParams;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.view.Menu;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private double currentBalance;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//button.getBackground().setColorFilter(new LightingColorFilter(0xFFFFFFFF, 0xFFAA0000));
		setContentView(R.layout.activity_main);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void toDeposit(View view) {
		 Intent intent = new Intent(this, Deposit.class);
		 startActivity(intent);
	}

	public void toWithdraw(View view) {
		 Intent intent = new Intent(this, Withdraw.class);
		 startActivity(intent);
	}
	
	public void toGoals(View view) {
		 Intent intent = new Intent(this, Goals.class);
		 startActivity(intent);
	}
	
	public void onStart() {
		super.onStart();

		SharedPreferences account = getSharedPreferences("account", Context.MODE_PRIVATE);
		currentBalance = account.getFloat("account", 0);
		
		TextView money = (TextView) findViewById(R.id.account);
		money.setText("$" + currentBalance);
	}
	
	/**
	 * 
	 * @return
	 */
	public double getBalance() {
		SharedPreferences account = getSharedPreferences("account", 0);
		float myBalance = account.getFloat("account", 0);
		return myBalance;
	}
}
