package com.iodesystems.ferret;

import com.iodesystems.ferret.file.FerretReader;
import com.iodesystems.ferret.xsd.Ferret;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class FerretApplication {


    private final FerretReader reader;
    private final Ferret ferret;
    private final Exception error;

    public FerretApplication(Exception error) {
        this(null, null, error);
    }

    public FerretApplication() {
        this(null, null, null);
    }

    public FerretApplication(FerretReader reader, Ferret ferret) {
        this(reader, ferret, null);
    }

    public FerretApplication(FerretReader reader, Ferret ferret, Exception error) {
        this.reader = reader;
        this.ferret = ferret;
        this.error = error;
    }

    public void service(HttpServletRequest req, HttpServletResponse rsp) throws IOException, ServletException {
        if (error == null) {
            req.setAttribute("ferret", ferret);
            req.getRequestDispatcher("ferret.jsp").forward(req, rsp);
        } else {
            rsp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            PrintWriter writer = rsp.getWriter();
            writer.println(error.getMessage());
            error.printStackTrace(writer);
        }

    }
}
