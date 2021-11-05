package com.example.todo.database


data class TodoDataBase (
            var index: Int=0,
            var todoList: MutableList<Todo> = mutableListOf()// = 공백 필수
            //데이터 베이스 리스트
        ){
        fun init(){//초기화 메소드
            this.index=0
            this.todoList= mutableListOf()
            println("init 데이타베이이스 초기화")
        }
}
