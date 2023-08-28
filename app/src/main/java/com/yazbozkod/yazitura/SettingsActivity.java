package com.yazbozkod.yazitura;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.Toast;

public class SettingsActivity extends AppCompatActivity {
    //region Global Variables
    ImageButton ibOnceki, ibParaOnceki, ibParaSonraki, ibPara;
    Button btnBlack, btnDarkerGray, btnRed, btnOrange, btnBlue, btnGreen, btnTeal;
    CheckBox cbTitresim;
    DbHelper dbHelper;
    View settingsLayout;
    private int[] imageArray = {R.drawable.abdcent_on, R.drawable.k250_on, R.drawable.gumus1804_on, R.drawable.kurus1_on, R.drawable.kurus50_on, R.drawable.kurus500_on, R.drawable.tl1_on, R.drawable.yenilira_on, R.drawable.centon, R.drawable.manat2_on, R.drawable.marka5_on,R.drawable.tyin50_on};
    private int currentImageIndex = 0;
    private int titresim,titresimSure= 30;

    //endregion

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
        setContentView(R.layout.activity_settings);
        //region XML TO CODE
        ibOnceki = findViewById(R.id.ibOnceki);
        ibParaOnceki = findViewById(R.id.ibParaOnceki);
        ibParaSonraki = findViewById(R.id.ibParaSonraki);
        ibPara = findViewById(R.id.ibPara);
        btnBlack = findViewById(R.id.btnBlack);
        btnDarkerGray = findViewById(R.id.btnDarkerGray);
        btnRed = findViewById(R.id.btnRed);
        btnOrange = findViewById(R.id.btnOrange);
        btnBlue = findViewById(R.id.btnBlue);
        btnGreen = findViewById(R.id.btnGreen);
        btnTeal = findViewById(R.id.btnTeal);
        cbTitresim = findViewById(R.id.cbTitresim);
        dbHelper = new DbHelper(getApplicationContext());
        settingsLayout = findViewById(R.id.settingsLayout);
        int arkaPlanRenkKaynagi = dbHelper.getArkaPlanRengi();
        settingsLayout.setBackgroundColor(arkaPlanRenkKaynagi);
        int para = dbHelper.getPara();
        titresim = dbHelper.getTitresim();
        if (titresim == 1) cbTitresim.setChecked(true);
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);


        // imageArray'de ilgili resim id'sini bulun ve imageButton'un src'sini değiştirin
        if (para >= 0 && para < imageArray.length) {
            ibPara.setImageResource(imageArray[para]);
        } else {
            // Geçersiz bir resim id'si geldiyse, varsayılan bir resim belirleyebilirsiniz
            ibPara.setImageResource(R.drawable.tl1_on);
        }
        //endregion

        //region ibOnceki.setOnClickListener
        ibOnceki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                SettingsActivity.super.onBackPressed();
            }
        });
        //endregion

        //region ibParaOnceki.setOnClickListener
        ibParaOnceki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                currentImageIndex = (currentImageIndex - 1 + imageArray.length) % imageArray.length;
                updateImageView();
            }
        });
        //endregion

        //region ibParaSonraki.setOnClickListener
        ibParaSonraki.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                currentImageIndex = (currentImageIndex + 1) % imageArray.length;
                updateImageView();
            }
        });
        //endregion

        //region ibPara.setOnClickListener
        ibPara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                dbHelper.updatePara(currentImageIndex);
                Toast.makeText(SettingsActivity.this, R.string.para_secme_basarili, Toast.LENGTH_SHORT).show();
            }
        });
        //endregion

        //region cbTitresim.setOnCheckedChangeListener
        cbTitresim.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (cbTitresim.isChecked())
                    dbHelper.updateTitresim(1);
                else if (!cbTitresim.isChecked())
                    dbHelper.updateTitresim(0);
                else
                    Toast.makeText(SettingsActivity.this, R.string.titresim_error, Toast.LENGTH_SHORT).show();
            }
        });
        //endregion

        // region Renkler
        //region btnBlack.setOnClickListener
        btnBlack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                dbHelper.updateArkaPlanRengi(ContextCompat.getColor(getApplicationContext(), R.color.blacked), settingsLayout);
            }
        });
        //endregion

        //region btnDarkerGray.setOnClickListener
        btnDarkerGray.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                dbHelper.updateArkaPlanRengi(ContextCompat.getColor(getApplicationContext(), android.R.color.darker_gray), settingsLayout);
            }
        });
        //endregion

        //region btnRed.setOnClickListener
        btnRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                dbHelper.updateArkaPlanRengi(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_red_dark), settingsLayout);
            }
        });
        //endregion

        //region btnOrange.setOnClickListener
        btnOrange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                dbHelper.updateArkaPlanRengi(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_orange_dark), settingsLayout);
            }
        });
        //endregion

        //region btnOrange.setOnClickListener
        btnBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                dbHelper.updateArkaPlanRengi(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_blue_dark), settingsLayout);
            }
        });
        //endregion

        //region btnOrange.setOnClickListener
        btnGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                dbHelper.updateArkaPlanRengi(ContextCompat.getColor(getApplicationContext(), android.R.color.holo_green_dark), settingsLayout);
            }
        });
        //endregion

        //region btnOrange.setOnClickListener
        btnTeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(titresimSure);
                dbHelper.updateArkaPlanRengi(ContextCompat.getColor(getApplicationContext(), R.color.teal_700), settingsLayout);
            }
        });
        //endregion
        // endregion
    }

    //region updateImageView()
    private void updateImageView() {
        ibPara.setImageResource(imageArray[currentImageIndex]);
    }
    //endregion

}