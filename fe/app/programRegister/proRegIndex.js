import React, {Component}from 'react'
import ReactDOM from 'react-dom';
import './ProRegIndex.css';

const axios = require('axios');
const regeneratorRuntime = require("regenerator-runtime");


class ProRegIndex extends Component {


      render() {
               return (
            <div className="ProRegIndex">
                  <h1>RIRO 서비스의 프로그램을 등록하시겠습니까?</h1>
                  
            </div>            
            
        )
   
      }

}

ReactDOM.render(<ProRegIndex/>,document.getElementById('proRegIndex'));
