import React, {Component} from 'react';
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
            this.setState({hospitals: this.state.hospitals.filter(hospital => hospital.id !== id)});
        });
    }
    
    

    componentDidMount(){
        HospitalService.getHospitals().then((res) => {
        this.setState({hospitals:res.data});
        });
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
                                             <td>
                                           
     <button style={{marginLeft: "20px"}} onClick={ () => this.deleteHospital(hospital.id)} className="btn-list">Delete </button>
    
                                             </td>        
                                        </tr>
                                        
                                    )
                                }
                            </tbody>
                        </table>
                        <div className="login-button">
                
                 <button ><Link to={"/"}>Add Hospital</Link></button>
                 </div>

                 </div>
                 </div>
   
        )
    }
}