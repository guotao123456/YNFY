package bw.com.ynf.activity;

import android.content.Intent;
import android.os.Bundle;

import com.zhy.autolayout.AutoLayoutActivity;

import java.util.Timer;
import java.util.TimerTask;

import bw.com.ynf.R;

public class MainActivity extends AutoLayoutActivity {
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, PagerLandActivity.class);
                startActivity(intent);
                finish();
            }
        };
        timer.schedule(task, 3000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (timer != null) {
            timer.cancel();
        }
    }
}
