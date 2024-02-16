package com.campusdual.cd2023bfs3g3.model.core.dao;


import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;

import com.ontimize.jee.server.dao.common.ConfigurationFile;
import com.ontimize.jee.server.dao.jdbc.OntimizeJdbcDaoSupport;


@Lazy
@Repository(value = "UserRoleDao")
@ConfigurationFile(
	configurationFile = "dao/UserRoleDao.xml",
	configurationFilePlaceholder = "dao/placeholders.properties")
public class UserRoleDao extends OntimizeJdbcDaoSupport {

	public static final String ID = "user_";
	public static final String ID_USER_ROLE = "id_user_role";
	public static final String ID_ROLENAME = "id_rolename";
}
