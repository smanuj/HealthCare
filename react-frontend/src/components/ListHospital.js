import React, {Component} from 'react';
import axios from "axios";
import {Link} from 'react-router-dom';
import HospitalService from '../services/HospitalService';



export default class ListHospital extends Component{

    constructor(props) {
        super(props)
        this.state = {
            hospitals:[]
    }
   
    this.deleteHospital = this.deleteHospital.bind(this);
    }

    deleteHospital(id){
        HospitalService.deleteHospital(id).then( res => {
            this.setState({hospitals: this.state.hospitals.filter(hospital => hospital.hospitalId !== id)});
        });
    }
  

    change(id){ 
        
        axios.post("http://localhost:8003/api/v1/changeBedAvailability/"+id).then(Response => {
           
                alert(id);
                alert("Changed Bed Availability");
                window.location.reload();
                
                    }); 
                }

    componentDidMount(){
        axios.get("http://localhost:8003/api/v1/hospitals").then(Response => Response.data).then((data)=>{this.setState({hospitals:data})});
      
    }
   
    render(){
        return(
            
            
            <div>
                
                <h2 className="text-center">HOSPITAL LIST</h2>
               
                 <br></br>
                 <div className = "row">
                <table className = "table table-striped table-bordered"> 
               

<thead>
    <tr>
        <th> Id</th>
        <th> Name</th>
        <th> Location</th>
        <th> Pincode</th>
        <th> Bed Availability</th>
        <th> Actions</th>
    </tr>
</thead>
<tbody>
                    {
                                    this.state.hospitals.map(
                                        hospital => 
                                        <tr key = {hospital.hospitalId}>
                                            <td> {hospital.hospitalId} </td>  
                                             <td> {hospital.name} </td>   
                                             <td> {hospital.location}</td>
                                             <td> {hospital.pincode}</td>
                                             <td> {String(hospital.bedAvailabilty)}</td>
                                             <td>
                                           
     <button style={{marginLeft: "20px"}} onClick={ () => this.deleteHospital(hospital.hospitalId)} className="btn-list">Delete </button>&nbsp;&nbsp;
     <button style={{marginLeft: "20px"}} onClick={ () => this.change(hospital.hospitalId)} className="btn-list">Change</button>&nbsp;&nbsp;
    {/* <button className="btn-list"> <Link to={`/update/${hospital.hospitalId}`} >Edit</Link></button> */}
    
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