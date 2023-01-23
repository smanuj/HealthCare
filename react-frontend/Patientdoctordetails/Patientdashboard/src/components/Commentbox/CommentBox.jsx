import "./commentbox.css"
import React from 'react';



function Comments() {
  return (
    
    <form className="commentForm">
      <label className="comment" >Comments:</label><br/>
      <textarea rows="9" cols="70"> </textarea> 
      
    </form>
    
  )
}

export default Comments;
