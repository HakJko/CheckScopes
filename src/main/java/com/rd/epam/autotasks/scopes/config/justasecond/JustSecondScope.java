package com.rd.epam.autotasks.scopes.config.justasecond;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JustSecondScope implements Scope {

    private Map<String, Object> scopedObjects
            = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Runnable> destructionCallbacks
            = Collections.synchronizedMap(new HashMap<>());

    @Override
    public Object get(String bean, ObjectFactory<?> objectFactory) {
        if (!scopedObjects.containsKey(bean) || bean.equals(null)) {
            scopedObjects.put(bean, objectFactory.getObject());
        } else {
            scopedObjects.put(bean, objectFactory.getObject());
        }
        return scopedObjects.get(bean);
    }

    @Override
    public Object remove(String bean) {
        destructionCallbacks.remove(bean);
        return scopedObjects.remove(bean);
    }

    @Override
    public void registerDestructionCallback(String bean, Runnable callback) {
        destructionCallbacks.put(bean, callback);
    }

    @Override
    public Object resolveContextualObject(String key) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "justASecond";
    }
}
