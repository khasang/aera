package io.aera.controller;

import io.aera.entity.Personage;
import io.aera.entity.TypePersonage;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TypePersonageControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/type_personage";
    private final String ALL = "/all";
    private final String ADD = "/add";
    private final String GET_ID = "/get/";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete";

    @Test
    public void getAllTypePersonage(){
        RestTemplate restTemplate = new RestTemplate();
        createTypePersonage();
        createTypePersonage();

        ResponseEntity<List<TypePersonage>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<TypePersonage>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<TypePersonage> list = responseEntity.getBody();
        assertNotNull(list);
    }

    @Test
    public void deleteTypePersonage(){
        TypePersonage typePersonage = createTypePersonage();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                typePersonage.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<TypePersonage> checkType = restTemplate.exchange(
                ROOT + GET_ID + "/{id}",
                HttpMethod.GET,
                null,
                TypePersonage.class,
                typePersonage.getId()
        );

        assertNull(checkType.getBody());
    }

    @Test
    public void addTypePersonage() {
        TypePersonage typePersonage = createTypePersonage();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<TypePersonage> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "{id}",
                HttpMethod.GET,
                null,
                TypePersonage.class,
                typePersonage.getId()
        );

        TypePersonage resultType = responseEntity.getBody();

        assertNotNull(resultType);
        assertEquals(typePersonage.getName(), resultType.getName());
    }

    private TypePersonage createTypePersonage() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        TypePersonage typePersonage = prefillTypePersonage();

        HttpEntity<TypePersonage> httpEntity = new HttpEntity<>(typePersonage, headers);

        RestTemplate restTemplate = new RestTemplate();
        TypePersonage result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                TypePersonage.class
        ).getBody();

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("pupil", result.getName());

        return result;
    }

    private TypePersonage prefillTypePersonage() {
        Personage potter = new Personage();
        potter.setName("Harry Potter");
        potter.setLevel(1);

        Personage weasley = new Personage();
        weasley.setName("Ron Weasley");
        weasley.setLevel(1);

        Personage granger = new Personage();
        granger.setName("Hermione Granger");
        granger.setLevel(1);

        List<Personage> pupilList = new ArrayList<>();
        pupilList.add(potter);
        pupilList.add(weasley);
        pupilList.add(granger);

        TypePersonage pupil = new TypePersonage();
        pupil.setName("pupil");
        pupil.setPersonage(pupilList);

        return pupil;
    }
}
