import React, {useState, useEffect} from 'react'
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
        <div>
            <div>Ciphers</div>
            <div>
                {created && created.length > 0 ? (
                    created.map((cipher) => (
                        <Cipher key={cipher.id} cipher={cipher}/>
                    ))
                ) : (
                    <p>No Ciphers Created</p>
                )}
            </div>
            <div>
                {permitted && permitted.length > 0 ? (
                    permitted.map((cipher) => (
                        <Cipher cipher={cipher}/>
                    ))
                ) : (
                    <p>No Shared Ciphers</p>
                )}
            </div>
            <Link to={`/${activeUser.username}/ciphers/create`}>
                <button>Create New Cipher</button>
            </Link>
            <Link to={`/dashboard`}>
                <button>Back to Dashboard</button>
            </Link>
        </div>
     </div>
   )
 }
 
 export default Ciphers