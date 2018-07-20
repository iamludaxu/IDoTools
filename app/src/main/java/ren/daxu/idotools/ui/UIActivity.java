package ren.daxu.idotools.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;

import ren.daxu.idotools.R;
import ren.daxu.ui.seekbar.BubbleSeekBar;

public class UIActivity extends AppCompatActivity {


    private BubbleSeekBar mBubbleSeekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ui);

        BubbleSeekBar bubbleSeekBar = (BubbleSeekBar) findViewById(R.id.bubbleSeekBar);
        final TextView textView = new TextView(this);
        textView.setLayoutParams(new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        textView.setBackgroundResource(R.drawable.bubble_bg);
        textView.setText("");
        textView.setTextColor(0xffffffff);
        textView.setGravity(Gravity.CENTER);
        bubbleSeekBar.addBubbleFL(textView);
        bubbleSeekBar.setOnProgressChangedListener(new BubbleSeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(BubbleSeekBar bubbleSeekBar, float progress, boolean fromUser) {
                String str = (int) progress + "/" + (int) bubbleSeekBar.getMax();
                bubbleSeekBar.updateThumbText(str);
                textView.setText(str);
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

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBubbleSeekBar.destroy();
    }
}


