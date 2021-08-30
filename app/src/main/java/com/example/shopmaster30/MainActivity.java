package com.example.shopmaster30;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    //Main Activity Buttons
    private Button itemMenu;
    private Button champions;
    private Button statDictionary;

    //Widget
    RecyclerView recyclerView;

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //itemMenu button click
        itemMenu = (Button) findViewById(R.id.items);
        itemMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openItemMenu();
            }
        });
        //Champions button click
        champions = (Button) findViewById(R.id.champions);
        champions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setContentView(R.layout.recyclerview_layout);
                initImageBitmaps();
            }
        });
        //Stats button click
        statDictionary = (Button) findViewById(R.id.stats);
        statDictionary.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                setContentView(R.layout.activity_stat_dictionary);
                openStatMenu();
            }
        });
        Log.d(TAG, "onCreate: started");
    }

    public void openItemMenu(){
        Intent intent = new Intent(this, ItemMenu.class);
        startActivity(intent);
    }

    public void openStatMenu(){
        Intent intent = new Intent(this, StatDictionary.class);
        startActivity(intent);
    }

    private void initImageBitmaps(){
        Log.d(TAG, "initImageBitmaps: preparing bitmaps.");

        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Aatrox.png"); mNames.add("Aatrox");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Ahri.png"); mNames.add("Ahri");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Akali.png"); mNames.add("Akali");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Akshan.png"); mNames.add("Akshan");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Alistar.png"); mNames.add("Alistar");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Amumu.png"); mNames.add("Amumu");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Anivia.png"); mNames.add("Anivia");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Annie.png"); mNames.add("Annie");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Aphelios.png"); mNames.add("Aphelios");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Ashe.png"); mNames.add("Ashe");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/AurelionSol.png"); mNames.add("Aurelion Sol");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Azir.png"); mNames.add("Azir");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Bard.png"); mNames.add("Bard");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Blitzcrank.png"); mNames.add("Blitzcrank");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Brand.png"); mNames.add("Brand");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Braum.png"); mNames.add("Braum");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Caitlyn.png"); mNames.add("Caitlyn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Camille.png"); mNames.add("Camille");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Cassiopeia.png"); mNames.add("Cassiopeia");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Chogath.png"); mNames.add("Cho'Gath");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Corki.png"); mNames.add("Corki");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Darius.png"); mNames.add("Darius");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Diana.png"); mNames.add("Diana");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/DrMundo.png"); mNames.add("Dr. Mundo");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Draven.png"); mNames.add("Draven");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Ekko.png"); mNames.add("Ekko");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Elise.png"); mNames.add("Elise");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Evelynn.png"); mNames.add("Evelynn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Ezreal.png"); mNames.add("Ezreal");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Fiddlesticks.png"); mNames.add("Fiddlesticks");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Fiora.png"); mNames.add("Fiora");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Fizz.png"); mNames.add("Fizz");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Galio.png"); mNames.add("Galio");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Gangplank.png"); mNames.add("Gangplank");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Garen.png"); mNames.add("Garen");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Gnar.png"); mNames.add("Gnar");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Gragas.png"); mNames.add("Gragas");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Graves.png"); mNames.add("Graves");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Gwen.png"); mNames.add("Gwen");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Hecarim.png"); mNames.add("Hecarim");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Heimerdinger.png"); mNames.add("Heimerdinger");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Illaoi.png"); mNames.add("Illaoi");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Irelia.png"); mNames.add("Irelia");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Ivern.png"); mNames.add("Ivern");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Janna.png"); mNames.add("Janna");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/JarvanIV.png"); mNames.add("Jarvan IV");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Jax.png"); mNames.add("Jax");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Jayce.png"); mNames.add("Jayce");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Jhin.png"); mNames.add("Jhin");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Jinx.png"); mNames.add("Jinx");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Kaisa.png"); mNames.add("Kai'Sa");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Kalista.png"); mNames.add("Kalista");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Karma.png"); mNames.add("Karma");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Karthus.png"); mNames.add("Karthus");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Kassadin.png"); mNames.add("Kassadin");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Katarina.png"); mNames.add("Katarina");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Kayle.png"); mNames.add("Kayle");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Kayn.png"); mNames.add("Kayn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Kennen.png"); mNames.add("Kennen");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Khazix.png"); mNames.add("Kha'Zix");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Kindred.png"); mNames.add("Kindred");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Kled.png"); mNames.add("Kled");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/KogMaw.png"); mNames.add("Kog'Maw");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Leblanc.png"); mNames.add("LeBlanc");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/LeeSin.png"); mNames.add("Lee Sin");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Leona.png"); mNames.add("Leona");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Lillia.png"); mNames.add("Lillia");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Lissandra.png"); mNames.add("Lissandra");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Lucian.png"); mNames.add("Lucian");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Lulu.png"); mNames.add("Lulu");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Lux.png"); mNames.add("Lux");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Malphite.png"); mNames.add("Malphite");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Malzahar.png"); mNames.add("Malzahar");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Maokai.png"); mNames.add("Maokai");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/MasterYi.png"); mNames.add("Master Yi");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/MissFortune.png"); mNames.add("Miss Fortune");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Mordekaiser.png"); mNames.add("Mordekaiser");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Morgana.png"); mNames.add("Morgana");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Nami.png"); mNames.add("Nami");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Nasus.png"); mNames.add("Nasus");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Nautilus.png"); mNames.add("Nautilus");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Neeko.png"); mNames.add("Neeko");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Nidalee.png"); mNames.add("Nidalee");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Nocturne.png"); mNames.add("Nocturne");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Nunu.png"); mNames.add("Nunu & Willump");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Olaf.png"); mNames.add("Olaf");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Orianna.png"); mNames.add("Orianna");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Ornn.png"); mNames.add("Ornn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Pantheon.png"); mNames.add("Pantheon");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Poppy.png"); mNames.add("Poppy");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Pyke.png"); mNames.add("Pyke");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Qiyana.png"); mNames.add("Qiyana");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Quinn.png"); mNames.add("Quinn");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Rakan.png"); mNames.add("Rakan");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Rammus.png"); mNames.add("Rammus");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/RekSai.png"); mNames.add("Rek'Sai");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Rell.png"); mNames.add("Rell");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Renekton.png"); mNames.add("Renekton");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Rengar.png"); mNames.add("Rengar");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Riven.png"); mNames.add("Riven");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Rumble.png"); mNames.add("Rumble");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Ryze.png"); mNames.add("Ryze");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Samira.png"); mNames.add("Samira");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Sejuani.png"); mNames.add("Sejuani");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Senna.png"); mNames.add("Senna");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Seraphine.png"); mNames.add("Seraphine");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Sett.png"); mNames.add("Sett");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Shaco.png"); mNames.add("Shaco");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Shen.png"); mNames.add("Shen");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Shyvana.png"); mNames.add("Shyvana");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Singed.png"); mNames.add("Singed");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Sion.png"); mNames.add("Sion");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Sivir.png"); mNames.add("Sivir");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Skarner.png"); mNames.add("Skarner");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Sona.png"); mNames.add("Sona");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Soraka.png"); mNames.add("Soraka");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Swain.png"); mNames.add("Swain");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Sylas.png"); mNames.add("Sylas");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Syndra.png"); mNames.add("Syndra");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/TahmKench.png"); mNames.add("Tahm Kench");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Taliyah.png"); mNames.add("Taliyah");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Talon.png"); mNames.add("Talon");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Taric.png"); mNames.add("Taric");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Teemo.png"); mNames.add("Teemo");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Thresh.png"); mNames.add("Thresh");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Tristana.png"); mNames.add("Tristana");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Trundle.png"); mNames.add("Trundle");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Tryndamere.png"); mNames.add("Tryndamere");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/TwistedFate.png"); mNames.add("Twisted Fate");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Twitch.png"); mNames.add("Twitch");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Udyr.png"); mNames.add("Udyr");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Urgot.png"); mNames.add("Urgot");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Varus.png"); mNames.add("Varus");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Vayne.png"); mNames.add("Vayne");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Veigar.png"); mNames.add("Veigar");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Velkoz.png"); mNames.add("Vel'Koz");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Vi.png"); mNames.add("Vi");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Viego.png"); mNames.add("Viego");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Viktor.png"); mNames.add("Viktor");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Vladimir.png"); mNames.add("Vladimir");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Volibear.png"); mNames.add("Volibear");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Warwick.png"); mNames.add("Warwick");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/MonkeyKing.png"); mNames.add("Wukong");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Xayah.png"); mNames.add("Xayah");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Xerath.png"); mNames.add("Xerath");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/XinZhao.png"); mNames.add("Xin Zhao");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Yasuo.png"); mNames.add("Yasuo");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Yone.png"); mNames.add("Yone");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Yorick.png"); mNames.add("Yorick");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Yuumi.png"); mNames.add("Yuumi");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Zac.png"); mNames.add("Zac");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Zed.png"); mNames.add("Zed");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Ziggs.png"); mNames.add("Ziggs");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Zilean.png"); mNames.add("Zilean");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Zoe.png"); mNames.add("Zoe");
        mImageUrls.add("https://ddragon.leagueoflegends.com/cdn/11.16.1/img/champion/Zyra.png"); mNames.add("Zyra");

        initRecyclerView();
    }

    private void initRecyclerView(){
        Log.d(TAG,"initRecyclerView: init recyclerview.");
        RecyclerView recyclerView = findViewById(R.id.recyclerv_view);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(mNames, mImageUrls, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

}