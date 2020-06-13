import React, {Component}from 'react'
import ReactDOM from 'react-dom';
import ProgramItem from './programItem.jsx';


const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');
  
class Index extends Component {
    
    constructor(props){
        
        super(props);
        this.state = { data: [] };
    }
    async componentDidMount(){

        let {data} = await axios.get('/community/axios');
        this.setState({data});
    }

    render() {
        
        return(
        <div>

                <div className="voteItem">
                    <ProgramItem data={this.state.data}/>
                </div>
         </div> )
    }
}
     
  


ReactDOM.render(<Index/>,document.getElementById('communityIndex'));
