package com.ctw.workstation.resource;

import com.ctw.workstation.dto.RackDTO;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
class RackResourceTest {
//
//    //make tests for racks
//    @Test
//    void get_all_racks() {
//        List<RackDTO> rackDTOs = given().header("Accept", "application/json")
//                .when().get("/racks")
//                .then()
//                .assertThat().statusCode(200).extract().as(new TypeRef<List<RackDTO>>() {});
//
//        assertThat(rackDTOs).allSatisfy( rackDTO -> {
//            assertThat(rackDTO).
//                    as("").
//                    hasNoNullFieldsOrProperties().
//                    usingRecursiveComparison().
//                    ignoringFields("id").
//                    as("").
//                    isEqualTo(rackDTO);
//                });
//    }
//
//    @Test
//    void addRack() {
//    }
}