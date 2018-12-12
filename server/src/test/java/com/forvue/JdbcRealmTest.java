package com.forvue;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

/**
 * Created by gqc on 2018/12/12.
 * jdbcRealem测试
 *
 */
public class JdbcRealmTest {
    @Test
    public void test() {

        //创建数据源
        DruidDataSource dataSource=new DruidDataSource();
        {
            dataSource.setUrl("jdbc:mysql://localhost:3306/my_cli");
            dataSource.setUsername("root");
            dataSource.setPassword("admin");
        }

        JdbcRealm jdbcRealm=new JdbcRealm();
        jdbcRealm.setDataSource(dataSource);

        //设置可以访问权限数据库 (默认为false)
        jdbcRealm.setPermissionsLookupEnabled(true);

        // 默认的查询sql
//        protected static final String DEFAULT_AUTHENTICATION_QUERY = "select password from users where username = ?";
//        protected static final String DEFAULT_SALTED_AUTHENTICATION_QUERY = "select password, password_salt from users where username = ?";
//        protected static final String DEFAULT_USER_ROLES_QUERY = "select role_name from user_roles where username = ?";
//        protected static final String DEFAULT_PERMISSIONS_QUERY = "select permission from roles_permissions where role_name = ?";



//        //自己写的sql 可以替换默认的sql
//        String sql="elect password from test_db where username = ?";
//        jdbcRealm.setAuthenticationQuery(sql);
//
//        String roleSql="select role_name from test_db where username = ?";
//        jdbcRealm.setUserRolesQuery(roleSql);

        DefaultSecurityManager defaultManager=new DefaultSecurityManager();

        defaultManager.setRealm(jdbcRealm);

        SecurityUtils.setSecurityManager(defaultManager);

//        //2、得到SecurityManager实例 并绑定给SecurityUtils
//        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
//        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");


        subject.login(token)
        ;
        //查询是否拥有角色
        subject.checkRole("visitor");

        subject.checkPermission("user:select");
    }
}
