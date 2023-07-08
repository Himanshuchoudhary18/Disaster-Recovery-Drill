import { Link } from "react-router-dom";
import { Link as ScrollLink } from "react-scroll";
import companyLogo from '../img/punjab-national-bank-1024x576.jpg';

function Header() {
  return (
  <div className='header'>
    <img src={companyLogo} clasname ='logo'alt="Company Logo"/>
    <ul className="link">
      <ScrollLink to="about" smooth={true} duration={500}>
            About
      </ScrollLink>
      <ScrollLink to="services" smooth={true} duration={500}>
      Services
      </ScrollLink>       
      <a href="/services">Services</a>
      <Link to="/team">Team</Link>
      <Link to="/contact">Contact</Link>
    </ul>
  </div>
 
  );
}

export default Header;