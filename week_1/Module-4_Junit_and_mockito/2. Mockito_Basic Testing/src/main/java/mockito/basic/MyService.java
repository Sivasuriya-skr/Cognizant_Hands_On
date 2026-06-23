package mockito.basic;

/**
 * A service class that depends on ExternalApi.
 */
public class MyService {
    private final ExternalApi externalApi;

    /**
     * Constructs MyService with its required dependency.
     *
     * @param externalApi the external API dependency
     */
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    /**
     * Fetches data using the external API.
     *
     * @return the fetched data String
     */
    public String fetchData() {
        return externalApi.getData();
    }
}
