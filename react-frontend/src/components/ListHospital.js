import React, {Component} from 'react';
import axios from "axios";
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
            this.setState({hospitals: this.state.hospitals.filter(hospital => hospital.id !== id)});
        });
    }
  

    componentDidMount(){
        axios.get("http://localhost:8080/api/v1/hospitals").then(Response => Response.data).then((data)=>{this.setState({hospitals:data})});
      
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
                                        <tr key = {hospital.id}>
                                            <td> {hospital.id} </td>  
                                             <td> {hospital.name} </td>   
                                             <td> {hospital.location}</td>
                                             <td> {hospital.pincode}</td>
                                             <td> {hospital.bedavailability}</td>
                                             <td>
                                           
     <button style={{marginLeft: "20px"}} onClick={ () => this.deleteHospital(hospital.id)} className="btn-list">Delete </button>
    
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