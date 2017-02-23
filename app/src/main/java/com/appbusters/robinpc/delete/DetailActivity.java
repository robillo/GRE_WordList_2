package com.appbusters.robinpc.delete;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private TextView word, meaning, example;
    private SeekBar seekBar;
    private String editWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);

        seekBar = (SeekBar) findViewById(R.id.seekbar);

        example = (TextView) findViewById(R.id.example);
        word = (TextView) findViewById(R.id.word);
        meaning = (TextView) findViewById(R.id.meaning);

        Intent intent = getIntent();
        editWord = intent.getStringExtra("word");
        editWord.replaceAll("[^A-Za-z]", "");
        word.setText(editWord);
        meaning.setText(intent.getStringExtra("meaning"));

        seekBar.setProgress(15);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                word.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);
                meaning.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);
                example.setTextSize(TypedValue.COMPLEX_UNIT_SP, progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

        }

        return super.onOptionsItemSelected(item);
    }

}
