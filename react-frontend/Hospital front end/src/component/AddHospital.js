import React from "react";
import {Link} from 'react-router-dom';
import { Form } from "react-bootstrap";
import styles from './Login.css'
import axios from "axios";
class AddHospital extends React.Component{

    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={};
    }
    
    
    initiaLSTATE={
        id:"",
        name:"",
        number:"",
        location:"",
        pincode:"",
       

    };
    handlesubmit= (event) => {
      alert(this.state.name)
       
        const hospital ={
            name:this.state.name,
            number:this.state.number,
            location:this.state.location,
            pincode:this.state.pincode
           
        }
       
         axios.post("http://localhost:8080/api/v1/hospitals",hospital).then(response => {
             alert("hospital saved");
          })
    }
       
    hospitalChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
        });
      };
    render(){
        
        
        return(
        <Form onSubmit={this.handlesubmit} >
            <div className="main">
            <div >
              <div>
                <div>
                  <h1>ADD HOSPITAL</h1>
                  <div className="second-input">
                    
                    <input type="text" placeholder="Hospital Name" className="name" pattern="[A-Za-z]{5,10}" name="name" value={this.state.name} onChange={this.hospitalChange} required/>
                  </div>
                  <div className="second-input">
                  
                  <input type="text" placeholder="Contact number" className="name"  pattern="(0/91)?[6-9][0-9]{9}" name="number" value={this.state.number} onChange={this.hospitalChange} required/>
                </div>
                  <div className="second-input">
                  
                    <input type="text" placeholder="Location" className="name" pattern="[A-Za-z]{5,30}" value={this.state.location}  name="location" onChange={this.hospitalChange} required/>
                  </div>
                  
                  <div className="second-input">
                  
                    <input type="text" placeholder="Pincode" className="name" pattern="[0-9]{6}" name="pincode"  value={this.state.pincode} onChange={this.hospitalChange} required/>
                  </div>
                  
               
                
                 
                 <div className="login-button">
                 <button  >submit</button><br></br>
                 <br></br>
                 <button ><Link to={"/list"}>List</Link></button>
                 </div>
                
                 </div>
                </div>
              
             
       
            </div>
           </div> 
           </Form>
           
        );
    }
}

export default AddHospital;