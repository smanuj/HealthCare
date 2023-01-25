import React from "react";
import {Link} from 'react-router-dom';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import { Alert, Form } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { Dropdown,DropdownButton } from "react-bootstrap";


import axios from "axios";
class Registration extends React.Component{

    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={
          hospitals:[],
          selectedOption:[]
          
        };
    }

    initiaLSTATE={
        id:"",
        name:"",
        email:"",
        username:"",
        password:"",
        confirmpassword:"",
        pnumber:"",
        hospital:""

    };

    componentDidMount(){
       
          axios.get("http://localhost:8080/hospitals").then(Response => (Response.data))
           .then((data)=>{this.setState({hospitals:data})});
           
         
     
      }
      
    handlesubmit= (event) => {
      
   
        const doctor = {
            name: this.state.name,
            pnumber: this.state.pnumber,
            specialization: this.state.specialization
            
           
          };

          

        const user ={
            email:this.state.email,
            password:this.state.password,
            doctordetails:{
                name: this.state.name,
            pnumber: this.state.pnumber,
            specialization: this.state.specialization,
            hospital:
              {
                hospitalId:this.state.hospital
              }
            },
          
            
          
            
        }
        const confirmpassword= this.state.confirmpassword;
        const password = this.state.password;
        
        
       
      
        
         if(confirmpassword==password) {
            axios.post("http://localhost:8080/api/savedoctor",user).then(response => {
                if(response.data=="not"){
                    this.setState(this.initiaLSTATE);
                    alert("User with this email already Exists")  ;
                    
                  
    
                }
                else{
                    alert("user saved")
                    window.location("/")
                }
              } )
         }
         else{
            alert("Password and ConfirmPassword are not same");
            window.location("/")
         }
          


        
        

    }
    bookChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
          
          
        });
      };

     handleChange = (value) =>{
      alert(value)
      this.setState.hospital=value
      alert(this.setState.hospital)
    
     }

     
  

       
    render(){
    
    
        return(
        <Form onSubmit={this.handlesubmit} >
            <div className="main">
            <div >
              <div>
                <div>
                  <h1>Registartion as Doctor</h1>
                  <div>
                    
                    <input type="text" placeholder="name" className="name" pattern="[A-Za-z]{5,10}" name="name" value={this.state.name} onChange={this.bookChange} required/>
                  </div>
                  <div className="second-input">
                  
                    <input type="email" placeholder="Email" className="name" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" value={this.state.email}  name="email" onChange={this.bookChange} required/>
                  </div>
                  
                  <div className="second-input">
                  
                    <input type="password" placeholder="Password" className="name" name="password" pattern="[A-Za-z0-9#@$&]{3,10}"  value={this.state.password} onChange={this.bookChange} required/>
                  </div>
                  <div className="second-input">
                  
                    <input type="password" placeholder=" Confirm Password" className="name" name="confirmpassword" pattern="[A-Za-z0-9#@$&]{3,10}" value={this.state.confirmpassword} onChange={this.bookChange}  required/>
                  </div>
                 
                  <div className="second-input">
                  
                    <input type="text" placeholder="Phone number" className="name"  name="pnumber" value={this.state.pnumber} onChange={this.bookChange} required/>
                  </div>
                  
                  <br></br>
                 <select   name="specialization"  value={this.state.specialization} onChange={this.bookChange} >
                <option value="" disabled selected>Select Your Specialization</option>
                    <option value="Cardiology">Cardiology</option>
                    <option value="Dermatology">Dermatology</option>
                    <option value="General Surgery">General Surgery</option>
                    <option value="Neurosurgery">Neurosurgery</option>
                    <option value="Ayurvedic physician">Ayurvedic physician</option>
                    
                    
                  </select>
                    <br></br>
                    <br></br>
                    <select name="hospital"  value={this.state.hosp} onChange={this.bookChange} >
                    <option value="" disabled selected>Select Your Hospital</option>
                    
                     {
                 this.state.hospitals.map((hospital) => (
                      
                     <option key={hospital.hospitalId}  value ={hospital.hospitalId}>{hospital.name}</option>
                    
                     ) )
                    }   
                 </select>     

                
                 
                 <div className="login-button">
                 <button  >submit</button><br></br>
                 <br></br>
                 <button ><Link to={"/"}>Login Page</Link></button>
                 </div>
                </div>
              </div>
             
       
            </div>
           </div> 
           </Form>


           
        );
    }
}

export default Registration;