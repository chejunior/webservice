package ch01.ts;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

class TimeClient {

   public static void main(String[] args) throws MalformedURLException {
      URL url = new URL("http://localhost:9876/ts?wsdl");
      QName qname = new QName("http://ts.ch01/", "TimeServerImplService");
      Service service = Service.create(url, qname);
      TimeServer eif = service.getPort(TimeServer.class);
      System.out.println(eif.getTimeAsString());
      System.out.println(eif.getTimeAsElapsed());

   }

}
