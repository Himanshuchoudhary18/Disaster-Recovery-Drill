import React,  {useState} from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Header from './components/Header';
import reportWebVitals from './reportWebVitals';
import {Provider} from "react-redux";
import Store  from "./utils/store";
import UserContext from "./utils/UserContext";
import Body from './components/Body';
import { createBrowserRouter, RouterProvider, Outlet } from "react-router-dom"; // for routing our page import createBrowserRouter and RouterProvider for providing router & Outlet for children component for nested routing
import Contact from "./components/Contact";
import Footer from './components/Footer';



const root = ReactDOM.createRoot(document.getElementById('root'));

 const AppLayout =()=>{

  const [user, setUser] = useState({name: "Himanshu", email: "himanshu@gmail.com"});

   
  return (
    <>
    <Provider store ={Store}>
    <UserContext.Provider value ={{user: user, setUser: setUser}} >
    <Header/>
    <Outlet/>
    {/* <Footer/> */}
    </UserContext.Provider>
    <Footer/>
    </Provider>
    
  </>
  )
}


 const appRouter = createBrowserRouter([
    {
      path: "/", // show path for routing
      element: <AppLayout />, // show component for particular path
      // errorElement: <Error />, // show error component for path is different
      children: [
        // show children component for routing
        {
          path: "/",
          element: <Body />,
        },
        {
          path: "/contact",
          element: <Contact />,
        }
      ],
    },
  ]);

root.render(<RouterProvider router={appRouter} />); // render RouterProvider and use router as props and pass value appRouter

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
