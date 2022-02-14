package com.beyondfoo.greeting.adapter.port.in;

import com.beyondfoo.greeting.adapter.port.in.dto.UserDto;
import com.beyondfoo.greeting.adapter.port.out.UserResponseDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {

    static Map<String, String> users = new HashMap<>();

//    @RequestMapping("/")
//    public @ResponseBody
//    List<UserResponseDto> getUsers() {
//        UserResponseDto response = new UserResponseDto();
//        return new ArrayList<>();
////        return response;
//    }

    @RequestMapping("/user")
    @PostMapping
    public boolean getUsers(@RequestBody UserDto userDto) {
        if(userDto != null && userDto.getUuid() != null) {
            users.put(userDto.getUuid(), userDto.getName());
            return true;
        }
        return false;
    }

}