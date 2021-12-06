package com.example.spring_rest_steps;


import java.util.Arrays;
import java.util.List;
import java.nio.charset.Charset;

import com.example.spring_rest_steps.models.Question;
import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.security.crypto.codec.Base64;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ApplicationTest.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SurveyControllerIT {

    @LocalServerPort
    private int port;

    private TestRestTemplate template = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();

    @Before
    public void setupJSONAcceptType() {
        headers.add("Authorization", createHttpAuthenticationHeaderValue(
                "user1", "secret1"));
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    @Test
    public void retrieveSurveyQuestion() throws Exception {

        String expected = "{\"id\":\"Question1\",\"description\":\"Largest Country in the World\",\"correctAnswer\":\"Russia\",\"options\":[\"India\",\"Russia\",\"United States\",\"China\"]}";
        ResponseEntity<String> response = template.exchange(
                createUrl("/surveys/Survey1/questions/Question1"),
                HttpMethod.GET, new HttpEntity<String>("DUMMY_DOESNT_MATTER",
                        headers), String.class);



        JSONAssert.assertEquals(expected, response.getBody(), false);

        //Assert.assertTrue(response.getBody().contains("\"id\":\"Question1\""));
    }


    @Test
    public void retrieveSurveyQuestions() throws Exception {
        ResponseEntity<List<Question>> response = template.exchange(
                createUrl("/surveys/Survey1/questions/"), HttpMethod.GET,
                new HttpEntity<String>("DUMMY_DOESNT_MATTER", headers),
                new ParameterizedTypeReference<List<Question>>() {
                });

        Question sampleQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        Assert.assertTrue(response.getBody().contains(sampleQuestion));
    }



    @Test
    public void retrieveAllSurveyQuestions() throws Exception {

        String url = "http://localhost:" + port + "/surveys/Survey1/questions";

        ResponseEntity<List<Question>> response = template.exchange(url,
                HttpMethod.GET, new HttpEntity<String>("DUMMY_DOESNT_MATTER",
                        headers),
                new ParameterizedTypeReference<List<Question>>() {
                });

        Question sampleQuestion = new Question("Question1",
                "Largest Country in the World", "Russia", Arrays.asList(
                "India", "Russia", "United States", "China"));

        Assert.assertTrue(response.getBody().contains(sampleQuestion));
    }



    @Test
    public void createSurveyQuestion() throws Exception {
        Question question = new Question("DOESN'T MATTER", "Smallest Number",
                "1", Arrays.asList("1", "2", "3", "4"));

        ResponseEntity<String> response = template.exchange(
                createUrl("/surveys/Survey1/questions/"), HttpMethod.POST,
                new HttpEntity<Question>(question, headers), String.class);

        Assert.assertThat(response.getHeaders().get(HttpHeaders.LOCATION).get(0),
                CoreMatchers.containsString(("/surveys/Survey1/questions/")));
    }


    private String createUrl(String uri) {
        return "http://localhost:" + port + uri;
    }

    private String createHttpAuthenticationHeaderValue(String userId,
                                                       String password) {

        String auth = userId + ":" + password;

        byte[] encodedAuth = Base64.encode(auth.getBytes(Charset
                .forName("US-ASCII")));

        String headerValue = "Basic " + new String(encodedAuth);

        return headerValue;
    }

}
