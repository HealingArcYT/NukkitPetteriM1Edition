package cn.nukkit.network.protocol;

import cn.nukkit.Nukkit;
import com.google.common.io.ByteStreams;
import lombok.ToString;

@ToString()
public class BiomeDefinitionListPacket extends DataPacket {

    // Call the latest version "TAG"
    private static final byte[] TAG; // 361

    static {
        try {
            TAG = ByteStreams.toByteArray(Nukkit.class.getClassLoader().getResourceAsStream("biome_definitions_361.dat"));
        } catch (Exception e) {
            throw new AssertionError("Error whilst loading biome definitions", e);
        }
    }

    @Override
    public byte pid() {
        return ProtocolInfo.BIOME_DEFINITION_LIST_PACKET;
    }

    @Override
    public void decode() {
    }

    @Override
    public void encode() {
        this.reset();
        this.put(TAG);
    }
}
