import './newPass.css'

import React from "react";
import {Link} from 'react-router-dom';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import { Alert, Form } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { Dropdown,DropdownButton } from "react-bootstrap";


import axios from "axios";
class NewPass extends React.Component{

    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={};
    }

    login(){
        return this.props.history.push("/");
    }

    initiaLSTATE={
        otp:"",
        pass:"",
        confpass:""

    };
    handlesubmit= (event) => {
       

        // const doctor = {
        //     name: this.state.name,
        //     pnumber: this.state.pnumber,
        //     specialization: this.state.specialization
            
           
        //   };

        const user ={
            email:this.state.otp,
            password:this.state.pass
        }




        const confirmpassword= this.state.confpass;
        const password = this.state.pass;
        
        
       
        //  axios.post("http://localhost:8081/api/save",doctor,email,password).then(response => alert(response.data))
        
         if(confirmpassword==password) {
            axios.post("http://localhost:8080/api/savedoctor",user).then(response => {
                if(response.data=="not"){
                    this.setState(this.initiaLSTATE);
                    alert("user not saved");
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
                  <h1>Reset Password</h1>
                  <div className="second-input">
                  
                    <input type="text" placeholder="Enter OTP here" className="name" value={this.state.otp}  name="otp" onChange={this.bookChange} required/>
                  </div>
                  <div className="second-input">
                  
                    <input type="text" placeholder="New Password" className="name" value={this.state.pass}  name="pass" onChange={this.bookChange} required/>
                  </div>
                  <div className="second-input">
                  
                    <input type="text" placeholder="Confirm Password" className="name" value={this.state.confpass}  name="confpass" onChange={this.bookChange} required/>
                  </div>
                  <br></br>
                 <div className="login-button">
                 <button  >submit</button><br></br>
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

export default NewPass;