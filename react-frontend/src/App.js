import Sidebar from "./components/sidebar/Sidebar";
import Topbar from "./components/topbar/Topbar";
import "./app.css"
import Patient from "./pages/patient/Patient";
import {Container, Row, Col} from 'react-bootstrap';
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
import PatientForm from "./components/PatientForm/PatientForm";
import NavBar from "./components/NavBar"
import UpdateHospital from "./components/UpdateHospital";
import Doctor from "./components/Doctor";
import Nurse1 from "./components/Nurse1";
import PatientDetails from './components/navbar/PatientDetails'
import DoctorDashboard from './components/navbar/DoctorDashboard'



  function App() {
    const marginTop={
      marginTop:"20px"
    };
  return( 
   <div>
    <BrowserRouter>
    <NavBar />
   

    
      <Routes>
        <Route exact path ="/" element={<Login/>}></Route>
        <Route exact path ="/doctorReg" element={< Registration/> } />
        <Route exact path ="/nurseReg" element={< Nurse/> } />
        <Route path="/index" element={<Index/>}/>
        <Route path="/create" element={<PatientForm/>}/>
        <Route path="/hospital" element={<Hospital/>}/>
        <Route exact path ="/admin/dashboard" element={<Admin/>}></Route>
        <Route exact path ="/admin/addHospital" element={<AddHospital/>}></Route>
        <Route exact path ="/admin/getHospitals" element={<ListHospital/>}></Route>
        <Route exact path ="/admin/approveDoctor" element={<ApproveDoctor/>}></Route>
        <Route exact path ="/admin/approveNurse" element={<ApproveNurse/>}></Route>
        <Route path='/update/:id' element={<UpdateHospital/>} ></Route>
        <Route path="/reset/forgotPass" element={<ForgotPass/>}/>
        <Route path="/reset/newPass/:id" element={<NewPass/>}/>
        {/* <Route path="/doctor/:id" element={<Doctor/>}/> */}
        <Route path="/nurse/:id" element={<Nurse1/>}/>
        <Route path="/nurse/createpatient/:id" element={<PatientForm/>}/>
        <Route path='/doctor/:id' element={<DoctorDashboard/>} />
        <Route path='/patientDetails/:patientId' element={<PatientDetails/>} />
        <Route path='/Login' element={<Login/>} />
      </Routes>       
    
    </BrowserRouter>
        
    </div>
  );
}

export default App;
