package com.deke.testredisdbjpa.testRest;


import com.google.gson.Gson;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TestRestTemplateService {

    private final RestTemplate restTemplate;

    public TestRestTemplateService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private static final String GITHUB_API_URL = "https://api.github.com/users";
    private static final String DOVIZ_API_URL = "https://api.genelpara.com/embed/doviz.json";

    public GithubUser[] getUsers() {
        return restTemplate.getForEntity(GITHUB_API_URL, GithubUser[].class).getBody();
    }

    public USD getRecentUSD() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Doviz> entity = new HttpEntity<>(headers);
        String value = restTemplate.exchange(DOVIZ_API_URL, HttpMethod.POST, entity, String.class).getBody();
        return new Gson().fromJson(value, Doviz.class).getUSD();
    }
}