package com.ykb.memories_back.common.dto.Response;

public interface ResponseMessage {
    String SUCCESS = "Success.";

    String VALIDATION_FAIL = "Validation Fail.";
    String EXIST_USER = "Exist User.";
    String NO_EXIST_DIARY = "No Exist Diary";
    String NO_EXIST_COMMENT = "No Exist Comment";

    String NO_PERMISSION = "No Permission";

    String SIGN_IN_FAIL = "Sign in Fail.";

    String DATABASE_ERROR = "DataBase Error";
    String OPEN_AI_ERROR = "Open AI Error";
}
