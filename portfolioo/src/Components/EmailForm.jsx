import React,{ useState } from 'react';
import emailjs from '@emailjs/browser';
import './email.css';
const EmailForm = () => {
    const [name, setName]=useState('');
    const [email, setEmail]=useState('');
    const [message, setMessage]=useState('');
    const [isSent, setIsSent]=useState(false)

    const handleSubmit= (e) => {
        e.preventDefault();

        const serviceId ="service_cr7xwlr";
        const templateId = "template_jnthm8n";
        const publicKey = "DIBHGLh3Z-qplB5J6";

    const templateParams ={
        from_name: name,
        from_email: email,
        to_name: 'My Portfolio',
        message: message,
    };

    emailjs.send(serviceId,templateId, templateParams, publicKey)
    .then((response) => {
        console.log('Email sent Successfully!',response);
        setName('');
        setEmail('');
        setMessage('');
        setIsSent(true);
    })
    .catch((error) => {
        console.error('Error sending email:',error);
    });
    }

  return (
      <div className='f'>
    <form onSubmit={handleSubmit} className="emailForm">
        <input
        type="text"
        placeholder='Your Name'
        value={name}
        onChange={(e) => setName(e.target.value)}
        />
        <input
        type='email'
        placeholder='Your Email'
        value={email}
        onChange={(e)=> setEmail(e.target.value)}
        />
        <textarea
        cols="30"
        rows="10"
        placeholder='Message'
        value={message}
        onChange={(e) => setMessage(e.target.value)}
        >
        </textarea>
        <button type="submit">Send Email</button>
    </form>
    {isSent && <p className='msg'>Message Sent Successfully</p>}
    </div>
  )
}

export default EmailForm