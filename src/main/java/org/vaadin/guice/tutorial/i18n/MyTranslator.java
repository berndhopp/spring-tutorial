package org.vaadin.guice.tutorial.i18n;

import com.vaadin.guice.annotation.UIScope;
import com.vaadin.guice.i18n.Translator;
import com.vaadin.server.VaadinSession;

@UIScope
public class MyTranslator implements Translator {
    @Override
    public String translate(String template) {
        switch (template) {
            case "error":
                switch (VaadinSession.getCurrent().getLocale().getLanguage()) {
                    case "de":
                        return "irgendwas lief falsch";
                    default:
                        return "something went wrong";
                }
            case "another_view_scoped_view_button_text":
                switch (VaadinSession.getCurrent().getLocale().getLanguage()) {
                    case "de":
                        return "noch ein view-scoped view";
                    default:
                        return "another view-scoped view";
                }
            case "view_scoped_view_button_text":
                switch (VaadinSession.getCurrent().getLocale().getLanguage()) {
                    case "de":
                        return "ein view-scoped view";
                    default:
                        return "a view-scoped view";
                }
            case "ui_scoped_view_button_text":
                switch (VaadinSession.getCurrent().getLocale().getLanguage()) {
                    case "de":
                        return "ein ui-scoped view";
                    default:
                        return "an ui-scoped view";
                }
            case "default_view_label":
                switch (VaadinSession.getCurrent().getLocale().getLanguage()) {
                    case "de":
                        return "das ist der standard view";
                    default:
                        return "this is the default view";
                }
            case "view_scoped_view_label":
                switch (VaadinSession.getCurrent().getLocale().getLanguage()) {
                    case "de":
                        return "das ist der view-scope view";
                    default:
                        return "this is the view-scope view";
                }
            default:
                return "template not found";
        }
    }
}
