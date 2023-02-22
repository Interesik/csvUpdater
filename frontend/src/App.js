
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Component } from 'react';
class App extends Component{
  state = 
  {
    Clients: []
  }
  render() {
    return (
      <div>
        {this.state.Clients}
      </div>
    );
  }
}


export default App;
