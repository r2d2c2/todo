package com.example.todo.repository

import com.example.todo.database.Todo

interface TodoRepository {
    fun save(todo:Todo): Todo
    fun saveAll(todoList: MutableList<Todo>): Boolean  //결과 리턴
    
    fun update(todo: Todo): Todo
    fun delete(index: Int): Boolean
    
    fun findOne(index: Int): Todo //찾기
    fun findAll(): MutableList<Todo>//전체 찾기
}