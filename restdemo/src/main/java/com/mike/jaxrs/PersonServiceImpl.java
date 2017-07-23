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

	final void init() {
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
		System.out.println("GET person: ID:" + id);
		Long personId = Long.parseLong(id);
		return persons.get(personId);
	}

	@Override
	public Response updatePerson(Person person) {
		Person currentPerson = persons.get(person.getId());

		if (currentPerson != null) {
			System.out.println("UPDATE person: Name:" + person.getName());
			persons.put(person.getId(), person);
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}

	}

	@Override
	public Response addPerson(Person person) {
		System.out.println("ADD person: Name:" + person.getName());
		person.setId(++currentId);
		persons.put(person.getId(), person);
		return Response.ok(person).build();
	}

	@Override
	public Response deletePerson(String id) {
		Long personId = Long.parseLong(id);
		Person person = persons.get(personId);
		if (person != null) {
			System.out.println("DELETE person: Name:" + person.getName());
			persons.remove(personId);
			return Response.ok().build();
		} else {
			return Response.notModified().build();
		}

	}

	@Override
	public Game getGame(String gameId) {
		long id = Long.parseLong(gameId);
		Game game = games.get(id);
		return game;
	}

}
