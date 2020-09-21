package com.epam.model;

public class MessageEntity {
    private String topic;

    private String receiver;

    private String letterText;

    public MessageEntity(String topic, String receiver, String letterText) {
        this.topic = topic;
        this.receiver = receiver;
        this.letterText = letterText;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getLetterText() {
        return letterText;
    }

    public void setLetterText(String letterText) {
        this.letterText = letterText;
    }

    @Override
    public String toString() {
        return "MessageEntity{" +
                "topic='" + topic + '\'' +
                ", receiver='" + receiver + '\'' +
                ", letterText='" + letterText + '\'' +
                '}';
    }
}
