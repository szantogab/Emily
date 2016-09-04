package emily.serializer;

import android.util.Base64;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Type;

/**
 * A simple Serializer implementation that uses the built-in Java serialization mechanism.
 * <p><b>
 * Note: for this implementation to work, the objects to be serialized must implement the {@link Serializable} interface.
 * </b></p>
 *
 * @author Gabor Szanto
 * @since 1.0
 */
public class SimpleSerializer implements Serializer {
    @SuppressWarnings("unchecked")
    public <T> T deserialize(String s, Type type) throws SerializerException {
        try {
            byte[] data = Base64.decode(s, Base64.DEFAULT);
            ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(data));

            Object o = ois.readObject();
            ois.close();
            return (T) o;
        } catch (Exception e) {
            throw new SerializerException("Failed to deserialize string", e);
        }
    }

    // serialize the given object and save it to file
    public String serialize(Object obj) throws SerializerException {
        try {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(obj);
            oos.close();
            return Base64.encodeToString(baos.toByteArray(), Base64.DEFAULT);
        } catch (Exception e) {
            throw new SerializerException("Failed to serialize string", e);
        }
    }
}
