package com.example.exama330101;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.EditText;
import android.widget.TextView;

public class WelcomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        TextView result=(TextView)findViewById(R.id.textView1);
		
		String get_userName = intent.getStringExtra("return_userName");
		String get_password = intent.getStringExtra("return_password");
		String get_phone = intent.getStringExtra("return_phone");
		String get_email = intent.getStringExtra("return_email");
		String get_sex = intent.getStringExtra("return_sex");
		result.setText("用户名："+get_userName+"\n"+"密码："+get_password+"\n"+"手机号码："+get_phone+"\n"+"电子邮件："+get_email+"\n"+"性别："+get_userName);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }
    
}
