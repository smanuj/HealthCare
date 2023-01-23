
import './App.css';

import Comments from './components/Commentbox/CommentBox';
import Download from './components/Downloadbutton/DownloadButton';
import PatientDetails from './components/ListOfPatients/ListOfPatient';
import Navbar from './components/Navbar/NavBar';
import Savebutton from './components/SaveButton/SaveButton';

function App() {
  return (
    

   



    <div className="App">
      <Navbar />
      <Savebutton />
      <Download />
      <Comments />
      

      <div className="row">
          <div className="col-12 col-xl-7">
            <div className="LPdetails">
            <PatientDetails />
            </div>
            </div>
            </div>




      

 
     
     
    </div>
  );
}

export default App;
