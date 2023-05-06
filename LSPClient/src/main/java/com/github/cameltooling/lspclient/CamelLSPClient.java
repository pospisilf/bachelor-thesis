package com.github.cameltooling.lspclient;

import java.io.IOException;
import org.netbeans.api.editor.mimelookup.MimeRegistration;
import org.netbeans.api.editor.mimelookup.MimeRegistrations;
import org.netbeans.modules.lsp.client.spi.LanguageServerProvider;
import org.openide.util.Exceptions;
import org.openide.util.Lookup;

/**
 * Main class for Apache Camel Langauge Client. 
 * 
 * @author Filip Pospisil - xpospi0f
 */
@MimeRegistrations({
    @MimeRegistration(service = LanguageServerProvider.class,
            mimeType = ProcessPreferences.XML_MIME),
    @MimeRegistration(service = LanguageServerProvider.class,
            mimeType = ProcessPreferences.YAML_MIME),
    @MimeRegistration(service = LanguageServerProvider.class,
            mimeType = ProcessPreferences.JAVA_MIME)
})
public class CamelLSPClient implements LanguageServerProvider {
    @Override
    public LanguageServerProvider.LanguageServerDescription startServer(Lookup lkp) {

        try {
            Process p = new ProcessBuilder("java", "-jar", ProcessPreferences.calcualateAbsoluteServerPath()).start();
            return LanguageServerProvider.LanguageServerDescription.create(p.getInputStream(), p.getOutputStream(), p, ProcessPreferences.getPreferenceAsLanguageServerFormat());

        } catch (IOException ex) {
            Exceptions.printStackTrace(ex);
            return null;
        }
    }
}
