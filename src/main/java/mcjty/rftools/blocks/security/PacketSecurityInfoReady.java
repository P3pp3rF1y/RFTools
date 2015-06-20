package mcjty.rftools.blocks.security;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import io.netty.buffer.ByteBuf;
import mcjty.rftools.blocks.teleporter.PlayerName;
import mcjty.rftools.network.NetworkTools;

import java.util.List;

public class PacketSecurityInfoReady implements IMessage, IMessageHandler<PacketSecurityInfoReady, IMessage> {

    private SecurityChannels.SecurityChannel channel;


    @Override
    public void fromBytes(ByteBuf buf) {
        channel = new SecurityChannels.SecurityChannel();
        channel.setName(NetworkTools.readString(buf));
        channel.setWhitelist(buf.readBoolean());
    }

    @Override
    public void toBytes(ByteBuf buf) {
        NetworkTools.writeString(buf, channel.getName());
        buf.writeBoolean(channel.isWhitelist());
    }

    public PacketSecurityInfoReady() {
    }

    public PacketSecurityInfoReady(SecurityChannels.SecurityChannel channel) {
        this.channel = channel;
    }

    @Override
    public IMessage onMessage(PacketSecurityInfoReady message, MessageContext ctx) {
        GuiSecurityManager.channelFromServer = message.channel;
        return null;
    }
}