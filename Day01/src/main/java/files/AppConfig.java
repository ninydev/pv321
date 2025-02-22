package files;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.cdimascio.dotenv.Dotenv;
import lombok.Getter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.nio.file.Files;

public class AppConfig {
    private static final Dotenv dotenv = Dotenv.load();
    Logger logger = LogManager.getLogger("AppLogger");

    @Getter
    private AppConfigEntity appConfigEntity;

    String fileName;

    public AppConfig() {
        appConfigEntity = new AppConfigEntity();
        fileName = dotenv.get("APP_CONFIG_FILE");
    }

    public AppConfig(AppConfigEntity appConfigEntity) {
        this.appConfigEntity = appConfigEntity;
        fileName = dotenv.get("APP_CONFIG_FILE");
    }

    private static final ObjectMapper objectMapper = new ObjectMapper(); // Создаем объект ObjectMapper

    // Метод для сохранения объекта конфигурации в файл
    public void saveToFile() {
        System.out.println("Save fo file: " + fileName);

        // Проверка и создание директорий, если они не существуют
        File file = new File(fileName);
        File parentDir = file.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            // Создаем все необходимые папки, если они отсутствуют
            try {
                Files.createDirectories(parentDir.toPath());
            } catch (Exception e) {
                logger.error(e.getMessage());
            }
        }

        try {
            objectMapper.writeValue(new File(fileName), appConfigEntity); // Сохраняем в файл
            System.out.println("Configuration saved to file: " + appConfigEntity);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    // Метод для загрузки конфигурации из файла
    public void loadFromFile() {
        System.out.println("Load from file: " + fileName);
        try {
            this.appConfigEntity = objectMapper.readValue(new File(fileName), AppConfigEntity.class); // Читаем из файла
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        System.out.println("Configuration loaded from file: \n" + appConfigEntity);
    }

}
