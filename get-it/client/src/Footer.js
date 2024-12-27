import React from 'react';
import "./Footer.css";
import { FaInstagram} from "react-icons/fa";
import { FaFacebookSquare} from "react-icons/fa";
import { FaTwitter} from "react-icons/fa";


const Footer = () => {
    return(
    
        <div className="main-footer">
                 {/* Column1*/}
                 <div className="i">
        <ul className="i">
        <FaInstagram size={50} color={"white"}/>
        <FaFacebookSquare size={50} color={"white"}/>
        <FaTwitter size={50} color={"white"}/>
        </ul>
        </div>
                 <div className="col">
                     <ul className="list-unstyled">
                     <h4>GETIT! </h4>
                         <li>About Us</li>
                         <li>Partners</li>
                         <li>Contact Us</li>
                         <li>Terms of Use</li>
                     </ul>
                 </div>
                 {/* Column2*/}
                 <div className="col">
                     <ul className="list-unstyled">
                         <h4>Social </h4>
                         <li>Facebook</li>
                         <li>Instagram</li>
                         <li>Twitter</li>
                        
                     </ul>
                     <FaInstagram />
                 </div>
                 {/* Column3*/}
                 <div className="col">
                     <ul className="list-unstyled">
                         <h4>Activity </h4>
                         <li>Compare</li>
                         <li>Download</li>
                         <li>Feedback</li>
                         <li>Bug Report</li>
                     </ul>
                     <h3>Copyright &#169; 2021 Getit!. All rights reserved.</h3>
                 </div>
</div>
    )
}
export default Footer;