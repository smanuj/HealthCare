import React from "react";
import {Link} from 'react-router-dom';
import main from './Login.css'



class Admin extends React.Component{

    
    render(){
         
        return(
            
              
                 <div className="admin-main">
                 
                 <button ><Link to={"/admin/addHospital"}>ADD HOSPITAL</Link></button><br/><br/>
                 <button ><Link to={"/admin/getHospitals"}>HOSPITAL LIST</Link></button><br/><br/>
                 <button ><Link to={"/admin/approvedoctor"}>APPROVE DOCTOR</Link></button><br/><br/>
                 <button ><Link to={"/admin/approvenurse"}>APPROVE NURSE</Link></button>
                 
                 </div>
                
               
          
           
        );
    }
}

export default Admin;