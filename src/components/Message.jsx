import React from 'react'

const Message = ({message}) => {
  return (
    <div>
        <h4>From: {message.sender} </h4>
        <p>{message.rawMessage}</p>
        <small>{new Date(message.time).toLocaleString()}</small>
    </div>
  )
}

export default Message