package com.beyondfoo.greeting.adapter.port.in.dto;

import java.util.List;

public class ChatRoomDto {

    private String uuid;
    private String name;
    private List<String> userIds;
    private List<ChatMessageDto> chats;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<String> userIds) {
        this.userIds = userIds;
    }

    public List<ChatMessageDto> getChats() {
        return chats;
    }

    public void setChats(List<ChatMessageDto> chats) {
        this.chats = chats;
    }

    @Override
    public String toString() {
        return "ChatRoomDto{" +
                "uuid='" + uuid + '\'' +
                ", name='" + name + '\'' +
                ", users=" + userIds +
                ", chats=" + chats +
                '}';
    }
}
