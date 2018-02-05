package bd;

import java.util.List;

import entities.Users;
import persistence.UsersCrud;



public class Probador {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 List<Users> users =	UsersCrud.cargalista();
		 System.out.println (users);
	}
}
