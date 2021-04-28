import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import io.restassured.http.Headers;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import petclinic.api.vet.data.Response;
import petclinic.api.vet.VetApiClient;
import petclinic.api.vet.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class VetApiTest {

    static java.lang.String apiUrl;

    @BeforeAll
    static void getApiUrl() {
        apiUrl = System.getProperty("apiUrl");
    }
    //Status code
    @Test
    public void getReponse_StatusCode() throws InvalidResponseException {
        VetApiClient client = new VetApiClient(apiUrl, "/api/vets");
        int statusCode = client.getStatus();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(statusCode).isEqualTo(201);
        softly.assertAll();

    }
    //Header verfication
    @Test
    public void getServices_Header() throws InvalidResponseException {
        VetApiClient client = new VetApiClient(apiUrl, "/api/vets");

        SoftAssertions softly = new SoftAssertions();

        Headers contentType = client.getHeader("Content-Type");
        softly.assertThat(contentType ).isNotNull() ;

        softly.assertAll();

    }

    //Get Vet details
    @Test
    public void getVet_Details() throws InvalidResponseException {
        VetApiClient client = new VetApiClient(apiUrl, "/api/vets");
        Response[] getvet = client.getResponses();

        SoftAssertions softly = new SoftAssertions();
        System.out.println("The value at index 1" + getvet[0]);
        softly.assertThat(getvet[0].getId()).as("ID is 100:").isEqualTo("100");
        softly.assertThat(getvet[1].getFirstName()).as("the given name is shital:  ").isEqualTo("Shital");


    }

}
