package com.ykb.memories_back.common.dto.Response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access=AccessLevel.PRIVATE)
public class ResponseDto {
    // 변수를 String 형태가 아닌 enum형태로 변경하는게 가장 객체지향적인 방법임
    private String code;
    private String message;

    protected ResponseDto(){
        this.code = ResponseCode.SUCCESS;
        this.message = ResponseMessage.SUCCESS;
    }
    
    // ResponseEntity: ResponseDto를 인스턴스로 다룰 수 있게 해주는 클래스
    public static ResponseEntity<ResponseDto> success(HttpStatus status){
        ResponseDto body = new ResponseDto();
        return ResponseEntity.status(status).body(body);
    }

    public static ResponseEntity<ResponseDto> validationFail(){
        ResponseDto body = new ResponseDto(ResponseCode.VALIDATION_FAIL, ResponseMessage.VALIDATION_FAIL);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    public static ResponseEntity<ResponseDto> existUser(){
        ResponseDto body = new ResponseDto(ResponseCode.EXIST_USER, ResponseMessage.EXIST_USER);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    public static ResponseEntity<ResponseDto> noExistDiary(){
        ResponseDto body = new ResponseDto(ResponseCode.NO_EXIST_DIARY, ResponseMessage.NO_EXIST_DIARY);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(body);
    }

    public static ResponseEntity<ResponseDto> signInFail(){
        ResponseDto body = new ResponseDto(ResponseCode.SIGN_IN_FAIL, ResponseMessage.SIGN_IN_FAIL);
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(body);
    }

    public static ResponseEntity<ResponseDto> noPermission(){
        ResponseDto body = new ResponseDto(ResponseCode.NO_PERMISSION, ResponseMessage.NO_PERMISSION);
        return ResponseEntity.status(HttpStatus.FORBIDDEN).body(body);
    }

    public static ResponseEntity<ResponseDto> databaseError(){
        ResponseDto body = new ResponseDto(ResponseCode.DATABASE_ERROR, ResponseMessage.DATABASE_ERROR);
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }

}
