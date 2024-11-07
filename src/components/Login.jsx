import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';

const Login = ({ setAuth,setActiveUser }) => {
    const [loginError, setLoginError] = useState('')
    const [signUp, setSignUp] = useState(false)
    const [credentials, setCredentials] = useState({
        username:'',
        password:''
    })
    const navigate = useNavigate();
    const apiURL = import.meta.env.VITE_API_KEY;

    async function handleLogin(e){
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

    async function handleSignUp(e) {
      e.preventDefault();
      try {
        const response = await fetch(`${apiURL}/users/register`, {
          method: "POST",
          headers: {"Content-type": "application/json"},
          body: JSON.stringify(credentials),
        });
  
        if(response.ok) {
          handleLogin(e);
        } else {
          setSignUp(false)
          setCredentials({
            username:'',
            password:''
        })
          setLoginError('Sign up failed. Please try again')
          throw new Error("Unable to create user");
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
    <div className="main-wrapper" id="loginContainer">
      <div className="item-holder">
          <div className="logo" id='login-logo'>
            <img className="icon" id="login-icon" src={"icon.png"} alt="enigmate icon" />
            <img className="wordmark" id="login-wordmark" src={"wordmark2.png"} alt="" />
          </div>
          <div className="title-wrap">
            <h2 id="title">
              Login
            </h2>
          </div>
        <div className="form-wrap">
          <form onSubmit={handleLogin} className="login-form" id="login-form">
            <input
              onChange={handleChange}
              name="username"
              placeholder="Username"
              id="username-input"
            />
            <input
              onChange={handleChange}
              type="password"
              placeholder="Password"
              name="password"
              id="password-input"
            />
            <label className="errorLabel">{loginError}</label>
            {!signUp &&
              <div className="form-btns-wrap" id="login-form-btns">
                <input className="form-btns" type="submit" value="Log In" />
                <input onClick={() => setSignUp(true)}className="form-btns" type="button" value="Sign Up" />
              </div>
            }
            {signUp &&
              <div className="form-btns-wrap" id="login-form-btns">
                <input onClick={handleSignUp} className="submit-user" type="button" value="Submit" />
              </div>
            }
          </form>
        </div>
      </div>
    </div>
  );
}

export default Login;

