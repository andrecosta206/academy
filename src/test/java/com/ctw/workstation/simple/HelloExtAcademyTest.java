package com.ctw.workstation.simple;

import org.apache.commons.lang3.NotImplementedException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class HelloExtAcademyTest {

    /*@Mock
    ExternalMessageService externalMessageService;

    @InjectMocks
    private HelloExtAcademy helloExtAcademy;

    @Test
    void lista() {
        List<String> minhaLista = new ArrayList<>();
        List<String> minhaListaSpy = Mockito.spy(minhaLista);


        Mockito.when(minhaListaSpy.get(0)).thenReturn("Hello");
        Mockito.doReturn("Hello").when(minhaListaSpy).get(0);

        assertThat(minhaListaSpy.get(0)).isEqualTo("Hello");
    }

    @Test
    @DisplayName("Hello from outer space with mock")
    void hello_from_outer_space_mock() {
        String name = "André";

        Mockito.when(externalMessageService.sayHelloFromOuterSpace(name)).
                thenThrow(new NotImplementedException("This feature is not available. Please contact support!"));

        String result = helloExtAcademy.sayHello(null);

        assertThat(result).
                isEqualTo("Hello from outer space André");
    }


    @Test
    @DisplayName("Hello from outer space with spy")
    void hello_from_outer_space_spy() {
        //given
        HelloExtAcademy hello = new HelloExtAcademy();
        String name = "André";

        //spy config
        ExternalMessageService externalMessageService = new ExternalMessageServiceImpl();
        ExternalMessageService externalMessageServiceSpy = Mockito.spy(externalMessageService);
        //hello.externalMessageService = externalMessageServiceSpy;

        Mockito.doReturn("Hello World")
               .when(externalMessageServiceSpy).sayHelloFromOuterSpace();

        //when
        String result = hello.sayHello(name);
        //then
        assertThat(result).
                isEqualTo("Hello World");
    }*/

    //Testes, restassured, assertj, mockito, junit
    //argument captor\\
}