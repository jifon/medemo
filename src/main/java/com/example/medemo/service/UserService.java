package com.example.medemo.service;

import com.example.medemo.dto.UserDto;
import com.example.medemo.model.User;
import com.example.medemo.model.constants.Status;
import com.example.medemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

//    @Autowired
//    UserRepository userRepository;
//
//    public List<User> getAllPosts(){
//        return userRepository.findAllByStatus(Status.ACTIVE);
//    }
//
//    public User createUser(UserDto userDto) throws Exception{
//        if(userRepository.existsByEmail(userDto.getEmail())){
//            throw new Exception("Такой пользователь уже существует!");
//        }
//        else{
//            User user = new User(userDto.getId(), userDto.getPhoneNumber(), userDto.getPassword(),
//                    userDto.getEmail(), userDto.getRole(), userDto.getStatus(), userDto.isOtpActive(),
//                    userDto.getPswResetCode(), userDto.getFirstName(), userDto.getLastName(),
//                    userDto.getMiddle_name());
//            return user;
//        }
//    }
//
//    public User updateUser(UserDto userDto) throws Exception{
//        User user = userRepository.findById(userDto.getId()).orElseThrow(
//                ()-> new Exception("Пользователь с таким id не существует! ID : "+userDto.getId())
//        );
//        user.setId(userDto.getId());
//        user.setPhoneNumber(userDto.getPhoneNumber());
//        user.setPassword(userDto.getPassword());
//        user.setEmail(userDto.getEmail());
//        user.setRole(userDto.getRole());
//        user.setStatus(userDto.getStatus());
//        user.setOtpActive(userDto.isOtpActive());
//        user.setPswResetCode(userDto.getPswResetCode());
//        user.setFirstName(userDto.getFirstName());
//        user.setLastName(userDto.getLastName());
//        user.setMiddle_name(userDto.getMiddle_name());
//
//        return user;
//    }
//
//    public UserDto deleteUser(long id){
//        UserDto userDto = new UserDto();
//
//        return userRepository.save(us);
//    }
//
//    public User getUserDyId(long id){
//        return userRepository.save(us);
//    }
}
