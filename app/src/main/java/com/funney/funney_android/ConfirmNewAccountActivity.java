package com.funney.funney_android;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

@TargetApi(21)
public class ConfirmNewAccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_new_account);


        final AlertDialog.Builder confirmDialog = new AlertDialog.Builder(this, R.style.ConfirmDialogStyle);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        Button confirmButton = (Button) findViewById(R.id.confirm_button);
        getWindow().setStatusBarColor(Color.parseColor("#F3A033"));

        // TODO 前アクティビティからの値の受け取りと対応するTextViewへの値の挿入
        TextView id = (TextView) findViewById(R.id.new_id);
        TextView name = (TextView) findViewById(R.id.new_name);
        TextView birthday = (TextView) findViewById(R.id.new_birthday);
        TextView phone = (TextView) findViewById(R.id.new_phone);
        TextView password = (TextView) findViewById(R.id.new_password);
        TextView passwordConfirm = (TextView) findViewById(R.id.new_password_confirm);


        confirmDialog.setMessage("アカウントを作成しました");
        confirmDialog.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            /**
             * ダイアログのOKタップ時
             */
            public void onClick(DialogInterface dialog, int id) {
                Intent intent = new Intent(getApplication(), HomeActivity.class);
                startActivity(intent);
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            /**
             * Confirmボタンタップ時
             */
            @Override
            public void onClick(View view) {
                confirmDialog.show();
            }
        });

        setSupportActionBar(toolbar);
        setTitle("アカウント作成");
        toolbar.setNavigationIcon(R.drawable.arrow);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // FIXME NewAccountの名前が変更された場合治す
                Intent intent = new Intent(getApplication(),NewAccount.class);
                startActivity(intent);
            }
        });
    }
}
