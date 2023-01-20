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
    componentDidMount(){
        axios.get("http://localhost:8080/api/login").then(Response => (Response.data));
        
    }
    handlesubmit= (event) => {
        
        const user={
            email:this.state.email,
            password:this.state.password
        }
            
        
        axios.post("http://localhost:8080/api/login",user).then(Response => {
            if(Response.data=="successfully"){
                alert("log in success")
                
            }
        else if(Response.data=="wait"){
            alert("wait for approval")  
        }
        else if(Response.data=="pass"){
            alert("password invalid")  
        }
        else{
            alert("log in failed")
        }
       
    
    }
            )
       
        
        // this.state=this.initiaLSTATE
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
        //      <div  className="border d-flex align-items-center justify-content-center">
        //      <div class="wrapper" > 
        //      <div class="title">LOGIN FORM</div>
        //      <div className = "form-box">
        //      <Form >
                
        //   <div class="field">
		//   				<input name="username" type="text" pattern="[A-Za-z]{3,10}"
		//  					required title="User name must be between 3-10 characters !!" />
		//  				<label>Username</label>
	 	//  		</div> 

	 	// 		<div class="field">
		//   				<input name="password" type="password" required
		//   					title="Password must be between 3-10 characters !!" /> <label>Password</label>
		//   			</div>
        //               <div class="field">
		//  				<input type="submit" value="LOGIN" name="submit" />
		//   			</div>
        //     </Form>
        //     <a href="/register">NOT YET REGISTERED</a>
        //     <br></br>
		//  			<a href="/sendotp">FORGOT PASSWORD</a>
        //     </div>
        //     </div>
        //     </div>
        
        
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
             <input type="text" placeholder="email" className="name" name="email" value={this.state.email} onChange={this.bookChange}/>
           </div>
           <div className="second-input">
             <img src={pass} alt="pass" className="email"/>
             <input type="password" placeholder="Password" className="name" name="password" value={this.state.password} onChange={this.bookChange}/>
           </div>
          <div className="login-button">
          <button>Login</button>
          </div>
           
            <p className="link1">
            <a href="#">Forgot password ?</a> <br></br>
            <Link to="reg">Sing Up as Doctor</Link>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
            <Link to="re">Sing Up as Nurse</Link>
             
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
