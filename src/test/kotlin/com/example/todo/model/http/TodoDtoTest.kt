package com.example.todo.model.http

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.TestComponent
import javax.validation.Validation

@TestComponent
class TodoDtoTest {
    val validator=Validation.buildDefaultValidatorFactory().validator

    @Test
    fun todoDtoTest(){

    }
}