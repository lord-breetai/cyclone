package org.alfac.config;

import javax.annotation.Resource;
import javax.annotation.sql.DataSourceDefinition;
import javax.inject.Named;
import javax.sql.DataSource;

/**
 * @author Ivan
 */
@DataSourceDefinition(
        name = "java:app/jdbc/cycloneDS",
        transactional = true,
        url = "jdbc:hsqldb:mem:cycloneDS",
        className = "org.hsqldb.jdbcDriver",
        user = "sa",
        password = ""
)
@Named
public class DataSourceProvider {

    @Resource(lookup = "java:app/jdbc/cycloneDS")
    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }
}
