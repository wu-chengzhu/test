
package com.example.gp62.test;
import java.io.Serializable;

public class Message implements Serializable {
    private  int sender;
    private  int receiver;
    private String msg;


    public int getSender() {
        return sender;
    }

    public void setSender(int sender) {
        this.sender = sender;
    }

    public int getReceiver() {
        return receiver;
    }

    public void setReceiver(int receiver) {
        this.receiver = receiver;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender=" + sender +
                ", receiver=" + receiver +
                ", msg='" + msg + '\'' +
                '}';
    }
}
