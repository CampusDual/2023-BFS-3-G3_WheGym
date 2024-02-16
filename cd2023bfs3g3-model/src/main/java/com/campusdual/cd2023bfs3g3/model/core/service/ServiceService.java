package com.campusdual.cd2023bfs3g3.model.core.service;

import com.campusdual.cd2023bfs3g3.api.core.service.IServiceService;
import com.campusdual.cd2023bfs3g3.model.core.dao.ServiceDao;
import com.campusdual.cd2023bfs3g3.model.core.dao.UserDao;
import com.ontimize.jee.common.dto.EntityResult;
import com.ontimize.jee.common.exceptions.OntimizeJEERuntimeException;
import com.ontimize.jee.server.dao.DefaultOntimizeDaoHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Lazy
@Service("ServiceService")
public class ServiceService implements IServiceService {

    @Autowired
    private ServiceDao serviceDao;

    @Autowired
    private DefaultOntimizeDaoHelper daoHelper;

    @Override
    public EntityResult serviceQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
        return this.daoHelper.query(serviceDao, keyMap, attrList);    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EntityResult serviceInsert(Map<String, Object> attributes) throws OntimizeJEERuntimeException {
        return this.daoHelper.insert(this.serviceDao, attributes);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public EntityResult serviceUpdate(Map<String, Object> attributes, Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
        return this.daoHelper.update(this.serviceDao, attributes, keyValues);
    }

    @Override
    public EntityResult serviceDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        return this.daoHelper.delete(this.serviceDao, keyMap);
    }
    @Override
    public EntityResult myServiceQuery(Map<String, Object> keyMap, List<String> attrList) throws OntimizeJEERuntimeException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        keyMap.put(UserDao.ID,auth.getName());
        return this.daoHelper.query(serviceDao, keyMap, attrList);
    }
    @Override
    public EntityResult myServiceInsert(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        keyMap.put(UserDao.ID,auth.getName());
        return this.daoHelper.insert(this.serviceDao, keyMap);
    }

    @Override
    public EntityResult myServiceDelete(Map<String, Object> keyMap) throws OntimizeJEERuntimeException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        keyMap.put(UserDao.ID,auth.getName());
        return this.daoHelper.delete(this.serviceDao, keyMap);
    }
    @Override
    public EntityResult myServiceUpdate(Map<String, Object> attributes, Map<String, Object> keyValues) throws OntimizeJEERuntimeException {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        keyValues.put(UserDao.ID,auth.getName());
        return this.daoHelper.update(this.serviceDao, attributes, keyValues);
    }
}
