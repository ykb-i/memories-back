package com.ykb.memories_back.common.entity;

import com.ykb.memories_back.common.dto.Request.auth.SignUpRequestDto;
import com.ykb.memories_back.common.dto.Request.diary.PatchDiaryRequestDto;
import com.ykb.memories_back.common.dto.Request.user.PatchUserRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// user 테이블에 매핑시키는 엔터티 클래스
@Entity(name="user")
@Table(name="user")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    private String userId;
    private String userPassword;
    private String joinType;
    private String snsId;
    private String name;
    private String address;
    private String detailAddress;
    private String profileImage;
    private String gender;
    private Integer age;

    public UserEntity(SignUpRequestDto dto){
        this.userId = dto.getUserId();
        this.userPassword = dto.getUserPassword();
        this.joinType = dto.getJoinType();
        this.name = dto.getName();
        this.address = dto.getAddress();
        this.detailAddress = dto.getDetailAddress();
        this.snsId = dto.getSnsId();
    }

    public void patch(PatchUserRequestDto dto){
        this.name = dto.getName();
        this.profileImage = dto.getProfileImage();
        this.address = dto.getAddress();
        this.detailAddress = dto.getDetailAddress();
        this.gender = dto.getGender();
        this.age = dto.getAge();
    }
}
