package com.example.mychattest;

public class Msg {

    private final String content;
    private final int msg_type;
    public static final int RECEIVE = 0;
    public static final int SENT = 1;

    public Msg(String content, int msg_type) {
        this.content = content;
        this.msg_type = msg_type;
    }

    public String getContent() {
        return content;
    }

    public int getMsg_type() {
        return msg_type;
    }
}
