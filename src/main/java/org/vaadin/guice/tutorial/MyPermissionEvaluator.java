package org.vaadin.guice.tutorial;

import com.vaadin.guice.annotation.UIScope;
import com.vaadin.guice.security.PermissionEvaluator;
import com.vaadin.server.VaadinSession;

@UIScope
public class MyPermissionEvaluator implements PermissionEvaluator {
    @Override
    public boolean hasPermission(String permission) {

        //don't try this in production mode, but for the sake of simplicity..
        switch (permission){
            case "admin":
                return VaadinSession.getCurrent().getAttribute(CurrentUserRole.class) == CurrentUserRole.ADMIN;
            default:
                return true;
        }
    }
}
