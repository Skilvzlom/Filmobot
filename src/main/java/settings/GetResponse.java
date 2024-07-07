package settings;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
@Slf4j
public class GetResponse {
    private final static ConfigSettings settings = ConfigSettings.getInstance();
    public static HttpResponse<String> getResponse(boolean anime, boolean serial, boolean film, Boolean[] genres) {
        String request = "https://api.kinopoisk.dev/v1.4/movie/random?notNullFields=names.name&notNullFields=videos.trailers.url&rating.kp=6-10";
        if (anime) {
            request += "&type=anime";
        } else if (serial) {
            request += "&type=tv-series";
        } else if (film) {
            request += "&type=movie";
        }
        if (genres[15]) {
            request += "&ageRating=%2118";
        }
        if (genres[8]) {
            request += "&type=cartoon";
        }
        if (genres[0]) {
            request += "&genres.name=%D0%B1%D0%BE%D0%B5%D0%B2%D0%B8%D0%BA";
        }
        if (genres[1]) {
            request += "&genres.name=%D0%B4%D1%80%D0%B0%D0%BC%D0%B0";
        }
        if (genres[2]) {
            request += "&genres.name=%D0%BA%D0%BE%D0%BC%D0%B5%D0%B4%D0%B8%D1%8F";
        }
        if (genres[3]) {
            request += "&genres.name=%D1%82%D1%80%D0%B8%D0%BB%D0%BB%D0%B5%D1%80";
        }
        if (genres[4]) {
            request += "&genres.name=%D1%84%D0%B0%D0%BD%D1%82%D0%B0%D1%81%D1%82%D0%B8%D0%BA%D0%B0";
        }
        if (genres[5]) {
            request += "&genres.name=%D1%84%D1%8D%D0%BD%D1%82%D0%B5%D0%B7%D0%B8";
        }
        if (genres[6]) {
            request += "&genres.name=%D0%B4%D0%B5%D1%82%D0%B5%D0%BA%D1%82%D0%B8%D0%B2";
        }
        if (genres[7]) {
            request += "&genres.name=%D1%83%D0%B6%D0%B0%D1%81%D1%8B";
        }
        if (genres[9]) {
            request += "&genres.name=%D0%BC%D0%B5%D0%BB%D0%BE%D0%B4%D1%80%D0%B0%D0%BC%D0%B0";
        }
        if (genres[10]) {
            request += "&genres.name=%D0%BF%D1%80%D0%B8%D0%BA%D0%BB%D1%8E%D1%87%D0%B5%D0%BD%D0%B8%D1%8F";
        }
        if (genres[11]) {
            request += "&genres.name=%D0%B2%D0%BE%D0%B5%D0%BD%D0%BD%D1%8B%D0%B9";
        }
        if (genres[12]) {
            request += "&genres.name=%D1%81%D0%B5%D0%BC%D0%B5%D0%B9%D0%BD%D1%8B%D0%B9";
        }
        if (genres[13]) {
            request += "&genres.name=%D0%B8%D1%81%D1%82%D0%BE%D1%80%D0%B8%D1%8F";
        }
        if (genres[14]) {
            request += "&genres.name=%D0%B4%D0%BE%D0%BA%D1%83%D0%BC%D0%B5%D0%BD%D1%82%D0%B0%D0%BB%D1%8C%D0%BD%D1%8B%D0%B9";
        }
        if (genres[16]) {
            request += "&genres.name=%D0%BA%D1%80%D0%B8%D0%BC%D0%B8%D0%BD%D0%B0%D0%BB";
        }
        if (genres[17]) {
            request += "&genres.name=%D0%B2%D0%B5%D1%81%D1%82%D0%B5%D1%80%D0%BD";
        }

        HttpRequest httpRequest = HttpRequest.newBuilder().
                uri(URI.create(request))
                .header("accept", "application/json")
                .header("X-API-KEY", settings.getXApiToken())
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = null;
        try {
            response = HttpClient.newHttpClient().send(httpRequest, HttpResponse.BodyHandlers.ofString());
        } catch (InterruptedException | IOException e) {
            log.warn("Error with response");
        }
        return response;
    }
}
