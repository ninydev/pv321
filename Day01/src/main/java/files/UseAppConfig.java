package files;

public class UseAppConfig {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        appConfig.loadFromFile();
        // System.out.println(appConfig.getAppConfigEntity());

//        AppConfigEntity appConfigEntity = new AppConfigEntity();
//        appConfigEntity.setName("AppConfigEntity");
//        appConfigEntity.setValue(1);
//        appConfigEntity.setEmail("keeper@ninydev.com");
//        appConfigEntity.setPassword("password");
//
//        System.out.println(appConfigEntity);
//
//        AppConfig appConfig = new AppConfig(appConfigEntity);
//
//        appConfig.saveToFile();


    }
}
