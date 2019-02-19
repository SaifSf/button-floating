package com.example.nihedhamed.customfloatingactionbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends AppCompatActivity {

    private Button operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setBackgroundDrawable(getResources().getDrawable(R.drawable.flot_btn))
                //.setLayoutParams(new FrameLayout.LayoutParams(100, 100))
                .setPosition(3)
                .build();

        FrameLayout.LayoutParams contentParams = new FrameLayout.LayoutParams(160, 160);
        SubActionButton.Builder itemBuilder = new SubActionButton.Builder(this)
                .setLayoutParams(contentParams)
                .setTheme(2);

        CustomAmountView viewBtn1 = new CustomAmountView(this);
        viewBtn1.changeTextAmount1();
        CustomAmountView viewBtn2 = new CustomAmountView(this);
        viewBtn2.changeTextAmount3();
        CustomAmountView viewBtn3 = new CustomAmountView(this);
        viewBtn3.changeTextAmount5();
        CustomAmountView viewBtn4 = new CustomAmountView(this);
        viewBtn4.changeTextAmount10();

        SubActionButton btn1dt = itemBuilder.setContentView(viewBtn4).build();
        SubActionButton btn3dt = itemBuilder.setContentView(viewBtn3).build();
        SubActionButton btn5dt = itemBuilder.setContentView(viewBtn2).build();
        SubActionButton btn10dt = itemBuilder.setContentView(viewBtn1).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .setStartAngle(90)
                .setEndAngle(270)
                .setRadius(200)
                .addSubActionView(btn1dt)
                .addSubActionView(btn3dt)
                .addSubActionView(btn5dt)
                .addSubActionView(btn10dt)
                .attachTo(actionButton)
                .build();

    }
}
