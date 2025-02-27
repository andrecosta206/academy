package com.ctw.workstation.service;

import com.ctw.workstation.config.CtwAcademyResource;
import com.ctw.workstation.dto.TeamDTO;
import com.ctw.workstation.entity.Team;
import com.ctw.workstation.repository.TeamRepository;
import io.quarkus.test.InjectMock;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.QuarkusTestProfile;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
@TestProfile(QuarkusTestProfile.class)
class TeamServiceTest {

    //injeta todas as dependencias pertencentes ao
    //   teamService sem ecessitar de criar mocks manualment
    @Inject
    TeamService teamService;

    @InjectMock
    TeamRepository teamRepository;

    @Test
    @DisplayName("Create team")
    void create_team() {
        TeamDTO teamDTO = new TeamDTO(null,"Wind Wizards", "Fly", "LISBON");
        //when
        TeamDTO createdTeam = teamService.createTeam(teamDTO);
        //then
        assertThat(createdTeam)
                .as("DTO from persisted team was returned with no null fileds of properties")
                .hasNoNullFieldsOrProperties()
                .usingRecursiveComparison()
                .ignoringFields("id")
                .as("DTO was returned with the data provided")
                .isEqualTo(teamDTO);
    }

    @Test
    @DisplayName("Create team impossible")
    void create_team_impossible() {
        Mockito.doThrow(new IllegalArgumentException("PODE NAO VELHO"))
                .when(teamRepository)
                .persist(Mockito.any(Team.class));

        TeamDTO teamDTO = new TeamDTO(null,"Wind Wizards", "Fly", "LISBON");
        //when
        TeamDTO createdTeam = teamService.createTeam(teamDTO);
        //then
        assertThatThrownBy(() -> teamService.createTeam(teamDTO))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("PODE NAO VELHO");
    }

    @Test
    void getTeamById() {
    }

    @Test
    void createTeam() {
    }
}