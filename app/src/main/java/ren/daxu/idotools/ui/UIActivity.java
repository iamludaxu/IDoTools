package ren.daxu.idotools.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ren.daxu.idotools.R;
import ren.daxu.ui.seekbar.BubbleSeekBar;

public class UIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        BubbleSeekBar bubbleSeekBar = (BubbleSeekBar) findViewById(R.id.bubbleSeekBar);
        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, float progress, boolean fromUser) {
                bubbleSeekBar.updateThumbText((int) progress + "/" + (int) bubbleSeekBar.getMax());
            }

            @Override
            public void onStartTrackingTouch(BubbleSeekBar bubbleSeekBar) {

            }

            @Override
            public void onStopTrackingTouch(BubbleSeekBar bubbleSeekBar) {

            }
        });
        bubbleSeekBar.setProgress(60);

    }

}
