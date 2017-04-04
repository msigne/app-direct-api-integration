package app.direct.api.helper;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyString;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

@SuppressWarnings("unchecked")
@RunWith(MockitoJUnitRunner.class)
public class HttpHelperTest {

    @Mock
    private RestTemplate restTemplate;

    private HttpHelper<String> http;

    @Before
    public void setup() throws Exception {
        http = new HttpHelper<String>(restTemplate);
        TestingHelper.setFieldValue(http, "authHeader", "header");
    }

    @Test
    public void testDoGet() {
        http.doGet("http:/test", String.class, "requestId");
        verify(restTemplate, times(1)).exchange(anyString(), any(HttpMethod.GET.getClass()), any(HttpEntity.class), eq(String.class));
    }

    @Test
    public void testDoPost() {
        http.doPost("http:/test", "body", String.class, "requestId");
        verify(restTemplate, times(1)).exchange(anyString(), any(HttpMethod.POST.getClass()), any(HttpEntity.class), eq(String.class));
    }

    @Test
    public void testDoPut() {
        http.doPut("http:/test", "body", String.class, "requestId");
        verify(restTemplate, times(1)).exchange(anyString(), any(HttpMethod.PUT.getClass()), any(HttpEntity.class), eq(String.class));
    }
  
    @Test(expected = Exception.class)
    public void testDoGetException() {
        when(restTemplate.exchange(anyString(), eq(HttpMethod.GET), any(), eq(String.class))).thenThrow(Exception.class);
        http.doGet("http:/test", String.class, "requestId");
        verify(restTemplate, times(1)).exchange(anyString(), any(HttpMethod.GET.getClass()), any(HttpEntity.class), eq(String.class));
    }

    @Test(expected = Exception.class)
    public void testDoPostException() {
        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(), eq(String.class))).thenThrow(Exception.class);
        http.doPost("http:/test", "body", String.class, "requestId");
        verify(restTemplate, times(1)).exchange(anyString(), any(HttpMethod.POST.getClass()), any(HttpEntity.class), eq(String.class));
    }

    @Test(expected = Exception.class)
    public void testDoPutException() {
        when(restTemplate.exchange(anyString(), eq(HttpMethod.PUT), any(), eq(String.class))).thenThrow(Exception.class);
        http.doPut("http:/test", "body", String.class, "requestId");
        verify(restTemplate, times(1)).exchange(anyString(), any(HttpMethod.PUT.getClass()), any(HttpEntity.class), eq(String.class));
    }
}
