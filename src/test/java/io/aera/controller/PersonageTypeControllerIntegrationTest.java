package io.aera.controller;

import io.aera.entity.PersonageType;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.*;

public class PersonageTypeControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/type_personage";
    private final String ALL = "/all";
    private final String ADD = "/add";
    private final String GET_ID = "/get";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete";

    private final String[] TEST_PERSONAGE_TYPES = {"warrior", "wizard", "thief"};
    private int testPersonageTypeIndex = 0;

    @Test
    public void getAllPersonageTypes() {
        RestTemplate restTemplate = new RestTemplate();
        createPersonageType();
        createPersonageType();

        ResponseEntity<List<PersonageType>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<PersonageType>>() {
                }
        );

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        List<PersonageType> list = responseEntity.getBody();
        assertNotNull(list);
    }

    @Test
    public void deleteTypePersonage() {
        PersonageType personageType = createPersonageType();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "/{id}",
                HttpMethod.DELETE,
                null,
                String.class,
                personageType.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());

        ResponseEntity<PersonageType> checkType = restTemplate.exchange(
                ROOT + GET_ID + "/{id}",
                HttpMethod.GET,
                null,
                PersonageType.class,
                personageType.getId()
        );

        assertNull(checkType.getBody());
    }

    @Test
    public void addTypePersonage() {
        PersonageType personageType = createPersonageType();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<PersonageType> responseEntity = restTemplate.exchange(
                ROOT + GET_ID + "/{id}",
                HttpMethod.GET,
                null,
                PersonageType.class,
                personageType.getId()
        );

        PersonageType resultType = responseEntity.getBody();

        assertNotNull(resultType);
        assertEquals(personageType.getName(), resultType.getName());
    }

    private PersonageType createPersonageType() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON_UTF8);

        PersonageType personageType = prefillPersonageType();

        HttpEntity<PersonageType> httpEntity = new HttpEntity<>(personageType, headers);

        RestTemplate restTemplate = new RestTemplate();
        PersonageType result = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                PersonageType.class
        ).getBody();

        assertNotNull(result);
        assertNotNull(result.getId());
        assertEquals("pupil", result.getName());

        return result;
    }

    private PersonageType prefillPersonageType() {
        PersonageType personageType = new PersonageType();
        personageType.setName(TEST_PERSONAGE_TYPES[testPersonageTypeIndex]);
        if (testPersonageTypeIndex == TEST_PERSONAGE_TYPES.length) {
            testPersonageTypeIndex = 0;
        } else {
            testPersonageTypeIndex++;
        }
        return personageType;
    }
}
