package app.direct.api;

import java.net.HttpURLConnection;
import java.net.URL;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import oauth.signpost.OAuthConsumer;
import oauth.signpost.basic.DefaultOAuthConsumer;

@SpringBootApplication
public class AppDirectApiIntegrationApplication {

    public static void main(String[] args) {
        SpringApplication.run(AppDirectApiIntegrationApplication.class, args);
    }

    @PostConstruct
    public void test() throws Exception {
        OAuthConsumer consumer = new DefaultOAuthConsumer("Dummy", "secret");
        URL url = new URL("https://www.appdirect.com/api/events/dummyChange");
        HttpURLConnection request = (HttpURLConnection) url.openConnection();
        consumer.sign(request);
        request.connect();
    }
}
