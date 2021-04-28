package petclinic.api.vet;

import api.common.ApiClient;
import api.common.ApiRequest;
import api.common.ApiResponse;
import api.common.exception.InvalidResponseException;
import petclinic.api.vet.data.SpecialtiesItem;
import petclinic.api.vet.data.Response;
import com.google.gson.GsonBuilder;
import io.restassured.config.ObjectMapperConfig;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.internal.mapping.GsonMapper;
import io.restassured.mapper.ObjectMapperType;


public class VetApiClient extends ApiClient {

    public VetApiClient(String baseUrl, String basePath) {
        super(baseUrl, basePath);

        ObjectMapperConfig config = new ObjectMapperConfig(ObjectMapperType.GSON)
                .gsonObjectMapperFactory((type, s) -> new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create());
        setObjectMapper(new GsonMapper(config.gsonObjectMapperFactory()));
    }

    //Verify status code
    public int getStatus() throws InvalidResponseException {

        ApiResponse response = caller.executeRequest(getRequest(), Method.POST, Response.class);
        return response.getHttpStatusCode();
    }
    //Header verification

    public Headers getHeader(String s) throws InvalidResponseException {

        ApiResponse response = caller.executeRequest(getRequest(), Method.GET, Response.class);
        return response.getHttpHeaders();

    }

    //GET Vet details
    public Response[] getResponses() throws InvalidResponseException {
        ApiResponse<Response[]> response = caller.executeRequest(getRequest(), Method.GET, Response[].class);
        return response.getContent();
    }

    //POST Add Vet
    public Response addVet(Response response) throws InvalidResponseException {
        ApiRequest request = getRequest().withBody(response).withHeader("Content-Type", "application/json");
        ApiResponse<Response> response1 = caller.executeRequest(request, Method.POST, Response.class);
        return response1.getContent();
    }

}