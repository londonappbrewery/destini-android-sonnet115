package com.londonappbrewery.destini;

public class StoryLine {
    int mStoryId;
    int mAns1, mAns2;

    public StoryLine(int id, int ans1, int ans2) {
        mStoryId = id;
        mAns1 = ans1;
        mAns2 = ans2;
    }

    public int getStoryId() {
        return mStoryId;
    }

    public void setStoryId(int storyId) {
        mStoryId = storyId;
    }

    public int getAns1() {
        return mAns1;
    }

    public void setAns1(int ans1) {
        mAns1 = ans1;
    }

    public int getAns2() {
        return mAns2;
    }

    public void setAns2(int ans2) {
        mAns2 = ans2;
    }
}
