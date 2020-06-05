
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
        //this.getVoteItemWithOptionPaging();

        let {data} = await axios.get('/community/axios');
        this.setState({data});
        // var parentsDiv = document.getElementById("program_option")

        // const programOptionTitle = document.createElement("div");
        // programOptionTitle.innerHTML = "프로그램 ▶ "
        // programOptionTitle.className ="voteType"
        // parentsDiv.appendChild(programOptionTitle);
        // data.map((program,index)=>{
            //  var div = document.createElement("div");

            //  div.innerHTML = program.name;
            //  div.className = "voteState program"
            //  div.title= program.id

            //  div.onclick = this.clickProgramName.bind(this,program.id);

            //  parentsDiv.appendChild(div);
        // })
    }

    render() {
        
        return(
        <div>

                <div className="voteItem">
                    <ProgramItem data={this.state.data}/>
                </div>
         </div> 

     
    }
}


ReactDOM.render(<Index/>,document.getElementById('communityIndex'));
