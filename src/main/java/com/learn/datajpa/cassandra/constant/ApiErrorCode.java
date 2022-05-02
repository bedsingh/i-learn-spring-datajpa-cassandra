package com.learn.datajpa.cassandra.constant;

/****************************************************************************************************
 * Date: 5/1/22 10:07 PM | Author: Singh, Ved |
 * To change this template user Preferences | Editor | File and Code Templates | Includes tab
 *
 *****************************************************************************************************/

public enum ApiErrorCode {

    BAD_REQUEST(10001),
    SERVER_ERROR(10002),
    DATABASE_ERROR(10003);

    private final Integer apiErrorCode;

    ApiErrorCode(Integer apiError) {
        this.apiErrorCode = apiError;
    }

    public Integer getApiErrorCode() {
        return apiErrorCode;
    }
}
