package com.acejhonatan.parkingcontrol.core.util;

public abstract class ServiceUtil {

    protected final String getServiceName() {
        return this.getClass().getSimpleName();
    }

    protected final String getEntityName() {

        String serviceName = getServiceName();
        StringBuilder sb = new StringBuilder();

        for (String simpleName : serviceName.split("(?<!(^|[A-Z]))(?=[A-Z])|(?<!^)(?=[A-Z][a-z])")) {
            sb.append(simpleName);
            break;
        }

        return sb.toString();
    }
}
