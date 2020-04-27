import React from 'react'

export class ProductTable extends React.Component
{
     render()
    {
        return <table style={{border:"5px solid lightBue" }}>
                <tr >
                <td style={{border:"5px solid lightBlue"}}>id</td>
                <td style={{border:"5px solid lightBlue"}}>Name</td>
                <td style={{border:"5px solid lightBlue"}}>Quantity</td>
                <td style={{border:"5px solid lightBlue"}}>Price</td>
                <td style={{border:"5px solid lightBlue"}}>Actions</td>
                </tr>  
                <tbody>
                {this.props.tableContent()}
                </tbody>  
               </table>
    }
}