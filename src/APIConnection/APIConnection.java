package APIConnection;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class APIConnection
{
    private static final String GET_ALL_POSTS_URL = "http://localhost:8080/post/getAll";

    public static HttpResponse<String> sendGET(String URL) throws IOException, InterruptedException
    {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .GET()
                .header("accept", "application/json")
                .uri(URI.create(URL))
                .build();

        return client.send(request, HttpResponse.BodyHandlers.ofString());
    }
}
