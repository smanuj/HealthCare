import React, {Component} from 'react';
import axios from "axios";



export default class ApproveNurse extends Component{

    constructor(props) {
        super(props)
        this.state = {
            nurses:[]
    }
   
    
    }

    componentDidMount(){
       // axios.get("http://localhost:8080/api/v1/nurses").then(Response => Response.data).then((data)=>{this.setState({doctors:data})});
      
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
                                        <tr key = {nurse.id}>
                                             <td> {nurse.id} </td>  
                                             <td> {nurse.name} </td>   
                                             <td> {nurse.pnumber}</td>
                                             <td> {nurse.availability}</td>
                                             <td> {nurse.approval}</td>
 
                                             <td>
                                           
     <button style={{marginLeft: "20px"}} onClick={ () => this.approveNurse(nurse.id)} className="btn-list">Approve </button>
<button style={{marginLeft: "20px"}} onClick={ () => this.rejectNurse(nurse.id)} className="btn-list">Reject </button>
    
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