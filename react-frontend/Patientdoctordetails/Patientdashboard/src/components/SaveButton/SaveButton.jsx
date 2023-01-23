import "./savebutton.css"
import React, { useState } from 'react';


function Savebutton() {
  const [count, setCount] = useState(0);

  function handleClick() {
    setCount(count + 1);
  }

  return (
    <button className="bt1" onClick={handleClick}>
      Save
    </button>
  );
}

export default Savebutton;