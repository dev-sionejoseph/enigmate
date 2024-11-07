import React from 'react'

const Message = ({message}) => {
  return (
    <div className='map-item message-item'>
        <h4>From: {message.sender} </h4>
        <p>{message.rawMessage}</p>
        <small>{new Date(message.time).toLocaleString()}</small>
    </div>
  )
}

export default Message