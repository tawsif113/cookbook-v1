package com.cook.demo1;

import com.cook.demo1.records.PlayerResponseBody;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "player", url = "http://localhost:8080/api/v1")
public interface PlayerClient {

    @RequestMapping(value = "/players",method = RequestMethod.GET)
    List<PlayerResponseBody> getAllPlayers();

    @RequestMapping(value = "/players/{id}",method = RequestMethod.GET)
    PlayerResponseBody getPlayerById(@PathVariable Long id);


}
