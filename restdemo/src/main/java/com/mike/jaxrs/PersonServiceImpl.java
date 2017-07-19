package com.mike.jaxrs;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.core.Response;


public class PersonServiceImpl implements PersonService {
   
   private long currentId = 123;
   private Map<Long, Person> persons = new HashMap<Long, Person>();
   private Map<Long, Game> games = new HashMap<Long, Game>();
   
   public PersonServiceImpl() {
      init();
   }
   
   final void init(){
      Person person = new Person();
      person.setName("Mike");
      person.setId(currentId);
      persons.put(person.getId(), person);
      
      Game game = new Game();
      game.setDescription("FF X");
      game.setId(001);
      games.put(game.getId(), game);
   }

   @Override
   public Person getPerson(String id) {
      // TODO Auto-generated method stub
      return null;
   }

   public Response updatePerson(Person person) {
      // TODO Auto-generated method stub
      return null;
   }

   @Override
   public Response addPerson(Person person) {
      System.out.println("....invoking add person.");
      person.setId(++currentId);
      persons.put(person.getId(), person);
      return Response.ok(person).build();
   }

   @Override
   public Response getGame(String Game) {
      return null;
   }

}
