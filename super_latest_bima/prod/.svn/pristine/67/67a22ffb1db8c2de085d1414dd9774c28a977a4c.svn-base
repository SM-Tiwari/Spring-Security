package com.gnv.d3.fcm.scheduler.config;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

/**
 * <pre>
 *  com.gnv.d3.fcm.scheduler.config.PropertiesLoader 
 * </pre>
 *
 * @author edwin < edwinkun at gmail dot com >
 * Jun 10, 2017 11:34:30 PM
 *
 */
public class PropertiesLoader {

    private static final PropertiesLoader PROPERTIES_LOADER = new PropertiesLoader();
    private Properties properties;
    
    private PropertiesLoader() {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(new File("app.properties"));
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
                
        }
    }
    
    public static PropertiesLoader getPropertiesLoader() {
        return PROPERTIES_LOADER;
    }

    public Properties getProperties() {
        return properties;
    }
}
