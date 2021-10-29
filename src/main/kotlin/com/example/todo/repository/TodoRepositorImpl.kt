package com.example.todo.repository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TodoRepositorImpl : TodoRepository{//내가 만든 인터 페이스 가져오기

    @Autowired
    lateinit var todoDataBase: TodoDataBase //내가 만든 데이터 베이스 불러오기

    override fun save(todo: Todo): Todo {
        var index=todoDataBase.index++ //데이터 베이스에 마지막 인덱스 추가
        todo.index=index
        todoDataBase.todoList.add(todo)
        return todoDataBase.todoList as Todo  //강의내용과 다르게 자바방식으로 해서 문제시 강의 20분으로
    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        TODO("Not yet implemented")
    }

    override fun update(todo: Todo): Todo {
        TODO("Not yet implemented")
    }

    override fun delete(index: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun findOne(index: Int): Todo {
        TODO("Not yet implemented")
    }

    override fun findAll(): MutableList<Todo> {
        TODO("Not yet implemented")
    }
}