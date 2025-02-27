package com.ctw.workstation.resource;

import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.repository.TeamRepository;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestHTTPEndpoint(TeamResource.class)
class TeamResourceTest {
    private static Team team;

    private static TeamDTO buildTeamDTO() {
        return new TeamDTO(null,"Stars","Popo Car","LISBON");
    }

    @Test
    @DisplayName("Fetching all teams")
    @Order(2)
    void fetching_all_teams() {
        List<TeamDTO> teamDTOs = given().
                header("Content-Type","application/json")
                .when().get("")
                .then().
                statusCode(200).
                extract().as(new TypeRef<List<TeamDTO>>() {});

        assertThat(teamDTOs).allSatisfy(teamDTO -> {
            assertThat(teamDTO).as("Teams fetched validation").hasNoNullFieldsOrProperties();
        });
    }

    @Test
    @DisplayName("Creating team")
    @Order(1)
    void creating_team() {
        TeamDTO teamDTO = buildTeamDTO();

        team = given().
                header("Content-Type","application/json").
                body(teamDTO).
                when().
                post("").
                then().
                statusCode(201).
                extract().as(Team.class);

        assertAll(
                () -> assertNotNull(team.getId()),
                () -> assertEquals("Stars",team.getName()),
                () -> assertEquals("Popo Car",team.getProduct())
        );
    }

    @Test
    @DisplayName("Fetching team by Id")
    @Order(3)
    void fetching_team_by_id() {
        given().
                header("Content-Type","application/json").
                when().
                get("/{id}", team.getId())
                .then().statusCode(200);
    }
}