package com.github.cameltooling.lspclient;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import org.netbeans.spi.options.OptionsPanelController;
import org.openide.util.HelpCtx;

import org.openide.util.Lookup;

/**
 * Class with control panel for user interface used in Apache Camel Language Client.
 * 
 * @author Filip Pospisil - xpospi0f
 */
@OptionsPanelController.TopLevelRegistration(
        categoryName = "#OptionsCategory_Name_ApacheCamel",
        iconBase = "com/github/cameltooling/lspclient/icon32x32.png",
        keywords = "#OptionsCategory_Keywords_ApacheCamel",
        keywordsCategory = "ApacheCamel"
)
@org.openide.util.NbBundle.Messages({"OptionsCategory_Name_ApacheCamel=Apache Camel", "OptionsCategory_Keywords_ApacheCamel=apache camel preferences"})
public final class ApacheCamelOptionsPanelController extends OptionsPanelController {

    private ApacheCamelPanel panel;
    private final PropertyChangeSupport pcs = new PropertyChangeSupport(this);
    private boolean changed;

    public void update() {
        getPanel().load();
        changed = false;
    }

    public void applyChanges() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                getPanel().store();
                changed = false;
            }
        });
    }

    public void cancel() {
        // need not do anything special, if no changes have been persisted yet
    }

    public boolean isValid() {
        return getPanel().valid();
    }

    public boolean isChanged() {
        return changed;
    }

    public HelpCtx getHelpCtx() {
        return null; // new HelpCtx("...ID") if you have a help set
    }

    public JComponent getComponent(Lookup masterLookup) {
        return getPanel();
    }

    public void addPropertyChangeListener(PropertyChangeListener l) {
        pcs.addPropertyChangeListener(l);
    }

    public void removePropertyChangeListener(PropertyChangeListener l) {
        pcs.removePropertyChangeListener(l);
    }

    private ApacheCamelPanel getPanel() {
        if (panel == null) {
            panel = new ApacheCamelPanel(this);
        }
        return panel;
    }

    void changed() {
        if (!changed) {
            changed = true;
            pcs.firePropertyChange(OptionsPanelController.PROP_CHANGED, false, true);
        }
        pcs.firePropertyChange(OptionsPanelController.PROP_VALID, null, null);
    }

}
