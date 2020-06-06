import React, {Component}from 'react'
import ReactDOM from 'react-dom';



const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class Index extends Component {
    
    constructor(props){
        super(props);
        this.state = { data: [] };
    }


    render() {
        
        return(
        <div>

                <div>
                    
                </div>
         </div> )
    }
}
     
  


ReactDOM.render(<Index/>,document.getElementById('communityIndex'));
