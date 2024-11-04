import React, {useEffect, useState} from 'react'
import { Link } from 'react-router-dom'
import Message from '../components/Message'

const Inbox = ({activeUser}) => {
    const [messages, setMessages] = useState({});
    const [newMessage, setNewMessage] = useState({
        sender: activeUser.username,
        receiver:'',
        cipher:'',
        rawMessage:''
    })
    const apiURL = import.meta.env.VITE_API_KEY;

    useEffect(() => {
      async function fetchInbox() {
        try {
            const response = await fetch(`${apiURL}/messages/${activeUser.id}/inbox`, {
                method: "GET",
              });
            const data = await response.json();
            setMessages(data);
            console.log(data);
        } catch (e) {
            console.log('Error fetching inbox:', e)
        }
      }
      
      fetchInbox();
    }, [])

    function handleChange(e) {
        const { name, value } = e.target;
        setNewMessage({
          ...newMessage,
          [name]: value,
        });
      }

    async function handleSubmit(e){
        e.preventDefault();

        try {
            const response = await fetch(`${apiURL}/messages/${activeUser.id}/send`, {
                method: "POST",
                headers: { "Content-type": "application/json" },
                body: JSON.stringify(newMessage),
              });
        } catch (e) {
            console.log("Uh oh!", e);
        }
        
    }
    
  return (
    <div>
        <div>
            <div>Inbox</div>
            <div>
                {messages.length > 0 ? (
                    messages.map((message) => (
                        <Message key={message.id} message={message}/>
                    ))
                ) : (
                    <p>Let's Get Cryptic</p>
                )}
                <div>
                    <form>
                        <select onChange={handleChange} name="cipher" id="permittedCiphers" placeholder='cipher'>
                            <option value=''>Choose a Cipher</option>
                            <option value='cipher two'>cipher two</option>
                        </select>
                        <input onChange={handleChange} type="text" name='receiver' placeholder='To:'></input>
                        <input onChange={handleChange} type="text" name='rawMessage' placeholder='Start a New Message'></input>
                        <button onClick={handleSubmit}>Send</button>
                    </form>
                </div>
            </div>
            <Link to={`/dashboard`}>
                <button>Back to Dashboard</button>
            </Link>
            
        </div>

    </div>
  )
}

export default Inbox