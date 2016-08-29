package com.iodesystems.ferret;

import com.iodesystems.ferret.route.Router;
import com.iodesystems.ferret.ui.UiResolver;
import com.iodesystems.ferret.xsd.Ferret;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FerretApplication {

    private final Ferret ferret;
    private final Exception error;
    private final Router router;
    private final UiResolver uiResolver;

    public FerretApplication() {
        this(null, null);
    }

    public FerretApplication(Ferret ferret, Exception error) {
        this.error = error;
        this.ferret = ferret;
        this.uiResolver = new UiResolver(ferret.getUi());
        this.router = new Router();
    }

    public void service(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        if (error == null) {
            req.setAttribute("ferret", ferret);
        } else {
            rsp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            PrintWriter writer = rsp.getWriter();
            writer.println(error.getMessage());
            error.printStackTrace(writer);
        }

    }
}
