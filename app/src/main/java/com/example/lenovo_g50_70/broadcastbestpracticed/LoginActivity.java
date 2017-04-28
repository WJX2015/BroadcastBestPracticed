package com.example.lenovo_g50_70.broadcastbestpracticed;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button loginBtn;
    private boolean isRemember;
    private CheckBox rememberPass;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.hide();
        }
       initView();
    }

    private void initView() {
        accountEdit= (EditText) findViewById(R.id.account);
        passwordEdit= (EditText) findViewById(R.id.password);
        loginBtn= (Button) findViewById(R.id.login);
        //记住密码，后加功能
        sp=PreferenceManager.getDefaultSharedPreferences(this);
        rememberPass= (CheckBox) findViewById(R.id.remember_pass);
        isRemember=sp.getBoolean("remember_password",false);
        if(isRemember){
            String account =sp.getString("account","");
            String password =sp.getString("password","");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);
        }
        //记住密码，到上为止
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account=accountEdit.getText().toString();
                String password=passwordEdit.getText().toString();
                //账号admin,密码123456
                if(account.equals("admin")&&password.equals("123456")){
                    //记住密码功能
                    editor =sp.edit();
                    if(rememberPass.isChecked()){
                        editor.putBoolean("remember_password",true);
                        editor.putString("account",account);
                        editor.putString("password",password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    //记住密码功能，到上为止
                    Intent intent =new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
