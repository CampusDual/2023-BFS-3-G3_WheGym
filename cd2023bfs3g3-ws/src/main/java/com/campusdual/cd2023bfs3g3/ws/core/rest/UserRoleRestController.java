package com.campusdual.cd2023bfs3g3.ws.core.rest;

import com.campusdual.cd2023bfs3g3.api.core.service.IUserRoleService;
import com.ontimize.jee.server.rest.ORestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/userRole")
public class UserRoleRestController extends ORestController<IUserRoleService> {

    @Autowired
    private IUserRoleService userRoleService;
    @Override
    public IUserRoleService getService() {
        return this.userRoleService;
    }

}
