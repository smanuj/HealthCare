import Sidebar from "./components/sidebar/Sidebar";
import Topbar from "./components/topbar/Topbar";
import "./app.css"
import Patient from "./pages/patient/Patient";

import CaseInfo from "./components/patientInfo/CaseInfo";
import Chart from "./components/charts/Chart";
import { BrowserRouter,Route,Routes,useLocation } from "react-router-dom"
import Index from "./components/index/Index";
import Hospital from "./components/hospital-details/Hospital";


function App() {
     
  return( <div>
   
    <BrowserRouter>
    <Topbar />
    <div >
      <Routes>

        <Route path="/" element={<Index/>}/>
        <Route path="/hospital" element={<Hospital/>}/>
      
        </Routes>
        
        
         
        </div>
        </BrowserRouter>
        
        </div>
      
        
    );
}

export default App;
