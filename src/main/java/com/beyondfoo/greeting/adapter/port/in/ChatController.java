package com.beyondfoo.greeting.adapter.port.in;

import com.beyondfoo.greeting.adapter.port.in.dto.ChatMessageDto;
import com.beyondfoo.greeting.adapter.port.in.dto.ChatRoomDto;
import com.beyondfoo.greeting.adapter.port.in.dto.UserDto;
import org.springframework.util.CollectionUtils;
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

//    @RequestMapping("/")
//    public @ResponseBody
//    List<UserResponseDto> getUsers() {
//        UserResponseDto response = new UserResponseDto();
//        return new ArrayList<>();
////        return response;
//    }

    @RequestMapping("/send")
    @PostMapping
    public boolean sendMessage(@RequestBody ChatMessageDto chatMessageDto) {
        // Assuming data sent in via input is valid

        // Check if the user is nt a member of the room
        String chatroom = chatMessageDto.getChatroom();
        ChatRoomDto chatroomDto = chatrooms.get(chatroom);
        List<UserDto> chatUsers = chatroomDto.getUsers();

        // TODO - Check if this can be keyed on the user id directly instead of the object to make it easier to search.
        UserDto user = new UserDto();
        user.setUuid(chatMessageDto.getSender());
        user.setName(chatMessageDto.getSender());

//        if(!chatUsers.contains(user)) {
//            throw new RuntimeException("User not a part of this chatroom.");
//        } else {
            List<ChatMessageDto> messages = chatroomDto.getChats();
            messages.add(chatMessageDto);
//        }
        displayChatRooms();
        return true;
    }


    @RequestMapping("/join")
    @PostMapping
    public boolean joinChatRoom(@RequestParam String userId, @RequestParam String chatroom) {
        // Assuming data sent in via input is valid

        // Handle the use case of chatroom not present when the user is trying to join one
        UserDto user = new UserDto();
        user.setUuid(userId);
        user.setName(userId);


        if(chatrooms.get(chatroom) == null) {
            ChatRoomDto chatroomDto = new ChatRoomDto();
            chatroomDto.setName(chatroom);
            chatroomDto.setUuid(chatroom);

            List<UserDto> users = new ArrayList<>();
            users.add(user);

            chatroomDto.setUsers(users);
            chatroomDto.setChats(new ArrayList<>());

            chatrooms.put(chatroomDto.getName(), chatroomDto);
        } else {
            ChatRoomDto existingChatroom = chatrooms.get(chatroom);
            List<UserDto> users = existingChatroom.getUsers();

            if(users == null) {
                users = new ArrayList<>();
            } else if(users.contains(user)) {
                displayChatRooms();
                return true;
            }
            users.add(user);
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