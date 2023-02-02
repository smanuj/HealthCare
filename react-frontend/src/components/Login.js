import React from "react";
import {Form,Button} from "react-bootstrap";
import profile from './profile.png';
import email from './email.jpg';
import pass from './pass.png';
import {Link} from 'react-router-dom';
import { useNavigate } from 'react-router-dom';
import Registration from "./Registration";

import axios from "axios";

// import './Login.css';
import styles from './Login.css'

class Login extends React.Component{

    constructor(props){
        super(props);
        this.state= this.initiaLSTATE;
        this.state={
            user:[]
        };
    }
    initiaLSTATE={
        email:"",
        password:""
    };
    
    handlesubmit= (event) => {
       event.preventDefault()
        const user={
            email:this.state.email,
            password:this.state.password
        }
        this.state=this.initiaLSTATE    
        
        axios.post("http://localhost:8002/api/login/login",user).then(Response => {
            if(Response.data=="nurse"){
              axios.get("http://localhost:8002/api/login/nurselogin/"+user.email).then(Response => {const id = Response.data ;
              window.location="/nurse/"+id})
                
            }
            else if(Response.data=="admindashboard"){
              window.location="/admin/dashboard"
         }
            else if(Response.data=="doctor"){
              axios.get("http://localhost:8002/api/login/doctorlogin/"+user.email).then(Response => {const id = Response.data ;
               window.location="/doctor/"+id})
              //  window.location="/admin/addHospital"
          }
            
        else if(Response.data=="wait"){
            alert("wait for approval")  
            window.location.reload();
        }
        else if(Response.data=="pass"){
            alert("password invalid") 
            window.location.reload(); 
        }
        else{
            alert("Email has not been register please Register")
            window.location.reload();
        }
       
    
    }
        )

  
            
            
        
       
    }
    bookChange = (event) => {
        this.setState({
          [event.target.name]: event.target.value,
        });
      };

      bookList = () => {
        return this.props.history.push("/");
      };

    render(){
        

       
        return(
      
        
        
 <Form onSubmit={this.handlesubmit}>

     
<div className="main">
     <div className="sub-main">
       <div>
         <div className="imgs">
           <div className="container-image">
             <img src={profile} alt="profile" className="profile"/>

           </div>


         </div>
         <div>
           <h1>Login Page</h1>
           <div>
             <img src={email} alt="email" className="email"/>
             <input type="text" placeholder="Email" className="name" name="email" pattern="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$" required value={this.state.email} onChange={this.bookChange}/>
           </div>
           <div className="second-input">
             <img src={pass} alt="pass" className="email"/>
             <input type="password" placeholder="Password" className="name" name="password" pattern="[A-Za-z0-9#@$&]{3,10}" required  value={this.state.password} onChange={this.bookChange}/>
           </div>
          <div className="login-button">
          <button>Login</button>
          </div>
           
            <p className="link1">
            <a href="/reset/forgotPass">Forgot password ?</a> <br></br>
            <a href="/doctorReg">Sign Up as Doctor</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="/nurseReg">Sign Up as Nurse</a>
             
            </p>
            
           
 
         </div>
       </div>
       

     </div>
    </div>
    </Form>      
          
        );
}
}

export default Login;
