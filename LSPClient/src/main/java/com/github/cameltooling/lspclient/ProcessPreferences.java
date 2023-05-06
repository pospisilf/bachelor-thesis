package com.github.cameltooling.lspclient;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.List;
import org.openide.util.NbPreferences;

/**
 * Function to process Language Client preferences from UI.
 * 
 * @author Filip Pospisil - xpospi0f
 */
public class ProcessPreferences {

    // Default values for variables: 
    public static final String VERSION_DEFAULT = null; // Default version
    public static final Integer PROVIDER_DEFAULT = 0; // Default
    public static final String COMPONENTS_DEFAULT = null; // Empty
    public static final String KAFKA_DEFAULT = "localhost:9092";

    public static final Boolean ADVANCED_FLAG_DEFAULT = false;

    public static final Boolean CUSTOM_SERVER_FLAG_DEFAULT = false;
    public static final String CUSTOM_SERVER_PATH_DEFAULT = "";

    public static final String XML_MIME = "text/xml";
    public static final String JAVA_MIME = "text/java";
    public static final String YAML_MIME = "text/yaml";
    
    // Variables for creating JSON with preferences:
    private static final String TOP_NODE_CAMEL_KEY = "camel";
    static final String CAMEL_CATALOG_VERSION_PREF_KEY = "Camel catalog version";
    static final String CAMEL_ADDITIONAL_COMPONENT_PREF_KEY = "extra-components";
    static final String CAMEL_CATALOG_RUNTIME_PROVIDER_PREF_KEY = "Camel catalog runtime provider";
    public static final String KAFKA_CONNECTION_URL = "Kafka Connection URL";

    /**
     * Calcualcte absolute path to Camel Language Server.
     * @return Path to Language server. 
     */
    public static String calcualateAbsoluteServerPath() {
        String customPath = NbPreferences.forModule(ApacheCamelPanel.class).get("customServerPath", "");
        if (isAdvancedSetupUsed() && !customPath.isEmpty()) {
            return customPath;
        } else {
            return "libs/camel-lsp-server-1.9.1.jar";
        }
    }

    /**
     * Checks, if advanced setup is activated.
     * @return true/false.
     */
    private static boolean isAdvancedSetupUsed() {
        return NbPreferences.forModule(ApacheCamelPanel.class).getBoolean("advancedPreference", false);
    }

    /**
     * Gets user preferences and returns them as JSON format accepted by Camel Langauge Server.
     * @return User preferences in format accepted by Camel Language Server.
     */
    public static Map<String, Map<String, Object>> getPreferenceAsLanguageServerFormat() {
        Map<String, Map<String, Object>> settings = new HashMap<>();
        Map<String, Object> camelSettings = new HashMap<>();
        camelSettings.put(CAMEL_CATALOG_VERSION_PREF_KEY, NbPreferences.forModule(ApacheCamelPanel.class).get("versionPreference", ProcessPreferences.VERSION_DEFAULT));
        camelSettings.put(CAMEL_CATALOG_RUNTIME_PROVIDER_PREF_KEY, getProviderAsString());
        camelSettings.put(CAMEL_ADDITIONAL_COMPONENT_PREF_KEY, getAdditionalComponentIfValid());
        camelSettings.put(KAFKA_CONNECTION_URL, NbPreferences.forModule(ApacheCamelPanel.class).get("kafkaPreference", ProcessPreferences.KAFKA_DEFAULT));
        settings.put(TOP_NODE_CAMEL_KEY, camelSettings);
        return settings;
    }

    /**
     * Gets Additional Component from user preferences and checks if they're valid. If so, they're added to list.  
     * @return List of components.
     */
    private static List<?> getAdditionalComponentIfValid() {
        String additionalComponentAsString = NbPreferences.forModule(ApacheCamelPanel.class).get("additionalComponents", ProcessPreferences.COMPONENTS_DEFAULT);
        if (additionalComponentAsString != null && !additionalComponentAsString.isEmpty()) {
            try {
                return new Gson().fromJson(additionalComponentAsString, List.class);
            } catch (JsonSyntaxException ex) {
                return Collections.emptyList();
            }
        }
        return Collections.emptyList();
    }

    /**
     * Converts Catalog provider from preferences to String.
     * @return Catalog provider as String.
     */
    private static String getProviderAsString() {
        switch (NbPreferences.forModule(ApacheCamelPanel.class).getInt("providerPreference", ProcessPreferences.PROVIDER_DEFAULT)) {
            case 1:
                return "SPRINGBOOT";
            case 2:
                return "QUARKUS";
            case 3:
                return "KARAF";
            default:
                return "DEFAULT";
        }
    }
}
