package com.ykb.memories_back.service.implement;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ykb.memories_back.common.dto.Request.user.PatchUserRequestDto;
import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.dto.Response.user.GetSignInUserResponseDto;
import com.ykb.memories_back.common.entity.UserEntity;
import com.ykb.memories_back.repository.UserRepository;
import com.ykb.memories_back.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImplement implements UserService {

  private final UserRepository userRepository;

  @Override
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(String userId) {

    UserEntity userEntity = null;

    try{

      userEntity = userRepository.findByUserId(userId);

    } catch(Exception exception){
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return GetSignInUserResponseDto.success(userEntity);
  }

  @Override
  public ResponseEntity<ResponseDto> patchUser(PatchUserRequestDto dto, String userId) {
    

    try{

      UserEntity userEntity = userRepository.findByUserId(userId);
      userEntity.patch(dto);
      userRepository.save(userEntity);

    } catch(Exception exception) {
      exception.printStackTrace();
      return ResponseDto.databaseError();
    }

    return ResponseDto.success(HttpStatus.OK);
  }
  
}
