package com.example.todo.config

import com.example.todo.database.TodoDataBase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration//자바빈 설정
class AppConfig {

    @Bean(initMethod = "init") //빈 등록 (실행 메소드)
    fun todoDataBase(): TodoDataBase {
        return TodoDataBase()
    }
}