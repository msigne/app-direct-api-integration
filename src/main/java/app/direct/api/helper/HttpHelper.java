package app.direct.api.helper;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import oauth.signpost.basic.DefaultOAuthConsumer;

/**
 * Entity helper for http calls.
 */
@Component
public class HttpHelper {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpHelper.class);

    private final DefaultOAuthConsumer consumer;

    @Autowired
    public HttpHelper(DefaultOAuthConsumer consumer) {
        this.consumer = consumer;
    }

    /**
     * Perfom a http call using the POST verb.
     * 
     * @param url Target URL
     * @param body incoming request body
     * @return An ResponseEntity object that contains the response as a body.
     */
    public ResponseEntity<String> doPost(String url, String body) {
        LOGGER.info("Request to send recieved. url =[{}]. Body =[{}]", url, body);
        try {
            final URL path = new URL(url);
            final HttpURLConnection request = (HttpURLConnection) path.openConnection();
            consumer.sign(request);
            request.setRequestMethod("POST");
            request.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            request.setRequestProperty("Accept", "application/json");
            request.setDoOutput(true);
            final OutputStream os = request.getOutputStream();
            os.write(body.getBytes("UTF-8"));
            os.flush();
            request.connect();
            return ResponseEntity.status(request.getResponseCode()).body(request.getResponseMessage());
        } catch (Exception e) {
            LOGGER.error("Error occured. message =[{}]", e.getMessage(), e);
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }

    }

    /**
     * Perfom a http call using the DELETE verb.
     * 
     * @param url Target Url.
     * @return An ResponseEntity object that contains the response as a body.
     */
    public ResponseEntity<String> doDelete(String url) {
        LOGGER.info("Request to send recieved. url =[{}]", url);
        try {
            final URL path = new URL(url);
            final HttpURLConnection request = (HttpURLConnection) path.openConnection();
            consumer.sign(request);
            request.setRequestMethod("DELETE");
            request.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            request.setRequestProperty("Accept", "application/json");
            request.setDoOutput(true);
            request.connect();
            return ResponseEntity.status(request.getResponseCode()).body(request.getResponseMessage());
        } catch (Exception e) {
            LOGGER.error("Error occured. message =[{}]", e.getMessage(), e);
            return ResponseEntity.unprocessableEntity().body(e.getMessage());
        }
    }
}
