
import './App.css';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import AddHospital from './component/AddHospital';
import ListHospital from './component/ListHospital';


function App() {
  return (
    <div className="App">
      <Router>
      
      <Routes>
        <Route exact path ="/" element={<AddHospital/>}></Route>
        <Route exact path ="/list" element={<ListHospital/>}></Route>
      
      </Routes>
      </Router>
    </div>
  );
}

export default App;
