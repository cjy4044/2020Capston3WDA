import React, {Component}from 'react'
import ReactDOM from 'react-dom';
const regeneratorRuntime = require("regenerator-runtime");
const axios = require('axios');

class VoteIndex extends Component {
    constructor(props){
        super(props);
<<<<<<< HEAD
        this.state = { data: [] };
<<<<<<< HEAD
        this.options = {type: 1,page : 1, size : 6, sort : "id", count: 1, program: 0};
        this.url = "/vote/axios?page="+(this.options.page-1)+"&size="+this.options.size+"&sort="+this.options.sort+"&state="+this.options.type+"&program="+this.options.program;
        // 
=======
        this.state = { title: [] };
>>>>>>> parent of 877a2626... Merge branch 'minseok'
    }

    async componentDidMount(){
        let {data : title} = await axios.get('/vote/axios');

        this.setState({title});
        
    }
    render() {
        const { title } = this.state;
        return title.map((tt,index)=>{
            return (
                <div key={'div'+index}>
                    <a href={"/vote/"+tt.id} key={index}>{tt.title}</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href={'/vote/result/'+tt.id}>실시간 투표 결과</a>
                </div>
            )
        })
<<<<<<< HEAD
    }
    async getVoteItemWithOptionPaging(){
        let {data} = await axios.get(this.url);
        // this.options.count=data.pop(); 
        this.options.count = Math.ceil((data.pop()*1.0)/this.options.size);
        // console.log(this.options.count);
=======
        this.options = {type: 1,page : 1, size : 6, sort : "id", count: 1};
        this.url = "/vote/axios?page="+(this.options.page-1)+"&size="+this.options.size+"&sort="+this.options.sort+"&state="+this.options.type;
        
    }
    async componentDidMount(){
        // console.log(this.url);
        let {data} = await axios.get(this.url);
        // this.options.count=data.pop(); 
        this.options.count = Math.ceil((data.pop()*1.0)/this.options.size);
        console.log(this.options.count);
>>>>>>> jaeyoung

        this.setState({data});
    }

    clickTag(type){
        this.options.page = 1;
        this.options.type= type;
        this.setUrl();
        // this.forceUpdate();
<<<<<<< HEAD
        // this.componentDidMount();
        this.getVoteItemWithOptionPaging();
    }
    clickProgramName(id){
        // console.log("프로그램 클릭  id : "+id);
        this.options.page = 1;
        this.options.program = id;
        this.setUrl();
        this.getVoteItemWithOptionPaging();
    }
    setUrl(){
        this.url = "/vote/axios?page="+(this.options.page-1)+"&size="+this.options.size+"&sort="+this.options.sort+"&state="+this.options.type+"&program="+this.options.program;
=======
        this.componentDidMount();
    }
    setUrl(){
        this.url = "/vote/axios?page="+(this.options.page-1)+"&size="+this.options.size+"&sort="+this.options.sort+"&state="+this.options.type;
>>>>>>> jaeyoung
    }
    pageClick(e, page){
        this.options.page = page;
        // console.log(this.options);
        this.setUrl();
        // this.forceUpdate();
<<<<<<< HEAD
        // this.componentDidMount();
        this.getVoteItemWithOptionPaging();
=======
        this.componentDidMount();
>>>>>>> jaeyoung
    }
    // getCount(count){
    //     console.log("자식으로 부터 온 데이터 : "+count);
    //     this.options.count = count;
    //     // <VoteIndex url={this.url} getCount={this.getCount.bind(this)}/>
    // }
=======
      }
}
class Index extends Component{
>>>>>>> parent of 877a2626... Merge branch 'minseok'
    render(){
        return(
            <div>
<<<<<<< HEAD
                <h2>실시간 투표</h2>
<<<<<<< HEAD
                <div className="vote_options_select_div">
                    <div className="options">
                        <div>정렬</div>
                        <div className="vote_option_div">
                            <div>투표상태 ▶ </div>
                            <div className="voteState type" title="0" onClick={this.clickTag.bind(this,0)}>시작전 투표</div>
                            <div className="voteState type" title="1" onClick={this.clickTag.bind(this,1)}>진행중인 투표</div>
                            <div className="voteState type" title="2" onClick={this.clickTag.bind(this,2)}>마감된 투표</div>
                        </div>
                        <div id="program_option"className="vote_option_div">
                            {/* componentDidMount 에서 추가 */}
                        </div>
                        <div>
                            <a href="/vote/create">투표 생성</a>
                        </div>
                    </div>
                    <div className="search_vote">
                        검색
                        <input type="text"/>
                    </div>
                </div>
                <br/><br/><br/>
                <div className="voteItem">
                    <VoteIndex data={this.state.data}/>
                </div>
                <div className="pagingCenter">
                    <Pagination count={this.options.count} page={this.options.page} onChange={this.pageClick.bind(this)}/>
                </div>
            
=======
                <div>정렬</div>
                <div className="vote_option_div">
                    <div>투표상태 : </div>
                    <div className="voteState"onClick={this.clickTag.bind(this,0)}>시작전 투표</div>
                    <div className="voteState"onClick={this.clickTag.bind(this,1)}>진행중인 투표</div>
                    <div className="voteState"onClick={this.clickTag.bind(this,2)}>마감된 투표</div>
                </div>
                <div>
                    <a href="/vote/create">투표 생성</a>
                </div>
                <br/><br/><br/>
                <VoteIndex data={this.state.data}/>
                <Pagination count={this.options.count} page={this.options.page} onChange={this.pageClick.bind(this)}/>
>>>>>>> jaeyoung
=======
                Vote
                <div>
                    <a href="/vote/create">투표 생성</a>
                </div>
                <br/><br/><br/>
                <VoteIndex/>
>>>>>>> parent of 877a2626... Merge branch 'minseok'
            </div>
        )
    }
}


ReactDOM.render(<Index/>,document.getElementById('voteIndex'));

