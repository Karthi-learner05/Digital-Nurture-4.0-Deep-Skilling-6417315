import React, { Component } from 'react';
import CurrencyConvertor from './CurrencyConvertor';

class App extends Component {
  constructor(props) {
    super(props);
    this.state = {
      count: 0
    };
  }

  increment = () => {
    this.setState(prev => ({ count: prev.count + 1 }));
  }

  sayHello = () => {
    alert("Hello! Member1");
  }

  handleIncrement = () => {
    this.increment();
    this.sayHello();
  }

  decrement = () => {
    this.setState(prev => ({ count: prev.count - 1 }));
  }

  sayWelcome = (msg) => {
    alert(msg);
  }

  handleSynthetic = () => {
    alert("I was clicked");
  }

  render() {
    return (
      <div style={{ textAlign: 'left', marginLeft: '20px', fontFamily: 'Arial' }}>
        <h3>{this.state.count}</h3>
        <button onClick={this.handleIncrement}>Increment</button>
        <br /><br />
        <button onClick={this.decrement}>Decrement</button>
        <br /><br />
        <button onClick={() => this.sayWelcome("welcome")}>Say welcome</button>
        <br /><br />
        <button onClick={this.handleSynthetic}>Click on me</button>
        <br /><br />
        <CurrencyConvertor />
      </div>
    );
  }
}

export default App;
