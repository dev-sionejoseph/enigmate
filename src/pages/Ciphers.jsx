import React, { useState, useEffect } from 'react'
import { Link } from 'react-router-dom'
import Cipher from '../components/Cipher';
 
 const Ciphers = ({ activeUser }) => {
    const [created, setCreated] = useState([]);
    const [permitted, setPermitted] = useState([]);

    const apiURL = import.meta.env.VITE_API_KEY;

    useEffect(() => {
        async function fetchCiphers() {
          try {
              const response = await fetch(`${apiURL}/users/${activeUser.id}`, {
                  method: "GET",
                });
              const data = await response.json();
              setCreated(data.createdCiphers);
              setPermitted(data.permittedCiphers)
              console.log("Cipher Fetch", data);
          } catch (e) {
              console.log('Error fetching ciphers:', e)
          }
        }
        fetchCiphers();
      }, [])

      useEffect(()=>{
        console.log('created ciphers changed',created)
      },[created])

      useEffect(()=>{
        console.log('permitted ciphers changed',permitted)
      },[permitted])


   return (
     <div className='main-wrapper'>
        <div className='item-holder'>
            <div className='logo'>
                <img className="icon" src={"/icon.png"} alt="enigmate icon"/>
                <img className="wordmark" src={"/wordmark1.png"} alt="enigmate wordmark"/>
            </div>
            <div className='title-wrap'>
                <h2 id='title'>Ciphers</h2>
            </div>
            <div className="inner-holder" id='inner-ciphers'>
                <div className="map-wrap" id="cipher-map-wrap">
                    <div className='cipher-maps container'>
                        {created && created.length > 0 ? (
                            created.map((cipher) => (
                                <Cipher key={cipher.id} cipher={cipher}/>
                            ))
                        ) : (
                            <p className='map-item'>No Ciphers Created</p>
                        )}
                    </div>
                    <div className='cipher-maps container'>
                        {permitted && permitted.length > 0 ? (
                            permitted.map((cipher) => (
                                <Cipher cipher={cipher}/>
                            ))
                        ) : (
                            <p>No Shared Ciphers</p>
                        )}
                    </div>
                </div>
                <div className="link-wrap">
                    <Link to={`/${activeUser.username}/ciphers/create`}>
                        <button>Create New Cipher</button>
                    </Link>
                    <Link to={`/dashboard`}>
                        <button>Back to Dashboard</button>
                    </Link>
                </div>
            </div>
        </div>
     </div>
   )
 }
 
 export default Ciphers