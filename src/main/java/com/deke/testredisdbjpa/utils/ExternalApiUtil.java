package com.deke.testredisdbjpa.utils;


import com.deke.testredisdbjpa.testRest.Doviz;
import com.deke.testredisdbjpa.testRest.USD;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@UtilityClass
public class ExternalApiUtil {

    private static final String GITHUB_API_URL = "https://api.github.com/users";
    private static final String DOVIZ_API_URL = "https://api.genelpara.com/embed/doviz.json";

    /*
        public GithubUser[] getUsers() {
            return restTemplate.getForEntity(GITHUB_API_URL, GithubUser[].class).getBody();
        }
     */

    public static USD getRecentUSD() {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Doviz> entity = new HttpEntity<>(headers);
        String value = restTemplate.exchange(DOVIZ_API_URL, HttpMethod.POST, entity, String.class).getBody();
        return new Gson().fromJson(value, Doviz.class).getUSD();
    }
}