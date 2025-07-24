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
