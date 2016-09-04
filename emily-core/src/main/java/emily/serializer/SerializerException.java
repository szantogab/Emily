package emily.serializer;

/**
 * This exception is thrown by @{@link Serializer}s when de/serialization fails.
 *
 * @author szantogabor
 * @since 1.0
 */

class SerializerException extends RuntimeException {
    public SerializerException() {
    }

    public SerializerException(String message) {
        super(message);
    }

    public SerializerException(String message, Throwable cause) {
        super(message, cause);
    }

    public SerializerException(Throwable cause) {
        super(cause);
    }
}
