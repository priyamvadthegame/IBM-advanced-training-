import React from 'react'
import {ProductTable} from './ProductTable'
import {ProductForm} from './ProductForm'
import {EditForm} from './EditPage.js'
import { BrowserRouter, Route, Link,Switch } from 'react-router-dom';
export class RootTable extends React.Component
{  
     constructor(props)
    {
        super(props)
        this.state={tableContentsArray:[]}

    }

    render() {
        
        return <div><center><br/><br/><br/><ProductForm getTableContents={this.copyTextToDuplicateTextBox.bind(this)}/><br/><br/><br/>
        <ProductTable tableContent={this.getContents.bind(this)}/></center></div>
    }

    copyTextToDuplicateTextBox(text) {
       
        const arrayCopy=this.state.tableContentsArray.slice();
        arrayCopy.push(text)
        this.setState({tableContentsArray:arrayCopy})
    } 


    deleteRow(id)
    {       
        var tableContent = [...this.state.tableContentsArray];
        tableContent.splice(id, 1);
        console.log(tableContent)
        this.setState({tableContentsArray:tableContent});
    }

    getContents()
    {     
        
        return this.state.tableContentsArray.map((student, index) => {
            const {  name, quantity, price } = student 
            return (
               <tr key={index} >
                  <td style={{border:"5px solid lightBlue"}}>{index}</td>
                  <td style={{border:"5px solid lightBlue"}}>{name}</td>
                  <td style={{border:"5px solid lightBlue"}}>{quantity}</td>
                  <td style={{border:"5px solid lightBlue"}}>{price}</td>
                  <td style={{border:"5px solid lightBlue"}}>
                      <BrowserRouter>
                        <Switch>
                            <Route path="/editform" exact component={EditForm} />
                             <button><Link to="/editform">edit</Link></button>
                        </Switch>
                        </BrowserRouter>
                         <button style={{marginLeft:"10px"}} onClick={this.deleteRow.bind(this,index)}>delete </button>
                  </td>
               </tr>
            )
         })
    

    }

}