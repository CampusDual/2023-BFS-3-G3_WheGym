package com.campusdual.cd2023bfs3g3.ws.core.rest;

import com.campusdual.cd2023bfs3g3.api.core.service.IGymService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/gyms")
public class GymRestController extends ORestController<IGymService> {

    @Autowired
    private IGymService gymService;
    @Override
    public IGymService getService() {
        return this.gymService;
    }
}
