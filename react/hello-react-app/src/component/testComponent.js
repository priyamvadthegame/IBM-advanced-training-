import React from 'react'
export class Test extends React.Component
{
  constructor(props)
  {
    super(props)
    this.state={
      check:true
    }
  }

  changeState()
  {
    this.setState({check:false})
    console.log(this.state.check)
  }

  render()
  {
    return <div>
    <button onClick={this.changeState.bind(this)}>Check</button>
    <h1>{this.state.check}</h1>
    </div>
  }
}