package com.example.exama330101;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

	private static EditText username, password, repassword, startphone,
			startemail;
	Intent intent = new Intent();
	private static RadioButton radio1, radio2;
	private static String error_registers;
	private static String error_equals;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		username = (EditText) findViewById(R.id.user);
		password = (EditText) findViewById(R.id.psd);
		repassword = (EditText) findViewById(R.id.repsd);
		startphone = (EditText) findViewById(R.id.phone);
		startemail = (EditText) findViewById(R.id.email);
		radio1 = (RadioButton) findViewById(R.id.radioBoy);
		radio2 = (RadioButton) findViewById(R.id.radioGirl);	

		Button registerButton = (Button) findViewById(R.id.register);
		registerButton.setOnClickListener(new OnClickListener() {
			public void onClick(View v) {

				if (username.getText().toString().equals("")
						|| password.getText().toString().equals("")
						|| repassword.getText().toString().equals("")) {

					error_registers = getResources().getString(
							R.string.error_register);
					Toast toast_notnull = Toast.makeText(
							getApplicationContext(), error_registers,
							Toast.LENGTH_SHORT);
					toast_notnull.show();

				} else if (password.getText().toString()
						.equals(repassword.getText().toString()) == false) {

					error_equals = getResources().getString(
							R.string.error_equal);
					Toast toast_equal = Toast.makeText(getApplicationContext(),
							error_equals, Toast.LENGTH_SHORT);
					toast_equal.show();

				} else {

					intent.putExtra("return_userName", username.getText()
							.toString());
					intent.putExtra("return_password", password.getText()
							.toString());
					intent.putExtra("return_phone", startphone.getText()
							.toString());
					intent.putExtra("return_email", startemail.getText()
							.toString());
					intent.putExtra("return_sex", radio1.getText().toString());
					
							

					new AlertDialog.Builder(MainActivity.this)
							.setTitle("提示信息")
							.setMessage("注册成功")
							.setPositiveButton("确定",
									new DialogInterface.OnClickListener() {

										@Override
										public void onClick(
												DialogInterface arg0, int arg1) {
											// TODO Auto-generated method stub
											intent.setClass(MainActivity.this,
													WelcomeActivity.class);
											startActivity(intent);
										}
									}).show();
				}
			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main_menu, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		Toast toast = Toast.makeText(getApplicationContext(), "",
				Toast.LENGTH_SHORT);
		int id = item.getItemId();
		if (id == R.id.action_exit) {
			toast.setText("退出");
			toast.show();
			username.setText("");
			password.setText("");
			repassword.setText("");
		}

		return super.onOptionsItemSelected(item);
	}

}
