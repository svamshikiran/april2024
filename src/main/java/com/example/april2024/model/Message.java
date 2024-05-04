package com.example.april2024.model;

/*
{
    "msgid": "123",
    "msg": "THIS IS A TEST MESSAGE"
}
 */

public class Message {

    private int msgid;
    private String msg;

    public int getMsgid() {
        return msgid;
    }

    public void setMsgid(int msgid) {
        this.msgid = msgid;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString(){
        return msgid+"-"+msg;
    }
}
