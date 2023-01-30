import './forgotPass.css'

import React from "react";
import {Link} from 'react-router-dom';
import { BrowserRouter as Router, Route,Routes } from "react-router-dom";
import { Alert, Form } from "react-bootstrap";
import { useHistory } from "react-router-dom";
import { Dropdown,DropdownButton } from "react-bootstrap";


import axios from "axios";
class ForgotPass extends React.Component{

    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={};
    }

    login(){
        return this.props.history.push("/");
    }

    initiaLSTATE={
        email:""

    };
    handlesubmit= (event) => {
       
            const email = {
              email: this.state.email
            }
        // const doctor = {
        //     name: this.state.name,
        //     pnumber: this.state.pnumber,
        //     specialization: this.state.specialization
            
           
        //   };

        // const user ={
        //     email:this.state.email,
        //     password:this.state.password,
        //     doctordetails:{
        //         name: this.state.name,
        //     pnumber: this.state.pnumber,
        //     specialization: this.state.specialization
            
        //     }
        // }
        // const confirmpassword= this.state.confirmpassword;
        // const password = this.state.password;
        
        
       axios.post("http://localhost:8008/api/s1/reset/forgotPass",email).then(response => {
                if(response.data=="sent"){
                    
                  
                    axios.get("http://localhost:8008/api/s1/"+email).then(Response => {const id = Response.data ; alert(id);
              window.location="/reset/newPass/"+id})
                  
    
                }
                else{
                    alert("fail")
                }
              } )
        //  axios.post("http://localhost:8080/api/save",doctor,email,password).then(response => alert(response.data))
        
        //  if(confirmpassword==password) {
        //     axios.post("http://localhost:8080/api/savedoctor",user).then(response => {
        //         if(response.data=="not"){
        //             this.setState(this.initiaLSTATE);
        //             alert("user not saved")
        // ;
                  
    
        //         }
        //         else{
        //             alert("user saved")
        //         }
        //       } )
        //  }
        //  else{
        //     alert("password");
        //  }
          


        
        

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
                  
                    <input type="email" placeholder="Email" className="name" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" value={this.state.email}  name="email" onChange={this.bookChange} required/>
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

export default ForgotPass;