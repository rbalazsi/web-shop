package com.webshop.webportal.util;


import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class RestClientUtils {

    public static <T> List<T> getEntities(RestTemplate template, String url) {
        ResponseEntity<Resources<T>> categoryEntities = template.exchange(url,
                HttpMethod.GET, null, new ParameterizedTypeReference<Resources<T>>() {});
        return new ArrayList<>(categoryEntities.getBody().getContent());
    }
}
