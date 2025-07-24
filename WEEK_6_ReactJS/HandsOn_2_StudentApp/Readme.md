# StudentReact App

In this hands on I have created multiple components such as ```Home.js```,```About.js``` and ```Contact.js``` and then rendered in the ```App.js```.

---

## Set up React environment

Created react app using the following commands.

``` bash

npm install -g creat-react-app

npx create-react-app studentapp

```

---

## Creating Multiple Component


```Home.js```

``` js

import React,{Component} from "react";
class Home extends Component{
    render(){
        return(<center>
        <div>
        <h3>Welcome to the Home page of Student Management Portal</h3>
        </div>
        </center>);
    }
}
export default Home;

```

``` About.js ```

``` js

import React,{Component} from "react";
class About extends Component{
    render(){
        return(
            <center>
            <div>
            <h3>Welcome to the About page of Student Management Portal</h3>
            </div>
            </center>
        );
    }
}
export default About;

```

```Contact.js```

``` js

import React,{Component} from "react";
class Contact extends Component{
    render(){
        return(<center>
        <div>
        <h3>Welcome to the Contact page of Student Management Portal</h3>
        </div>
        </center>);
    }
}
export default Contact;

```

---

## Rendering the Components

I have rendered all the created components in ``` App.js```.

```App.js```

``` js

import logo from './logo.svg';
import './App.css';
import Home from '../src/Components/Home'
import Contact from '../src/Components/Contact'
import About from './Components/About'

function App() {
  return (
    <div className="container">
      <Home/>
      <About/>
      <Contact/>
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