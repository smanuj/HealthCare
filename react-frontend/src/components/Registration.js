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
        this.state={};
    }

    login(){
        return this.props.history.push("/");
    }

    initiaLSTATE={
        id:"",
        name:"",
        email:"",
        username:"",
        password:"",
        confirmpassword:"",
        pnumber:"",

    };
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
            specialization: this.state.specialization
            
            }
        }
        const confirmpassword= this.state.confirmpassword;
        const password = this.state.password;
        
        
       
        //  axios.post("http://localhost:8080/api/save",doctor,email,password).then(response => alert(response.data))
        
         if(confirmpassword==password) {
            axios.post("http://localhost:8080/api/savedoctor",user).then(response => {
                if(response.data=="not"){
                    this.setState(this.initiaLSTATE);
                    alert("user not saved")
        ;
                  
    
                }
                else{
                    alert("user saved")
                }
              } )
         }
         else{
            alert("password");
         }
          


        
        

    }
    bookChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
        });
      };
    render(){
        // const { name,pnumber , specialization,avaliability } =
        // this.state;
        
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
                  {/* <div className="second-input">
                  
                    <input type="text" placeholder="Specialization" className="name" name="specialization"  value={this.state.specialization}  onChange={this.bookChange}required/>
                  </div> */}
                  <div className="second-input">
                  
                    <input type="text" placeholder="Phone number" className="name"  name="pnumber" value={this.state.pnumber} onChange={this.bookChange} required/>
                  </div>
                  {/* <div className="second-input">
                  
                    <input type="text" placeholder="Avaliability" className="name" name="avaliability"  value={this.state.avaliability} onChange={this.bookChange} required/>
                  </div> */}
                  <br></br>
                 <select   name="specialization"  value={this.state.specialization} onChange={this.bookChange} >
                <option value="" disabled selected>Select Your Specialization</option>
                    <option value="Cardiology">Cardiology</option>
                    <option value="Dermatology">Dermatology</option>
                    <option value="General Surgery">General Surgery</option>
                    <option value="Neurosurgery">Neurosurgery</option>
                    <option value="Ayurvedic physician">Ayurvedic physician</option>
                    
                    
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