/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.*;
import entity.*;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author user
 */
@WebFilter("/*")
public class LoginFilter implements Filter{

    KullaniciGirisiDao kgd=new KullaniciGirisiDao();
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        String url = req.getRequestURI();
        KullaniciGirisi kul = (KullaniciGirisi) req.getSession().getAttribute("simdiki_kul");
        if (kul == null) {
            if (url.contains("secret") || url.contains("cikisyap")) {
            res.sendRedirect(req.getContextPath()+"/module/kullanicigirisi.xhtml");
                
            } else {
                chain.doFilter(request, response);
            }

        } else {
if(url.contains("kullanicikayit")||url.contains("kullanicigirisi")){
                res.sendRedirect(req.getContextPath()+"/secret/secret.xhtml");
}
else if(url.contains("cikisyap")){
    req.getSession().invalidate();
    getKgd().setIcerdemi(false);
    res.sendRedirect(req.getContextPath()+"cikisyap.xhtml");
}

else{
chain.doFilter(request, response);
}
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       
    }

    @Override
    public void destroy() {
    }

    public KullaniciGirisiDao getKgd() {
        if(this.kgd==null)
            this.kgd=new KullaniciGirisiDao();
        return kgd;
    }



}