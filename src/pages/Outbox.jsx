import React, {useEffect, useState} from 'react'
import { Link } from 'react-router-dom'
import Message from '../components/Message'

const Outbox = ({activeUser}) => {
    const [messages, setMessages] = useState({});
    const [newMessage, setNewMessage] = useState({
        sender: activeUser.username,
        receiver:'',
        cipher:'',
        rawMessage:''
    })
    const apiURL = import.meta.env.VITE_API_KEY;

    useEffect(() => {
    /*   async function fetchOutbox() {
        try {
            const response = await fetch(`${apiURL}/messages/${activeUser.id}/outbox`, {
                method: "GET",
              });
            const data = await response.json();
            setMessages(data);
            console.log(data);
        } catch (e) {
            console.log('Error fetching inbox:', e)
        }
      }
      
      fetchInbox(); */
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
    <div className='main-wrapper gradient-overlay'>
        <div className='item-holder'>
            <div className='logo'>
                <img className="icon" src={"/icon.png"} alt="enigmate icon"/>
                <img className="wordmark" src={"/wordmark1.png"} alt="enigmate wordmark"/>
            </div>
            <div className='title-wrap'>
                <h2 id='title'>Outbox</h2>
            </div>
            <div className='inner-holder' id='inner-outbox'>
                <div className='map-wrap' id='outbox-map'>
                    {messages.length > 0 ? (
                        messages.map((message) => (
                            <Message key={message.id} message={message}/>
                        ))
                    ) : (
                        <p>Let's Get Cryptic</p>
                    )}
                </div>
                <div className="form-wrap">
                    <form>
                        <label className="form-title">Send a new message</label>
                        <select onChange={handleChange} name="cipher" id="permittedCiphers" placeholder='cipher'>
                            <option value=''>Choose a Cipher</option>
                            <option value='cipher two'>cipher two</option>
                        </select>
                        <input onChange={handleChange} type="text" name='receiver' placeholder='To:'></input>
                        <input onChange={handleChange} type="text" name='rawMessage' placeholder='Start a New Message'></input>
                        <button onClick={handleSubmit}>Send</button>
                    </form>
                </div>
                <Link to={`/dashboard`}>
                    <button>Back to Dashboard</button>
                </Link>
            </div>
            
        </div>

    </div>
  )
}

export default Outbox;