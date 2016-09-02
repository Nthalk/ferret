package com.iodesystems.ferret.servlet;

import com.iodesystems.ferret.file.FileWatcher;
import com.iodesystems.ferret.xsd.Ferret;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;

public class FerretServlet extends GenericServlet {
    ApplicationContext applicationContext;
    @Override
    public void init() throws ServletException {
        new FileWatcher() {
            @Override
            public File getFile() throws Exception {
                return new File(System.getProperty("ferret.home") + "/ferret.xml");
            }

            @Override
            public void onFileChange(File file) throws Exception {
                applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml");
                System.out.println();
            }

            @Override
            public void onError(Exception e) {

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
    }

}
