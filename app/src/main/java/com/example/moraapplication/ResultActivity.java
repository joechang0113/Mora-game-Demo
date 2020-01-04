package com.example.moraapplication;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private Button mbt_back;
    private TextView mtv_result2;
    private Menu mMn_close;
    private Menu mMn_about;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        //getSupportActionBar().hide(); //隱藏TITLE
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏TITLE狀態


        mbt_back = findViewById(R.id.bt_back);
        mtv_result2 = findViewById(R.id.tv_result2);
        Bundle bundle = getIntent().getExtras();
        int Win = bundle.getInt("Win");
        int Lose = bundle.getInt("Lose");
        int Tie = bundle.getInt("Tie");
        mtv_result2.setText("勝: "+Win + "\r\n" + "負: "+Lose + "\r\n" + "平手: "+Tie + "\r\n");
        mtv_result2.setTextSize(70);
        mtv_result2.setTextColor(Color.parseColor("#F3BD14"));
        mMn_close = findViewById(R.id.mn_close);
        mMn_about = findViewById(R.id.mn_about);


        mbt_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mtv_result2.setText("勝: " + "0" + "\r\n" + "負: " + "0" + "\r\n" + "平手: "+ "0" + "\r\n");
                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                //跳轉完要記得finish()殺掉當前頁面，才不會再關閉程式時跳回此頁
                ResultActivity.this.finish();

            }
        });
    }
}
