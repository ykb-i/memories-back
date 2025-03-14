package com.ykb.memories_back.handler;

import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ykb.memories_back.common.dto.Response.ResponseDto;

// RestController에서 발생하는 에러를 잡아서 해당 에러에 대한 결과를반환해준다.
@RestControllerAdvice
public class CustomExceptionHandler {
    
    // description: MethodArgumentNotValidException - 유효성 검사 실패 //
    // description: HttpMessageNotReadableException - RequestBody가 필요한데 존재하지 않을 때 //
    @ExceptionHandler({
        MethodArgumentNotValidException.class,
        HttpMessageNotReadableException.class
    })
    public ResponseEntity<ResponseDto> validExceptionHandler(Exception exception){
        exception.printStackTrace();
        return ResponseDto.validationFail();
    }
}

