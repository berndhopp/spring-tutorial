package org.vaadin.guice.tutorial;

import com.google.inject.Inject;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.guice.annotation.GuiceUI;
import com.vaadin.guice.annotation.GuiceVaadinConfiguration;
import com.vaadin.guice.bus.BusModule;
import com.vaadin.guice.server.GuiceVaadinServlet;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

import org.vaadin.guice.tutorial.components.RootLayout;
import org.vaadin.guice.tutorial.components.ViewContainer;
import org.vaadin.guice.tutorial.di.TutorialTranslationModule;
import org.vaadin.guice.tutorial.di.TutorialSecurityModule;
import org.vaadin.guice.tutorial.views.ErrorView;

import javax.servlet.annotation.WebServlet;

@Theme("valo")
@GuiceUI(viewContainer = ViewContainer.class, errorView = ErrorView.class)
public class MyVaadinUI extends UI {

    @Inject
    private RootLayout root;

    @Override
    protected void init(VaadinRequest request) {
        setContent(root);
    }

    @WebServlet(urlPatterns = "/*", name = "MyVaadinServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyVaadinUI.class, productionMode = false)
    @GuiceVaadinConfiguration(
        modules = {
            TutorialTranslationModule.class,
            TutorialSecurityModule.class,
            BusModule.class
        },
        basePackages = "org.vaadin.guice.tutorial"
    )
    public static class MyVaadinServlet extends GuiceVaadinServlet {
    }
}