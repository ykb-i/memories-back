package com.ykb.memories_back.service;

import org.springframework.http.ResponseEntity;

import com.ykb.memories_back.common.dto.Request.diary.PatchDiaryRequestDto;
import com.ykb.memories_back.common.dto.Request.diary.PostCommentRequestDto;
import com.ykb.memories_back.common.dto.Request.diary.PostDiaryRequestDto;
import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetCommentResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetDiaryResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetEmpathyResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetMyDiaryResponseDto;

public interface DiaryService {
    ResponseEntity<ResponseDto> postDiary(PostDiaryRequestDto dto, String userId);
    ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(String userId);
    ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryNumber);
    ResponseEntity<ResponseDto> patchDiary(PatchDiaryRequestDto dto, Integer diaryNumber, String userId);
    ResponseEntity<ResponseDto> deleteDiary(Integer diaryNumber, String userId);
    ResponseEntity<ResponseDto> putEmpathy(Integer diaryNumber, String userId);
    ResponseEntity<? super GetEmpathyResponseDto> getEmpathy(Integer diaryNumber);
    ResponseEntity<? super GetCommentResponseDto> getComment(Integer diaryNumber);
    ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, Integer diaryNumber, String userId);
    ResponseEntity<ResponseDto> deleteComment(Integer commentNumber, Integer diaryNumber, String userId);
}
