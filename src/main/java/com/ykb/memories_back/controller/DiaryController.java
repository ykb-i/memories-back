package com.ykb.memories_back.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ykb.memories_back.common.dto.Request.diary.PatchDiaryRequestDto;
import com.ykb.memories_back.common.dto.Request.diary.PostCommentRequestDto;
import com.ykb.memories_back.common.dto.Request.diary.PostDiaryRequestDto;
import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetCommentResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetDiaryResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetEmpathyResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetMyDiaryResponseDto;
import com.ykb.memories_back.service.DiaryService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/diary")
@RequiredArgsConstructor
public class DiaryController {
  
  private final DiaryService diaryService;

  // 아무것도 없는것 or / 로 입력받겠다.
  // AuthenticationPrincipal : filter에서 context에 저장한 첫번째 매개변수 값을 받아올 수 있음(userId) 받아오기
  @PostMapping({"","/"})
  public ResponseEntity<ResponseDto> postDiary(
    @RequestBody @Valid PostDiaryRequestDto requestBody,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = diaryService.postDiary(requestBody, userId);
    return response;
  }

  @GetMapping("/my")
  public ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<? super GetMyDiaryResponseDto> response = diaryService.getMyDiary(userId);
    return response;
  }

  @GetMapping("/{diaryNumber}")
  public ResponseEntity<? super GetDiaryResponseDto> getDiary(
    @PathVariable("diaryNumber") Integer diaryNumber
  ){
    ResponseEntity<? super GetDiaryResponseDto> response = diaryService.getDiary(diaryNumber);
    return response;
  }

  @PatchMapping("/{diaryNumber}")
  public ResponseEntity<ResponseDto> patchDiary(
    @RequestBody @Valid PatchDiaryRequestDto requestBody,
    @PathVariable("diaryNumber") Integer diaryNumber,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = diaryService.patchDiary(requestBody, diaryNumber, userId);
    return response;
  }

  @DeleteMapping("/{diaryNumber}")
  public ResponseEntity<ResponseDto> deleteDiary(
    @PathVariable("diaryNumber") Integer diaryNumber,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = diaryService.deleteDiary(diaryNumber, userId);
    return response;
  }

  @GetMapping("/{diaryNumber}/empathy")
  public ResponseEntity<? super GetEmpathyResponseDto> getEmpathy(
    @PathVariable("diaryNumber") Integer diaryNumber
  ) {
    ResponseEntity<? super GetEmpathyResponseDto> response = diaryService.getEmpathy(diaryNumber);
    return response;
  }


  @PutMapping("/{diaryNumber}/empathy")
  public ResponseEntity<ResponseDto> putEmpathy(
    @PathVariable("diaryNumber") Integer diaryNumber,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = diaryService.putEmpathy(diaryNumber, userId);
    return response;
  }

  @GetMapping("/{diaryNumber}/comment")
  public ResponseEntity<? super GetCommentResponseDto> getComment(
    @PathVariable("diaryNumber") Integer diaryNumber
  ){
    ResponseEntity<? super GetCommentResponseDto> response = diaryService.getComment(diaryNumber);
    return response;
  }

  @PostMapping("/{diaryNumber}/comment")
  public ResponseEntity<ResponseDto> postComment(
    @RequestBody @Valid PostCommentRequestDto requestBody,
    @PathVariable("diaryNumber") @Valid Integer diaryNumber,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = diaryService.postComment(requestBody, diaryNumber, userId);
    return response;
  }

  @DeleteMapping("/{diaryNumber}/comment/{commentNumber}")
  public ResponseEntity<ResponseDto> deleteComment(
    @PathVariable("diaryNumber") @Valid Integer diaryNumber,
    @PathVariable("commentNumber") @Valid Integer commentNumber,
    @AuthenticationPrincipal String userId
  ){
    ResponseEntity<ResponseDto> response = diaryService.deleteComment(commentNumber, diaryNumber, userId);
    return response;
  } 
}