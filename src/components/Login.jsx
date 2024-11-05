import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = ({ setAuth,setActiveUser }) => {
    const [loginError, setLoginError] = useState('')
    const [credentials, setCredentials] = useState({
        username:'',
        password:''
    })
    const navigate = useNavigate();
    const apiURL = import.meta.env.VITE_API_KEY;

    async function handleSubmit(e){
    
        e.preventDefault();
        try {
          const response = await fetch(`${apiURL}/auth`, {
            method: "POST",
            headers: {"Content-type": "application/json"},
            body: JSON.stringify(credentials),
          });
    
          if(response.ok) {
            setAuth(true)
            const data = await response.json();
            setActiveUser({
              username: credentials.username,
              id: data
            });
            navigate("/dashboard")
          } else {
            setLoginError('Invalid username or password')
            throw new Error("Unable to validate credentials");
          }
          
        } catch (error) {
          console.log("error logging in", error);
        }
    }

    function handleChange(e) {
        const { name, value } = e.target;
        setCredentials({
          ...credentials,
          [name]: value,
        });
      }

  return (
    <div className='loginContainer main-wrapper'>
        <div className="titleContainer">
            <div className="title">Enigmate</div>
            <div id="tagline">keep the mystery alive</div>
        </div>
        <form onSubmit={handleSubmit} className="class" id="loginForm">
            <input onChange={handleChange} name="username" placeholder="Username" id="username-input" />
            <input onChange={handleChange} type="password" placeholder="Password" name="password" id="password-input" />
            <label className='errorLabel'>{loginError}</label>
            <input type="submit" value="Log In" />
        </form>
    </div>
  )
}

export default Login;

