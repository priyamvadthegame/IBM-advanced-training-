var chatroom=new Map();

export function createChatroom()
{
    
    var chatroomSports={name:"Sports",id:1};
    var contentsMap=new Map();
    var userSet=new Set();
    var userMessages=new Set();
    var user1={name:"priyam",
            id:101};
    var user2={name:"abhishek",
            id:101};
    var user3={name:"hemant",
            id:101};
    var mesage1={
        message:"hi",
        id:1
    };
    var mesage2={
        message:"hello",
        id:2
    };
    var mesage3={
        message:"ho gya bro",
        id:3
    };

    userSet.add(user1);
    userSet.add(user2);
    userSet.add(user3);
    
    userMessages.add(mesage1);
    userMessages.add(mesage2);
    userMessages.add(mesage3);

    contentsMap.set("Users",userSet);
    contentsMap.set("Messages",userMessages);
    chatroom.set(chatroomSports,contentsMap);

}

export function getUserList()
    {
        for(var key of chatroom.keys())
        {   
            var chatRoom=chatroom.get(key);
            console.log(key.name);
            for(var users of chatRoom.get("Users"))
            {
                console.log(users);
            }

        }
    }


   export function getMessageList()
    {
        for(var key of chatroom.keys())
        {   
            var chatRoom=chatroom.get(key);
            console.log(key.name+" ");
            for(var messages of chatRoom.get("Messages"))
            {
                console.log(messages);
            }

        }
    }