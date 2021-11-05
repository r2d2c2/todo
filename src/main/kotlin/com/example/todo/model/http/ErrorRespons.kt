package com.example.todo.model.http

import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
//에러 발생식 출력할 데이터 값
data class ErrorRespons(
    @JsonProperty("result_code")
    var resultCode:String?=null,
    @JsonProperty("http_status")
    var httpStatus:String?=null,
    @JsonProperty("http_method")
    var httpMethod:String?=null,

    var message:String?=null,

    var path:String?=null,

    var timestamp:LocalDateTime?=null,

    var error: MutableList<Error>?=null
)
data class Error(
    var field:String?=null,
    var message:String?=null,
    var value:Any?=null
)