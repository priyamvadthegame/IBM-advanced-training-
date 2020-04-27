import React from 'react';

export class ButtonsComponent extends React.Component
{   
    actionOk()
    {
        alert("Ok Button Clicked")
    }
    actionCancel()
    {
        alert("Cancel Button Clicked")
    }
    render()
    {
        return <div><button type='submit'  onClick={this.actionOk.bind(this)}>OK</button><br/>
                    <button type='submit'  onClick={this.actionCancel.bind(this)}>CANCEL</button>
                </div>
        
    }

}