import React, { Component } from 'react';

class CurrencyConvertor extends Component {
    constructor(props) {
        super(props);
        this.state = {
        amount: '',
        result: ''
        };
    }

    handleChange = (e) => {
        this.setState({ amount: e.target.value });
    }

    handleSubmit = () => {
        const result = parseFloat(this.state.amount) * 80;
        alert(`Converting to Euro Amount is ${result}`);
        this.setState({ result });
    }

    render() {
        return (
        <div style={{ fontFamily: 'Arial', marginTop: '30px' }}>
            <h1 style={{ color: 'green' }}>Currency Convertor!!!</h1>
            <form>
            <label>Amount: </label>
            <input type="text" value={this.state.amount} onChange={this.handleChange} />
            <br /><br />
            <label>Currency: </label>
            <textarea value="Euro" readOnly />
            <br /><br />
            <button type="button" onClick={this.handleSubmit}>Submit</button>
            </form>
        </div>
        );
    }
}

export default CurrencyConvertor;
