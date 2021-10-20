package mk.ukim.finki.emt.project.userreservationmanagement.xport.client;

import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.Dog;
import mk.ukim.finki.emt.project.userreservationmanagement.domain.valueobjects.DogId;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Collections;
import java.util.List;

@Service
public class DogClient {

    private final RestTemplate restTemplate;
    private final String serverUrl;

    public DogClient(@Value("${app.dogs.url}") String serverUrl) {
        this.serverUrl = serverUrl;
        this.restTemplate = new RestTemplate();
        var requestFactory = new SimpleClientHttpRequestFactory();
        this.restTemplate.setRequestFactory(requestFactory);
    }

    private UriComponentsBuilder uri() {
        return UriComponentsBuilder.fromUriString(this.serverUrl);
    }

    public List<Dog> findAll() {
        try {
            return restTemplate.exchange(uri().path("/api/dogs").build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<List<Dog>>() {
            }).getBody();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }
    public Dog findDogById(String id) {
        try {
            Dog dog = restTemplate.exchange(uri().path("/api/dogs/"+id).build().toUri(), HttpMethod.GET,null, new ParameterizedTypeReference<Dog>() {
            }).getBody();
            return dog;
        } catch (Exception e) {
           throw new IllegalArgumentException();
        }
    }
    public Dog changeDogStatus(String id) {
        try {
            Dog dog = restTemplate.exchange(uri().path("/api/dogs/reserved/"+id).build().toUri(), HttpMethod.GET, null, new ParameterizedTypeReference<Dog>() {
            }).getBody();
            return dog;
        } catch (Exception e) {
            throw e;
        }
    }
}
