package com.iodesystems.ferret.servlet;

import com.iodesystems.ferret.FerretApplication;
import com.iodesystems.ferret.file.FerretFileWatcher;
import com.iodesystems.ferret.file.FerretReader;
import com.iodesystems.ferret.xsd.Ferret;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FerretServlet extends GenericServlet {
    FerretApplication ferretApplication = new FerretApplication();
    FerretReader ferretReader = new FerretReader();

    @Override
    public void init() throws ServletException {
        new FerretFileWatcher(ferretReader) {

            @Override
            public void onError(Exception e) {
                ferretApplication = new FerretApplication(e);
            }

            @Override
            public void onFerret(Ferret ferret) {
                ferretApplication = new FerretApplication(ferretReader, ferret);
            }
        }.start();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        if (req instanceof HttpServletRequest && res instanceof HttpServletResponse) {
            HttpServletRequest request = (HttpServletRequest) req;
            HttpServletResponse response = (HttpServletResponse) res;
            service(request, response);
        }
    }

    protected void service(HttpServletRequest req, HttpServletResponse rsp)
        throws ServletException, IOException {
        ferretApplication.service(req, rsp);
    }

}
