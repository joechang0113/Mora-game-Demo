package com.example.moraapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mbt_scissors;
    private Button mbt_stone;
    private Button mbt_net;
    private ImageView mcomputer;
    private TextView mtv_resultview;
    private Menu mmn_about;
    private Button mbt_result;
    int win=0, lose=0, tie=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide(); //隱藏TITLE
        //getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN); //隱藏TITLE狀態


        mbt_scissors = findViewById(R.id.bt_scissors);
        mbt_stone = findViewById(R.id.bt_stone);
        mbt_net = findViewById(R.id.bt_net);
        mcomputer = findViewById(R.id.im_computer);
        mtv_resultview = findViewById(R.id.tv_resultview);
        mmn_about = findViewById(R.id.mn_about);
        mbt_result = findViewById(R.id.bt_result);

        mbt_result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("Win", win);
                bundle.putInt("Lose", lose);
                bundle.putInt("Tie", tie);
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            }
        });

        mbt_scissors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iComplay = (int)(Math.random()*3+1);
                if (iComplay == 1)
                {
                    mcomputer.setImageResource(R.mipmap.scissors);
                    mtv_resultview.setText(getText(R.string.tieresult));
                    tie++;
                }
                else if (iComplay == 2)
                {
                    mcomputer.setImageResource(R.mipmap.stone);
                    mtv_resultview.setText(getText(R.string.loseresult));
                    lose++;
                }
                else
                {
                    mcomputer.setImageResource(R.mipmap.net);
                    mtv_resultview.setText(getText(R.string.winresult));
                    win++;
                }
            }
        });

        mbt_stone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iComplay = (int)(Math.random()*3+1);
                if (iComplay == 1)
                {
                    mcomputer.setImageResource(R.mipmap.scissors);
                    mtv_resultview.setText(getText(R.string.winresult));
                    win++;
                }
                else if (iComplay == 2)
                {
                    mcomputer.setImageResource(R.mipmap.stone);
                    mtv_resultview.setText(getText(R.string.tieresult));
                    tie++;
                }
                else
                {
                    mcomputer.setImageResource(R.mipmap.net);
                    mtv_resultview.setText(getText(R.string.loseresult));
                    lose++;
                }
            }
        });

        mbt_net.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int iComplay = (int)(Math.random()*3+1);
                if (iComplay == 1)
                {
                    mcomputer.setImageResource(R.mipmap.scissors);
                    mtv_resultview.setText(getText(R.string.loseresult));
                    lose++;
                }
                else if (iComplay == 2)
                {
                    mcomputer.setImageResource(R.mipmap.stone);
                    mtv_resultview.setText(getText(R.string.winresult));
                    win++;
                }
                else
                {
                    mcomputer.setImageResource(R.mipmap.net);
                    mtv_resultview.setText(getText(R.string.tieresult));
                    tie++;
                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 設置要用哪個menu檔做為選單
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // 取得點選項目的id
        int id = item.getItemId();

        // 依照id判斷點了哪個項目並做相應事件

        if (id == R.id.mn_about) {
            // 按下「關於」要做的事

            Toast.makeText(MainActivity.this,"玩家 VS 電腦", Toast.LENGTH_LONG).show();

        }
        else if (id == R.id.mn_close) {
            // 按下「關閉」要做的事
            System.exit(0);

        }

        return super.onOptionsItemSelected(item);
    }

}
