package com.cursos.springsecuritycourse.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@CrossOrigin
@RequestMapping("/api/timezonedb")
public class TimezoneProxyController {

    @Value("${timezonedb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    @GetMapping("/list-time-zone")
    public ResponseEntity<String> proxyTimezoneListRequest(@RequestParam String country) {
        String url = "https://api.timezonedb.com/v2.1/list-time-zone"
                   + "?key=" + apiKey
                   + "&format=json"
                   + "&country=" + country;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

    @GetMapping("/get-time-zone")
    public ResponseEntity<String> proxyTimezoneRequest(@RequestParam String zoneName) {
        String url = "https://api.timezonedb.com/v2.1/get-time-zone"
                   + "?key=" + apiKey
                   + "&format=json"
                   + "&by=zone&zone=" + zoneName;

        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        HttpEntity<Void> requestEntity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, requestEntity, String.class);
        return ResponseEntity.status(response.getStatusCode()).body(response.getBody());
    }

}
