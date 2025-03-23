package com.ykb.memories_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ykb.memories_back.common.dto.Request.user.PatchUserRequestDto;
import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.dto.Response.user.GetSignInUserResponseDto;
import com.ykb.memories_back.service.UserService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
  
  private final UserService userService;

  @GetMapping("/sign-in")
  public ResponseEntity<? super GetSignInUserResponseDto> getSignInUser(
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<? super GetSignInUserResponseDto> response = userService.getSignInUser(userId);

    return response;
  }

  @PatchMapping({"", "/"})
  public ResponseEntity<ResponseDto> patchUser(
    @RequestBody @Valid PatchUserRequestDto requestBody,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = userService.patchUser(requestBody, userId);

    return response;
  }
}
