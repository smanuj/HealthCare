import React, {Component} from 'react';
import axios from "axios";



export default class ApproveDoctor extends Component{

    constructor(props) {
        super(props)
        this.state = {
            doctors:[]
    }
   
    
    }

   
    

    componentDidMount(){
      //  axios.get("http://localhost:8080/api/v1/doctors").then(Response => Response.data).then((data)=>{this.setState({doctors:data})});
      
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
                                        <tr key = {doctor.id}>
                                            <td> {doctor.id} </td>  
                                             <td> {doctor.name} </td>   
                                             <td> {doctor.pnumber}</td>
                                             <td> {doctor.specialization}</td>
                                             <td> {doctor.availability}</td>
                                             <td> {doctor.approval}</td>
 
                                             <td>
                                           
     <button style={{marginLeft: "20px"}} onClick={ () => this.approveDoctor(doctor.id)} className="btn-list">Approve </button>
<button style={{marginLeft: "20px"}} onClick={ () => this.rejectDoctor(doctor.id)} className="btn-list">Reject </button>
    
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