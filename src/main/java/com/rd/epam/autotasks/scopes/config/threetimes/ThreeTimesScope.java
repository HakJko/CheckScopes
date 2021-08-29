package com.rd.epam.autotasks.scopes.config.threetimes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ThreeTimesScope implements Scope {

    private static final int QUANTITY_OBJECTS = 3;
    private static int counterThreeTimes = -1;
    private static int counterBeans;
    private Map<String, Object> scopedObjects
            = Collections.synchronizedMap(new HashMap<>());
    private Map<String, Runnable> destructionCallbacks
            = Collections.synchronizedMap(new HashMap<>());


    @Override
    public Object get(String bean, ObjectFactory<?> objectFactory) {
        ++counterThreeTimes;
        ++counterBeans;
        zeroingCounter();
        if (!scopedObjects.containsKey(bean)) {
            scopedObjects.put(bean, objectFactory.getObject());
        } else if (counterThreeTimes % QUANTITY_OBJECTS == 0) {
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
        return "threeTimes";
    }



    private void zeroingCounter() {
        final int counterBorder = 11;
        if (counterBeans == counterBorder) {
            counterThreeTimes = 0;
        }
    }

}
