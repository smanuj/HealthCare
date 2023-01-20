import logo from './logo.svg';
import './App.css';
import Login from './component/Login';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import Registration from './component/Registration';
import Nurse from './component/Nurse';

function App() {
  return (
    <div className="App">
      <Router>
      
      <Routes>
        <Route exact path ="/" element={<Login/>}></Route>
      <Route exact path ="/reg" element={< Registration/> } />
      <Route exact path ="/re" element={< Nurse/> } />
      </Routes>
      </Router>
    </div>
  );
}

export default App;
