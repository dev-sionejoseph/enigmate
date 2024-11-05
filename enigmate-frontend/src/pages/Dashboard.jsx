import React, { useEffect } from 'react'
import { Link } from 'react-router-dom'

const Dashboard = ({ setAuth, activeUser }) => {
    useEffect(() => {
      console.log("From Dashboard",activeUser)
    }, [])
    
    const username = activeUser.username
  return (
    <main className='main-wrapper gradient-overlay'>
        <div className='item-holder'>
            <div>Dashboard</div>
            <Link to={`/${username}/inbox`}>
                <button>Inbox</button>
            </Link>
            <Link to={`/${username}/ciphers`}>
                <button>Ciphers</button>
            </Link>
        </div>
    </main>
  )
}

export default Dashboard