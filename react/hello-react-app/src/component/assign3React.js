import React from 'react';

export class FormComponent extends React.Component
{   
    constructor(props)
    {
        super(props);

        this.state={
            result:""
        }
    }
    
    validation(e)
    {   
        e.preventDefault();
        let username=this.refs.username.value;
        let password=this.refs.password.value;
        /*
        if(username.length<5)
        {
                return Error("username should be more than 5 characters")
        }
       if(password.length<3)
       {
        return Error("password should be more than 3 characters")
       }
       */
      console.log(username);
       if(username===password)
       { console.log(username);
        this.setState({result:"Login Succesfull"})
       }
       else{
        this.setState({result:"Login Failed"});
       }
    }
    
    render()
    {
        return <div>
                <form>
                    <input type='text' ref="username" placeholder="Enter Username"/><br/>
                    <input type='password' ref="password" placeholder="Enter Password"/><br/>
                    <input type='submit' value="Submit" id="username" onClick={this.validation.bind(this)}/><br/>
                    
                </form>
                <h1>{this.state.result}</h1>
                </div>
        
    }

}