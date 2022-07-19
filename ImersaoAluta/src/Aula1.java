import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;


public class Aula1 {
    public static void main(String[] args) throws Exception {

        // Conexão HTTP e fazer o GET

        String url = "https://api.mocki.io/v2/549a5d8b";
        URI address = URI.create(url);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder(address).GET().build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String body = response.body();
        //System.out.println(body);

        // filtrar as infos (título, poster e nota)

        JsonParser parser = new JsonParser();

        List<Map<String, String>> movies = parser.parse(body);

        // Exibir e manipular os dados

        for (Map<String, String> movie : movies) {

            System.out.println("Movie: " + movie.get("title"));
            System.out.println("Poster: " + movie.get("image"));
            float rating = Float.parseFloat(movie.get("imDbRating"));
            System.out.print("Rating: ");
            for (int i = 0; i <= rating; i++){
                System.out.print("\u270A\uD83C\uDFFF");
            }
        }

    }
}
