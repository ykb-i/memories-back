package com.ykb.memories_back.common.dto.Response.diary;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.ykb.memories_back.common.dto.Response.ResponseDto;
import com.ykb.memories_back.common.entity.DiaryEntity;
import com.ykb.memories_back.common.vo.DiaryVO;

import lombok.Getter;

@Getter
public class GetMyDiaryResponseDto extends ResponseDto{

    private List<DiaryVO> diaries;

    private GetMyDiaryResponseDto(List<DiaryEntity> list) {
        this.diaries = DiaryVO.getList(list);
    }

    public static ResponseEntity<GetMyDiaryResponseDto> success(List<DiaryEntity> list){
        GetMyDiaryResponseDto body = new GetMyDiaryResponseDto(list);
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
}
