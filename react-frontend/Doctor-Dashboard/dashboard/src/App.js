import Commentbox from './components/commentbox/Commentbox';
import Topbar from './components/topbar/Topbar';
import Details from './components/details/Details';
import "./App.css"

function App() {
  return (
    <div className="App">
      <Topbar/>
    <div className="container">
   <Commentbox />
   <div className="details">
    <Details />
   </div>
     
    
    </div>
    </div>
  );
}

export default App;
