import Sidebar from "./components/sidebar/Sidebar";
import Topbar from "./components/topbar/Topbar";
import "./app.css"
import Patient from "./pages/patient/Patient";

import CaseInfo from "./components/patientInfo/CaseInfo";
import Chart from "./components/charts/Chart";
import { BrowserRouter,Route,Routes,useLocation } from "react-router-dom"
import Index from "./components/index/Index";
import Hospital from "./components/hospital-details/Hospital";

import ForgotPass from "./components/forgot-pass/ForgotPass";
import NewPass from "./components/new-pass/NewPass"; 

import AddHospital from './components/AddHospital';
import ListHospital from './components/ListHospital';
import Admin from "./components/Admin";
import ApproveDoctor from "./components/ApproveDoctor";
import ApproveNurse from "./components/ApproveNurse";

import Login from './components/Login';
import Registration from './components/Registration';
import Nurse from './components/Nurse';


function App() {
     
  return( <div>
   
    <BrowserRouter>
    <Topbar />
    <div >
      <Routes>
        <Route exact path ="/" element={<Login/>}></Route>
        <Route exact path ="/doctorReg" element={< Registration/> } />
        <Route exact path ="/nurseReg" element={< Nurse/> } />
        <Route path="/index" element={<Index/>}/>
        <Route path="/hospital" element={<Hospital/>}/>
        <Route exact path ="/admin/dashboard" element={<Admin/>}></Route>
        <Route exact path ="/admin/addHospital" element={<AddHospital/>}></Route>
        <Route exact path ="/admin/getHospitals" element={<ListHospital/>}></Route>
        <Route exact path ="/admin/approvedoctor" element={<ApproveDoctor/>}></Route>
        <Route exact path ="/adminapprovenurse" element={<ApproveNurse/>}></Route>
        <Route path="/reset/forgotPass" element={<ForgotPass/>}/>
        <Route path="/reset/newPass" element={<NewPass/>}/>
      </Routes>       
    </div>
    </BrowserRouter>
        
  </div>     
  );
}

export default App;
