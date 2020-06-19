import React from 'react';
import ReactDOM from 'react-dom';
import BagItem from './bagItem.jsx';
import Pagination from '@material-ui/lab/Pagination';
import './css/mybag.css'

const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
import jQuery from "jquery";
window.$ = window.jQuery = jQuery;

class BuySuccess extends React.Component {
    constructor(props){
        super(props)

    }

    render() {
        
        return (
            <div>
                <h2>상품 구매 완료</h2>
                <a href="#">주문목록으로 가기</a>
                <a href="/">홈으로 가기</a>
            </div>
            
        )
    }
}

ReactDOM.render(<BuySuccess/>,document.getElementById('buySuccess'));