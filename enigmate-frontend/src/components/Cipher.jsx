import React from 'react'

const Cipher = ({ cipher, key }) => {
  return (
    <div id={key}>
        <h4>{cipher.name}</h4>
        {/* <div>{cipher.codebreakers.map((breaker)=><p>{breaker.username}</p>)}</div> */}
        {/* <small>created by {cipher.codemaker}</small> */}
    </div>
  )
}

export default Cipher