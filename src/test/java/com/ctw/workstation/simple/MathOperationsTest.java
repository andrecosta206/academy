package com.ctw.workstation.simple;

import io.quarkus.logging.Log;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MathOperationsTest {
    /*private static MathOperations mathOperations;

    @BeforeAll
    static void setup(){
        Log.info("Setting up tests");
        mathOperations = new MathOperations();
        //initialization of complex variable or connections
    }

    @BeforeEach
    void setUpEch(){
        Log.info("Setting up before each tests");
    }

    @AfterEach
    void tearDownEch(){
        Log.info("Tearing down after each tests");
    }

    @AfterAll
    static void tearDown(){
        Log.info("Ending test");
    }

    @ParameterizedTest
    @Order(1)
    @Test
    @DisplayName("""
            checking add number with positive, negative and zero
            """)
    void add_number(int a, int b) {
        //given
        //when
        //then
        Assertions.assertAll(
                () ->assertEquals(5, mathOperations.add(3,2)),
                () ->assertEquals(10, mathOperations.add(3,7)),
                () ->assertEquals(8, mathOperations.add(3,5))
        );
    }
    @Order(2)
    @Test
    void divide_by_zero() {
        //given
        int dividend = 1;
        int divisor = 0;
        //when
        Assertions.assertThrows(ArithmeticException.class,
                () -> mathOperations.divide(dividend,divisor));
    }*/
}