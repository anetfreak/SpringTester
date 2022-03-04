package com.beyondfoo.greeting.adapter.port.in;

import com.beyondfoo.greeting.adapter.port.in.dto.ChatMessageDto;
import com.beyondfoo.greeting.adapter.port.in.dto.ChatRoomDto;
import com.beyondfoo.greeting.adapter.port.in.dto.UserDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/chat")
public class ChatController {

    static Map<String, String> messages = new HashMap<>();
    static Map<String, ChatRoomDto> chatrooms = new HashMap<>();

    @RequestMapping("/send")
    @PostMapping
    public boolean sendMessage(@RequestBody ChatMessageDto chatMessageDto) {
        // Assuming data sent in via input is valid

        // Check if the user is nt a member of the room
        String chatroom = chatMessageDto.getChatroom();
        ChatRoomDto chatroomDto = chatrooms.get(chatroom);
        List<String> chatUsers = chatroomDto.getUserIds();

        if(!chatUsers.contains(chatMessageDto.getSender())) {
            throw new RuntimeException("User not a part of this chatroom.");
        } else {
            List<ChatMessageDto> messages = chatroomDto.getChats();
            messages.add(chatMessageDto);
        }
        displayChatRooms();
        return true;
    }


    @RequestMapping("/join")
    @PostMapping
    public boolean joinChatRoom(@RequestParam String userId, @RequestParam String chatroom) {
        // Assuming data sent in via input is valid
        // Handle the use case of chatroom not present when the user is trying to join one


        if(chatrooms.get(chatroom) == null) {
            ChatRoomDto chatroomDto = new ChatRoomDto();
            chatroomDto.setName(chatroom);
            chatroomDto.setUuid(chatroom);

            List<String> users = new ArrayList<>();
            users.add(userId);

            chatroomDto.setUserIds(users);
            chatroomDto.setChats(new ArrayList<>());

            chatrooms.put(chatroomDto.getName(), chatroomDto);
        } else {
            ChatRoomDto existingChatroom = chatrooms.get(chatroom);
            List<String> users = existingChatroom.getUserIds();

            if(users == null) {
                users = new ArrayList<>();
            } else if(users.contains(userId)) {
                displayChatRooms();
                return true;
            }
            users.add(userId);
        }

        displayChatRooms();
        return true;
    }


    public void displayChatRooms() {
        for(ChatRoomDto chatroom : chatrooms.values()) {
            System.out.println(chatroom);
        }
    }
}