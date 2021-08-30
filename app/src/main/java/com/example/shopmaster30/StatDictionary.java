package com.example.shopmaster30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class StatDictionary extends AppCompatActivity {
    private Button aD;
    private Button aS;
    private Button crit;
    private Button lifeSteal;
    private Button armorPen;
    private Button back;

    //Widget
    RecyclerView recyclerView;

    //vars
    private ArrayList<String> mDescription = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat_dictionary);

        aS = (Button) findViewById(R.id.as);
        aS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_statdescription);
                inAS();
            }
        });

        aD = (Button) findViewById(R.id.ad);
        aD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_statdescription);
                inAD();
            }
        });

        crit = (Button) findViewById(R.id.crit);
        crit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_statdescription);
                inCrit();
            }
        });

        lifeSteal = (Button) findViewById(R.id.ls);
        lifeSteal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_statdescription);
                inLifeSteal();
            }
        });

        armorPen = (Button) findViewById(R.id.armor_pen);
        armorPen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.layout_statdescription);
                inLethaility();
            }
        });
    }


    private void inAD(){
        TextView tv = (TextView) findViewById(R.id.description);
        tv.setText("Attack damage (AD) is the stat that determines the amount of physical damage dealt by basic attacks. AD also determines the damage of various champion abilities, items and runes.\n" +
                "\n" + "Total attack damage is comprised of base attack damage and bonus attack damage.\n" + "\n" +
                "The base attack damage is innate to the champion. It does not depend on items or runes and increases with each champion level.");
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void inAS(){
        TextView tv = (TextView) findViewById(R.id.description);
        tv.setText("Attack speed (AS or ASPD) is a stat that is the frequency of a unit's basic attacks. They are measured and displayed as attacks per second.\n" +
                "\n" +
                "Each champion starts with a certain attack speed ratio, which is also the value given by default to their base attack speed (attack speed at level 1 without any other bonuses). Some champions can start with a base attack speed different from their attack speed ratio. Additional bonus attack speed can be obtained through level-up or with a variety of items, abilities and runes. Bonus attack speed Additive stacking icon.png stacks additively, and each bonus point acquired directly affects its statistic. Bonus attack speed is a percentage of the attack speed ratio, therefore, champions with higher ratio benefit more from bonus attack speed.");
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });}

    private void inCrit(){
        TextView tv = (TextView) findViewById(R.id.description);
        tv.setText("A critical strike is a damage effect that deals 175% of its normal damage by default, denoted as Critical strike damage icon.png critical strike damage. This can occur on some items and abilities, and almost always on basic attacks. Depending on the effect, a critical strike would occur under specific conditions, or based on Critical strike chance critical strike chance");
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });}

    private void inLifeSteal(){
        TextView tv = (TextView) findViewById(R.id.description);
        tv.setText("Life steal is an offensive stat which grants healing equal to a precentage of the damage dealt by basic attacks, including those that are modified.  It applies to abilities that deal basic damage.  The damage of most item on-hit effects benefits from life steal."
        +"\n" + "The heal is based on the post-mitigation damage dealt, or after sources of armor, magic resistance, and damage reduction are taken into account to the damage.");
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });}

    private void inLethaility(){
        TextView tv = (TextView) findViewById(R.id.description);
        tv.setText("Armor penetration is a champion statistic that dictates how much of the target's Armor icon.png armor will be ignored when the user deals physical damage. Percentage armor penetration and Lethality have no effect if the target's armor is less than or equal to 0.\n" +
                "\n" +
                "Armor reduction is an effect which reduces the target's armor by an amount for a period of time. Flat armor reduction can reduce the value below 0, percentage armor reduction cannot.\n" +
                "\n" +
                "All champions have 0 base armor penetration and lethality, but they can be increased with items, runes, and some champion abilities.\n" +
                "\n" +
                "Lethality is a champion statistic introduced in season 2017 that is converted to flat armor penetration at a rate that increases based on your level.");
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                finish();
            }
        });}
}
