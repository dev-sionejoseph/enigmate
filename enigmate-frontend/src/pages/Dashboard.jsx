import React, { useEffect } from 'react'
import { Link } from 'react-router-dom'

const Dashboard = ({ setAuth, activeUser }) => {
    useEffect(() => {
      console.log("From Dashboard",activeUser)
    }, [])
    
    const username = activeUser.username

    function handleLogout(){
        setAuth(false);
    }
  return (
    <main className='main-wrapper gradient-overlay'>
        <div className='item-holder'>
            <div>
                <div className='logo'>
                    <img className="icon" id='dash-icon' src={"icon.png"} alt="enigmate icon" />
                    <img className="wordmark" id='dash-wordmark' src={"wordmark1.png"} alt="" />
                </div>
                <div className='title-wrap'>
                    <h2 id='title'>{activeUser.username.charAt(0).toUpperCase() + activeUser.username.slice(1)}'s Dashboard</h2>
                </div>
            </div>
            <div className="inner-holder" id='dash-buttonwrap'>
                <Link to={`/${username}/inbox`}>
                    <button className='dash-button'>
                        <span className="dupe-text">&%j@k</span>
                        <span className="real-text">Inbox</span>
                    </button>
                </Link>
                <Link to={`/${username}/outbox`}>
                    <button className='dash-button'>
                        <span className="dupe-text">Yf^j@k</span>
                        <span className="real-text">Outbox</span>
                    </button>
                </Link>
                <Link to={`/${username}/ciphers`}>
                    <button className='dash-button'>
                        <span className="dupe-text">X$#kE+v</span>
                        <span className="real-text">Ciphers</span>
                    </button>
                </Link>
                <Link to={`/`}>
                    <button onClick={handleLogout} className='dash-button'>
                        <span className="dupe-text">Kfo Y#tr</span>
                        <span className="real-text">Log Out</span>
                    </button>
                </Link>
            </div>
        </div>
    </main>
  )
}

export default Dashboard