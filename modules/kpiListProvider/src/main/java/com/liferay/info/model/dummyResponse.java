package com.liferay.info.model;

import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.LinkedHashMap;
import java.util.Map;
/**
 * @author Mahmoud Hussein Tayem
 */
public class dummyResponse {
    public Map<String, Object> details = new LinkedHashMap<>();

    @JsonAnySetter
    void setDetail(String key, Object value) {
        details.put(key, value);
    }

}
