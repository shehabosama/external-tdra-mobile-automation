package pages.HomePage;

import org.yaml.snakeyaml.DumperOptions;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.Map;

public class ReadWriteBsID {

    public static void main(String[] args) {
        writeTheBS_ID();
    }
    static public void writeTheBS_ID()
    {
        try {

          //  String path1 = "..\\..\\..\\browserstack.yml";
            String path1 = "D:\\busniss\\external-tdra-mobile-automation\\browserstack.yml";
            // YAML to Map
            final DumperOptions options = new DumperOptions();
            options.setDefaultFlowStyle(DumperOptions.FlowStyle.BLOCK);
            options.setPrettyFlow(true);
            final Yaml yaml = new Yaml(options);
            Map<String, Object> map = yaml.load(new FileInputStream(path1));
            // fill data to map
            map.put("app", readBS_ID());
// Map to YAML
            final FileWriter writer = new FileWriter(path1);
            yaml.dump(map, writer);
        } catch (IOException e) {
            System.err.println("Error when we try to save new property.yml");
            throw new RuntimeException(e);
        }
    }
    static public String readBS_ID(){
        String filePath = "D:\\busniss\\external-tdra-mobile-automation\\browserstackID.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // Process each line of the file
                System.out.println(line);
                return line;
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
