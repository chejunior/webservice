package com.mike.jaxrs;

import java.util.HashMap;
import java.util.Map;

public class Game {
   
   private long id;
   private String description;
   private Map<Long, Console> clasifications = new HashMap<Long, Console>();
   public Game() {
//      init();
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
   
//   @GET
//   @PATH(games/{id})
//   
   

}
