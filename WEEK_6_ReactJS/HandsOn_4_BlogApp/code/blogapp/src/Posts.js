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
