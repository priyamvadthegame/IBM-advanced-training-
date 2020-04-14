package com.springdata.restApi.Utils;

import com.springdata.restApi.entity.MessageEntity;
import com.springdata.restApi.json.Message;

public class MessageUtils {

	public static MessageEntity convertMessageJsonToMessageEntity(Message message)
	{
		return new MessageEntity(message.getId(),message.getMessage(),UserUtils.convertUserToUserEntity(message.getUserSendingMessage()),AdvertisementUtils.convertAdvJsonToAdvEntity( message.getForAdvertisement()));
	}
	
	public static Message convertMessageEntityToMessageJson(MessageEntity message)
	{
		return new Message(message.getId(),message.getMessage(),UserUtils.convertUserEntityToUser(message.getUserSendingMessage()),AdvertisementUtils.convertAdvEntityToAdvJson(message.getForAdvertisement()));
	}
}
