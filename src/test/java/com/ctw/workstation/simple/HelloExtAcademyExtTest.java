package com.ctw.workstation.simple;

import com.ctw.workstation.config.CtwAcademyResource;
import com.ctw.workstation.config.CtwAcademyTestProfile;
import com.ctw.workstation.config.WiremockResource;
import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.junit.WireMockRule;
import io.quarkus.logging.Log;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.MediaType;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static org.assertj.core.api.Assertions.*;


@QuarkusTest
//@TestProfile(CtwAcademyTestProfile.class)
@QuarkusTestResource(WiremockResource.class)
class HelloExtAcademyExtTest {

    /*@Inject
    HelloExtAcademy helloExtAcademy;

    @Test
    @DisplayName("Saying hello to external api")
    void saying_hello_to_external_api () {
        //given
        String name ="World";
        Log.info("Wiremock: "+ WiremockResource.wireMockServer.baseUrl());
        WiremockResource.wireMockServer.stubFor(get("/external/hello")
                .willReturn(aResponse().
                        withHeader("Content-Type", MediaType.APPLICATION_JSON)
                        .withBody("""
                                {
                                    "message":"Hello World"
                                }
                                """)));
        //when
        String result = helloExtAcademy.sayHello(name);
        //then
        assertThat(result)
                .isEqualTo("Hello OLA");
    }*/

}