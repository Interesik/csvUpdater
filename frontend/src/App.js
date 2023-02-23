
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';
import { Component } from 'react';
import axios from 'axios';
class App extends Component {
  state = 
  {
    Clients: [],
    file: null
  }
  componentDidUpdate(){
    axios.get("http://localhost:8080/")
      .then(respones => this.setState({Clients: respones.data }))
  }
  componentDidMount() {
    axios.get("http://localhost:8080/")
      .then(respones => this.setState({Clients: respones.data }))
  }
  handleSubmit = (event) => {
    event.preventDefault()
    const url = 'http://localhost:8080/';
    const formData = new FormData();
    formData.append('file', this.state.file);
    const config = {
      headers: {
        'content-type': 'multipart/form-data',
      },
    };
    axios.post(url, formData, config).then((response) => {
      console.log(response.data);
    }).catch(e => console.log(e));
  }
  render(){
    return (
      <div className="form-group">
        <form onSubmit={this.handleSubmit} >
            <h1>Csv Uplader</h1>
            <input class="form-control" type="file" onChange={(event) => this.setState({ file: event.target.files[0]})}/>
            <button class="btn btn-primary" type="submit">Upload</button>
          </form>
        <table class="table">
          <tbody>
            <tr>
              <th>name</th>
              <th>email</th>
              <th>phone number</th>
            </tr>
              {this.state.Clients.map(client => 
              <tr key={client.id}>
                <td>{client.name}</td>
                <td>{client.email}</td>
                <td>{client.phoneNumber}</td>
                </tr>)}
          </tbody>
        </table>
      </div>
    );
  }
}


export default App;
