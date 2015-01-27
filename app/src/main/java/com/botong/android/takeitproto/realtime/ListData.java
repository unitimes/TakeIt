package com.botong.android.takeitproto.realtime;

/**
 * Created by cob_macpro on 2015. 1. 26..
 */
public class ListData {
    private String content;
    private int counts;

    public ListData(String content, int counts) {
        this.content = content;
        this.counts = counts;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCounts() {
        return counts;
    }

    public void setCounts(int counts) {
        this.counts = counts;
    }
}
