package egitim.uniyaz;
import javax.servlet.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FindAllPersonServlet implements Servlet {
    List<Personel> listPersonel=new ArrayList<Personel>();

    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("Init metodu çalıştı");
    }

    public ServletConfig getServletConfig() {
        System.out.println("ServletConfig metodu çalıştı");
        return null;
    }

    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        Personel personel;
        servletResponse.setCharacterEncoding("UTF-8");
        PrintWriter out = servletResponse.getWriter();
        String islem= servletRequest.getParameter("islem");
        String ad = servletRequest.getParameter("ad");
        String soyad = servletRequest.getParameter("soyad");

        if (islem.equals("listele")){
            System.out.println("Listele işlemi");//console
            out.println("Listeleme islemi");
            for (Personel personel2:listPersonel) {
                System.out.println(personel2.getAd() +" "+ personel2.getSoyad());//console
                out.println(personel2.getAd() +" "+ personel2.getSoyad());
            }
        }
        else if(islem.equals("kaydet")){
            personel=new Personel();
            personel.setAd(ad);
            personel.setSoyad(soyad);
            listPersonel.add(personel);
            System.out.println("Kaydedilen kişi: " +personel.getAd()+" " + personel.getSoyad());//console
            out.println(personel.getAd()+"  " + personel.getSoyad()+" kisisi kaydedildi");

        }
    }


    public String getServletInfo() {
        System.out.println("ServletInfo metodu çalıştı");
        return null;
    }

    public void destroy() {
        System.out.println("Service metodu çalıştı");
    }
}
