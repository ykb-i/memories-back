package com.ykb.memories_back.common.dto.Response.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetSignInUserResponseDto extends ResponseDto {
  private String userId;
  private String name;
  private String profileImage;
  private String address;
  private String detailAddress;
  private String gender;
  private Integer age;

  private GetSignInUserResponseDto(UserEntity userEntity) {
    this.userId = userEntity.getUserId();
    this.name = userEntity.getName();
    this.profileImage = userEntity.getProfileImage();
    this.address = userEntity.getAddress();
    this.detailAddress = userEntity.getDetailAddress();
    this.gender = userEntity.getGender();
    this.age = userEntity.getAge();
  }

  public static ResponseEntity<GetSignInUserResponseDto> success(UserEntity userEntity){
    GetSignInUserResponseDto body = new GetSignInUserResponseDto(userEntity);
    return ResponseEntity.status(HttpStatus.OK).body(body);
  }
}
