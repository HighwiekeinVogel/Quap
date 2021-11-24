package com.quap.client.domain;

import java.sql.Date;
import java.util.Objects;

public final class Message extends UserContent {
    private final String content;
    private final Date timestamp;
    private final int senderID;

    public Message(String content, Date timestamp, int senderID) {
        this.content = content;
        this.timestamp = timestamp;
        this.senderID = senderID;
    }

    public String content() {
        return content;
    }

    public Date timestamp() {
        return timestamp;
    }

    public int senderID() {
        return senderID;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Message) obj;
        return Objects.equals(this.content, that.content) &&
                Objects.equals(this.timestamp, that.timestamp) &&
                this.senderID == that.senderID;
    }

    @Override
    public int hashCode() {
        return Objects.hash(content, timestamp, senderID);
    }

    @Override
    public String toString() {
        return "Message[" +
                "content=" + content + ", " +
                "timestamp=" + timestamp + ", " +
                "senderID=" + senderID + ']';
    }


    @Override
    public String display() {
        return "Message[" +
                "content=" + content + ", " +
                "timestamp=" + timestamp + ", " +
                "senderID=" + senderID + ']';
    }

    @Override
    public int getId() {
        return senderID;
    }

    @Override
    public Date getTime() {
        return timestamp;
    }
}