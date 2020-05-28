import React from 'react';
import ReactDOM from 'react-dom';
import Header_top from './shop/header_top.js';
import Header_middle from './shop/header_middle.js';
import Header_bottom from './shop/header_bottom.js';


class Shop_layout extends React.Component {
    render() {
        return (
            <div>
                <Header_top></Header_top>
                <Header_middle></Header_middle>
                <Header_bottom></Header_bottom>
            </div>
            
        )
    }
}

ReactDOM.render(<Shop_layout/>,document.getElementById('header'));
