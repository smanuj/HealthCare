import React from "react";
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
      hospitalId:"",
        name:"",
        location:"",
        pincode:"",
        bedAvailabilty:""
       

    };
    handlesubmit= (event) => {
      event.preventDefault()
      alert(this.state.name)
       
        const hospital ={
            name:this.state.name,
            location:this.state.location,
            pincode:this.state.pincode,
            bedAvailabilty:this.state.bedAvailabilty
           
        }
       
         axios.post("http://localhost:8003/api/v1/hospitals",hospital).then(response => {
             alert("hospital saved");
             window.location="/admin/dashboard";
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
                    
                    <input type="text" placeholder="Hospital Name" className="name" pattern="[A-Za-z]+([\ A-Za-z]+)" name="name" value={this.state.name} onChange={this.hospitalChange} required/>
                  </div>
           
                  <div className="second-input">
                  
                    <input type="text" placeholder="Location" className="name" pattern="[A-Za-z]+([\ A-Za-z]+)" value={this.state.location}  name="location" onChange={this.hospitalChange} required/>
                  </div>
                  
                  <div className="second-input">
                  
                    <input type="text" placeholder="Pincode" className="name" pattern="[0-9]{6}" name="pincode"  value={this.state.pincode} onChange={this.hospitalChange} required/>
                  </div>
                  <br></br>
                 <select   name="bedAvailabilty"  value={this.state.bedAvailabilty} onChange={this.hospitalChange} >
                 <option value="" disabled selected>Select Bed Availability</option> 
                    <option value="true">Yes</option>
                    <option value="false">No</option>
                    
                 </select>
               
                
                 
                 <div className="login-button">
                 <button  >Submit</button><br></br>
                 <br></br>
                 
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