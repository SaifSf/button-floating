package com.example.nihedhamed.customfloatingactionbutton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.oguzdev.circularfloatingactionmenu.library.FloatingActionButton;
import com.oguzdev.circularfloatingactionmenu.library.FloatingActionMenu;
import com.oguzdev.circularfloatingactionmenu.library.SubActionButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton actionButton = new FloatingActionButton.Builder(this)
                .setBackgroundDrawable(getResources().getDrawable(R.drawable.flot_btn))
                .setLayoutParams(this.getResources().getDimensionPixelSize(R.dimen.action_button_width)
                        ,this.getResources().getDimensionPixelSize(R.dimen.action_button_height)
                        ,0,0,20,0)
                .setPosition(3)
                .build();


        SubActionButton.Builder subButtons = new SubActionButton.Builder(this)
                .setLayoutParams(this.getResources().getDimensionPixelSize(R.dimen.sub_action_button_width)
                ,this.getResources().getDimensionPixelSize(R.dimen.sub_action_button_height))
                .setTheme(2); //THEME_LIGHTER = 2

        CustomAmountView viewBtn1 = new CustomAmountView(this);
        viewBtn1.changeTextAmount1();
        CustomAmountView viewBtn2 = new CustomAmountView(this);
        viewBtn2.changeTextAmount3();
        CustomAmountView viewBtn3 = new CustomAmountView(this);
        viewBtn3.changeTextAmount5();
        CustomAmountView viewBtn4 = new CustomAmountView(this);
        viewBtn4.changeTextAmount10();

        SubActionButton btn10dt = subButtons.setContentView(viewBtn4).build();
        SubActionButton btn5dt = subButtons.setContentView(viewBtn3).build();
        SubActionButton btn3dt = subButtons.setContentView(viewBtn2).build();
        SubActionButton btn1dt = subButtons.setContentView(viewBtn1).build();

        FloatingActionMenu actionMenu = new FloatingActionMenu.Builder(this)
                .setStartAngle(90) //angle in degrees
                .setEndAngle(270)
                .setRadius(this.getResources().getDimensionPixelSize(R.dimen.distance_between_action_button_and_items))  //Distance of menu items from action button
                .addSubActionView(btn10dt)
                .addSubActionView(btn5dt)
                .addSubActionView(btn3dt)
                .addSubActionView(btn1dt)
                .attachTo(actionButton)
                .build();

        btn1dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "1 dt", Toast.LENGTH_LONG).show();
            }
        });
        btn3dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "3 dt", Toast.LENGTH_LONG).show();
            }
        });
        btn5dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "5 dt", Toast.LENGTH_LONG).show();
            }
        });
        btn10dt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "10 dt", Toast.LENGTH_LONG).show();
            }
        });
    }
}
