import React from 'react';

const Contact = () => {
  return (
    <div className="bg-white rounded-lg p-8 shadow-md min-h-screen">
      <h1 className="text-2xl font-bold mb-4">Contact Us</h1>
      <p className="mb-4">Get in touch with us</p>
      <form>
        <div className="mb-4">
          <label htmlFor="name" className="block font-medium mb-2">Name:</label>
          <input type="text" id="name" name="name" className="border-gray-300 border rounded-lg p-2 w-full" />
        </div>
        <div className="mb-4">
          <label htmlFor="email" className="block font-medium mb-2">Email:</label>
          <input type="email" id="email" name="email" className="border-gray-300 border rounded-lg p-2 w-full" />
        </div>
        <div className="mb-4">
          <label htmlFor="message" className="">Message:</label>
          <textarea id="message" name="message" rows="5" className=""></textarea>
        </div>
        <button type="submit" className="btn">Submit</button>
      </form>
    </div>
  );
};

export default Contact;