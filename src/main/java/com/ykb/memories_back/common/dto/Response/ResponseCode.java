package com.ykb.memories_back.common.dto.Response;

public interface ResponseCode {
    String SUCCESS = "SU";

    String VALIDATION_FAIL = "VF";
    String EXIST_USER = "EU";
    String NO_EXIST_DIARY = "ND";
    String NO_EXIST_COMMENT = "NC";

    String SIGN_IN_FAIL = "SF";

    String NO_PERMISSION = "NP";

    String DATABASE_ERROR = "DBE";
    String OPEN_AI_ERROR = "OAE";
}
