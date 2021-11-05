package com.example.todo.database

import java.time.LocalDateTime
//데이터 베이스
data class Todo(
    var index:Int?=null,   //일정 인덱스
    var title:String?=null, //일정 타이틀
    var description:String?=null,//일정 설명
    var schedule: LocalDateTime?=null,//일정시간
    var createaAt:LocalDateTime?=null,//생성 시간
    var updatedAt:LocalDateTime?=null//업데이트 시간


)
