import React, {Component} from 'react';
import axios from "axios";
import { Navigate } from 'react-router-dom';



export default class ApproveNurse extends Component{

    constructor(props) {
        super(props)
        this.state = {
            nurses:[]
    }
   
    
    }

    componentDidMount(){
        axios.get("http://localhost:8003/api/v1/admin/nurseApproval").then(Response => 
        Response.data).then((data)=>{this.setState({nurses:data})});
        
      
    }

    approveNurse(id){ 
        
        axios.post("http://localhost:8003/api/v1/admin/nurseApproval/"+id).then(Response => {
             if(Response.data==="Approved"){
             alert(id);
             alert("Approved");
             axios.get("http://localhost:8008/api/s1/registersuccessfulfornurse/"+id)
             window.location.reload();
                 } 
          
                    }); 
                   
                }

                disapproveNurse(id) {

                
                    axios.delete("http://localhost:8003/api/v1/admin/nurseDisapproval/"+id).then(Response => {
                            if(Response.data==="Disapproved"){
                                alert("Disapproved");
                                axios.get("http://localhost:8008/api/s1/registerfailurefornurse/"+id)
                                window.location.reload();
                               
                            }
                            
                        });
            
                    
                }
   
    render(){
        return(
            
            
            <div>
                
                <h2 className="text-center">Nurse List</h2>
               
                 <br></br>
                 <div className = "row">
                <table className = "table table-striped table-bordered"> 

<thead>
    <tr>
        <th> Id</th>
        <th> Name</th>
        <th> Contact number</th>
        <th> Availability</th>
        <th> Approval</th>
        <th> Actions</th>
    </tr>
</thead>
<tbody>
                    {
                                    this.state.nurses.map(
                                        nurse => 
                                        <tr key = {nurse.nurseId}>
                                             <td> {nurse.nurseId} </td>  
                                             <td> {nurse.name} </td>   
                                             <td> {nurse.pnumber}</td>
                                             <td> {String(nurse.avaliability)}</td>
                                             <td> {String(nurse.approval)}</td>
 
                                             <td>
                                           
     <button style={{marginLeft: "20px"}} onClick={ () => this.approveNurse(nurse.nurseId)} className="btn-list">Approve </button>
<button style={{marginLeft: "20px"}} onClick={ () => this.disapproveNurse(nurse.nurseId)} className="btn-list">Disapprove </button>
    
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