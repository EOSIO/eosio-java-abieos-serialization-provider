package one.block.eosiojavaabieosserializationprovider;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * This class holds the JSON templates for ABI conversion as immutable static Maps.  These are used
 * to serialize/deserialize specific types.
 */
public class AbiEosJson {
    private static List<String> abiFiles = Arrays.asList("eosio.assert.abi.json", "transaction.abi.json",
            "packed.transaction.abi.json", "ship.abi.json");
    public static final Map<String, String> abiEosJsonMap = initAbiEosJsonMap();

    /**
     * Initialize an immutable static map with the JSON templates for ABI and Transaction
     * serialization and deserialization.  These are used as inputs to the ABIEOS C++
     * serialization provider implementation.
     * @return - Immutable map containing the ABI and Transaction JSON serilization/deserialization templates.
     */
    private static Map<String, String> initAbiEosJsonMap() {
        Map<String, String> jsonMap = new HashMap<>();
        ClassLoader classLoader = AbiEosJson.class.getClassLoader();
        String jsonContent;

        for (String fileName: abiFiles) {
            File f = new File(classLoader.getResource("abi/" + fileName).getFile());

            try {
                jsonContent = new String(Files.readAllBytes(f.toPath()));
                jsonMap.put(fileName, jsonContent);
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }
        return Collections.unmodifiableMap(jsonMap);
    }

}
