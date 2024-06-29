package com.ivan.spring.selenium.kelvin.scope;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.SimpleThreadScope;
import org.springframework.lang.NonNull;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ThreadLocalScope extends SimpleThreadScope {

    private final ThreadLocal<Map<String, Object>> threadScope = ThreadLocal.withInitial(HashMap::new);

    @Override
    @NonNull
    public Object get(@NonNull String name, @NonNull ObjectFactory<?> objectFactory) {
        Map<String, Object> scope = threadScope.get();
        Object object = scope.get(name);
        if (object == null) {
            object = objectFactory.getObject();
            scope.put(name, object);
        }

        SessionId sessionId = ((RemoteWebDriver) object).getSessionId();
        if (Objects.isNull(sessionId)) {
            scope.remove(name);
            object = objectFactory.getObject();
            scope.put(name, object);
        }

        return object;
    }

    @Override
    public void registerDestructionCallback(@NonNull String name, @NonNull Runnable callback) {
    }
}
