import React from 'react';
import ReactDOM from 'react-dom';
import Footer from './shop/footer.js';
import Footer2 from './shop/footer2.js';
import Chat from './shop/chat.jsx';


class Shop_chat extends React.Component {
    render() {
        return (
            <div>
                <Footer></Footer>
                <Footer2></Footer2>
                <Chat></Chat>
            </div>
            
        )
    }
}

ReactDOM.render(<Shop_chat/>,document.getElementById('footer'));
