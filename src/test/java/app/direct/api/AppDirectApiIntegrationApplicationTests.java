package app.direct.api;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import app.direct.api.consumer.AppDirectApiConsumer;
import app.direct.api.helper.HttpHelper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppDirectApiIntegrationApplicationTests {

    @Autowired
    private AppDirectApiConsumer api;
    
    @Autowired
    private HttpHelper http;
	
    @Test
	public void contextLoads() {
        assertNotNull(api);
        assertNotNull(http);
	}
}
