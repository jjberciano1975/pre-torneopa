package servicios;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



import entities.Users;
import persistence.UsersCrud;

@Path("/UserRestful")
public class UserRestful extends Users {
	public UserRestful(String name, String email, int idUser) {
		super(name, email, idUser);
		// TODO Auto-generated constructor stub
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public  List<Users> getUser() {
		 System.out.println ("hola");
		 List<Users> users =	UsersCrud.cargalista();
		  return users;
	}
	
	
	
}
