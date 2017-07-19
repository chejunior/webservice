package com.mike.jaxrs;

import javax.xml.ws.Response;

public interface PersonService {
   
   public abstract Person getPerson(String id);
   
   public abstract Response updatePerson(Person person);
   
   public abstract Response addPerson(Person person);
   
   public abstract Response getGame(String Game);

}
