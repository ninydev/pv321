package files;

import io.github.cdimascio.dotenv.Dotenv;

public class ReadEnv {
    private static final Dotenv dotenv = Dotenv.load();

    public static void main(String[] args) {
        System.out.println(dotenv.get("APP_CONFIG_FILE"));
    }

}
