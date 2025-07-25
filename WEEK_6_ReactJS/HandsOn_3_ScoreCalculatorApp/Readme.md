# Score Calculator App

In this hands-on I have component ```CalculateScore.js``` to calculate the students score and stylesheet ```Mystyle.css``` to style the web page.

---

## Set up React environment

Created react app using the following commands.

``` bash

npm install -g creat-react-app

npx create-react-app scorecalculator

```

---

## CalculateScore Component

This component used to calculate the score and return the Name,Class,total and Score to the ```App.js```.

```CalculateScore.js```

``` js

import '../StyleSheets/Mystyle.css'

const perecentToDecimal=(decimal)=>{
    return (decimal.toFixed(2)+'%')
}

const calcScore=(total,goal)=>{
    return perecentToDecimal(total/goal)
}

export const CalculateScore=({Name,School,total,goal})=>(
    <div className='formatstyle'>
        <h1><font color='Brown'>Student Details</font></h1>
        <div className='Name'>
            <b><span> Name: </span></b>
            <span>{Name}</span>
        </div>
        <div className='School'>
            <b><span> School: </span></b>
            <span>{School}</span>
        </div>
        <div className='Total'>
            <b><span> Total: </span></b>
            <span>{total}</span>
        </div>
        <div className='Score'>
            <b>Score:</b>
            <span>
                {calcScore(
                    total,
                    goal
                )}
            </span>
        </div>
    </div>
)

```

---

## StyleSheet

I have created stylesheet ```Mystyle.css``` to style the react page.

```Mystyle.css```

``` css

.Name{
    font-weight: 300;
    color: blue;
}
.School{
    color: crimson;
}
.Total{
    color: darkmagenta;
}
.formatstyle{
    text-align: center;
    font-size: large;
}
.Score{
    color: forestgreen;
}

```

---

## Main Component

```App.js``` is the main comonent where it renders the other components on the user screen.

```App.js```

``` js

import logo from './logo.svg';
import './App.css';
import {CalculateScore} from '../src/Components/CalculateScore';

function App() {
  return (
    <div>
      <CalculateScore Name={"Karthi"}
      School={"GKN Higher Secondary School"}
      total={284}
      goal={3}
      />
    </div>
  );
}

export default App;


```
---

## Starting react app

I have started the react application using the following commmand.

``` bash

npm start

```