package edu.nju.ise.interceptor.dao;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.util.Map;
import java.util.Properties;

/**
 * Mybatis分页查询拦截器
 *
 * @author Hermit
 * @version 1.0 2018/02/14
 * */
@Intercepts({
        @Signature(type = StatementHandler.class, method = "prepare", args = {Connection.class, Integer.class})
})
public class MybatisPageInterceptor implements Interceptor {

    private static final Logger logger = LoggerFactory.getLogger(MybatisPageInterceptor.class);

    //每页条数
    private Long pageSize;
    //当前显示页数
    private Long currentPage;

    private String dbType;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        //获取StatementHandler，默认是RoutingStatementHandler
        StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
        //获取statementHandler包装类
        MetaObject metaObjectHandler = SystemMetaObject.forObject(statementHandler);

        //分离代理对象链
        while (metaObjectHandler.hasGetter("h")) {
            Object obj = metaObjectHandler.getValue("h");
            metaObjectHandler = SystemMetaObject.forObject(obj);
        }

        while (metaObjectHandler.hasGetter("target")) {
            Object obj = metaObjectHandler.getValue("target");
            metaObjectHandler = SystemMetaObject.forObject(obj);
        }

        //获取查询接口映射的相关信息
        MappedStatement mappedStatement = (MappedStatement) metaObjectHandler.getValue("delegate.mappedStatement");
        String mapId = mappedStatement.getId();

        //拦截以.ByPage结尾的请求，分页功能统一实现
        if (mapId.matches(".+ByPage$")) {
            //获取进行数据库操作时管理参数的handler
            ParameterHandler parameterHandler = (ParameterHandler) metaObjectHandler.getValue("delegate.parameterHandler");
            //获取请求时参数
            Map<String, Object> paramObject = (Map<String, Object>) parameterHandler.getParameterObject();

            //参数名称与service中设置到map中的名称一致
            currentPage = (Long) paramObject.get("currentPage");
            pageSize = (Long) paramObject.get("pageSize");

            String sql = (String) metaObjectHandler.getValue("delegate.boundSql.sql");

            //构建分页功能的SQL语句
            String limitSql;
            sql = sql.trim();

            limitSql = sql + " limit " + (currentPage - 1) * pageSize + "," + pageSize;

            //将构建完成的分页SQL语句替换delegate.boundSql.sql
            metaObjectHandler.setValue("delegate.boundSql.sql", limitSql);
        }

        //调用原对象方法，进入责任链的下一级
        return invocation.proceed();
    }

    //获取代理对象
    @Override
    public Object plugin(Object target) {
        //生成object的动态代理对象
        return Plugin.wrap(target, this);
    }

    //设置代理对象参数
    @Override
    public void setProperties(Properties properties) {
        //如果项目中分页的pageSize是统一的，也可以在这里统一配置和获取，这样就不用每次请求都传递pageSize参数了
        String limit1 = properties.getProperty("limit", "10");
        this.pageSize = Long.valueOf(limit1);
        this.dbType = properties.getProperty("dbType", "mysql");
    }
}
