package com.ctw.workstation.simple;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SayHelloAcademyTest {
/*
    public static Stream<Arguments> say_hello_with_valid_name(){
        return Stream.of(
                Arguments.of("Hello Maria","Maria"),
                Arguments.of("Hello José","José"),
                Arguments.of("Hello José da Quinta da Ti.Maria","José da Quinta da Ti.Maria"),
                Arguments.of("Hello",null),
                Arguments.of("Hello ", "")
        );
    }

    @ParameterizedTest
//    @NullAndEmptySource
//    @ValueSource(strings = {"Toze","Joaquim","Ze das quintas"})
    @MethodSource
    void say_hello_with_valid_name(String expected, String name) {
        //given
        SayHelloAcademy sayHelloAcademy = new SayHelloAcademy();

        //when
        String result = sayHelloAcademy.sayHello(name);

        //then
        assertEquals(expected, result);
    }
    @Test
    void say_hello_with_empty_name() {
        //Given
        String name = "";
        SayHelloAcademy sayHelloAcademy = new SayHelloAcademy();

        //when
        String result = sayHelloAcademy.sayHello(name);

        //then
        assertEquals("Hello ", result, "Matching result is not what was expected");
    }

    @Test
    void say_hello_with_invalid_name() {
        //Given
        SayHelloAcademy sayHelloAcademy = new SayHelloAcademy();

        //when
        String result = sayHelloAcademy.sayHello(null);

        //then
        assertEquals("Hello", result, "Matching result is not what was expected");
    }*/
}