package mcjty.rftools.blocks.security;

import mcjty.lib.container.ContainerFactory;
import mcjty.lib.container.GenericContainer;
import mcjty.lib.container.SlotDefinition;
import mcjty.lib.container.SlotType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class SecurityManagerContainer extends GenericContainer {

    public static final String CONTAINER_INVENTORY = "container";

    public static final int SLOT_CARD = 0;
    public static final int SLOT_LINKER = 1;
    public static final int SLOT_BUFFER = 2;
    public static final int BUFFER_SIZE = (3*4);
    public static final int SLOT_PLAYERINV = SLOT_CARD + BUFFER_SIZE + 2;

    public static final ContainerFactory factory = new ContainerFactory() {
        @Override
        protected void setup() {
            addSlotBox(new SlotDefinition(SlotType.SLOT_SPECIFICITEM, new ItemStack(SecuritySetup.securityCardItem)), CONTAINER_INVENTORY, SLOT_CARD, 10, 7, 1, 18, 1, 18);
            addSlotBox(new SlotDefinition(SlotType.SLOT_SPECIFICITEM, new ItemStack(SecuritySetup.securityCardItem)), CONTAINER_INVENTORY, SLOT_LINKER, 42, 7, 1, 18, 1, 18);
            addSlotBox(new SlotDefinition(SlotType.SLOT_SPECIFICITEM, new ItemStack(SecuritySetup.securityCardItem)), CONTAINER_INVENTORY, SLOT_BUFFER, 10, 124, 3, 18, 4, 18);
            layoutPlayerInventorySlots(74, 124);
        }
    };

    public SecurityManagerContainer(EntityPlayer player, IInventory containerInventory) {
        super(factory);
        addInventory(CONTAINER_INVENTORY, containerInventory);
        addInventory(ContainerFactory.CONTAINER_PLAYER, player.inventory);
        generateSlots();
    }
}
