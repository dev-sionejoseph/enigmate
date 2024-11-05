import { useState, useEffect } from 'react'
import './App.css'
import { 
  BrowserRouter as Router,
  Route,
  Routes,
  useParams,
  Link,
  useNavigate } from 'react-router-dom'

  import Login from './components/Login'
  import Ciphers from './pages/Ciphers'
  import Dashboard from './pages/Dashboard'
  import Inbox from './pages/Inbox'
import CreateCipher from './components/CreateCipher'

function App() {
  const [auth, setAuth] = useState(false)
  const [activeUser, setActiveUser] = useState({username:'', userId:''})
  const navigate = useNavigate();
  
  useEffect(() => {  //DELETE LATER!!!!!!!
    console.log("From App", activeUser)
  }, [activeUser])

  useEffect(() => { 
    if(!auth){
      navigate('/')
    }
  }, [auth])
  

  return (
    <main className='app wrap-gradient'>
      {/* <Router> */}
        <Routes>
          <Route exact path="/" element={<Login setAuth={setAuth} setActiveUser={setActiveUser}/>}></Route>
          <Route path="/:username" element={<Dashboard auth={auth} setAuth={setAuth} activeUser={activeUser}/>}></Route>
          <Route path="/:username/inbox" element={<Inbox auth={auth} activeUser={activeUser}/>}></Route>
          <Route path="/:username/ciphers" element={<Ciphers auth={auth} activeUser={activeUser}/>}></Route>
          <Route path="/:username/ciphers/create" element={<CreateCipher auth={auth} activeUser={activeUser}/>}></Route>
        </Routes>
      {/* </Router> */}
      
    </main>
  )
}

export default App
