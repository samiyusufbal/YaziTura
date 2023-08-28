package com.yazbozkod.yazitura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView ivLogo;
    DbHelper dbHelper;
    View mainLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //region FullScreen
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        //endregion
        setContentView(R.layout.activity_main);
        ivLogo = findViewById(R.id.ivLogo);
        mainLayout = findViewById(R.id.mainLinear);
        dbHelper = new DbHelper(getApplicationContext());
        dbHelper.startArkaPlanRengi(ContextCompat.getColor(getApplicationContext(), R.color.blacked));
        int arkaPlanRenkKaynagi = dbHelper.getArkaPlanRengi();
        mainLayout.setBackgroundColor(arkaPlanRenkKaynagi);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), OyunActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2000);
    }
}