package org.ericxu.plugins;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.util.Properties;

@Intercepts({
        @Signature(type = Executor.class, method = "query", args = {
                MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class
        }),
        @Signature(type = Executor.class, method = "close", args = {boolean.class})
})
public class ExamplePlugin implements Interceptor {

    private Integer testProp;

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        return null;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {
        testProp = Integer.parseInt(properties.get("testProp").toString());
    }

    public Integer getTestProp() {
        return testProp;
    }

    public void setTestProp(Integer testProp) {
        this.testProp = testProp;
    }
}
