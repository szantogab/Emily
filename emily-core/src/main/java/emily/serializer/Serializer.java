package emily.serializer;

import java.lang.reflect.Type;

/**
 * An interface for serializing objects.
 *
 * @author Gabor Szanto
 * @since 1.0
 */
public interface Serializer {
    /**
     * Implementations should deserialize a given string to the given type.
     *
     * @param serialized The serialized string.
     * @param type       The type of the deserialized class. <b>Note: If the implementation can find out the type from the serialized string itself, then this parameter can be ignored.</b>
     * @return The deserialized object.
     * @throws SerializerException Throws this exception when the deserialization failed.
     */
    <T> T deserialize(String serialized, Type type) throws SerializerException;

    /**
     * Implementations should serialize a given object to a string.
     *
     * @param obj The object to serialize.
     * @return The serialized string.
     * @throws SerializerException Throws this exception when the serialization failed.
     */
    String serialize(Object obj) throws SerializerException;
}
