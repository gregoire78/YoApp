package xyz.gregoirejoncour.merdouille2;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

public class AfficherMessage extends AppCompatActivity {

    protected Button playBtn;
    protected Button stopBtn;
    protected ImageView fire;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String message = intent.getStringExtra(Principale.MESSAGE);

        //textView
        TextView textView = new TextView(this);
        textView.setTextSize(40);
        textView.setText(message);

        setContentView(R.layout.activity_afficher_message);

        TableLayout layout = (TableLayout) findViewById(R.id.layout_afficher_message);

        layout.addView(textView);

        fire = new ImageView(this);
        fire.setImageResource(R.drawable.anim_android);

        stopBtn = new Button(this);
        stopBtn.setText(R.string.btn_stop);
        stopBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable anim = (AnimationDrawable)
                        fire.getDrawable();
                anim.stop();
            }
        });

        playBtn = new Button(this);
        playBtn.setText(R.string.btn_play);
        playBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AnimationDrawable anim = (AnimationDrawable)
                        fire.getDrawable();
                anim.start();
            }

        });

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
