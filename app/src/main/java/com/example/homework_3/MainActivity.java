package com.example.homework_3;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView text01, text02, text03;

    FragmentManager fm;

    private tab_1 t1;
    private tab_2 t2;
    private tab_3 t3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initview();
        text01.setTextColor(Color.RED);


    }

    private void initview() {

        text01 = (TextView) findViewById(R.id.tv01);
        text02 = (TextView) findViewById(R.id.tv02);
        text03 = (TextView) findViewById(R.id.tv03);

        text01.setOnClickListener(this);
        text02.setOnClickListener(this);
        text03.setOnClickListener(this);

        fm = getSupportFragmentManager();
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv01:
                setTabSelection(0);
                text01.setTextColor(Color.RED);

                break;

            case R.id.tv02:
                setTabSelection(1);
                text02.setTextColor(Color.RED);

                break;

            case R.id.tv03:
                setTabSelection(2);
                text03.setTextColor(Color.RED);

                break;
        }
    }

    private void setTabSelection(int index) {
        FragmentTransaction ft = fm.beginTransaction();
        hideFragment(ft);
        switch (index) {
            case 0:
                if (t1 == null) {

                    t1 = new tab_1();
                    ft.add(R.id.vp, t1);

                    text02.setTextColor(Color.BLACK);
                    text03.setTextColor(Color.BLACK);


                } else {
                    ft.show(t1);

                    text02.setTextColor(Color.BLACK);
                    text03.setTextColor(Color.BLACK);
                }
                break;

            case 1:
                if (t2 == null) {
                    t2 = new tab_2();
                    ft.add(R.id.vp, t2);

                    text01.setTextColor(Color.BLACK);
                    text03.setTextColor(Color.BLACK);
                } else
                    ft.show(t2);
                text01.setTextColor(Color.BLACK);
                text03.setTextColor(Color.BLACK);

                break;

            case 2:
                if (t3 == null) {
                    t3 = new tab_3();
                    ft.add(R.id.vp, t3);

                    text01.setTextColor(Color.BLACK);
                    text02.setTextColor(Color.BLACK);
                } else
                    ft.show(t3);

                text01.setTextColor(Color.BLACK);
                text02.setTextColor(Color.BLACK);
                break;
        }
        ft.commit();
    }

    //用于隐藏fragment
    private void hideFragment(FragmentTransaction ft) {
        if (t1 != null) {
            ft.hide(t1);
        }
        if (t2 != null) {
            ft.hide(t2);
        }
        if (t3 != null) {
            ft.hide(t3);
        }
    }

}