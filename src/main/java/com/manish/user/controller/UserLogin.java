package com.manish.user.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.manish.user.dao.UserDao;
import com.manish.user.daoImpl.UserDaoImpl;
import com.manish.user.pojo.User;

@Path("/detail")
public class UserLogin {

	public static Map<String, String> userMap = new HashMap<String, String>();
	public static User currUser;
	UserDao userDao = new UserDaoImpl();

	@GET
	@Path("/getUsers")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser() {
		List<User> userList = userDao.getAllUsers();
		return Response.status(Response.Status.OK).entity(userList).type(MediaType.APPLICATION_JSON).build();
	}

	@GET
	@Path("/userInfo/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLink(@PathParam("id") String id) {
		System.out.println(userMap.get(id));
		if (currUser.getExposure().equals("public"))
			return Response.status(Response.Status.OK).entity(userMap.get(id)).type(MediaType.APPLICATION_JSON).build();
		return Response.status(Response.Status.UNAUTHORIZED).entity("User is not authorized to access content")
				.type(MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/login")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createUser(User user) {
		System.out.println(user.getPassword());

		return Response.status(Response.Status.OK).entity(user).type(MediaType.APPLICATION_JSON).build();
	}

	@POST
	@Path("/createUser")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response createUser(@FormParam("userContent") String userContent, @FormParam("expiration") int expiration,
			@FormParam("exposure") String exposure, @FormParam("name") String name,
			@FormParam("password") String password) {
		User user = new User();
		user.setExpiration(expiration);
		user.setName(name);
		user.setExposure(exposure);
		user.setPassword(password);
		user.setUserContent(userContent);
		User userResponse = userDao.createUser(user);
		currUser = userResponse;
		userMap.put(userResponse.getUidLink().toString(), userResponse.getUserContent());
		return Response.status(Response.Status.OK).entity("User Created SuccessFully '" + userResponse.getUidLink().toString()+ "'").build();
	}
}
