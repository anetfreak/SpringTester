package com.beyondfoo.greeting.adapter.port.in.dto;

public class ChatMessageDto {

    private String uuid;
    private String sender;
    private String message;
    private String chatroom;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChatroom() {
        return chatroom;
    }

    public void setChatroom(String chatroom) {
        this.chatroom = chatroom;
    }

    @Override
    public String toString() {
        return "ChatMessageDto{" +
                "uuid='" + uuid + '\'' +
                ", sender='" + sender + '\'' +
                ", message='" + message + '\'' +
                ", chatroom='" + chatroom + '\'' +
                '}';
    }
}
