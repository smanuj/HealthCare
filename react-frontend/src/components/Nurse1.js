import React from "react";
import { useParams } from "react-router";


function withParams(Component) {
    return props => <Component {...props} params={useParams()} />;
   }
class Nurse1 extends React.Component{


    handlesubmit= (event) => {

        let {id}= this.props.params;
        window.location="/nurse/createpatient/"+id
    }
  
    render(){
        return(<div className="admin-main">
                 
        <button  onClick={this.handlesubmit}>REGISTER Patient</button><br/><br/>
        
        </div>)
    }
}

export default withParams(Nurse1);