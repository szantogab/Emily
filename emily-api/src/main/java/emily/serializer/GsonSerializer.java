package emily.serializer;

import com.google.gson.Gson;

import java.lang.reflect.Type;

/**
 * A Gson Serializer implementation that uses the given Gson object passed in the constructor.
 * <p><b>
 * Note: for this implementation to work, the Gson library needs to be added to the classpath.
 * </b></p>
 *
 * @author Gabor Szanto
 * @since 1.0
 */
public class GsonSerializer implements Serializer {
    private Gson gson;

    public GsonSerializer(Gson gson) {
        this.gson = gson;
    }

    public <T> T deserialize(String s, Type type) throws SerializerException {
        try {
            return gson.fromJson(s, type);
        } catch (Exception e) {
            throw new SerializerException("Failed to deserialize string", e);
        }
    }

    // serialize the given object and save it to file
    public String serialize(Object obj) throws SerializerException {
        try {
            return gson.toJson(obj);
        } catch (Exception e) {
            throw new SerializerException("Failed to serialize string", e);
        }
    }

    protected Gson getGson() {
        return gson;
    }
}
