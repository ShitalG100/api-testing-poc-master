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

import static petclinic.api.vet.data.Response.*;

public class VetApiTest {

    static java.lang.String apiUrl;

    @BeforeAll
    static void getApiUrl() {
        apiUrl = System.getProperty("apiUrl");
    }

    //Status code
   /* @Test
    public void getReponse_StatusCode() throws InvalidResponseException {
	//checking git commands
        VetApiClient client = new VetApiClient(apiUrl, "/api/vets");
        int statusCode = client.getStatus();
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(statusCode).isEqualTo(200);
        softly.assertAll();

    }*/


    //Get Vet details
    @Test
    public void getVet_Details() throws InvalidResponseException {
        VetApiClient client = new VetApiClient(apiUrl, "/api/vets");
        Response[] getvet = client.getResponses();
        int statusCode = client.getStatus();
        SoftAssertions softly = new SoftAssertions();
        System.out.println("The value of status" + statusCode);
        System.out.println("The value at index 1" + getvet[0]);
        softly.assertThat(statusCode).isEqualTo(200);
        softly.assertThat(getvet[0].getId()).as("ID is 100:").isEqualTo("100");
        softly.assertThat(getvet[0].getFirstName()).as("the given name is shital:  ").isEqualTo("Shital");    }


    //Create Vet using hardcoding value
    /*
    @Test
    public void addVet_checkId_ShouldReturnNewVet () throws InvalidResponseException, IOException {
        VetApiClient client = new VetApiClient(apiUrl, "/api/vets");
        Response vet = client.addVet(builder()
                .firstName("Shital")
                .id(300)
                .lastName("Gawande")
                .Specialties(1,"Surgery")
                .build());
        SoftAssertions softly = new SoftAssertions();
        softly.assertThat(vet.getFirstName()).as("First name should be Shital").isEqualTo("Shital");
        softly.assertThat(vet.getLastName()).as("last name should be Gawande").isEqualTo("Gawande");
        softly.assertThat(vet.getId()).as("A unique ID should be populated").isNotNull();
        softly.assertAll();
    }*/
}
