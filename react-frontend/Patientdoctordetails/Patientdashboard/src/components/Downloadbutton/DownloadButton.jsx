import "./downloadbutton.css"
import React, { useState } from 'react';


function Download() {
  const [count, setCount] = useState(0);

  function handleClick() {
    setCount(count + 1);
  }

  return (
    <button className="bt2" onClick={handleClick}>
      Download
    </button>
  );
}

export default Download;