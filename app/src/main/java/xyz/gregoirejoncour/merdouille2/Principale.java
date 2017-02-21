package xyz.gregoirejoncour.merdouille2;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.List;

public class Principale extends AppCompatActivity {

    public static final String MESSAGE = "xyz.gregoirejoncour.merdouille2.principale.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principale);

        ImageView img = (ImageView) findViewById(R.id.animAndroid);
        img.setBackgroundResource(R.drawable.anim_android);

        AnimationDrawable frameAnimation = (AnimationDrawable) img.getBackground();

        frameAnimation.start();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
                Intent intent = new Intent(Principale.this, Game.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principale, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.menu_web) {
            Uri webpage = Uri.parse("http://www.gregoirejoncour.xyz");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

            PackageManager pm = getPackageManager();
            List<ResolveInfo> activbities = pm.queryIntentActivities(webIntent, 0);
            boolean isIntentSafe = activbities.size() > 0;

            if (isIntentSafe) {
                startActivity(webIntent);
            }
        }

        if (id == R.id.street) {
            Intent webIntent = new Intent(Principale.this, StreetyActivity.class);
            startActivity(webIntent);
        }

        if (id == R.id.map) {
            Intent webIntent = new Intent(Principale.this, StreetActivity.class);
            startActivity(webIntent);
        }

        return super.onOptionsItemSelected(item);
    }

    public void envoiMessage(View view) {
        Intent intent = new Intent(this, AfficherMessage.class);


        EditText editText = (EditText) findViewById(R.id.chp_saisie);
        String message = editText.getText().toString();
//        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        intent.putExtra(MESSAGE, message);
        startActivity(intent);
    }
}
