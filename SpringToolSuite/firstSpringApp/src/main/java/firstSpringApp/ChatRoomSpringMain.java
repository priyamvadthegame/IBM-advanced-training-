package firstSpringApp;

import java.util.Map;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ChatRoomSpringMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractApplicationContext iocContainer=new ClassPathXmlApplicationContext("Beans_Assignment3.xml");
		Map<String,ChatRoomSpring> orderMap=iocContainer.getBeansOfType(ChatRoomSpring.class);
		for(String key :orderMap.keySet())
		{
			ChatRoomSpring chatroom=orderMap.get(key);
			System.out.println(chatroom);
		}
		
	}

}
