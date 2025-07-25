# Blog App

In this hands-on I have create two components ```Post.js``` and ```Posts.js``` to maintain the post in this blogging platform.

---

## Set up React environment

Created react app using the following commands.

``` bash

npm install -g creat-react-app

npx create-react-app blogapp

```
---

## Post Component

This component was used to initialize the structure for every post we are creating.

```Post.js```
``` js

class Post {
    constructor(id, title, body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }
}

export default Post;


```

## Posts Component

This component was used to load posts from ```https://jsonplaceholder.typicode.com/posts``` and maps that in the ```Post[]``` list and uses two hooks called ```ComponentDidMount()``` and ```ComponentDidCatch()```.
--```ComponentDidMount``` automatically loads the post by `loadComponent()` after the component mounts.
--```ComponentDidCatch()``` catches any run time errors and displays that in alert.

```Posts.js```

``` js

import React from "react";
import Post from "./Post";

class Posts extends React.Component {
constructor(props) {
super(props);
this.state = {
    posts: []
};
}
loadPosts() {
fetch("https://jsonplaceholder.typicode.com/posts")
    .then((response) => response.json())
    .then((data) => {
    const postObjects = data.map(
        (p) => new Post(p.id, p.title, p.body)
    );
    this.setState({ posts: postObjects });
    })
    .catch((err) => console.error("Error fetching posts: ", err));
}
componentDidMount() {
this.loadPosts();
}
render() {
return (
    <div>
    <h2>Blog Posts</h2>
    {this.state.posts.map((post) => (
        <div key={post.id} style={{ marginBottom: "15px" }}>
        <h3>{post.title}</h3>
        <p>{post.body}</p>
        </div>
    ))}
    </div>
);
}
componentDidCatch(error, info) {
alert("An error occurred: " + error);
console.error("Error Info: ", info);
}
}
export default Posts;

```

## Main Component

```App.js``` is the main comonent where it renders the other components on the user screen.

```App.js```

``` js

import React from "react";
import "./App.css";
import Posts from "./Posts";

function App() {
  return (
    <div className="App">
      <h1>Welcome to Blog App</h1>
      <Posts />
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