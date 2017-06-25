package com.londonappbrewery.destini;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import static android.R.attr.id;
import static com.londonappbrewery.destini.R.string.T1_Ans1;

public class MainActivity extends AppCompatActivity {

    // TODO: Steps 4 & 8 - Declare member variables here:
        TextView mStoryTextView;
        Button mButtonTop;
        Button mButtonBottom;
        int mStoryIndex=0;

    // TODO: Making Story Line
        StoryLine mStoryLine[]= new StoryLine[]{
            new StoryLine(R.string.T1_Story, T1_Ans1, R.string.T1_Ans2),
            new StoryLine(R.string.T2_Story, R.string.T2_Ans1, R.string.T2_Ans2),
            new StoryLine(R.string.T3_Story, R.string.T3_Ans1, R.string.T3_Ans2),
        };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // TODO: Step 5 - Wire up the 3 views from the layout to the member variables:
            mStoryTextView = (TextView) findViewById(R.id.storyTextView);
            mButtonTop = (Button) findViewById(R.id.buttonTop);
            mButtonBottom = (Button) findViewById(R.id.buttonBottom);


        // TODO: Steps 6, 7, & 9 - Set a listener on the top button:
            mButtonTop.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                  if(mStoryLine[mStoryIndex].getAns1() == R.string.T1_Ans1){
                      mStoryTextView.setText(R.string.T3_Story);
                      mButtonTop.setText(R.string.T3_Ans1);
                      mButtonBottom.setText(R.string.T3_Ans2);
                      mStoryIndex=2;
                  }
                  else if(mStoryLine[mStoryIndex].getAns1() == R.string.T3_Ans1){
                      mStoryTextView.setText(R.string.T6_End);

                      mButtonBottom.setVisibility(View.INVISIBLE);
                      mButtonTop.setVisibility(View.INVISIBLE);
                      endOfStory();
                  }
                  else if(mStoryLine[mStoryIndex].getAns1() == R.string.T2_Ans1){
                      mStoryTextView.setText(R.string.T3_Story);
                      mButtonTop.setText(R.string.T3_Ans1);
                      mButtonBottom.setText(R.string.T3_Ans2);
                      mStoryIndex=2;
                  }

                }
            });

        // TODO: Steps 6, 7, & 9 - Set a listener on the bottom button:
            mButtonBottom.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mStoryLine[mStoryIndex].getAns2() == R.string.T1_Ans2){
                        mStoryTextView.setText(R.string.T2_Story);
                        mButtonTop.setText(R.string.T2_Ans1);
                        mButtonBottom.setText(R.string.T2_Ans2);
                        mStoryIndex=1;
                    }
                    else if(mStoryLine[mStoryIndex].getAns2() == R.string.T2_Ans2){
                        mStoryTextView.setText(R.string.T4_End);

                        mButtonBottom.setVisibility(View.INVISIBLE);
                        mButtonTop.setVisibility(View.INVISIBLE);
                        endOfStory();
                    }
                    else if(mStoryLine[mStoryIndex].getAns2() == R.string.T3_Ans2){
                        mStoryTextView.setText(R.string.T5_End);

                        mButtonBottom.setVisibility(View.INVISIBLE);
                        mButtonTop.setVisibility(View.INVISIBLE);
                        endOfStory();
                    }

                }
            });
    }

    public void endOfStory(){
        AlertDialog.Builder alert= new AlertDialog.Builder(this);
        alert.setTitle("Story Ended");
        alert.setCancelable(false);
        alert.setPositiveButton("Start again?", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                mStoryIndex=0;
                mStoryTextView.setText(R.string.T1_Story);

                mButtonTop.setText(R.string.T1_Ans1);
                mButtonBottom.setVisibility(View.VISIBLE);

                mButtonBottom.setText(R.string.T2_Ans1);
                mButtonTop.setVisibility(View.VISIBLE);
            }
        });
        alert.setNegativeButton("Close Application", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }
}
