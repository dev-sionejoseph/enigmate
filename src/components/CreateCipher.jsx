import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const CreateCipher = ({ activeUser }) => {
    const [] = useState('')
    const [addError, setAddError] = useState('')
    const [newCipher, setNewCipher] = useState({
        name:'',
        key:'',
        userId: activeUser.id,
        codebreakers: []
    })
    const navigate = useNavigate();
    const apiURL = import.meta.env.VITE_API_KEY;

    async function handleSubmit(e){
        e.preventDefault();
        console.log(newCipher)
        try {
          const response = await fetch(`${apiURL}/ciphers/create`, {
            method: "POST",
            headers: { "Content-type": "application/json" },
            body: JSON.stringify(newCipher),
          });
    
          if(response.ok) {
            navigate(`/${activeUser.username}/ciphers`)
          } else {
            setAddError('Unable to add cipher')
            throw new Error("Unable to add cipher");
          }

        } catch (error) {
          console.log("error creating Cipher", error);
        }
    }

    function handleChange(e) {
        const { name, value } = e.target;
        if (name == 'codebreakers'){
          const input = value;
          const userArray = input.split(",").map(user => user.trim());
          setNewCipher({
            ...newCipher,
            codebreakers: userArray,
          });
        } else {
          setNewCipher({
            ...newCipher,
            [name]: value,
          });
        }
      }

  return (
    <div className='loginContainer'>
        <div className="titleContainer">
            <div className="title">Create A New Cipher</div>
            <small>keep your key somewhere safe!</small>
        </div>
        <form onSubmit={handleSubmit} className="cipherForm">
            <input onChange={handleChange} name="name" placeholder="Cipher Name" id="cipher-name-input" />
            <input onChange={handleChange} type="password" placeholder="Secret Key" name="key" id="key-input" />
            <label className='errorLabel'>{addError}</label>
            <input onChange={handleChange} type='text' placeholder='Enter Codebreakers' name="codebreakers" />
            <input type="submit" value="Create" />
        </form>
    </div>
  )
}

export default CreateCipher;