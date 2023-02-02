import React from "react";
import {Link} from 'react-router-dom';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import { Alert, Form } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { Dropdown,DropdownButton } from "react-bootstrap";

import axios from "axios";
class Nurse extends React.Component{

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
       

      event.preventDefault()

        const user ={
            email:this.state.email,
            password:this.state.password,
            nursedetails:{
                name: this.state.name,
            pnumber: this.state.pnumber,
            specialization: this.state.specialization
            
            }
        }
        const confirmpassword= this.state.confirmpassword;
        const password = this.state.password;
        
    
          
         if(confirmpassword==password) {
            axios.post("http://localhost:8002/api/login/savenurse",user).then(response => {
                if(response.data=="not"){
                    this.setState(this.initiaLSTATE);
                    alert("user not saved")
        ;
                  
    
                }
                else{
                  this.setState(this.initiaLSTATE);
                    alert("user saved")
                    axios.post("http://localhost:8008/api/s1/notifyregistration",user)
                     window.location="/";
                }
              } )
         }
         else{
          this.setState(this.initiaLSTATE);
            alert("Password and ConfirmPassword are not same");
         }


        
        

    }
    bookChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
        });
      };
    render(){
        
        return(
        <Form onSubmit={this.handlesubmit} >
            <div className="main">
            <div>
              <div>
                <div>
                  <h1>Registration as Nurse</h1>
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
                  
                    <input type="text" placeholder="Phone number" className="name"  name="pnumber" pattern="(0/91)?[6-9][0-9]{9}" value={this.state.pnumber} onChange={this.bookChange} required/>
                  </div>
                  
                  
                 
                 <div className="login-button">
                 <button  >submit</button><br></br>
                 
                 </div>
                </div>
              </div>
             
       
            </div>
           </div> 
           </Form>
           
        );
    }
}

export default Nurse;