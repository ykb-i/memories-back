package com.ykb.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.ykb.memories_back.common.dto.Request.auth.IdCheckRequestDto;
import com.ykb.memories_back.common.dto.Request.auth.SignInRequestDto;
import com.ykb.memories_back.common.dto.Request.auth.SignUpRequestDto;
import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.dto.Response.auth.SignInResponseDto;

public interface AuthService {
    ResponseEntity<ResponseDto> idCheck(IdCheckRequestDto dto);
    ResponseEntity<ResponseDto> signUp(SignUpRequestDto dto);
    ResponseEntity<? super SignInResponseDto> signIn(SignInRequestDto dto);
    //선언부만 보고 무엇을 호출하려고 하는지 판단하기 위해
    // extends를 사용하게되면 ResponseDto를 상속받는 모든 클래스 호출이 가능하기 때문에 제한하는 의미가 떨어짐
}
