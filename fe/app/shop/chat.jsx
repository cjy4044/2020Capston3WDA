import React from 'react';

class Chat extends React.Component {
    render() {
        return (
            <div className="l_c_h">
                <div className="c_h">
                    <div className="left_c">
                        <div className="left right_c left_icons">
                            <a href="#" className="mini">+</a>
                        </div>
                        <div className="left center_icons">RIRO CHAT !</div>
                    </div>
                </div>
                <div className="chat_container">
                    <ul id="messages"></ul>
                    <form id="chatform" action="">
                        <input id="chatinput" autoComplete="nope" ></input>
                        <button id="chatbutton">Send</button>
                    </form>
                </div>
            </div >
        )
    }
}

export default Chat;
