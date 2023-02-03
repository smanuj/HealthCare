import React, {Component} from 'react';
import axios from "axios";
import { Navigate } from 'react-router-dom';
import { WindowSharp } from '@mui/icons-material';


export default class ApproveDoctor extends Component{

    constructor(props) {
        super(props)
        this.state = {
            doctors:[]
    }
   
    }

    componentDidMount(){
       axios.get("http://localhost:8003/api/v1/admin/doctorApproval").then(Response => Response.data).then((data)=>{this.setState({doctors:data})});
      
    }

    approveDoctor(id){ 
        
        axios.post("http://localhost:8003/api/v1/admin/doctorApproval/"+id).then(Response => {
            if(Response.data==="Approved"){
                alert(id);
                alert("Approved");
                 axios.get("http://localhost:8008/api/s1/registersuccessfulfordoctor/"+id)
                window.location.reload();
                
                
                } 
               
                    }); 
                }
               
                disapproveDoctor(id) {

                
                    axios.delete("http://localhost:8003/api/v1/admin/doctorDisapproval/"+id).then(Response => {
                            if(Response.data==="Disapproved"){
                                alert("Disapproved");
                                 axios.get("http://localhost:8008/api/s1/registerfailurefordoctor/"+id)
                                window.location.reload();
                               
                            }
                            
                        });
             
                }
   
   
    render(){
        return(
            
            
            <div>
                
                <h2 className="text-center">DOCTORS LIST</h2>
               
                 <br></br>
                 <div className = "row">
                <table className = "table table-striped table-bordered"> 

<thead>
    <tr>
        <th> Id</th>
        <th> Name</th>
        <th> Contact number</th>
        <th> Specialization</th>
        <th> Availability</th>
        <th> Approval</th>
        <th> Actions</th>
    </tr>
</thead>
<tbody>
                    {
                                    this.state.doctors.map(
                                        doctor => 
                                        <tr key = {doctor.doctorId}>
                                            <td> {doctor.doctorId} </td>  
                                             <td> {doctor.name} </td>   
                                             <td> {doctor.pnumber}</td>
                                             <td> {doctor.specialization}</td>
                                             <td> {String(doctor.avaliability)}</td>
                                             <td> {String(doctor.approval)}</td>
 
                                             <td>
                                           
     <button style={{marginLeft: "20px"}} onClick={ () => this.approveDoctor(doctor.doctorId)} className="btn-list">Approve </button>
<button style={{marginLeft: "20px"}} onClick={ () => this.disapproveDoctor(doctor.doctorId)} className="btn-list">Disapprove </button>
    
                                             </td>        
                                        </tr>
                                        
                                    )
                                }
                            </tbody>
                        </table>
                      

                 </div>
                 </div>
   
        )
    }
}