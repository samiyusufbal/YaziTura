package com.yazbozkod.yazitura;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class OyunActivity extends AppCompatActivity {
    //region Global Variables
    Button btnAt;
    ImageView ivPara;
    ImageButton ibSettings;
    TextView tvSonuc;
    Random random = new Random();
    View gameLayout;
    DbHelper dbHelper;
    private int titresim, para;
    private int[] imageArray = {R.drawable.abdcent_on, R.drawable.k250_on, R.drawable.gumus1804_on, R.drawable.kurus1_on, R.drawable.kurus50_on, R.drawable.kurus500_on, R.drawable.tl1_on, R.drawable.yenilira_on, R.drawable.centon, R.drawable.manat2_on, R.drawable.marka5_on, R.drawable.tyin50_on};
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //region XML TO CODE
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
        setContentView(R.layout.activity_oyun);

        btnAt = findViewById(R.id.btnAt);
        ivPara = findViewById(R.id.ivPara);
        ibSettings = findViewById(R.id.ibSettings);
        tvSonuc = findViewById(R.id.tvSonuc);
        gameLayout = findViewById(R.id.gameLayout);
        dbHelper = new DbHelper(getApplicationContext());
        int arkaPlanRenkKaynagi = dbHelper.getArkaPlanRengi();
        gameLayout.setBackgroundColor(arkaPlanRenkKaynagi);
        para = dbHelper.getPara();
        paraSecim();
        titresim = dbHelper.getTitresim();
        Vibrator v = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        //endregion

        //region btnAt
        btnAt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                titresim = dbHelper.getTitresim();
                if (titresim == 1) v.vibrate(30);

                String tura = getString(R.string.tura), yazi = getString(R.string.yazi), bekleyin = getString(R.string.bekleyin);
                int deger = random.nextInt(2);
                para = dbHelper.getPara();
                btnAt.setEnabled(false);
                tvSonuc.setText(bekleyin);

                if (para == 0) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.abdcent_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.abdcent_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 1) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.k250_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.k250_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 2) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.gumus1804_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.gumus1804_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 3) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.kurus1_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.kurus1_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 4) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.kurus50_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.kurus50_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 5) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.kurus500_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.kurus500_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 6) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.tl1_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.tl1_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 7) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.yenilira_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.yenilira_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 8) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.centarka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.centon);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 9) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.manat2_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.manat2_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 10) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.marka5_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.marka5_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else if (para == 11) {
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (deger == 1) {
                                ivPara.setImageResource(R.drawable.tyin50_arka);
                                tvSonuc.setText(tura);
                                btnAt.setEnabled(true);
                            } else {
                                ivPara.setImageResource(R.drawable.tyin50_on);
                                tvSonuc.setText(yazi);
                                btnAt.setEnabled(true);
                            }
                        }
                    }, 1000);
                } else {
                    Toast.makeText(OyunActivity.this, R.string.hata, Toast.LENGTH_SHORT).show();
                }
            }

        });
        //endregion

        //region ibSettings
        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (titresim == 1) v.vibrate(30);
                Intent intent = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(intent);
            }
        });
        //endregion
    }

    @Override
    protected void onResume() {
        super.onResume();
        int arkaPlanRenkKaynagi = dbHelper.getArkaPlanRengi();
        gameLayout.setBackgroundColor(arkaPlanRenkKaynagi);
        paraSecim();
        tvSonuc.setText("");
        titresim = dbHelper.getTitresim();
    }

    private void paraSecim() {
        para = dbHelper.getPara();
        if (para >= 0 && para < imageArray.length) {
            ivPara.setImageResource(imageArray[para]);
        } else {
            // Geçersiz bir resim id'si geldiyse, varsayılan bir resim belirleyebilirsiniz
            ivPara.setImageResource(R.drawable.tl1_on);
        }
    }
}