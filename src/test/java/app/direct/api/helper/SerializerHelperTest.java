package app.direct.api.helper;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

public class SerializerHelperTest {

    private Map<String, Object> map = Maps.newHashMap();
    private String json;

    @Before
    public void setup() {
        map = Maps.newHashMap();
        map.put("f1", "v1");
        map.put("f2", "v2");
        final Map<String, Object> m = Maps.newHashMap();
        m.put("f11", "v11");
        m.put("f12", "v12");
        map.put("cf", m);

        json = "{\"cf\":{\"f12\":\"v12\",\"f11\":\"v11\"},\"f1\":\"v1\",\"f2\":\"v2\"}";
    }

    @Test
    public void testToJson() {
        final String toJson = SerializerHelper.toJson(map);
        assertThat(json, is(toJson));
    }
   
    @SuppressWarnings("rawtypes")
    @Test
    public void testDeserialized() {
        final Map m = SerializerHelper.deserialized(json, Map.class);
        assertThat(SerializerHelper.toJson(m), is(SerializerHelper.toJson(m)));
    }

    @Test
    public void testCopy() {
        final Map<String, Object> copy = SerializerHelper.copy(map);
        assertThat(SerializerHelper.toJson(copy), is(SerializerHelper.toJson(map)));
    }
}
