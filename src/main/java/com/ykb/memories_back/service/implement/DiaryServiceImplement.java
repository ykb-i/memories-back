package com.ykb.memories_back.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ykb.memories_back.common.dto.Request.diary.PatchDiaryRequestDto;
import com.ykb.memories_back.common.dto.Request.diary.PostCommentRequestDto;
import com.ykb.memories_back.common.dto.Request.diary.PostDiaryRequestDto;
import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetCommentResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetDiaryResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetEmpathyResponseDto;
import com.ykb.memories_back.common.dto.Response.diary.GetMyDiaryResponseDto;
import com.ykb.memories_back.common.entity.CommentEntity;
import com.ykb.memories_back.common.entity.DiaryEntity;
import com.ykb.memories_back.common.entity.EmpathyEntity;
import com.ykb.memories_back.repository.CommentRepository;
import com.ykb.memories_back.repository.DiaryRepository;
import com.ykb.memories_back.repository.EmpathyRepository;
import com.ykb.memories_back.service.DiaryService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DiaryServiceImplement implements DiaryService{

    private final DiaryRepository diaryRepository;
    private final EmpathyRepository empathyRepository;
    private final CommentRepository commentRepository;

    @Override
    public ResponseEntity<ResponseDto> postDiary(PostDiaryRequestDto dto, String userId) {

      try{
        
        DiaryEntity diaryEntity = new DiaryEntity(dto, userId);
        diaryRepository.save(diaryEntity);

      }catch(Exception exception){
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return ResponseDto.success(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<? super GetMyDiaryResponseDto> getMyDiary(String userId) {

      List<DiaryEntity> diaryEntities = new ArrayList<>();

      try{
        
        diaryEntities = diaryRepository.findByOrderByDiaryNumberDesc();

      }catch(Exception exception){
        exception.printStackTrace();
        ResponseDto.databaseError();
      }

      return GetMyDiaryResponseDto.success(diaryEntities);
    }

    @Override
    public ResponseEntity<? super GetDiaryResponseDto> getDiary(Integer diaryNumber) {
      
      DiaryEntity diaryEntity = null;

      try{

        diaryEntity = diaryRepository.findByDiaryNumber(diaryNumber);
        if(diaryEntity == null) return ResponseDto.noExistDiary();

      }catch(Exception exception){
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return GetDiaryResponseDto.success(diaryEntity);
    }

    @Override
    public ResponseEntity<ResponseDto> patchDiary(PatchDiaryRequestDto dto, Integer diaryNumber, String userId) {
      
      try{

        DiaryEntity diaryEntity = diaryRepository.findByDiaryNumber(diaryNumber);
        if(diaryEntity == null) return ResponseDto.noExistDiary();
        
        String writerId = diaryEntity.getUserId();
        boolean isWriter = writerId.equals(userId);
        
        if(!isWriter) return ResponseDto.noPermission();

        diaryEntity.patch(dto);
        diaryRepository.save(diaryEntity);

      }catch(Exception exception){
        exception.printStackTrace();
        ResponseDto.databaseError();
      }

      return ResponseDto.success(HttpStatus.OK);

    }

    @Override
    public ResponseEntity<ResponseDto> deleteDiary(Integer diaryNumber, String userId) {
      
      try{

        DiaryEntity diaryEntity = diaryRepository.findByDiaryNumber(diaryNumber);
        if(diaryEntity == null) return ResponseDto.noExistDiary();

        String writerId = diaryEntity.getUserId();
        boolean isWriter = writerId.equals(userId);


        if(!isWriter) return ResponseDto.noPermission();

        empathyRepository.deleteByDiaryNumber(diaryNumber);
        commentRepository.deleteByDiaryNumber(diaryNumber);
        diaryRepository.delete(diaryEntity);

      }catch(Exception exception){
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return ResponseDto.success(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ResponseDto> putEmpathy(Integer diaryNumber, String userId) {
      
      try {

        boolean existDiary = diaryRepository.existsByDiaryNumber(diaryNumber);
        if(!existDiary) return ResponseDto.noExistDiary();

        EmpathyEntity empathyEntity = empathyRepository.findByUserIdAndDiaryNumber(userId, diaryNumber);

        if(empathyEntity == null) {
          empathyEntity = new EmpathyEntity(userId, diaryNumber);
          empathyRepository.save(empathyEntity);
        } else {
          empathyRepository.delete(empathyEntity);
        }

      } catch(Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return ResponseDto.success(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<? super GetEmpathyResponseDto> getEmpathy(Integer diaryNumber) {

      List<EmpathyEntity> empathyEntities = new ArrayList<>();

      try {

        empathyEntities = empathyRepository.findByDiaryNumber(diaryNumber);

      } catch(Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return GetEmpathyResponseDto.success(empathyEntities);
    }

    @Override
    public ResponseEntity<ResponseDto> postComment(PostCommentRequestDto dto, Integer diaryNumber, String userId) {
      
      try{

        boolean existDiary = diaryRepository.existsByDiaryNumber(diaryNumber);
        if(!existDiary) return ResponseDto.noExistDiary();

        CommentEntity commentEntity = new CommentEntity(dto, diaryNumber, userId);

        commentRepository.save(commentEntity);

      } catch(Exception exception){
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return ResponseDto.success(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<? super GetCommentResponseDto> getComment(Integer diaryNumber) {

      List<CommentEntity> commentEntities = new ArrayList<>();

      try{
        
        commentEntities = commentRepository.findByDiaryNumber(diaryNumber);

      } catch(Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return GetCommentResponseDto.success(commentEntities);
    }

    @Override
    public ResponseEntity<ResponseDto> deleteComment(Integer commentNumber, Integer diaryNumber, String userId) {

      try{

        CommentEntity commentEntity = commentRepository.findByDiaryNumberAndCommentNumber(diaryNumber, commentNumber);
        if(commentEntity == null) return ResponseDto.noExistComment();

        String writerId = commentEntity.getUserId();
        boolean isWrite = writerId.equals(userId);

        if(!isWrite) return ResponseDto.noPermission();

        commentRepository.delete(commentEntity);

      } catch(Exception exception) {
        exception.printStackTrace();
        return ResponseDto.databaseError();
      }

      return ResponseDto.success(HttpStatus.OK);
    }
    
}
