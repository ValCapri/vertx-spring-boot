package dev.snowdrop.vertx.http.utils;

import io.vertx.core.http.HttpMethod;

public class HttpMethodConverter {

    public static io.vertx.core.http.HttpMethod springToVertx(org.springframework.http.HttpMethod springMethod) {
        if (springMethod == null) {
            return null;
        }
        if (springMethod.equals(org.springframework.http.HttpMethod.GET)) {
            return io.vertx.core.http.HttpMethod.GET;
        } else if (springMethod.equals(org.springframework.http.HttpMethod.POST)) {
            return io.vertx.core.http.HttpMethod.POST;
        } else if (springMethod.equals(org.springframework.http.HttpMethod.PUT)) {
            return io.vertx.core.http.HttpMethod.PUT;
        } else if (springMethod.equals(org.springframework.http.HttpMethod.DELETE)) {
            return io.vertx.core.http.HttpMethod.DELETE;
        } else if (springMethod.equals(org.springframework.http.HttpMethod.HEAD)) {
            return io.vertx.core.http.HttpMethod.HEAD;
        } else if (springMethod.equals(org.springframework.http.HttpMethod.OPTIONS)) {
            return io.vertx.core.http.HttpMethod.OPTIONS;
        } else if (springMethod.equals(org.springframework.http.HttpMethod.TRACE)) {
            return io.vertx.core.http.HttpMethod.TRACE;
        } else if (springMethod.equals(org.springframework.http.HttpMethod.PATCH)) {
            return io.vertx.core.http.HttpMethod.PATCH;
        }

        // Continue with other methods
        throw new IllegalArgumentException("Unknown method: " + springMethod);
    }

    public static org.springframework.http.HttpMethod vertxToSpring(io.vertx.core.http.HttpMethod vertxMethod) {
        if (vertxMethod == null) {
            return null;
        }
        if (vertxMethod.equals(io.vertx.core.http.HttpMethod.GET)) {
            return org.springframework.http.HttpMethod.GET;
        } else if (vertxMethod.equals(io.vertx.core.http.HttpMethod.POST)) {
            return org.springframework.http.HttpMethod.POST;
        } else if (vertxMethod.equals(io.vertx.core.http.HttpMethod.PUT)) {
            return org.springframework.http.HttpMethod.PUT;
        } else if (vertxMethod.equals(io.vertx.core.http.HttpMethod.DELETE)) {
            return org.springframework.http.HttpMethod.DELETE;
        } else if (vertxMethod.equals(io.vertx.core.http.HttpMethod.HEAD)) {
            return org.springframework.http.HttpMethod.HEAD;
        } else if (vertxMethod.equals(io.vertx.core.http.HttpMethod.OPTIONS)) {
            return org.springframework.http.HttpMethod.OPTIONS;
        } else if (vertxMethod.equals(io.vertx.core.http.HttpMethod.TRACE)) {
            return org.springframework.http.HttpMethod.TRACE;
        } else if (vertxMethod.equals(io.vertx.core.http.HttpMethod.PATCH)) {
            return org.springframework.http.HttpMethod.PATCH;
        }

        // Continue with other methods
        throw new IllegalArgumentException("Unknown method: " + vertxMethod);
    }
}

