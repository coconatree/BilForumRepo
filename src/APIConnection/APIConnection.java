package APIConnection;

import PojoClasses.Post;
import PojoClasses.User;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class APIConnection
{
    /**

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

     */

    public static List<Post> httpGET() throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/post/getAll")).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String bodyAsString = response.body().toString();

        ObjectMapper mapper = new ObjectMapper();

        List<Post> postList = mapper.readValue(bodyAsString, new TypeReference<List<Post>>(){});

        return postList;
    }

    public static String httpPOST(Post post) throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("FUNCTION");

        ObjectMapper mapper = new ObjectMapper();

        String requestBody = mapper.writeValueAsString(post);

        System.out.println(requestBody);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/post/addPost")).PUT(HttpRequest.BodyPublishers.ofString(requestBody)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.toString();
    }
    public static List<User> getUsers() throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/user/getAll")).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String bodyAsString = response.body().toString();

        ObjectMapper mapper = new ObjectMapper();

        List<User> userList = mapper.readValue(bodyAsString, new TypeReference<List<User>>(){});

        return userList;
    }
    public static String httpUser(User user) throws Exception
    {
        HttpClient client = HttpClient.newHttpClient();

        System.out.println("FUNCTION");

        ObjectMapper mapper = new ObjectMapper();

        String requestBody = mapper.writeValueAsString(user);

        System.out.println(requestBody);

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("http://localhost:8080/user/addUser")).PUT(HttpRequest.BodyPublishers.ofString(requestBody)).build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.toString();
    }

    public static void main(String[] args)
    {
        try
        {
            httpGET();
        }
        catch (Exception exception)
        {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
    }
}
