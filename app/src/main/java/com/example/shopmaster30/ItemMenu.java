package com.example.shopmaster30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Resources;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class ItemMenu extends AppCompatActivity {

    //Item Menu Buttons
    private Button allItems;
    private Button attack;
    private Button attack_speed;
    private Button magic;
    private Button defense;
    private Button movement;
    private Button tools;

    //Widget
    RecyclerView recyclerView;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_menu);

        allItems = (Button) findViewById(R.id.all_items);
        allItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.recyclerview_layout);
                initImageBitmaps();
            }
        });

        attack = (Button) findViewById(R.id.attack);
        attack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.recyclerview_layout);
                inAttackItems();
            }
        });

        attack_speed = (Button) findViewById(R.id.attack_speed);
        attack_speed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.recyclerview_layout);
                inASpeedItems();
            }
        });

        magic = (Button) findViewById(R.id.magic);
        magic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.recyclerview_layout);
                inMagicItems();
            }
        });

        defense = (Button) findViewById(R.id.defense);
        defense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.recyclerview_layout);
                inDefenseItems();
            }
        });

        movement = (Button) findViewById(R.id.movement);
        movement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.recyclerview_layout);
                inMovementItems();
            }
        });

        tools = (Button) findViewById(R.id.tools);
        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.recyclerview_layout);
                inTools();
            }
        });
    }

    private void initImageBitmaps(){

        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1001.png"); mNames.add("Boots");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1004.png"); mNames.add("Faerie Charm");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1006.png"); mNames.add("Rejuvenation Bead");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1011.png"); mNames.add("Giant's Belt");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1018.png"); mNames.add("Cloak of Agility");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1026.png"); mNames.add("Blasting Wand");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1027.png"); mNames.add("Sapphire Crystal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1028.png"); mNames.add("Ruby Crystal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1029.png"); mNames.add("Cloth Armor");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1031.png"); mNames.add("Chain Vest");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1033.png"); mNames.add("Null-Magic Mantle");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1035.png"); mNames.add("Emberknife");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1036.png"); mNames.add("Long Sword");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1037.png"); mNames.add("Pickaxe");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1038.png"); mNames.add("B. F. Sword");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1039.png"); mNames.add("Hailblade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1042.png"); mNames.add("Dagger");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1043.png"); mNames.add("Recurve Bow");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1052.png"); mNames.add("Amplifying Tome");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1053.png"); mNames.add("Vampiric Scepter");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1054.png"); mNames.add("Doran's Shield");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1055.png"); mNames.add("Doran's Blade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1056.png"); mNames.add("Doran's Ring");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1057.png"); mNames.add("Negatron Cloak");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1058.png"); mNames.add("Needlessly Large Rod");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1082.png"); mNames.add("Dark Seal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1083.png"); mNames.add("Cull");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2003.png"); mNames.add("Health Potion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2010.png"); mNames.add("Total Biscuit of Everlasting Will");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2015.png"); mNames.add("Kircheis Shard");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2031.png"); mNames.add("Refillable Potion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2033.png"); mNames.add("Corrupting Potion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2051.png"); mNames.add("Guardian's Horn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2052.png"); mNames.add("Poro-Snax");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2055.png"); mNames.add("Control Ward");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2065.png"); mNames.add("Shurelya's Battlesong");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2138.png"); mNames.add("Elixir of Iron");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2139.png"); mNames.add("Elixir of Sorcery");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2140.png"); mNames.add("Elixir of Wrath");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2403.png"); mNames.add("Minion Dematerializer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2419.png"); mNames.add("Commencing Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2420.png"); mNames.add("Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2421.png"); mNames.add("Broken Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2422.png"); mNames.add("Slightly Magical Footwear");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2423.png"); mNames.add("Perfectly Timed Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2424.png"); mNames.add("Broken Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3001.png"); mNames.add("Abyssal Mask");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3003.png"); mNames.add("Archangel's Staff");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3004.png"); mNames.add("Manamune");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3006.png"); mNames.add("Berserker's Greaves");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3009.png"); mNames.add("Boots of Swiftness");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3011.png"); mNames.add("Chemtech Putrifier");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3020.png"); mNames.add("Sorcerer's Shoes");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3024.png"); mNames.add("Glacial Buckler");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3026.png"); mNames.add("Guardian Angel");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3031.png"); mNames.add("Infinity Edge");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3033.png"); mNames.add("Mortal Reminder");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3035.png"); mNames.add("Last Whisper");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3036.png"); mNames.add("Lord Dominik's Regards");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3040.png"); mNames.add("Seraph's Embrace");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3041.png"); mNames.add("Mejai's Soulstealer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3042.png"); mNames.add("Muramana");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3044.png"); mNames.add("Phage");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3046.png"); mNames.add("Phantom Dancer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3047.png"); mNames.add("Plated Steelcaps");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3050.png"); mNames.add("Zeke's Convergence");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3051.png"); mNames.add("Hearthbound Axe");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3053.png"); mNames.add("Sterak's Gage");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3057.png"); mNames.add("Sheen");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3065.png"); mNames.add("Spirit Visage");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3066.png"); mNames.add("Winged Moonplate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3067.png"); mNames.add("Kindlegem");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3068.png"); mNames.add("Sunfire Aegis");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3070.png"); mNames.add("Tear of the Goddess");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3071.png"); mNames.add("Black Cleaver");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3072.png"); mNames.add("Bloodthirster");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3074.png"); mNames.add("Ravenous Hydra");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3075.png"); mNames.add("Thornmail");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3076.png"); mNames.add("Bramble Vest");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3077.png"); mNames.add("Tiamat");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3078.png"); mNames.add("Trinity Force");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3082.png"); mNames.add("Warden's Mail");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3083.png"); mNames.add("Warmog's Armor");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3085.png"); mNames.add("Runaan's Hurricane");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3086.png"); mNames.add("Zeal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3089.png"); mNames.add("Rabadon's Deathcap");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3091.png"); mNames.add("Wit's End");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3094.png"); mNames.add("Rapid Firecannon");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3095.png"); mNames.add("Stormrazor");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3100.png"); mNames.add("Lich Bane");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3102.png"); mNames.add("Banshee's Veil");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3105.png"); mNames.add("Aegis of the Legion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3107.png"); mNames.add("Redemption");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3108.png"); mNames.add("Fiendish Codex");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3109.png"); mNames.add("Knight's Vow");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3110.png"); mNames.add("Frozen Heart");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3111.png"); mNames.add("Mercury's Treads");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3112.png"); mNames.add("Guardian's Orb");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3113.png"); mNames.add("Aether Wisp");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3114.png"); mNames.add("Forbidden Idol");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3115.png"); mNames.add("Nashor's Tooth");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3116.png"); mNames.add("Rylai's Crystal Scepter");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3117.png"); mNames.add("Mobility Boots");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3123.png"); mNames.add("Executioner's Calling");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3124.png"); mNames.add("Guinsoo's Rageblade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3133.png"); mNames.add("Caulfield's Warhammer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3134.png"); mNames.add("Serrated Dirk");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3135.png"); mNames.add("Void Staff");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3139.png"); mNames.add("Mercurial Scimitar");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3140.png"); mNames.add("Quicksilver Sash");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3142.png"); mNames.add("Youmuu's Ghostblade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3143.png"); mNames.add("Randuin's Omen");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3145.png"); mNames.add("Hextech Alternator");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3152.png"); mNames.add("Hextech Rocketbelt");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3153.png"); mNames.add("Blade of The Ruined King");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3155.png"); mNames.add("Hexdrinker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3156.png"); mNames.add("Maw of Malmortius");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3157.png"); mNames.add("Zhonya's Hourglass");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3158.png"); mNames.add("Ionian Boots of Lucidity");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3165.png"); mNames.add("Morellonomicon");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3177.png"); mNames.add("Guardian's Blade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3179.png"); mNames.add("Umbral Glaive");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3181.png"); mNames.add("Hullbreaker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3184.png"); mNames.add("Guardian's Hammer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3190.png"); mNames.add("Locket of the Iron Solari");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3191.png"); mNames.add("Seeker's Armguard");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3193.png"); mNames.add("Gargoyle Stoneplate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3211.png"); mNames.add("Spectre's Cowl");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3222.png"); mNames.add("Mikael's Blessing");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3330.png"); mNames.add("Scarecrow Effigy");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3340.png"); mNames.add("Stealth Ward");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3363.png"); mNames.add("Farsight Alteration");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3364.png"); mNames.add("Oracle Lens");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3400.png"); mNames.add("Your Cut");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3504.png"); mNames.add("Ardent Censer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3508.png"); mNames.add("Essence Reaver");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3513.png"); mNames.add("Eye of the Herald");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3599.png"); mNames.add("Kalista's Black Spear");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3600.png"); mNames.add("Kalista's Black Spear");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3742.png"); mNames.add("Dead Man's Plate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3748.png"); mNames.add("Titanic Hydra");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3801.png"); mNames.add("Crystalline Bracer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3802.png"); mNames.add("Lost Chapter");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3814.png"); mNames.add("Edge of Night");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3850.png"); mNames.add("Spellthief's Edge");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3851.png"); mNames.add("Frostfang");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3853.png"); mNames.add("Shard of True Ice");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3854.png"); mNames.add("Steel Shoulderguards");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3855.png"); mNames.add("Runesteel Spaulders");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3857.png"); mNames.add("Pauldrons of Whiterock");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3858.png"); mNames.add("Relic Shield");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3859.png"); mNames.add("Targon's Buckler");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3860.png"); mNames.add("Bulwark of the Mountain");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3862.png"); mNames.add("Spectral Sickle");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3863.png"); mNames.add("Harrowing Crescent");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3864.png"); mNames.add("Black Mist Scythe");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3916.png"); mNames.add("Oblivion Orb");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4005.png"); mNames.add("Imperial Mandate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4401.png"); mNames.add("Force of Nature");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4403.png"); mNames.add("The Golden Spatula");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4628.png"); mNames.add("Horizon Focus");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4629.png"); mNames.add("Cosmic Drive");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4630.png"); mNames.add("Blighting Jewel");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4632.png"); mNames.add("Verdant Barrier");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4633.png"); mNames.add("Riftmaker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4635.png"); mNames.add("Leeching Leer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4636.png"); mNames.add("Night Harvester");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4637.png"); mNames.add("Demonic Embrace");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4638.png"); mNames.add("Watchful Wardstone");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4642.png"); mNames.add("Bandleglass Mirror");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4643.png"); mNames.add("Vigilant Wardstone");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6029.png"); mNames.add("Ironspike Whip");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6035.png"); mNames.add("Silvermere Dawn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6333.png"); mNames.add("Death's Dance");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6609.png"); mNames.add("hempunk Chainsword");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6616.png"); mNames.add("Staff of Flowing Water");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6617.png"); mNames.add("Moonstone Renewer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6630.png"); mNames.add("Goredrinker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6631.png"); mNames.add("Stridebreaker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6632.png"); mNames.add("Divine Sunderer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6653.png"); mNames.add("Liandry's Anguish");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6655.png"); mNames.add("Luden's Tempest");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6656.png"); mNames.add("Everfrost");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6660.png"); mNames.add("Bami's Cinder");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6662.png"); mNames.add("Frostfire Gauntlet");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6664.png"); mNames.add("Turbo Chemtank");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6670.png"); mNames.add("Noonquiver");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6671.png"); mNames.add("Galeforce");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6672.png"); mNames.add("Kraken Slayer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6673.png"); mNames.add("Immortal Shieldbow");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6675.png"); mNames.add("Navori Quickblades");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6676.png"); mNames.add("The Collector");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6677.png"); mNames.add("Rageknife");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6691.png"); mNames.add("Duskblade of Draktharr");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6692.png"); mNames.add("Eclipse");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6693.png"); mNames.add("Prowler's Claw");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6694.png"); mNames.add("Serylda's Grudge");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6695.png"); mNames.add("Serpent's Fang");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/8001.png"); mNames.add("Anathema's Chains");


        initRecyclerView();
    }

    private void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void inAttackItems(){
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3011.png"); mNames.add("Chemtech Putrifier");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3053.png"); mNames.add("Sterak's Gage");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3095.png"); mNames.add("Stormrazor");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3124.png"); mNames.add("Guinsoo's Rageblade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6671.png"); mNames.add("Galeforce");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1036.png"); mNames.add("Long Sword");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1037.png"); mNames.add("Pickaxe");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1038.png"); mNames.add("B. F. Sword");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1053.png"); mNames.add("Vampiric Scepter");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3004.png"); mNames.add("Manamune");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3026.png"); mNames.add("Guardian Angel");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3031.png"); mNames.add("Infinity Edge");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3033.png"); mNames.add("Mortal Reminder");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3036.png"); mNames.add("Lord Dominik's Regards");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3042.png"); mNames.add("Muramana");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3044.png"); mNames.add("Phage");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3057.png"); mNames.add("Sheen");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3071.png"); mNames.add("Black Cleaver");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3072.png"); mNames.add("Bloodthirster");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3074.png"); mNames.add("Ravenous Hydra");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3077.png"); mNames.add("Tiamat");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3078.png"); mNames.add("Trinity Force");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3123.png"); mNames.add("Executioner's Calling");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3133.png"); mNames.add("Caulfield's Warhammer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3134.png"); mNames.add("Serrated Dirk");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3139.png"); mNames.add("Mercurial Scimitar");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3142.png"); mNames.add("Youmuu's Ghostblade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3153.png"); mNames.add("Blade of The Ruined King");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3155.png"); mNames.add("Hexdrinker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3156.png"); mNames.add("Maw of Malmortius");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3179.png"); mNames.add("Umbral Glaive");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3181.png"); mNames.add("Hullbreaker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3748.png"); mNames.add("Titanic Hydra");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3814.png"); mNames.add("Edge of Night");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4005.png"); mNames.add("Imperial Mandate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6029.png"); mNames.add("Ironspike Whip");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6035.png"); mNames.add("Silvermere Dawn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6333.png"); mNames.add("Death's Dance");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6609.png"); mNames.add("hempunk Chainsword");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6630.png"); mNames.add("Goredrinker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6631.png"); mNames.add("Stridebreaker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6632.png"); mNames.add("Divine Sunderer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6672.png"); mNames.add("Kraken Slayer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6673.png"); mNames.add("Immortal Shieldbow");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6675.png"); mNames.add("Navori Quickblades");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6676.png"); mNames.add("The Collector");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6677.png"); mNames.add("Rageknife");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6691.png"); mNames.add("Duskblade of Draktharr");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6692.png"); mNames.add("Eclipse");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6693.png"); mNames.add("Prowler's Claw");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6694.png"); mNames.add("Serylda's Grudge");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6695.png"); mNames.add("Serpent's Fang");

        initRecyclerView();
    }

    private void inASpeedItems(){
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3095.png"); mNames.add("Stormrazor");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3124.png"); mNames.add("Guinsoo's Rageblade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6671.png"); mNames.add("Galeforce");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1018.png"); mNames.add("Cloak of Agility");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1042.png"); mNames.add("Dagger");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1043.png"); mNames.add("Recurve Bow");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2015.png"); mNames.add("Kircheis Shard");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3035.png"); mNames.add("Last Whisper");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3046.png"); mNames.add("Phantom Dancer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3085.png"); mNames.add("Runaan's Hurricane");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3086.png"); mNames.add("Zeal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3091.png"); mNames.add("Wit's End");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3094.png"); mNames.add("Rapid Firecannon");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6670.png"); mNames.add("Noonquiver");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3115.png"); mNames.add("Nashor's Tooth");


        initRecyclerView();
    }

    private void inMagicItems(){
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3115.png"); mNames.add("Nashor's Tooth");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1004.png"); mNames.add("Faerie Charm");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1026.png"); mNames.add("Blasting Wand");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1027.png"); mNames.add("Sapphire Crystal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1052.png"); mNames.add("Amplifying Tome");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1058.png"); mNames.add("Needlessly Large Rod");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1082.png"); mNames.add("Dark Seal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3003.png"); mNames.add("Archangel's Staff");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3040.png"); mNames.add("Seraph's Embrace");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3041.png"); mNames.add("Mejai's Soulstealer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3089.png"); mNames.add("Rabadon's Deathcap");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3100.png"); mNames.add("Lich Bane");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3108.png"); mNames.add("Fiendish Codex");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3113.png"); mNames.add("Aether Wisp");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3114.png"); mNames.add("Forbidden Idol");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3116.png"); mNames.add("Rylai's Crystal Scepter");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3135.png"); mNames.add("Void Staff");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3145.png"); mNames.add("Hextech Alternator");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3152.png"); mNames.add("Hextech Rocketbelt");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3165.png"); mNames.add("Morellonomicon");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3504.png"); mNames.add("Ardent Censer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3508.png"); mNames.add("Essence Reaver");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3802.png"); mNames.add("Lost Chapter");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3916.png"); mNames.add("Oblivion Orb");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4628.png"); mNames.add("Horizon Focus");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4629.png"); mNames.add("Cosmic Drive");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4633.png"); mNames.add("Riftmaker");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4635.png"); mNames.add("Leeching Leer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4636.png"); mNames.add("Night Harvester");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4637.png"); mNames.add("Demonic Embrace");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4642.png"); mNames.add("Bandleglass Mirror");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6616.png"); mNames.add("Staff of Flowing Water");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6617.png"); mNames.add("Moonstone Renewer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6653.png"); mNames.add("Liandry's Anguish");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6655.png"); mNames.add("Luden's Tempest");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6656.png"); mNames.add("Everfrost");

        initRecyclerView();
    }

    private void inDefenseItems(){
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3011.png"); mNames.add("Chemtech Putrifier");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3053.png"); mNames.add("Sterak's Gage");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1006.png"); mNames.add("Rejuvenation Bead");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1011.png"); mNames.add("Giant's Belt");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1028.png"); mNames.add("Ruby Crystal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1029.png"); mNames.add("Cloth Armor");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1031.png"); mNames.add("Chain Vest");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1033.png"); mNames.add("Null-Magic Mantle");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1057.png"); mNames.add("Negatron Cloak");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2065.png"); mNames.add("Shurelya's Battlesong");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3001.png"); mNames.add("Abyssal Mask");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3024.png"); mNames.add("Glacial Buckler");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3050.png"); mNames.add("Zeke's Convergence");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3065.png"); mNames.add("Spirit Visage");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3066.png"); mNames.add("Winged Moonplate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3067.png"); mNames.add("Kindlegem");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3068.png"); mNames.add("Sunfire Aegis");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3075.png"); mNames.add("Thornmail");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3076.png"); mNames.add("Bramble Vest");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3082.png"); mNames.add("Warden's Mail");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3083.png"); mNames.add("Warmog's Armor");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3102.png"); mNames.add("Banshee's Veil");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3105.png"); mNames.add("Aegis of the Legion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3107.png"); mNames.add("Redemption");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3109.png"); mNames.add("Knight's Vow");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3110.png"); mNames.add("Frozen Heart");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3140.png"); mNames.add("Quicksilver Sash");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3143.png"); mNames.add("Randuin's Omen");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3157.png"); mNames.add("Zhonya's Hourglass");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3190.png"); mNames.add("Locket of the Iron Solari");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3191.png"); mNames.add("Seeker's Armguard");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3193.png"); mNames.add("Gargoyle Stoneplate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3211.png"); mNames.add("Spectre's Cowl");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3222.png"); mNames.add("Mikael's Blessing");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3742.png"); mNames.add("Dead Man's Plate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3801.png"); mNames.add("Crystalline Bracer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4401.png"); mNames.add("Force of Nature");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4630.png"); mNames.add("Blighting Jewel");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4632.png"); mNames.add("Verdant Barrier");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6660.png"); mNames.add("Bami's Cinder");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6662.png"); mNames.add("Frostfire Gauntlet");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/6664.png"); mNames.add("Turbo Chemtank");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/8001.png"); mNames.add("Anathema's Chains");

        initRecyclerView();
    }

    private void inMovementItems(){
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1001.png"); mNames.add("Boots");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3006.png"); mNames.add("Berserker's Greaves");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3009.png"); mNames.add("Boots of Swiftness");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3020.png"); mNames.add("Sorcerer's Shoes");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3047.png"); mNames.add("Plated Steelcaps");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3111.png"); mNames.add("Mercury's Treads");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3117.png"); mNames.add("Mobility Boots");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3158.png"); mNames.add("Ionian Boots of Lucidity");

        initRecyclerView();
    }

    private void inTools(){
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1035.png"); mNames.add("Emberknife");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1039.png"); mNames.add("Hailblade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1054.png"); mNames.add("Doran's Shield");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1055.png"); mNames.add("Doran's Blade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1056.png"); mNames.add("Doran's Ring");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/1083.png"); mNames.add("Cull");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2003.png"); mNames.add("Health Potion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2010.png"); mNames.add("Total Biscuit of Everlasting Will");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2031.png"); mNames.add("Refillable Potion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2033.png"); mNames.add("Corrupting Potion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2051.png"); mNames.add("Guardian's Horn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2052.png"); mNames.add("Poro-Snax");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2055.png"); mNames.add("Control Ward");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2138.png"); mNames.add("Elixir of Iron");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2139.png"); mNames.add("Elixir of Sorcery");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2140.png"); mNames.add("Elixir of Wrath");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2403.png"); mNames.add("Minion Dematerializer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2419.png"); mNames.add("Commencing Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2420.png"); mNames.add("Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2421.png"); mNames.add("Broken Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2422.png"); mNames.add("Slightly Magical Footwear");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2423.png"); mNames.add("Perfectly Timed Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/2424.png"); mNames.add("Broken Stopwatch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3051.png"); mNames.add("Hearthbound Axe");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3070.png"); mNames.add("Tear of the Goddess");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3112.png"); mNames.add("Guardian's Orb");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3177.png"); mNames.add("Guardian's Blade");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3184.png"); mNames.add("Guardian's Hammer");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3330.png"); mNames.add("Scarecrow Effigy");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3340.png"); mNames.add("Stealth Ward");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3363.png"); mNames.add("Farsight Alteration");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3364.png"); mNames.add("Oracle Lens");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3400.png"); mNames.add("Your Cut");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3513.png"); mNames.add("Eye of the Herald");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3599.png"); mNames.add("Kalista's Black Spear");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3600.png"); mNames.add("Kalista's Black Spear");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3850.png"); mNames.add("Spellthief's Edge");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3851.png"); mNames.add("Frostfang");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3853.png"); mNames.add("Shard of True Ice");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3854.png"); mNames.add("Steel Shoulderguards");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3855.png"); mNames.add("Runesteel Spaulders");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3857.png"); mNames.add("Pauldrons of Whiterock");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3858.png"); mNames.add("Relic Shield");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3859.png"); mNames.add("Targon's Buckler");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3860.png"); mNames.add("Bulwark of the Mountain");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3862.png"); mNames.add("Spectral Sickle");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3863.png"); mNames.add("Harrowing Crescent");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/3864.png"); mNames.add("Black Mist Scythe");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4403.png"); mNames.add("The Golden Spatula");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4638.png"); mNames.add("Watchful Wardstone");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/item/4643.png"); mNames.add("Vigilant Wardstone");

        initRecyclerView();
    }
}

