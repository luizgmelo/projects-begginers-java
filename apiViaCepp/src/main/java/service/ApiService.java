package service;

import com.fasterxml.jackson.databind.ObjectMapper;
import dto.AddressDto;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiService {

    AddressDto addressDto = new AddressDto();

    public AddressDto getAddress(String cep) throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("http://viacep.com.br/ws/" + cep + "/json/")).build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            ObjectMapper mapper = new ObjectMapper();
            addressDto = mapper.readValue(response.body(), AddressDto.class);
        } catch(Exception e) {
            System.out.println(e.getMessage());
        }

        return addressDto;
    }
}
