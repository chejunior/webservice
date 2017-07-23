package com.mike.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Game")
public class Game {
   
   private long id;
   private String description;
   private Map<Long, Console> clasifications = new HashMap<Long, Console>();
   public Game() {
      init();
   }
   public long getId() {
      return id;
   }
   public void setId(long id) {
      this.id = id;
   }
   public String getDescription() {
      return description;
   }
   public void setDescription(String description) {
      this.description = description;
   }
   public Map<Long, Console> getClasifications() {
      return clasifications;
   }
   public void setClasifications(Map<Long, Console> clasifications) {
      this.clasifications = clasifications;
   }
   
   @GET
   @Path("consoles/{id}")
   public Console getConsole(@PathParam("id") int consoleId) {
	   return clasifications.get(new Long(consoleId));
   }
   
   final void init() {
	   Console console = new Console();
	   console.setId(444);
	   console.setDescription("Console 444");
	   clasifications.put(console.getId(), console);
   }
   
//   @GET
//   @PATH(games/{id})
//   
   

}
