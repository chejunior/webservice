package com.mike.ws.jaxb;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.mike.ws.generated.v110.Mustang;

public class MarshallUnmarshall {
   
   public static void main (String[] args){
      try {
         JAXBContext context = JAXBContext.newInstance(Mustang.class);
         Marshaller marshaller = context.createMarshaller();
         Mustang mustang = new Mustang();
         mustang.setId(1);
         mustang.setPlaca("RDG451");
         StringWriter st = new StringWriter();
         marshaller.marshal(mustang, st);
         System.out.println(st.toString());
         
         String test = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><mustang xmlns=\"http://www.coolsoft.com/Mustang\"><idxx>1</idxx><placssaa>RDG451</placaassa></mustang>";
         
         Unmarshaller unmarshaller = context.createUnmarshaller();
         Mustang unMustang = (Mustang) unmarshaller.unmarshal(new StringReader(st.toString()));
         System.out.println(unMustang.getPlaca());
      } catch (JAXBException e) {
         e.printStackTrace();
      }
      
   }

}
