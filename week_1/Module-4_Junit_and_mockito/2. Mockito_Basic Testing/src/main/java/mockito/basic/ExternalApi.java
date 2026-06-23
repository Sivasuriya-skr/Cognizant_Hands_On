package mockito.basic;

/**
 * An interface representing an external API dependency.
 */
public interface ExternalApi {
    /**
     * Fetches data from the external source.
     *
     * @return data as a String
     */
    String getData();
}
