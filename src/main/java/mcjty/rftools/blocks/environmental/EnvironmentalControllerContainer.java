package mcjty.rftools.blocks.environmental;

import mcjty.lib.container.ContainerFactory;
import mcjty.lib.container.GenericContainer;
import mcjty.lib.container.SlotDefinition;
import mcjty.lib.container.SlotType;
import net.minecraft.entity.player.EntityPlayer;

public class EnvironmentalControllerContainer extends GenericContainer {
    public static final String CONTAINER_INVENTORY = "container";

    public static final int SLOT_MODULES = 0;
    public static final int ENV_MODULES = 7;

    public static final ContainerFactory factory = new ContainerFactory() {
        @Override
        protected void setup() {
            addSlotBox(new SlotDefinition(SlotType.SLOT_INPUT), CONTAINER_INVENTORY, SLOT_MODULES, 7, 7, 1, 18, ENV_MODULES, 18);
            layoutPlayerInventorySlots(9, 142);
        }
    };


    public EnvironmentalControllerContainer(EntityPlayer player, EnvironmentalControllerTileEntity containerInventory) {
        super(factory);
        addInventory(CONTAINER_INVENTORY, containerInventory);
        addInventory(ContainerFactory.CONTAINER_PLAYER, player.inventory);
        generateSlots();
    }
}
