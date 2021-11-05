package com.example.todo.repository

import com.example.todo.database.Todo
import com.example.todo.database.TodoDataBase
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class TodoRepositorImpl (
    val todoDataBase:TodoDataBase
):TodoRepository{//내가 만든 인터 페이스 가져오기

   /* @Autowired
    lateinit var todoDataBase: TodoDataBase //내가 만든 데이터 베이스 불러오기*/

    override fun save(todo: Todo): Todo? {
        return todo.index?.let { index->
            //update
            findOne(index)?.apply {
                //찾아서 있으면 갱신
                this.title=todo.title
                this.description=todo.description
                this.schedule=todo.schedule
                this.updatedAt= LocalDateTime.now()
            }
        }?:kotlin.run {//없으면
            //추가
             todo.apply {
                this.index=++todoDataBase.index //데이터 베이스에 마지막 인덱스 추가 꼭 앞에 ++해줘야 1+되고 실행한다
                this.createaAt= LocalDateTime.now()
                this.updatedAt= LocalDateTime.now()
            }.run {
                todoDataBase.todoList.add(todo)
                this
                //Todo를 리턴
            }
        }
    }

    override fun saveAll(todoList: MutableList<Todo>): Boolean {
        return try {//saveAll이 잘 작동하면 true반환
            todoList.forEach {
                save(it)
            }
            true
        }catch (e: Exception){
            false
        }


    }



    override fun delete(index: Int): Boolean {
        val todo=findOne(index)

        return todo?.let {
            todoDataBase.todoList.remove(it)
            true
        }?:kotlin.run {
            false
        }

    }

    override fun findOne(index: Int): Todo? {
        return todoDataBase.todoList.first { it.index == index } //찾기

    }

    override fun findAll(): MutableList<Todo> {
        return todoDataBase.todoList
    }
}