package restApi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/advertsise")
public class Controller {
	List<UserRestApi> userMasterList=new ArrayList<UserRestApi>();
	Map<String,UserRestApi>  loggedUserMap=new HashMap<String,UserRestApi>();
	@PostMapping(value="/login", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String loginUser(@RequestBody JsonStringCheckPojo userNamrAndPassword)
	{	
		if(!(userNamrAndPassword==null))
		{
			Optional<UserRestApi> userApiStream=userMasterList.stream().filter((UserRestApi userCheck)-> userNamrAndPassword.getInput1().equals(userCheck.getUserName())&&userNamrAndPassword.getInput2().equals(userCheck.getPassword())).findAny();
			if(userApiStream.isPresent())
			{
				UserRestApi loggingInUser=userMasterList.stream().filter((UserRestApi userCheck)-> userNamrAndPassword.getInput1().equals(userCheck.getUserName())&&userNamrAndPassword.getInput2().equals(userCheck.getPassword())).collect(Collectors.toList()).get(0);
				loggedUserMap.put((loggingInUser.getUserName()+loggingInUser.getPhone()).toLowerCase(),loggingInUser);
				return "Succesfully LoggedIn";
			}
		}
		return "Authentication failed";
	}
	@PostMapping(value="/register", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String registerUser(@RequestBody UserRestApi user)
	{	
		if(!(user==null))
		{
			Stream<UserRestApi> userApiStream=userMasterList.stream().filter((UserRestApi userCheck)-> user.equals(userCheck));
			if(!(userApiStream.findAny().isPresent()&&user.getUserName().equals("")&&user.getPassword().equals("")))
			{
				userMasterList.add(user);
				return "Succesfully Registerd";
			}
			else
			{
				return "UserName Already exists";
			}
		}
		return "Authentication failed";
	}
	@PostMapping(value="/addadvertise", consumes=MediaType.APPLICATION_JSON_VALUE, produces=MediaType.APPLICATION_JSON_VALUE)
	public String addAdvertise(@RequestBody Advertisement advertisement,@RequestHeader(name="authToken") String authToken)
	{
		if(authToken==null)
		{
			return "{\"result\": \"Auth-token is mandatory\"}";
		}
		if(loggedUserMap.containsKey(authToken))
		{	
			UserRestApi user=loggedUserMap.get(authToken);
			user.setAdvertisementList(advertisement);
			return "Advertisement "+advertisement.toString()+" added to user "+user.getUserName()+" succesfully";
		}
		else
		{
			return "LogIn or register to continue";
		}
	}
	@GetMapping(value ="/getuserlist", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<UserRestApi> getAllUserInformation()
	{
		return this.userMasterList;
	}
	@GetMapping(value = "/getadvofuser",produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Advertisement> getAUserAdvertisementLsit(@RequestHeader(name="authToken") String authToken)
	{	
		if(authToken==null)
		{
			return null;
		}
		if(loggedUserMap.containsKey(authToken))
		{	
			UserRestApi user=loggedUserMap.get(authToken);
			return user.getAdvertisementList();
		}
		else
		{
			return null;
		}
	}
	@PostMapping(value="/logout")
	public String logOut(@RequestHeader(name="authToken") String authToken)
	{
		if(authToken==null)
		{
			return "{\"result\": \"Auth-token is mandatory\"}";
		}
		if(loggedUserMap.containsKey(authToken))
		{	
			UserRestApi userToBeDeleted=loggedUserMap.get(authToken);
			loggedUserMap.remove(authToken);
			return " Logged Out  user "+userToBeDeleted.getUserName()+" succesfully";
		}
		else
		{
			return "LogIn or register to continue";
		}
	}
			

}
