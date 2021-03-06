package mcjty.rftools.api.dimension;

/**
 * RFTools dimension providers will implement this interface. You can query for this to ask information
 * about this dimension:
 *     (RFToolsWorldProvider)(world.provider)
 */
public interface RFToolsWorldProvider {
    /**
     * Get the amount of RF left in this dimension (only works server-side).
     */
    int getCurrentRF();
}
