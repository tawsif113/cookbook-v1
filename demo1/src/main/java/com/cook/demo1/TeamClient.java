package com.cook.demo1;

import com.cook.demo1.records.TeamResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "team", url = "http://localhost:8080/api/v1")
public interface TeamClient {

    @RequestMapping(value = "/teams",method = RequestMethod.GET)
    List<TeamResponseBody> getAllTeams();

    @RequestMapping(value = "/teams/{id}",method = RequestMethod.GET)
    TeamResponseBody getTeamById(@PathVariable String id);

}
