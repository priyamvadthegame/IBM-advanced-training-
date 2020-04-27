import React from 'react'
import {Link, BrowserRouter, Route, Switch} from 'react-router-dom';
import {ProductForm} from './ProductForm'
export class EditForm extends React.Component
{
    constructor(props)
    {
        super(props);

        this.state={
            name:"",
            quantity:"",
            price:"",
            errorName:"",
            errorQuantity:"",
            errorPrice:""
         
        };

    }
    OnNameInputChange()
    {
        this.setState({name:this.refs.nameInput.value});
    }

    OnQuantityInputChange()
    {
        this.setState({quantity:this.refs.quantityInput.value});
    }
    
    
    OnPriceInputChange()
    {
        this.setState({price:this.refs.priceInput.value});
    }
    
    validate()
    {
        let validateName=true
        let validateQuantity=true
        let validatePrice=true 
        if(this.state.name==="")
        {
            this.setState({errorName:"name  should not be empty"})
            validateName=false
            
        }
        
        else if(this.state.name.length<3)
        {
            this.setState({errorName:"name length should be at least 3 characters long"})
            validateName=false
        }
        else{
            this.setState({errorName:""})
            validateName=true
        }


        if(this.state.price==="")
        {
            this.setState({errorPrice:"price  should not be empty"})
            validatePrice=false
        }

        else if(!(this.state.price.match(/^[0-9]*$/)))
        {
            this.setState({errorPrice:"price should  be numeric type"})
            validatePrice=false
        }
        else{
            this.setState({errorPrice:""})
            validatePrice=true
        }

        if(this.state.quantity==="")
        {
            this.setState({errorQuantity:"quantity  should not be empty"})
            validateQuantity=false
        }

        else if(!(this.state.quantity.match("^[0-9]*$")))
        {   
            this.setState({errorQuantity:"quantity should  be numeric type"})
            validateQuantity=false
        }
        else{
            this.setState({errorQuantity:""})
            validateQuantity=true
        }

        if(validateName&&validatePrice&&validateQuantity)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    onAddProducrButtonClicked(event)
    {   
        event.preventDefault();

        if(this.validate())
        {
            this.props.getTableContents({name:this.refs.nameInput.value,price:this.refs.priceInput.value,quantity:this.refs.quantityInput.value},this.props.id)            
        }
    }
    
    render()
    {
         return (
             <div>
                <form>
                    <strong>&nbsp;Name :</strong> <input ref="nameInput"type="text" value={this.props.name} onChange={this.OnNameInputChange.bind(this)}/>
                    <p style={{color:'red',marginLeft:'20px'}}>{this.state.errorName}</p>
                     <br/>
                    <strong>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Quantity :  </strong> <input ref="quantityInput"type="text" value={this.props.quantity} onChange={this.OnQuantityInputChange.bind(this)}/>
                    <p style={{color:'red',marginLeft:'20px'}}>{this.state.errorQuantity}</p>
                    <br/>
                    <strong>Price:  </strong> <input ref="priceInput" type="text" value={this.props.name} onChange={this.OnPriceInputChange.bind(this)}/>
                    <p style={{color:'red',marginLeft:'20px'}}>{this.state.errorPrice}</p>
                    <br/>
                    <div style={{display:"inline-flex"}}> 
                        <input style={{marginLeft:'50px'}} type="submit" ref="add-product-button" onClick={this.onAddProducrButtonClicked.bind(this)} value="Save"/> 
                        <BrowserRouter>
                            <Switch>
                                 <Route path="/" exact component={ProductForm}/>
                                <button><Link to="/">Page1</Link></button>
                            </Switch>
                         </BrowserRouter>
   
                    </div>


                </form>
            </div>
            )
        }
}